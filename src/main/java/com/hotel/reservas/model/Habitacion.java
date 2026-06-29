package com.hotel.reservas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "habitaciones")
@Data
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Integer idHabitacion;

    @Column(name = "numero_habitacion", nullable = false)
    private String numeroHabitacion;

    @Column(name = "tipo_habitacion", nullable = false)
    private String tipoHabitacion;

    @Column(name = "capacidad_maxima", nullable = false)
    private Integer capacidadMaxima;

    @Column(name = "precio_por_noche", nullable = false)
    private BigDecimal precioPorNoche; // Usamos BigDecimal para dinero

    @Column(name = "estado", nullable = false)
    private String estado = "DISPONIBLE";

    // Relación: Muchas habitaciones pertenecen a UN hotel
    @ManyToOne
    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel hotel;
}
