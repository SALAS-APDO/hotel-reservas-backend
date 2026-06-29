package com.hotel.reservas.controller;

import com.hotel.reservas.model.ChatbotPregunta;
import com.hotel.reservas.repository.ChatbotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chatbot")
// Permite que tu Angular se conecte
public class ChatbotController {

    @Autowired
    private ChatbotRepository chatbotRepository;

    @GetMapping("/preguntas")
    public List<ChatbotPregunta> obtenerPreguntas() {
        return chatbotRepository.findAll();
    }
}