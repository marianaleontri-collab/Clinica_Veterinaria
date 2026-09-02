package com.clinica.veterinaria;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "historia_clinica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha de apertura es requerida")
    @Column(nullable = false)
    private LocalDate fechaApertura;

    @NotBlank(message = "Los antecedentes son requeridos")
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String antecedentes;

    @NotBlank(message = "Las observaciones son requeridas")
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String observaciones;

    @OneToOne
    @JoinColumn(name = "mascota_id", nullable = false, unique = true)
    private Mascota mascota;
}