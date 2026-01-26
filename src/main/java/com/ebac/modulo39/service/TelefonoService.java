package com.ebac.modulo39.service;

import com.ebac.modulo39.dto.Telefono;
import com.ebac.modulo39.repository.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefonoService {
    @Autowired
    TelefonoRepository telefonorepository;

    public Telefono crearTelefono(Telefono telefono) throws Exception {
        if(telefono.getNumero().length() <= 15 ){
            return telefonorepository.save(telefono);
        }
        throw new Exception("Telefono invalido");
    }

    public Optional<Telefono> obtenerTelefonoXId(Long id){
        return telefonorepository.findById(id);
    }

    public List<Telefono> listarTelefonos(){
        return telefonorepository.findAll();
    }

    public void actualizarTelefono(Telefono telefono){
        telefonorepository.save(telefono);
    }

    public void eliminarTelefono(Long id){
        telefonorepository.deleteById(id);
    }


}
