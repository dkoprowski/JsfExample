package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Castle;
import com.example.jeedemo.domain.Person;
import com.example.jeedemo.domain.Material;
import com.example.jeedemo.service.CastleManager;
import com.example.jeedemo.service.MaterialManager;


@SessionScoped
@Named("castleBean")
public class CastleFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Castle castle = new Castle();
	private ListDataModel<Castle> castles = new ListDataModel<Castle>();
	
	private Castle castleToShow = new Castle();
	private ListDataModel<Material> materials = new ListDataModel<Material>();
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
		addMaterial();
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
	
	public ListDataModel<Material> getAllMaterials() {
		materials.setWrappedData(cm.getAllMaterials());
		return materials;
	}

	private Material material = new Material();
	private Material materialToShow = new Material();
	
	@Inject
	private MaterialManager mm;

	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	// Actions
	public String addMaterial() {
		material.setCastle(castle);
		mm.addMaterial(material);
		return "showMaterials";
		//return null;
	}

	public String deleteMaterial() {
		Material materialToDelete = materials.getRowData();
		mm.deleteMaterial(materialToDelete);
		return null;
	}
	
	
}
