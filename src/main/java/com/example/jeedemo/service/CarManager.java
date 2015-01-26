package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Car;
import com.example.jeedemo.domain.Person;

@Stateless
public class CarManager {

	@PersistenceContext
	EntityManager em;

	public void addCar(Car car) {
		car.setId(null);
		em.persist(car);
	}

	public void deleteCar(Car car) {
		car = em.find(Car.class, car.getId());
		em.remove(car);
	}

	@SuppressWarnings("unchecked")
	public List<Car> getAllCars() {
		return em.createNamedQuery("car.all").getResultList();
	}
/*
	public Person getOwner(Car car){
		car = em.find(Car.class, car.getId());
		// lazy loading here - try this code without this (shallow) copying
		Person owner = new Person(car.getOwner);
		return owner;
	}
	*/
	public List<Car> getOwnedCars(Person person) {
		person = em.find(Person.class, person.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Car> cars = new ArrayList<Car>(person.getCars());
		return cars;
	}

}
