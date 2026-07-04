package com.hotel.reservas.controller;

import com.hotel.reservas.model.ChatbotPregunta;
import com.hotel.reservas.repository.ChatbotPreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chatbot")
@CrossOrigin(origins = "http://localhost:4200")
public class ChatbotController {

    @Autowired
    private ChatbotPreguntaRepository repository;

    @GetMapping
    public List<ChatbotPregunta> obtenerPreguntas() {
        return repository.findAll();
    }
}