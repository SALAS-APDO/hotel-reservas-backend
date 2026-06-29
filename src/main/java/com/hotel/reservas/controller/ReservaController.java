package com.hotel.reservas.controller;

import com.hotel.reservas.dto.ReservaRequestDTO;
import com.hotel.reservas.model.Reserva;
import com.hotel.reservas.service.ReservaService;
import jakarta.validation.Valid; // <--- Importante: añadir esta línea
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
    public String registrar(@Valid @RequestBody ReservaRequestDTO dto) { // <--- Añadimos @Valid aquí
        reservaService.registrarReserva(dto);
        return "Reserva registrada con éxito";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizar(@PathVariable Long id, @RequestBody ReservaRequestDTO dto) { // Cambia a Long
        Reserva actualizada = reservaService.actualizarReserva(id, dto);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) { // Cambia a Long
        reservaService.eliminarReserva(id);
        return ResponseEntity.ok("Reserva eliminada con éxito");
    }
    // ✨ MÉTODO NUEVO PARA EL DASHBOARD ADMINISTRATIVO
    @GetMapping
    public ResponseEntity<List<Reserva>> listarTodas() {
        List<Reserva> lista = reservaService.findAll(); // Asegúrate de que este método exista en tu servicio
        return ResponseEntity.ok(lista);
    }
}