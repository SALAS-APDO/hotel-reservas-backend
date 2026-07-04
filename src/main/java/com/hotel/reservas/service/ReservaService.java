package com.hotel.reservas.service;

import com.hotel.reservas.dto.ReservaRequestDTO;
import com.hotel.reservas.dto.ReservaResponseDTO;
import com.hotel.reservas.model.Cliente;
import com.hotel.reservas.model.Habitacion;
import com.hotel.reservas.model.Reserva;
import com.hotel.reservas.repository.ClienteRepository;
import com.hotel.reservas.repository.HabitacionRepository;
import com.hotel.reservas.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Transactional
    public void registrarReserva(ReservaRequestDTO dto) {
        LocalDate hoy = LocalDate.now();
        
        if (dto.getFechaEntrada().isBefore(hoy)) {
            throw new RuntimeException("La fecha de entrada no puede ser una fecha pasada.");
        }
        
        if (dto.getFechaSalida().isBefore(dto.getFechaEntrada()) || dto.getFechaSalida().equals(dto.getFechaEntrada())) {
            throw new RuntimeException("La fecha de salida debe ser posterior a la fecha de entrada.");
        }

        Cliente cliente = clienteRepository.findByNumeroDocumentoOrCorreo(dto.getNumeroDocumento(), dto.getCorreo())
            .orElse(new Cliente());

        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setCorreo(dto.getCorreo());
        cliente.setTelefono(dto.getTelefono());
        cliente.setTipoDocumento(dto.getTipoDocumento());
        cliente.setNumeroDocumento(dto.getNumeroDocumento());
        
        clienteRepository.save(cliente);

        Habitacion habitacion = habitacionRepository.findById(dto.getIdHabitacion())
            .orElseThrow(() -> new RuntimeException("Habitación no encontrada con ID: " + dto.getIdHabitacion()));

        Reserva reserva = new Reserva();
        reserva.setCliente(cliente);
        reserva.setHabitacion(habitacion);
        reserva.setFechaEntrada(dto.getFechaEntrada());
        reserva.setFechaSalida(dto.getFechaSalida());
        reserva.setNumAdultos(dto.getNumAdultos());
        reserva.setNumNinos(dto.getNumNinos());
        reserva.setTipoComprobante(dto.getTipoComprobante());
        reserva.setRucEmpresa(dto.getRucEmpresa());
        reserva.setEstado("PENDIENTE");

        reservaRepository.save(reserva);
    }

    @Transactional
    public Reserva actualizarReserva(Long id, ReservaRequestDTO dto) {
        Reserva reservaExistente = reservaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + id));

        if (dto.getFechaEntrada() != null && !dto.getFechaEntrada().equals(reservaExistente.getFechaEntrada())) {
            if (dto.getFechaEntrada().isBefore(LocalDate.now())) {
                throw new RuntimeException("No puedes actualizar a una fecha de entrada pasada.");
            }
        }

        reservaExistente.setFechaEntrada(dto.getFechaEntrada());
        reservaExistente.setFechaSalida(dto.getFechaSalida());

        if (dto.getEstado() != null) {
            reservaExistente.setEstado(dto.getEstado());
        }

        return reservaRepository.save(reservaExistente);
    }

    @Transactional
    public void eliminarReserva(Long id) {
        Reserva reservaExistente = reservaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se puede eliminar, la reserva no existe"));
        
        // El truco: En vez de borrarla físicamente de la BD, le cambiamos el estado
        reservaExistente.setEstado("FINALIZADA");
        reservaRepository.save(reservaExistente);
    }

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public List<ReservaResponseDTO> findAllDTO() {
        return reservaRepository.findAll().stream().map(reserva -> {
            String sede = (reserva.getHabitacion() != null && reserva.getHabitacion().getHotel() != null) 
                    ? reserva.getHabitacion().getHotel().getNombre() : "Sin sede asignada";
            
            String clienteFull = (reserva.getCliente() != null) 
                    ? reserva.getCliente().getNombre() + " " + reserva.getCliente().getApellido() : "Sin cliente";
            
            String dni = (reserva.getCliente() != null) ? reserva.getCliente().getNumeroDocumento() : "Sin DNI";
            
            String habitacionNum = (reserva.getHabitacion() != null) ? reserva.getHabitacion().getNumeroHabitacion() : "N/A";

            return new ReservaResponseDTO(
                    reserva.getIdReserva(),
                    clienteFull,
                    dni,
                    habitacionNum,
                    sede,
                    reserva.getFechaEntrada(),
                    reserva.getFechaSalida(),
                    reserva.getEstado()
            );
        }).toList();
    }
}