package com.clinica.veterinaria;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "propietario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es requerido")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El documento es requerido")
    @Column(nullable = false, unique = true, length = 50)
    private String documento;

    @NotBlank(message = "El teléfono es requerido")
    @Column(nullable = false, length = 20)
    private String telefono;

    @NotBlank(message = "El correo es requerido")
    @Email(message = "El correo debe ser válido")
    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mascota> mascotas;
}