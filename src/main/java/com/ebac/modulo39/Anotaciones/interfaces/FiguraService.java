package com.ebac.modulo39.Anotaciones.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FiguraService {
    @Autowired
    @Qualifier("cuadrado")
    Figura figura1;

    @Autowired
    @Qualifier("triangulo")
    Figura figura2;

    public void imprimirNombre1(){
        figura1.nombre();
    }

    public void imprimirNombre2(){
        figura2.nombre();
    }
}
