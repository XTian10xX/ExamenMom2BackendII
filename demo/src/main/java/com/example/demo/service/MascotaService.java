package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Mascota;

public interface MascotaService {
    Mascota crearMascota(Mascota mascota);

    List<Mascota> obtenerTodosMascotas();

    Optional<Mascota> obtenerMascotaPorId(Long id);

    Mascota actualizarMascota(Long id, Mascota mascota);

    Mascota eliminarMascota(Long id);
}
