package com.proyect.demo.dao;

import com.proyect.demo.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> obtenerUsuarios() {
        String query = "SELECT u FROM Usuario u";
        return entityManager.createQuery(query, Usuario.class).getResultList();
    }
}