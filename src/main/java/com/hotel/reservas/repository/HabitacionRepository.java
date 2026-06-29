package com.hotel.reservas.repository;

import com.hotel.reservas.model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {

    @Query("SELECT h FROM Habitacion h WHERE h.hotel.idHotel = :idHotel " +
           "AND h.estado = 'DISPONIBLE' " + // 👈 ESTA ES LA LÍNEA NUEVA
           "AND h.capacidadMaxima >= :personasTotales " +
           "AND h.capacidadMaxima <= (:personasTotales + 3) " + 
           "AND h.idHabitacion NOT IN (" +
           "   SELECT r.habitacion.idHabitacion FROM Reserva r " +
           "   WHERE r.estado <> 'CANCELADA' " +
           "   AND (:llegada < r.fechaSalida AND :salida > r.fechaEntrada)" +
           ") " +
           "ORDER BY h.capacidadMaxima ASC, h.precioPorNoche ASC")
    List<Habitacion> buscarHabitacionesDisponibles(
        @Param("idHotel") Integer idHotel,
        @Param("llegada") LocalDate llegada,
        @Param("salida") LocalDate salida,
        @Param("personasTotales") Integer personasTotales
    );
}