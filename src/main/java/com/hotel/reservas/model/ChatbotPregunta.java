package com.hotel.reservas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "chatbot_preguntas")
public class ChatbotPregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String pregunta;
    
    @Column(length = 1000)
    private String respuesta;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPregunta() { return pregunta; }
    public void setPregunta(String pregunta) { this.pregunta = pregunta; }
    public String getRespuesta() { return respuesta; }
    public void setRespuesta(String respuesta) { this.respuesta = respuesta; }
}