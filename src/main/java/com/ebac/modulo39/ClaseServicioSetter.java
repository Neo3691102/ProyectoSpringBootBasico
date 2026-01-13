package com.ebac.modulo39;

public class ClaseServicioSetter {

    private ClaseModelo claseModelo;

    public void ejecucionTarea(){
        String elementoobtenido = claseModelo.obtenerPorId(1);
        System.out.println("Elemento recibido: " + elementoobtenido);
    }

    public void setClaseModelo(ClaseModelo claseModelo) {
        this.claseModelo = claseModelo;
    }
}
