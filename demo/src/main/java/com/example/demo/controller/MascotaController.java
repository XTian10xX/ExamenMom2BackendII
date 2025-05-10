package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Mascota;
import com.example.demo.service.MascotaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @PostMapping
    public ResponseEntity<Mascota> crearMascota(@RequestBody Mascota mascota) {
        Mascota nuevaMascota = mascotaService.crearMascota(mascota);
        return new ResponseEntity<>(nuevaMascota, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Mascota>> listarMascotas() {
        List<Mascota> mascotas = mascotaService.obtenerTodosMascotas();
        return new ResponseEntity<>(mascotas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> obtenerMascotaPorId(@PathVariable Long id) {
        Optional<Mascota> mascota = mascotaService.obtenerMascotaPorId(id);
        return mascota.map(ResponseEntity::ok)
                                            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizarMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        Mascota actualizacion = mascotaService.actualizarMascota(id, mascota);
        return (actualizacion != null) ? ResponseEntity.ok(actualizacion) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMascota(@PathVariable Long id) {
        Mascota eliminar = mascotaService.eliminarMascota(id);
        return eliminar != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}