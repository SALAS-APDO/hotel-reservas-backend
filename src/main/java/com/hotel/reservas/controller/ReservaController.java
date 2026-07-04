package com.hotel.reservas.controller;

import com.hotel.reservas.dto.ReservaRequestDTO;
import com.hotel.reservas.dto.ReservaResponseDTO;
import com.hotel.reservas.model.Reserva;
import com.hotel.reservas.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public String registrar(@Valid @RequestBody ReservaRequestDTO dto) {
        reservaService.registrarReserva(dto);
        return "Reserva registrada con éxito";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizar(@PathVariable Long id, @RequestBody ReservaRequestDTO dto) {
        Reserva actualizada = reservaService.actualizarReserva(id, dto);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        reservaService.eliminarReserva(id);
        return ResponseEntity.ok("Reserva eliminada con éxito");
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> listarTodas() {
        List<ReservaResponseDTO> lista = reservaService.findAllDTO();
        return ResponseEntity.ok(lista);
    }
}