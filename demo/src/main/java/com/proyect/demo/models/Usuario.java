package com.proyect.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // Constructor sin id (para crear nuevos usuarios)
    public Usuario(String nombre, String apellido, String telefono, String password, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.password = password;
        this.email = email;
    }
}