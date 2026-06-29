package com.hotel.reservas.controller;

import com.hotel.reservas.dto.LoginRequestDTO;
import com.hotel.reservas.repository.AdministradorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    // Usamos 'private final' para consistencia con tus otros controladores
    private final AdministradorRepository adminRepository;

    // Constructor para inyección, evitando @Autowired
    public AuthController(AdministradorRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO dto) {
        return adminRepository.findByCorreoAndContrasena(dto.getCorreo(), dto.getContrasena())
                .map(admin -> ResponseEntity.ok("Login exitoso"))
                .orElse(ResponseEntity.status(401).body("Credenciales incorrectas"));
    }
}