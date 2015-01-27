package com.example.jeedemo.domain;


import java.util.Date;

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
import javax.ws.rs.FormParam;

@Entity
@NamedQueries({
	@NamedQuery(name = "ceremony.all", query = "Select c from Ceremony c"),
	@NamedQuery(name = "ceremony.byCastle", query = "Select c from Ceremony c where c.castle.id = :castleId")
})
public class Ceremony {



	private Long id;

	private String name = "unknown";
	private float ticketPrice = 0;
	
	private Date ceremonyDate = new Date();
	private Castle castle;
	
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


	public float getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getCeremonyDate() {
		return ceremonyDate;
	}
	public void setCeremonyDate(Date ceremonyDate) {
		this.ceremonyDate = ceremonyDate;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	public Castle getCastle(){
		return castle;
	}
	
	public void setCastle(Castle castle){
		this.castle = castle;
	}
	
}
