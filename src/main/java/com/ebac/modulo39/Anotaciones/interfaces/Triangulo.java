package com.ebac.modulo39.Anotaciones.interfaces;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("triangulo")
public class Triangulo implements Figura{
    @Override
    public void nombre() {
        System.out.println("Triangulo");
    }
}
