package com.hotel.reservas.repository;

import com.hotel.reservas.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    // Esta interfaz ya tiene listos métodos como:
    // .findAll() -> para listar todos
    // .save()    -> para guardar uno nuevo
    // .findById()-> para buscar por ID
}