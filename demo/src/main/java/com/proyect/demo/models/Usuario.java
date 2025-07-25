package com.proyect.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "telefono", length = 50)
    private String telefono;

     // Para no exponer la contraseña en las respuestas JSON
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    // Constructor sin id y password (para respuestas públicas)
    public Usuario(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    // Constructor completo sin id (para crear nuevos usuarios)
    public Usuario(String nombre, String apellido, String telefono, String password, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.password = password;
        this.email = email;
    }
}