package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Castle;
import com.example.jeedemo.domain.Ceremony;
import com.example.jeedemo.service.CastleManager;
import com.example.jeedemo.service.CeremonyManager;



@SessionScoped
@Named("ceremonyBean")
public class CeremonyFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Ceremony ceremony = new Ceremony();
	private ListDataModel<Ceremony> currentCeremonies = new ListDataModel<Ceremony>();
	
	private long castleId = 0;
	private float bottomPrice = 0;
	private float upperPrice = 0;
	private Date endDate;
	private Date startDate;
	
	private Ceremony ceremonyToShow = new Ceremony();

	
	@Inject
	private CeremonyManager ceremonyManager;

	public Ceremony getCeremony() {
		return ceremony;
	}
	public void setCeremony(Ceremony ceremony) {
		this.ceremony = ceremony;
	}
	
	public String addCeremony(){
		ceremonyManager.addCeremony(ceremony,castleId);
		return "home";
	}
	
	public void setCastleId(long id){
		this.castleId = id;
	}
	
	public long getCastleId(){
		return castleId;
	}
	
	public void setBottomPrice(float price){
		this.bottomPrice = price;
	}
	
	public float getBottomPrice(){
		return bottomPrice;
	}
	public void setUpperPrice(float price){
		this.upperPrice = price;
	}
	
	public float getUpperPrice(){
		return upperPrice;
	}
	public ListDataModel<Ceremony> getCurrentCeremonies() {
		//currentCeremonies.setWrappedData(ceremonyManager.getAllCeremonies());
		return currentCeremonies;
	}
	
	public String findCeremonies(){
		currentCeremonies.setWrappedData(ceremonyManager.getCeremonies(castleId,bottomPrice,upperPrice));
		return "showCeremonies";
	}

	public String findCeremoniesByDate(){
		currentCeremonies.setWrappedData(ceremonyManager.getCeremonies(startDate, endDate));
		return "showCeremonies";
	}
	
	public Date getStartDate(){
		return startDate;
	}
	
	public void setStartDate(Date d){
		this.startDate = d;
	}
	
	public Date getEndDate(){
		return endDate;
	}
	
	public void setEndDate(Date d){
		this.endDate = d;
	}
}
