package com.proyect.demo.dao;

import com.proyect.demo.models.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class PersonaDaoImp implements PersonaDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Persona> obtenerPersona() {
        // Corregido: usar el nombre de la clase de entidad, no el nombre de la tabla
        String query = "SELECT p FROM Persona p";
        return entityManager.createQuery(query, Persona.class).getResultList();
    }
}