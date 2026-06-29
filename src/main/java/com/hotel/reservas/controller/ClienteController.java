package com.hotel.reservas.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.hotel.reservas.model.Cliente;
import com.hotel.reservas.dto.ClienteRequestDTO;
import com.hotel.reservas.service.ClienteService;
import com.hotel.reservas.repository.ClienteRepository;
import com.hotel.reservas.repository.ReservaRepository;
import jakarta.validation.Valid;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")

public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;
    private final ReservaRepository reservaRepository;

    // Inyectamos las dependencias necesarias a través del constructor
    public ClienteController(ClienteService clienteService, 
                             ClienteRepository clienteRepository, 
                             ReservaRepository reservaRepository) {
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
        this.reservaRepository = reservaRepository;
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@Valid @RequestBody ClienteRequestDTO dto) {
        clienteService.registrarCliente(dto);
        return ResponseEntity.ok("Cliente registrado correctamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @RequestBody ClienteRequestDTO dto) {
        return ResponseEntity.ok(clienteService.actualizarCliente(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.ok("Cliente eliminado correctamente");
    }

    // Nuevo método para listar todos los clientes en la tabla administrativa
    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    // Nuevo método para búsqueda administrativa por DNI
    @GetMapping("/buscar/{dni}")
    public ResponseEntity<?> buscarPorDni(@PathVariable String dni) {
        return clienteRepository.findByNumeroDocumento(dni)
            .map(cliente -> {
                var reservas = reservaRepository.findByCliente_IdCliente(cliente.getIdCliente());
                return ResponseEntity.ok(Map.of(
                    "cliente", cliente,
                    "reservas", reservas
                ));
            })
            .orElse(ResponseEntity.notFound().build());
    }
}