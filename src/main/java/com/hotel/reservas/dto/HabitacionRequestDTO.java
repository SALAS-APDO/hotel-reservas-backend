package com.hotel.reservas.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class HabitacionRequestDTO {
    private String numeroHabitacion;
    private String tipoHabitacion;
    private Integer capacidadMaxima;
    private BigDecimal precioPorNoche;
    private String estado;
}