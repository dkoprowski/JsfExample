package com.example.jeedemo.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name = "material.all", query = "Select m from Material m")
public class Material {
	
	private Long id;

	private String name = "unknown material";
	
	
	private Castle castle = new Castle();
	
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
	
	@ManyToOne
	public Castle getCastle() {
		return castle;
	}
	public void setCastle(Castle c) {
		this.castle = c;
	}
	/*
	@Override
	public String toString(){
		return this.name;
	}*/
}
