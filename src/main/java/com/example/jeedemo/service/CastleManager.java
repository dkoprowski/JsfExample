package com.example.jeedemo.service;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.jeedemo.domain.Castle;
import com.example.jeedemo.domain.Ceremony;
import com.example.jeedemo.domain.Comment;



@Stateless
public class CastleManager {

	@PersistenceContext
	EntityManager em;

	public void addCastle(Castle castle) {
		castle.setId(null);
		em.persist(castle);
	}
	public void addComment(Comment comment){
		comment.setId(null);
		em.persist(comment);
	}
	public void deleteCastle(Castle castle) {
		castle = em.find(Castle.class, castle.getId());
		em.remove(castle);
	}
	
	public void updateCastle(Castle castle) {

		Castle cas = (Castle)em.find(Castle.class, castle.getId());
		cas.setAverageRate(castle.getAverageRate());
		
		em.flush();
	}
	
	@SuppressWarnings("unchecked")
	public List<Castle> getAllCastles() {
		return em.createNamedQuery("castle.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Comment> getComments(Castle actualCastle) {
	    Query query = em.createNamedQuery("comment.byCastle");
	    return query.setParameter("castleId", actualCastle.getId()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Ceremony> getCeremonies(Castle actualCastle) {
	    Query query = em.createNamedQuery("ceremony.byCastle");
	    return query.setParameter("castleId", actualCastle.getId()).getResultList();
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
