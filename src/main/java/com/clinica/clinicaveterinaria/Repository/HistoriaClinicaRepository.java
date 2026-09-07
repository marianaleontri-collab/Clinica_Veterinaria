package com.clinica.clinicaveterinaria.Repository;

import com.clinica.clinicaveterinaria.Entity.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {
}