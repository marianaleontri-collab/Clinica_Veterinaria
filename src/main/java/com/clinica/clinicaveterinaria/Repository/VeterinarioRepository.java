package com.clinica.clinicaveterinaria.Repository;

import com.clinica.clinicaveterinaria.Entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}