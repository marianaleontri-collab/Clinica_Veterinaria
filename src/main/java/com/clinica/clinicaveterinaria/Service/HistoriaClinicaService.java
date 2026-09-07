package com.clinica.clinicaveterinaria.Service;

import com.clinica.clinicaveterinaria.Entity.HistoriaClinica;
import com.clinica.clinicaveterinaria.Repository.HistoriaClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    public List<HistoriaClinica> findAll() {
        return historiaClinicaRepository.findAll();
    }

    public Optional<HistoriaClinica> findById(Long id) {
        return historiaClinicaRepository.findById(id);
    }

    public HistoriaClinica save(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }

    public HistoriaClinica update(Long id, HistoriaClinica historiaClinica) {
        historiaClinica.setId(id);
        return historiaClinicaRepository.save(historiaClinica);
    }

    public void deleteById(Long id) {
        historiaClinicaRepository.deleteById(id);
    }
}