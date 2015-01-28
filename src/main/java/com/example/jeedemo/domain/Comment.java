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

@Entity

@NamedQueries({
	@NamedQuery(name = "comment.all", query = "SELECT c FROM Comment c"),
	@NamedQuery(name = "comment.byCastle", query = "SELECT c FROM Comment c "
			+ "WHERE c.castle.id = :castleId "
			+ "ORDER BY c.commentDate ASC, "
			+ "c.rate DESC")
})
public class Comment {

	private Long id;

	private String value = "";
	private int rate = 0;
	private String user = "";
	private Date commentDate = new Date();
	private Castle castle;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(min = 2, max = 200)
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Size(min = 2, max = 20)
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.REFRESH)
	public Castle getCastle(){
		return castle;
	}
	
	public void setCastle(Castle castle){
		this.castle = castle;
	}
	
	@SuppressWarnings("deprecation")
	public String getNiceDate() {
		return commentDate.toLocaleString();
	}
}
