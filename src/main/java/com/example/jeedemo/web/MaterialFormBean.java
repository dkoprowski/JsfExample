package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Castle;
import com.example.jeedemo.domain.Material;
import com.example.jeedemo.service.MaterialManager;


@SessionScoped
@Named("materialBean")
public class MaterialFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Material material = new Material();
	private Material materialToShow = new Material();
	private ListDataModel<Material> materials = new ListDataModel<Material>();
	
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
		mm.addMaterial(material);
		return "showMaterials";
		//return null;
	}

	public String deleteMaterial() {
		Material materialToDelete = materials.getRowData();
		mm.deleteMaterial(materialToDelete);
		return null;
	}
	
	public String showDetails() {
		materialToShow = materials.getRowData();
		return "details";
	}
	
	public ListDataModel<Material> getAllMaterials() {
		materials.setWrappedData(mm.getAllMaterials());
		return materials;
	}
	
}
