package com.proyect.demo.dao;

import com.proyect.demo.models.Persona;
import jakarta.transaction.Transactional;


import java.util.List;
@Transactional
public interface PersonaDao {
    List<Persona> obtenerPersona();
}
