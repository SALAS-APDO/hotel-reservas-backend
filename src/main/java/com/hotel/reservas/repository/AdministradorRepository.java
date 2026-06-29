package com.hotel.reservas.repository;

import com.hotel.reservas.model.Administrador; // Nota: Necesitarás crear este modelo
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    Optional<Administrador> findByCorreoAndContrasena(String correo, String contrasena);
}