package com.clinica.clinicaveterinaria.Service;

import com.clinica.clinicaveterinaria.Entity.Propietario;
import com.clinica.clinicaveterinaria.Repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropietarioService {

    @Autowired
    private PropietarioRepository propietarioRepository;

    public List<Propietario> findAll() {
        return propietarioRepository.findAll();
    }

    public Optional<Propietario> findById(Long id) {
        return propietarioRepository.findById(id);
    }

    public Propietario save(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    public Propietario update(Long id, Propietario propietario) {
        propietario.setId(id);
        return propietarioRepository.save(propietario);
    }

    public void deleteById(Long id) {
        propietarioRepository.deleteById(id);
    }
}