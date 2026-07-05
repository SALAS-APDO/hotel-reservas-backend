package com.hotel.reservas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "hoteles") // <-- CRÍTICO: Debe ser idéntico a tu tabla SQL
@Data // <-- Lombok genera automáticamente los Getters y Setters
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel") // <-- CRÍTICO: Debe ser idéntico al nombre de tu columna SQL
    private Integer idHotel;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imagen_url")
    private String imagenUrl;
}
