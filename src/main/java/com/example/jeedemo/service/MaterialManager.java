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
public class MaterialManager {

	@PersistenceContext
	EntityManager em;

	public void addMaterial(Material material) {
		material.setId(null);
		em.persist(material);
	}

	public void deleteMaterial(Material material) {
		material = em.find(Material.class, material.getId());
		em.remove(material);
	}
	
	@SuppressWarnings("unchecked")
	public List<Material> getAllMaterials() {
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
