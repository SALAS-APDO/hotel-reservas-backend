package com.hotel.reservas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reservas")
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties({"reservas"})
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion;

    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Integer numAdultos;
    private Integer numNinos;
    private String estado;
    
    private String tipoComprobante;
    private String rucEmpresa;
    private BigDecimal subtotal;
    private BigDecimal igv;
    private BigDecimal precioTotal;
}