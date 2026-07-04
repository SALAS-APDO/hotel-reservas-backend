package com.hotel.reservas.dto;

import java.time.LocalDate;

public class ReservaResponseDTO {
    
    private Long id;
    private String clienteNombre;
    private String dni;
    private String numeroHabitacion;
    private String nombreSede;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private String estado;

    public ReservaResponseDTO() {}

    public ReservaResponseDTO(Long id, String clienteNombre, String dni, String numeroHabitacion, String nombreSede, LocalDate fechaEntrada, LocalDate fechaSalida, String estado) {
        this.id = id;
        this.clienteNombre = clienteNombre;
        this.dni = dni;
        this.numeroHabitacion = numeroHabitacion;
        this.nombreSede = nombreSede;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNumeroHabitacion() { return numeroHabitacion; }
    public void setNumeroHabitacion(String numeroHabitacion) { this.numeroHabitacion = numeroHabitacion; }

    public String getNombreSede() { return nombreSede; }
    public void setNombreSede(String nombreSede) { this.nombreSede = nombreSede; }

    public LocalDate getFechaEntrada() { return fechaEntrada; }
    public void setFechaEntrada(LocalDate fechaEntrada) { this.fechaEntrada = fechaEntrada; }

    public LocalDate getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDate fechaSalida) { this.fechaSalida = fechaSalida; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
