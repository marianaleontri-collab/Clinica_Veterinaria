package com.clinica.clinicaveterinaria.Service;

import com.clinica.clinicaveterinaria.Entity.Veterinario;
import com.clinica.clinicaveterinaria.Repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public List<Veterinario> findAll() {
        return veterinarioRepository.findAll();
    }

    public Optional<Veterinario> findById(Long id) {
        return veterinarioRepository.findById(id);
    }

    public Veterinario save(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    public Veterinario update(Long id, Veterinario veterinario) {
        veterinario.setId(id);
        return veterinarioRepository.save(veterinario);
    }

    public void deleteById(Long id) {
        veterinarioRepository.deleteById(id);
    }
}