package com.hotel.reservas.service;

import com.hotel.reservas.model.Hotel;
import com.hotel.reservas.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> obtenerTodosLosHoteles() {
        return hotelRepository.findAll();
    }
}