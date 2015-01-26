package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Castle;
import com.example.jeedemo.domain.Material;
import com.example.jeedemo.domain.Person;


@Stateless
public class CastleManager {

	@PersistenceContext
	EntityManager em;

	public void addCastle(Castle castle) {
		castle.setId(null);
		em.persist(castle);
	}

	public void deleteCastle(Castle castle) {
		castle = em.find(Castle.class, castle.getId());
		em.remove(castle);
	}
	
	@SuppressWarnings("unchecked")
	public List<Castle> getAllCastles() {
		return em.createNamedQuery("castle.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getAllMaterials() {
		return em.createNamedQuery("material.all").getResultList();
	}
/*
	public List<Car> getOwnedCars(Person person) {
		person = em.find(Person.class, person.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Car> cars = new ArrayList<Car>(person.getCars());
		return cars;
	}
*/
}
