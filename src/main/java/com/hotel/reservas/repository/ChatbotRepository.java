package com.hotel.reservas.repository;

import com.hotel.reservas.model.ChatbotPregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatbotRepository extends JpaRepository<ChatbotPregunta, Long> {
}