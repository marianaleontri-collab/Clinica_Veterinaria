package com.clinica.veterinaria;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "veterinario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es requerido")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "La tarjeta profesional es requerida")
    @Column(nullable = false, unique = true, length = 50)
    private String tarjetaProfesional;

    @NotBlank(message = "La especialidad es requerida")
    @Column(nullable = false, length = 100)
    private String especialidad;

    @NotBlank(message = "El correo es requerido")
    @Email(message = "El correo debe ser válido")
    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @ManyToMany(mappedBy = "veterinarios")
    private List<Mascota> mascotas;
}