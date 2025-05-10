package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Mascota;
import com.example.demo.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService{

    @Autowired
    private MascotaRepository mascotaRepository;

    public Mascota crearMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public List<Mascota> obtenerTodosMascotas() {
        return mascotaRepository.findAll();
    }

    public Optional<Mascota> obtenerMascotaPorId(Long id) {
        return mascotaRepository.findById(id);
    }

    public Mascota actualizarMascota(Long id, Mascota mascotaDetalles) {
        Mascota mascota = mascotaRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
        mascota.setNombre(mascotaDetalles.getNombre());
        mascota.setEdad(mascotaDetalles.getEdad());
        mascota.setEspecie(mascotaDetalles.getEspecie());
        return mascotaRepository.save(mascota);
    }


    @Override
    public Mascota eliminarMascota(Long id) {
        Mascota mascota = mascotaRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
        mascotaRepository.delete(mascota);
        return null;
    }
}
