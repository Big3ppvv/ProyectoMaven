package com.proyect.demo.controller;

import com.proyect.demo.dao.PersonaDao;
import com.proyect.demo.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaDao personaDao;

    // Endpoint para personas hardcodeadas (para testing)
    @GetMapping(value = "personas/lista_personas")
    public List<Persona> getPersonas() {
        List<Persona> personas = new ArrayList<>();

        Persona persona = new Persona();
        persona.setId(3L);
        persona.setNombre("John");
        persona.setApellido("Doe");
        persona.setEmail("john.doe@gmail.com");
        persona.setTelefono("123456789");

        Persona persona2 = new Persona();
        persona2.setId(4L);
        persona2.setNombre("Jane");
        persona2.setApellido("Smith");
        persona2.setEmail("jane.smith@gmail.com");
        persona2.setTelefono("987654321");

        personas.add(persona);
        personas.add(persona2);
        return personas;
    }

    // Endpoint para personas de la base de datos
    @GetMapping(value = "api/personas")
    public List<Persona> getPersona() {
        return personaDao.obtenerPersonas();
    }
}
