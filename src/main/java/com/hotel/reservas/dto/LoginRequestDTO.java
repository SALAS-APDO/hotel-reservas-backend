package com.hotel.reservas.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String correo;
    private String contrasena;
}