package com.ebac.modulo39.controller;

import com.ebac.modulo39.dto.Usuario;
import com.ebac.modulo39.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.created;

@Slf4j
@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseWrapper<List<Usuario>> obtenerUsuarios(){
        log.info("Obteniendo usuarios...");
        List<Usuario> usuarioList = usuarioService.obtenerUsuarios();
        ResponseEntity<List<Usuario>> responseEntity = ResponseEntity.ok(usuarioList);

        return new ResponseWrapper<>(true, "Listado de usuarios", responseEntity);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseWrapper<Usuario> obtenerUsuarioXId(@PathVariable Long id){
        Optional<Usuario> optionalUsuario = usuarioService.obtenerUsuarioPorId(id);
        log.info("Obteniendo usuario por id {}...", id);
        ResponseEntity<Usuario> usuarioResponseEntity =
                optionalUsuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        return new ResponseWrapper<>(true, "Informacion del usuario " + id, usuarioResponseEntity);


    }

    @PostMapping("/usuarios")
    public ResponseWrapper<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        try{
            Usuario usuariocreado = usuarioService.crearUsuario(usuario);
            ResponseEntity<Usuario> responseEntity = ResponseEntity.created(new URI("http://localhost/usuarios")).body(usuariocreado);
            return new ResponseWrapper<>(true, "Usuario creado exitosamente", responseEntity);
        } catch (Exception e) {
            ResponseEntity<Usuario> responseEntity = ResponseEntity.badRequest().build();
            return new ResponseWrapper<>(false, e.getMessage(), responseEntity);
        }

    }

    @PutMapping("/usuarios/{id}")
    public ResponseWrapper<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuariosActualizar){
        Optional<Usuario> usuarioOptional = usuarioService.obtenerUsuarioPorId(id);
        if(usuarioOptional.isPresent()){
            usuariosActualizar.setIdUsuario(usuarioOptional.get().getIdUsuario());
            usuarioService.actualizarUsuario(usuariosActualizar);

            ResponseEntity<Usuario> responseEntity = ResponseEntity.ok(usuariosActualizar);
            return new ResponseWrapper<>(true, "Usuario actualizado correctamente", responseEntity);
        }else{
            ResponseEntity<Usuario> responseEntity = ResponseEntity.notFound().build();
            return new ResponseWrapper<>(false, "El usuario indicado no existe", responseEntity); //responde con error 404
        }
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseWrapper<Void> eliminarUsuario(@PathVariable Long id){
        usuarioService.eliminarUsuario(id);

        ResponseEntity<Void> responseEntity = ResponseEntity.noContent().build();
        return new ResponseWrapper<>(true, "Usuario eliminado correctamente", responseEntity);
    }
}
