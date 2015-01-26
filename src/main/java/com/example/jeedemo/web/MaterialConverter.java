package com.example.jeedemo.web;

import java.math.BigInteger;

import javax.annotation.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.example.jeedemo.domain.Material;

// You must annotate the converter as a managed bean, if you want to inject
// anything into it, like your persistence unit for example.
@Named("materialConverterBean")
@ManagedBean(value = "materialConverterBean") 
@FacesConverter(value = "materialConverter")
public class MaterialConverter implements Converter {

 //   @PersistenceContext(unitName = "luavipuPU")
    // I include this becgdfgdfdsfsdfkoperause you will need to
    // lookup  your entities based on submitted values
    private transient EntityManager em;  

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component,
            String value) {
      // This will return the actual object representation
      // of your Category using the value (in your case 52) 
      // returned from the client side
      return em.find(Material.class, new String("zzzzzzzz")); 
    }

    void koper xD

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        //This will return view-friendly output for the dropdown menu
        return ((Material) o).getId().toString(); 
    }
}