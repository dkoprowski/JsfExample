package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.King;


@Stateless
public class KingManager {

	@PersistenceContext
	EntityManager em;

	public void addKing(King king) {
		king.setId(null);
		em.persist(king);
	}

	public void deleteKing(King king) {
		king = em.find(King.class, king.getId());
		em.remove(king);
	}

	@SuppressWarnings("unchecked")
	public List<King> getAllKings() {
		return em.createNamedQuery("king.all").getResultList();
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
