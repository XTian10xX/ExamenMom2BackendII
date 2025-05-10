package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long>{
    Optional<Mascota> findById(Long id);
    Mascota findByNombre(String nombre);
}
