package com.example.jeedemo.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name = "castle.all", query = "Select c from Castle c")
public class Castle {

	private Long id;

	private String name = "unknown castle";
	private int numberOfSeats = 0;
	
	private Date buildDate = new Date();
	
	private List<Comment> comments = new ArrayList<Comment>();
	
	private List<Ceremony> ceremonies = new ArrayList<Ceremony>();
	
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


	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getBuildDate() {
		return buildDate;
	}
	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Comment> getComments(){
		return comments;
	}
	
	public void setComments(List<Comment> comm){
		comments = comm;
	}
	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Ceremony> getCeremonies(){
		return ceremonies;
	}
	
	public void setCeremonies(List<Ceremony> cer){
		ceremonies = cer;
	}
}
