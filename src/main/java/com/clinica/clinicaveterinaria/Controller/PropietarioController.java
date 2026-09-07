package com.clinica.clinicaveterinaria.Controller;

import com.clinica.clinicaveterinaria.Entity.Propietario;
import com.clinica.clinicaveterinaria.Service.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propietarios")
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping
    public List<Propietario> getAllPropietarios() {
        return propietarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propietario> getPropietarioById(@PathVariable Long id) {
        return propietarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Propietario> createPropietario(@RequestBody Propietario propietario) {
        Propietario nuevoPropietario = propietarioService.save(propietario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPropietario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Propietario> updatePropietario(@PathVariable Long id, @RequestBody Propietario propietario) {
        return propietarioService.findById(id)
                .map(existingPropietario -> {
                    propietario.setId(id);
                    return ResponseEntity.ok(propietarioService.save(propietario));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePropietario(@PathVariable Long id) {
        return propietarioService.findById(id)
                .map(existingPropietario -> {
                    propietarioService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}