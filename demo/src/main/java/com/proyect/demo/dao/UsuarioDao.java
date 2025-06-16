package com.proyect.demo.dao;

import com.proyect.demo.models.Usuario;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public interface UsuarioDao {

    default List<Usuario> obtenerUsuarios(){
        return null;
    }
}
