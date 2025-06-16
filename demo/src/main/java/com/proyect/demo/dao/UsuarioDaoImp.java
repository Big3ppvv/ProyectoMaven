package com.proyect.demo.dao;

import com.proyect.demo.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @Override
    public List<Usuario> obtenerUsuarios(){

        private EntityManager entityManager;

        String query = "from Usuario";

        return entityManager.createQuery(query).getResultList();
    }
}
