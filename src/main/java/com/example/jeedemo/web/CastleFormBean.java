package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Castle;
import com.example.jeedemo.domain.Ceremony;
import com.example.jeedemo.domain.Comment;
import com.example.jeedemo.service.CastleManager;



@SessionScoped
@Named("castleBean")
public class CastleFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Castle castle = new Castle();
	private ListDataModel<Castle> castles = new ListDataModel<Castle>();
	
	private Castle castleToShow = new Castle();
	private Comment comment = new Comment();
	
	@Inject
	private CastleManager cm;

	public Castle getCastle() {
		return castle;
	}
	public void setCastle(Castle castle) {
		this.castle = castle;
	}
	
	public ListDataModel<Castle> getAllCastles() {
		castles.setWrappedData(cm.getAllCastles());
		return castles;
	}

	
	// Actions
	public String addCastle() {
		cm.addCastle(castle);
		return "showCastles";
		//return null;
	}

	public String deleteCastle() {
		Castle castleToDelete = castles.getRowData();
		cm.deleteCastle(castleToDelete);
		return null;
	}
	
	public String showDetails() {
		castleToShow = castles.getRowData();
		return "details";
	}
	
	public Castle getCastleToShow(){
		return castleToShow;
	}
	
	public ListDataModel<Ceremony> getCeremonies(){
		ListDataModel<Ceremony> cer = new ListDataModel<Ceremony>();
		cer.setWrappedData(cm.getCeremonies(castleToShow));
		
		return cer;
	}
	
	public ListDataModel<Comment> getComments(){
		ListDataModel<Comment> comm = new ListDataModel<Comment>();
		comm.setWrappedData(cm.getComments(castleToShow));
		
		return comm;
	}

	//------- comment section
	
	public Comment getComment(){
		return comment;
	}
	

	
	public String addComment(){
		comment.setCastle(castleToShow);
		comment.setCommentDate(new Date());
		
		int elements = cm.getComments(castleToShow).size();
		float currentAv = castleToShow.getAverageRate();
		
		castleToShow.setAverageRate((currentAv * elements + comment.getRate())/(elements + 1));
		cm.updateCastle(castleToShow);
		
		cm.addComment(comment);
		return("details");
	}
	
}
