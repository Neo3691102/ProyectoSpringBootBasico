package com.ebac.modulo39.Anotaciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON) //igual por default es singleton
public class Service {
    @Autowired //inyeccion de dependencia de la clase DataBase
    DataBase dB;

    public String getById(int id){
        if(id < 10){
            return "El id no puede ser menor que 10";
        }
        return dB.getById(id);
    }
}
