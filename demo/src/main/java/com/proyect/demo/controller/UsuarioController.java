package com.proyect.demo.controller;

import com.proyect.demo.models.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UsuarioController {


        @RequestMapping(value = "mensaje")
        public String mensaje(){
            return("Hola");
        }

        @RequestMapping(value = "personas")
        public List<String> listarPersonas(){
                return List.of("Joaquin");
        }

    @GetMapping(value = "usuarios/lista_usuarios")
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(3L);
        usuario.setNombre("Big");
        usuario.setApellido("Boss");
        usuario.setEmail("msg3sk@gmail.com");
        usuario.setTelefono("354");

        Usuario usuario2 = new Usuario();
        usuario2.setId(4L);
        usuario2.setNombre("Solid");
        usuario2.setApellido("Snake");
        usuario2.setEmail("msgsk@gmail.com");
        usuario2.setTelefono("124");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        return usuarios;
    }

}
