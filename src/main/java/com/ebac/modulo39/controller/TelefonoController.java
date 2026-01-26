package com.ebac.modulo39.controller;

import com.ebac.modulo39.dto.Telefono;
import com.ebac.modulo39.dto.Usuario;
import com.ebac.modulo39.repository.TelefonoRepository;
import com.ebac.modulo39.service.TelefonoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class TelefonoController {
    @Autowired
    TelefonoService telefonoservice;

    @GetMapping("/telefonos")
    public ResponseWrapper<List<Telefono>> obtenerTelefonos(){
        log.info("Obteniendo telefonos...");
        List<Telefono> telefonoList = telefonoservice.listarTelefonos();
        ResponseEntity<List<Telefono>> responseEntity = ResponseEntity.ok(telefonoList);

        return new ResponseWrapper<>(true, "Listado de telefonos", responseEntity);
    }

    @GetMapping("/telefonos/{id}")
    public ResponseWrapper<Telefono> obtenerTelefonoXId(@PathVariable Long id){
        Optional<Telefono> optionalTelefono = telefonoservice.obtenerTelefonoXId(id);
        log.info("Obteniendo telefono por id {}...", id);
        ResponseEntity<Telefono> telefonoResponseEntity =
                optionalTelefono.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        return new ResponseWrapper<>(true, "Informacion del telefono " + id, telefonoResponseEntity);


    }

    @PostMapping("/telefonos")
    public ResponseWrapper<Telefono> crearTelefono(@RequestBody Telefono telefono) {
        try{
            Telefono telefonocreado = telefonoservice.crearTelefono(telefono);
            ResponseEntity<Telefono> responseEntity = ResponseEntity.created(new URI("http://localhost/telefonos")).body(telefonocreado);
            return new ResponseWrapper<>(true, "Telefono creado exitosamente", responseEntity);
        } catch (Exception e) {
            ResponseEntity<Telefono> responseEntity = ResponseEntity.badRequest().build();
            return new ResponseWrapper<>(false, e.getMessage(), responseEntity);
        }

    }

    @PutMapping("/telefonos/{id}")
    public ResponseWrapper<Telefono> actualizarTelefono(@PathVariable Long id, @RequestBody Telefono telefonoActualizar){
        Optional<Telefono> telefonoOptional = telefonoservice.obtenerTelefonoXId(id);
        if(telefonoOptional.isPresent()){
            telefonoActualizar.setIdTelefono(telefonoOptional.get().getIdTelefono());
            telefonoservice.actualizarTelefono(telefonoActualizar);

            ResponseEntity<Telefono> responseEntity = ResponseEntity.ok(telefonoActualizar);
            return new ResponseWrapper<>(true, "Telefono actualizado correctamente", responseEntity);
        }else{
            ResponseEntity<Telefono> responseEntity = ResponseEntity.notFound().build();
            return new ResponseWrapper<>(false, "El telefono indicado no existe", responseEntity); //responde con error 404
        }
    }

    @DeleteMapping("/telefonos/{id}")
    public ResponseWrapper<Void> eliminarTelefono(@PathVariable Long id){
        telefonoservice.eliminarTelefono(id);

        ResponseEntity<Void> responseEntity = ResponseEntity.noContent().build();
        return new ResponseWrapper<>(true, "Telefono eliminado correctamente", responseEntity);
    }
}
