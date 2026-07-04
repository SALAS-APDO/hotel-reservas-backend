package com.hotel.reservas.repository;

import com.hotel.reservas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByEstado(String estado);
    List<Reserva> findByCliente_IdCliente(Long idCliente);
}