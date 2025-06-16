package com.proyect.demo.controller;

import com.proyect.demo.dao.UsuarioDao;
import com.proyect.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    // Endpoint para usuarios hardcodeados (para testing)
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

    // Endpoint para usuarios de la base de datos con manejo de errores
    @GetMapping(value = "api/usuarios")
    public ResponseEntity<?> getUsuario(){
        try {
            List<Usuario> usuarios = usuarioDao.obtenerUsuarios();
            if (usuarios.isEmpty()) {
                return ResponseEntity.ok("No hay usuarios registrados en la base de datos");
            }
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener usuarios: " + e.getMessage());
        }
    }

    // Endpoint adicional para verificar conexión
    @GetMapping(value = "api/test-connection")
    public ResponseEntity<String> testConnection() {
        try {
            usuarioDao.obtenerUsuarios();
            return ResponseEntity.ok("Conexión a la base de datos exitosa");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error de conexión: " + e.getMessage());
        }
    }
}