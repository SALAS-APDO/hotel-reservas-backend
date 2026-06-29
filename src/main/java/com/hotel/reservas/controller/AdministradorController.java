package com.hotel.reservas.controller;

import com.hotel.reservas.model.Administrador;
import com.hotel.reservas.service.AdministradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/administradores")

public class AdministradorController {

    private final AdministradorService adminService;

    public AdministradorController(AdministradorService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Administrador> listar() {
        return adminService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Administrador> crear(@RequestBody Administrador admin) {
        return ResponseEntity.ok(adminService.guardar(admin));
    }
}