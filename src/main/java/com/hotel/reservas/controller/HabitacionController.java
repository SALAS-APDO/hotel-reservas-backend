package com.hotel.reservas.controller;

import com.hotel.reservas.model.Habitacion;
import com.hotel.reservas.dto.HabitacionRequestDTO;
import com.hotel.reservas.service.HabitacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")

public class HabitacionController {

    private final HabitacionService habitacionService;

    // Inyección por constructor (la forma correcta y profesional)
    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @GetMapping
    public ResponseEntity<List<Habitacion>> listar() {
        return ResponseEntity.ok(habitacionService.obtenerTodasLasHabitaciones());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitacion> actualizar(@PathVariable Long id, @RequestBody HabitacionRequestDTO dto) {
        return ResponseEntity.ok(habitacionService.actualizarHabitacion(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        habitacionService.eliminarHabitacion(id);
        return ResponseEntity.ok("Habitación eliminada correctamente");
    }
    @GetMapping("/buscar")
    public ResponseEntity<List<Habitacion>> listarDisponibles(
            @RequestParam Integer idHotel, 
            @RequestParam String llegada,  
            @RequestParam String salida,
            @RequestParam Integer adultos,
            @RequestParam Integer ninos) {
        
        // Sumamos los pasajeros para validar contra 'capacidad_maxima'
        Integer personasTotales = adultos + ninos;

        List<Habitacion> disponibles = habitacionService.buscarPorHotelYFechas(idHotel, llegada, salida, personasTotales);
        return ResponseEntity.ok(disponibles);
    }
}

