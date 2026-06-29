package com.hotel.reservas.service;

import com.hotel.reservas.model.Administrador;
import com.hotel.reservas.repository.AdministradorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdministradorService {
    private final AdministradorRepository adminRepository;

    public AdministradorService(AdministradorRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Administrador> listarTodos() {
        return adminRepository.findAll();
    }

    public Administrador guardar(Administrador admin) {
        return adminRepository.save(admin);
    }
}