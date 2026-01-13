package com.ebac.modulo39.Anotaciones;

import com.ebac.modulo39.Anotaciones.interfaces.FiguraService;
import com.ebac.modulo39.Anotaciones.service.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Contexto {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.ebac.modulo39.Anotaciones");
        context.refresh();

        Service service = context.getBean(Service.class);
        String byId = service.getById(18);
        System.out.println(byId);

        FiguraService fservice = context.getBean(FiguraService.class);
        fservice.imprimirNombre1();
        fservice.imprimirNombre2();
    }
}
