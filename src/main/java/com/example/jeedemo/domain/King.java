package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name = "king.all", query = "Select k from King k")
public class King {

	private Long id;

	private String name = "unknown king";
	private String familyName = "unknown family";
	private List<Province> provinces = new ArrayList<Province>();
	
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

	@Size(min = 2, max = 20)
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	// Be careful here, both with lazy and eager fetch type
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Province> getProvinces() {
		return provinces;
	}
	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}
}
