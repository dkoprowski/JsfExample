package com.example.jeedemo.domain;


import java.text.DecimalFormat;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
	@NamedQuery(name = "castle.all", query = "Select c from Castle c order by c.averageRate desc")

})

public class Castle {

	private Long id;

	private String name = "unknown castle";
	private String lastKing = "king";
	private int numberOfSeats = 0;
	
	private float averageRate = 0;
	
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

	public String getLastKing() {
		return lastKing;
	}
	public void setLastKing(String name) {
		this.lastKing = name;
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
	
	public int getAge() {
		return (new Date().getYear() - buildDate.getYear());
	}
	
	public float getAverageRate(){
		float x = Math.round(averageRate * 100);
		return (x/100);
	   
	}
	
	public void setAverageRate(float a){
		this.averageRate = a;
	}
	
	public String getRecomendation(){
		if(getAverageRate() >= 4)
			return "Polecane!";
		else
			return "";
	}
	/*
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
	*/
}
