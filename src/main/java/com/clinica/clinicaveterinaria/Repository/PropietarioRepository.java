package com.clinica.clinicaveterinaria.Repository;

import com.clinica.clinicaveterinaria.Entity.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {
}