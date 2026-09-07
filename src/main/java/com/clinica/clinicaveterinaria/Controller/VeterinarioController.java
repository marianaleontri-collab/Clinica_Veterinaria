package com.clinica.clinicaveterinaria.Controller;

import com.clinica.clinicaveterinaria.Entity.Veterinario;
import com.clinica.clinicaveterinaria.Service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping
    public List<Veterinario> getAllVeterinarios() {
        return veterinarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> getVeterinarioById(@PathVariable Long id) {
        return veterinarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Veterinario> createVeterinario(@RequestBody Veterinario veterinario) {
        Veterinario nuevoVeterinario = veterinarioService.save(veterinario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoVeterinario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veterinario> updateVeterinario(@PathVariable Long id, @RequestBody Veterinario veterinario) {
        return veterinarioService.findById(id)
                .map(existingVeterinario -> {
                    veterinario.setId(id);
                    return ResponseEntity.ok(veterinarioService.save(veterinario));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeterinario(@PathVariable Long id) {
        return veterinarioService.findById(id)
                .map(existingVeterinario -> {
                    veterinarioService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}