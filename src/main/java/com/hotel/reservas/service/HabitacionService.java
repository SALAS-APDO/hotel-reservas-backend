package com.hotel.reservas.service;

import com.hotel.reservas.model.Habitacion;
import com.hotel.reservas.dto.HabitacionRequestDTO;
import com.hotel.reservas.repository.HabitacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;

    // Inyección por constructor (más robusta y fácil de probar)
    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    public List<Habitacion> obtenerTodasLasHabitaciones() {
        return habitacionRepository.findAll();
    }

    public List<Habitacion> buscarPorHotelYFechas(Integer idHotel, String llegada, String salida, Integer personasTotales) {
        // Convertimos los Strings que vienen de Angular ("YYYY-MM-DD") a LocalDate
        LocalDate fechaLlegada = LocalDate.parse(llegada);
        LocalDate fechaSalida = LocalDate.parse(salida);
        
        // Ejecutamos la consulta inteligente de base de datos
        return habitacionRepository.buscarHabitacionesDisponibles(idHotel, fechaLlegada, fechaSalida, personasTotales);
    }

    @Transactional
    public Habitacion actualizarHabitacion(Long id, HabitacionRequestDTO dto) {
        Habitacion hab = habitacionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontró la habitación con ID: " + id));

        // Mapeo de datos desde el DTO hacia la entidad
        hab.setNumeroHabitacion(dto.getNumeroHabitacion());
        hab.setTipoHabitacion(dto.getTipoHabitacion());
        hab.setCapacidadMaxima(dto.getCapacidadMaxima());
        hab.setPrecioPorNoche(dto.getPrecioPorNoche());
        // Convertimos el Integer del DTO (1 o 0) a Boolean para tu entidad
        hab.setEstado(dto.getEstado());

        return habitacionRepository.save(hab);
    }

    @Transactional
    public void eliminarHabitacion(Long id) {
        if (!habitacionRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar: la habitación con ID " + id + " no existe.");
        }
        habitacionRepository.deleteById(id);
    }
}