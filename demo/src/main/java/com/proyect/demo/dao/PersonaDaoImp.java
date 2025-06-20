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
        String query = "SELECT u FROM persona u";
        return entityManager.createQuery(query, Persona.class).getResultList();
    }
}
