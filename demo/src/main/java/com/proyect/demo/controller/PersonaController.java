package com.proyect.demo.controller;

import com.proyect.demo.dao.PersonaDao;
import com.proyect.demo.models.Persona;
import com.proyect.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PersonaController {

    @Autowired
    private PersonaDao personaDao;


    @GetMapping(value = "api/persona")
    public List<Persona> getPersona(){
        return personaDao.obtenerPersona();
    }


}
