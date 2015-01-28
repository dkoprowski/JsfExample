package com.example.jeedemo.service;


import java.util.Date;
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
public class CeremonyManager {

	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Ceremony> getAllCeremonies() {
	    Query query = em.createNamedQuery("ceremony.all");
	    return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Ceremony> getCeremonies(long CastleId, float bottomPrice, float upperPrice) {
	    Query query = em.createNamedQuery("ceremony.byCastleAndPrice");
	    query.setParameter("castleId", CastleId);
	    query.setParameter("bottomPrice", bottomPrice);
	    query.setParameter("upperPrice", upperPrice);
	    
	    return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Ceremony> getCeremonies(Date startDate, Date endDate) {
	    Query query = em.createNamedQuery("ceremony.byDate");
	    query.setParameter("startDate", startDate);
	    query.setParameter("endDate", endDate);
	    
	    return query.getResultList();
	}
	
	public void addCeremony(Ceremony ceremony, long id){
		Castle c = em.find(Castle.class, id);
		ceremony.setCastle(c);
		ceremony.setId(null);
		em.persist(ceremony);

	}

}
