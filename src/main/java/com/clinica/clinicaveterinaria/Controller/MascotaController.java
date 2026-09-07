package com.clinica.clinicaveterinaria.Controller;

import com.clinica.clinicaveterinaria.Entity.Mascota;
import com.clinica.clinicaveterinaria.Service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    // Obtener todas las mascotas
    @GetMapping
    public List<Mascota> getAllMascotas() {
        return mascotaService.findAll();
    }

    // Obtener mascota por ID
    @GetMapping("/{id}")
    public ResponseEntity<Mascota> getMascotaById(@PathVariable Long id) {
        return mascotaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva mascota
    @PostMapping
    public ResponseEntity<Mascota> createMascota(@RequestBody Mascota mascota) {
        Mascota nuevaMascota = mascotaService.save(mascota);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMascota);
    }

    // Actualizar mascota
    @PutMapping("/{id}")
    public ResponseEntity<Mascota> updateMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        return mascotaService.findById(id)
                .map(existingMascota -> {
                    Mascota actualizada = mascotaService.update(id, mascota);
                    return ResponseEntity.ok(actualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar mascota
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMascota(@PathVariable Long id) {
        return mascotaService.findById(id)
                .map(existingMascota -> {
                    mascotaService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // EXTRA 1: Buscar mascotas por propietario
    @GetMapping("/propietario/{propietarioId}")
    public ResponseEntity<List<Mascota>> getMascotasByPropietario(@PathVariable Long propietarioId) {
        List<Mascota> mascotas = mascotaService.findByPropietarioId(propietarioId);
        if (mascotas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mascotas);
    }

    // EXTRA 2: Asignar un veterinario a una mascota
    @PostMapping("/{mascotaId}/veterinarios/{veterinarioId}")
    public ResponseEntity<Mascota> asignarVeterinario(
            @PathVariable Long mascotaId,
            @PathVariable Long veterinarioId) {
        try {
            Mascota mascotaActualizada = mascotaService.asignarVeterinario(mascotaId, veterinarioId);
            return ResponseEntity.ok(mascotaActualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}