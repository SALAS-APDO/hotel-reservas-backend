package com.hotel.reservas.repository;

import com.hotel.reservas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Para que el Admin vea solo las reservas pendientes
    List<Reserva> findByEstado(String estado);
    
    // Para que el Admin vea las reservas de un cliente específico por su ID
    List<Reserva> findByCliente_IdCliente(Long idCliente);
}