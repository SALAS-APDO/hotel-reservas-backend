package com.hotel.reservas.repository;

import com.hotel.reservas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // ESTE ES EL QUE YA TENÍAS (para validaciones de registro)
    Optional<Cliente> findByNumeroDocumentoOrCorreo(String numeroDocumento, String correo);

    // ESTE ES EL NUEVO (específico para tu panel administrativo)
    Optional<Cliente> findByNumeroDocumento(String numeroDocumento);
}