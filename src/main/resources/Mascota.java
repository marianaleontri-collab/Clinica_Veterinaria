package com.clinica.veterinaria;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "mascota")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es requerido")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "La especie es requerida")
    @Column(nullable = false, length = 50)
    private String especie;

    @NotBlank(message = "La raza es requerida")
    @Column(nullable = false, length = 50)
    private String raza;

    @NotNull(message = "La edad es requerida")
    @Min(value = 0, message = "La edad debe ser mayor a 0")
    @Column(nullable = false)
    private Integer edad;

    @NotNull(message = "El peso es requerido")
    @Min(value = 0, message = "El peso debe ser mayor a 0")
    @Column(nullable = false)
    private Double peso;

    @ManyToOne
    @JoinColumn(name = "propietario_id", nullable = false)
    private Propietario propietario;

    @OneToOne(mappedBy = "mascota", cascade = CascadeType.ALL, orphanRemoval = true)
    private HistoriaClinica historiaClinica;

    @ManyToMany
    @JoinTable(
            name = "mascota_veterinario",
            joinColumns = @JoinColumn(name = "mascota_id"),
            inverseJoinColumns = @JoinColumn(name = "veterinario_id")
    )
    private List<Veterinario> veterinarios;
}
