package com.hotel.reservas.model;

import jakarta.persistence.*;
import lombok.Data; // <--- Importante
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "clientes")
@Data // <--- Esto genera automáticamente los setNombre, setApellido, etc.
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String numeroDocumento;
    private String telefono;
    private String correo;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    private List<Reserva> reservas;
}