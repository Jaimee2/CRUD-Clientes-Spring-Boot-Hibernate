package com.PracticandoHibernate.PracticandoHibernate;

import com.PracticandoHibernate.PracticandoHibernate.Modelos.Cliente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class PracticandoHibernateApplication {


	public static void main(String[] args) {

		SpringApplication.run(PracticandoHibernateApplication.class, args);
		System.out.println("Servidor corriendo");

	}

}
