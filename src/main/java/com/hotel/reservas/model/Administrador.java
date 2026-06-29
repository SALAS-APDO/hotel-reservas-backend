package com.hotel.reservas.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "administradores")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;
    private String nombre;
    private String correo;
    private String contrasena;
}