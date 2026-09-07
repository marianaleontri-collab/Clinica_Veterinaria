package com.clinica.clinicaveterinaria.Repository;

import com.clinica.clinicaveterinaria.Entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    // Método para buscar mascotas por ID de propietario
    // Spring Data JPA automáticamente genera la consulta
    List<Mascota> findByPropietarioId(Long propietarioId);
}