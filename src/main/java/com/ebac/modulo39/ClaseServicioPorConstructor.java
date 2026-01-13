package com.ebac.modulo39;

public class ClaseServicioPorConstructor {
    private final ClaseModelo claseModelo;

    public ClaseServicioPorConstructor(ClaseModelo claseModelo){
        this.claseModelo = claseModelo;
    }

    public void ejecucionTarea(){
        String elementoobtenido = claseModelo.obtenerPorId(1);
        System.out.println("Elemento recibido: " + elementoobtenido);
    }
}
