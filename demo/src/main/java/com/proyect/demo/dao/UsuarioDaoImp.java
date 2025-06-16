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
        try {
            String query = "SELECT u FROM Usuario u";
            List<Usuario> usuarios = entityManager.createQuery(query, Usuario.class).getResultList();
            System.out.println("Usuarios encontrados: " + usuarios.size());
            return usuarios;
        } catch (Exception e) {
            System.err.println("Error al obtener usuarios: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}