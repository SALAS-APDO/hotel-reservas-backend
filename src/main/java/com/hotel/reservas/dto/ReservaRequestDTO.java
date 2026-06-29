package com.hotel.reservas.dto;

import jakarta.validation.constraints.Email; // Importación necesaria
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Data; // Usamos Lombok para los getters y setters

@Data
public class ReservaRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    private String tipoDocumento;
    private String numeroDocumento;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Formato de correo no válido") // <--- Validamos el formato aquí
    private String correo;

    private String telefono;

    @NotNull(message = "Debe seleccionar una habitación")
    private Long idHabitacion; 

    @NotNull(message = "La fecha de entrada es obligatoria")
    private LocalDate fechaEntrada;

    @NotNull(message = "La fecha de salida es obligatoria")
    private LocalDate fechaSalida;

    @NotNull(message = "El número de adultos es obligatorio")
    private Integer numAdultos;

    private Integer numNinos;

    private String tipoComprobante;
    private String rucEmpresa;
    private String estado;
    

    @NotNull(message = "El ID del cliente es obligatorio") // Aseguramos que el cliente venga
    private Long idCliente;
}