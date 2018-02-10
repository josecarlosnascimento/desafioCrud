package br.com.desafio.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionManager {
	
	private static EntityManagerFactory factory;

	public static EntityManagerFactory  open(){
		if(factory == null){
			factory = Persistence.createEntityManagerFactory("connectH2");
		}
		
		return factory;
	}
	
}
