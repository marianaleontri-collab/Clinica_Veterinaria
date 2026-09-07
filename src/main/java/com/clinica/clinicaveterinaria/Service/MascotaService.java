package com.clinica.clinicaveterinaria.Service;

import com.clinica.clinicaveterinaria.Entity.Mascota;
import com.clinica.clinicaveterinaria.Entity.Veterinario;
import com.clinica.clinicaveterinaria.Repository.MascotaRepository;
import com.clinica.clinicaveterinaria.Repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    // Buscar todas las mascotas
    public List<Mascota> findAll() {
        return mascotaRepository.findAll();
    }

    // Buscar por ID
    public Optional<Mascota> findById(Long id) {
        return mascotaRepository.findById(id);
    }

    // Guardar mascota
    public Mascota save(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    // Actualizar mascota
    public Mascota update(Long id, Mascota mascota) {
        mascota.setId(id);
        return mascotaRepository.save(mascota);
    }

    // Eliminar mascota
    public void deleteById(Long id) {
        mascotaRepository.deleteById(id);
    }

    // EXTRA 1: Buscar mascotas por propietario
    public List<Mascota> findByPropietarioId(Long propietarioId) {
        return mascotaRepository.findByPropietarioId(propietarioId);
    }

    // EXTRA 2: Asignar un veterinario a una mascota
    public Mascota asignarVeterinario(Long mascotaId, Long veterinarioId) {
        Optional<Mascota> mascotaOpt = mascotaRepository.findById(mascotaId);
        Optional<Veterinario> veterinarioOpt = veterinarioRepository.findById(veterinarioId);

        if (mascotaOpt.isPresent() && veterinarioOpt.isPresent()) {
            Mascota mascota = mascotaOpt.get();
            Veterinario veterinario = veterinarioOpt.get();

            // Verificar que la lista no sea null
            if (mascota.getVeterinarios() == null) {
                mascota.setVeterinarios(new ArrayList<>());
            }

            // Agregar el veterinario a la lista de veterinarios de la mascota
            mascota.getVeterinarios().add(veterinario);

            // Guardar la mascota actualizada
            return mascotaRepository.save(mascota);
        } else {
            throw new RuntimeException("Mascota o Veterinario no encontrado");
        }
    }
}