package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Province {

	private Long id;

	private String name = "unknown province";
	private int area = 0;
	private int population = 0;
	private int cities = 0;
	
	private List<Castle> castles = new ArrayList<Castle>();
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(min = 2, max = 20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}

	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
	public int getCities() {
		return cities;
	}
	public void setCities(int cities) {
		this.cities = cities;
	}
	
	// Be careful here, both with lazy and eager fetch type
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Castle> getCastles() {
		return castles;
	}
	public void setCastles(List<Castle> castles) {
		this.castles = castles;
	}
}
