package com.clinica.clinicaveterinaria.Controller;

import com.clinica.clinicaveterinaria.Entity.HistoriaClinica;
import com.clinica.clinicaveterinaria.Service.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historias-clinicas")
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @GetMapping
    public List<HistoriaClinica> getAllHistoriasClinicas() {
        return historiaClinicaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinica> getHistoriaClinicaById(@PathVariable Long id) {
        return historiaClinicaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HistoriaClinica> createHistoriaClinica(@RequestBody HistoriaClinica historiaClinica) {
        HistoriaClinica nuevaHistoriaClinica = historiaClinicaService.save(historiaClinica);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaHistoriaClinica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriaClinica> updateHistoriaClinica(@PathVariable Long id, @RequestBody HistoriaClinica historiaClinica) {
        return historiaClinicaService.findById(id)
                .map(existingHistoriaClinica -> {
                    historiaClinica.setId(id);
                    return ResponseEntity.ok(historiaClinicaService.save(historiaClinica));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistoriaClinica(@PathVariable Long id) {
        return historiaClinicaService.findById(id)
                .map(existingHistoriaClinica -> {
                    historiaClinicaService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}