package com.hotel.reservas.service;

import com.hotel.reservas.model.Cliente;
import com.hotel.reservas.dto.ClienteRequestDTO;
import com.hotel.reservas.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public void registrarCliente(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        mapearDtoAEntidad(dto, cliente); // Usamos el método auxiliar
        clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente actualizarCliente(Long id, ClienteRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
        
        mapearDtoAEntidad(dto, cliente); // Usamos el mismo método
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void eliminarCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar: el cliente con ID " + id + " no existe.");
        }
        clienteRepository.deleteById(id);
    }

    // MÉTODO AUXILIAR PARA NO REPETIR CÓDIGO
    private void mapearDtoAEntidad(ClienteRequestDTO dto, Cliente cliente) {
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setTipoDocumento(dto.getTipoDocumento());
        cliente.setNumeroDocumento(dto.getNumeroDocumento());
        cliente.setTelefono(dto.getTelefono());
        cliente.setCorreo(dto.getCorreo());
    }
}