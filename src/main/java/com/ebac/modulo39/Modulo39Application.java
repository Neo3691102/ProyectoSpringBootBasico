package com.ebac.modulo39;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Modulo39Application {

	public static void main(String[] args) {

		SpringApplication.run(Modulo39Application.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		//BEAN POR SETTER
		//Obtener el bean
//		ClaseServicioSetter primerBean = (ClaseServicioSetter) context.getBean("claseServicioBean");
//		primerBean.ejecucionTarea();

		//BEAN POR CONSTRUCTOR
//		ClaseServicioPorConstructor beanXc = (ClaseServicioPorConstructor)
//				context.getBean("claseServicioXconstructor");
//
//		beanXc.ejecucionTarea();

		ClaseServicioPorAnotacion b = (ClaseServicioPorAnotacion) context.getBean("cSxAnotacion");
		b.ejecucionTarea(3);


	}

}
