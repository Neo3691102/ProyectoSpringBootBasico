package com.ebac.modulo39;

import org.springframework.beans.factory.annotation.Autowired;

public class ClaseServicioPorAnotacion {
    @Autowired
    ClaseModelo claseModelo;

    public void ejecucionTarea(int id){
        claseModelo.obtenerPorId(id);
        System.out.println("El id# " + id + "fue encontrado");
    }
}
