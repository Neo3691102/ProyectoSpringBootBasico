package com.ebac.modulo39.Anotaciones.service;

import org.springframework.beans.factory.annotation.Value;

public class DataBase {

    @Value("${db.dev.url}")
    String dbUrl;

    @Value("root")
    String user;

    @Value("${VARIABLE_AMBIENTE}")
    String variableDeAmbiente;

    public String getById(int id){
        System.out.println("Url hacia la base de datos: " + dbUrl);
        System.out.println("Usuario por default: " + user);
        System.out.println("Valor de mi variable de ambiente: " + variableDeAmbiente);
        return "Elemento con id #" + id + " encontrado";
    }
}
