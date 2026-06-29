package com.hotel.reservas.controller;

import com.hotel.reservas.model.Hotel;
import com.hotel.reservas.service.HotelService; // Importamos el servicio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api/hoteles")

public class HotelController {

    @Autowired
    private HotelService hotelService; // Usamos el servicio

    @GetMapping
    public List<Hotel> listarHoteles() {
        return hotelService.obtenerTodosLosHoteles();
    }
}