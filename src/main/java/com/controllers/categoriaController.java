/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.entidades.Categoria;
import com.facade.CategoriaFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import recursos.Constantes;

/**
 *
 * @author monicaCastellanos
 */
@Named(value = "categoriaC")
@ViewScoped
public class categoriaController implements Serializable{
 @EJB
 CategoriaFacade categoriaFacade;
 private Categoria categoria;
 private String categorianame;
 private String descripcionCategoria;
 private List<Categoria>listaCategoriasCargue= new ArrayList();
 

    @PostConstruct
    public void init( ) {
    categoria= new Categoria();
    
   
    }

     
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getCategorianame() {
        return categorianame;
    }

    public void setCategorianame(String categorianame) {
        this.categorianame = categorianame;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public List<Categoria> getListaCategoriasCargue() {
        return listaCategoriasCargue;
    }

    public void setListaCategoriasCargue(List<Categoria> listaCategoriasCargue) {
        this.listaCategoriasCargue = listaCategoriasCargue;
    }



   
    
    
    
  public void insertarCategoria() {
    
      FacesContext context = FacesContext.getCurrentInstance();
       
        if (categorianame!= null
                && !categorianame.equals("")) {

            categoria.setEstadoCategoria(1);
            categoria.setNombreCategoria(categorianame);
            categoria.setDescripcionCategoia(descripcionCategoria);
            try {
                categoriaFacade.create(categoria);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitud categoria", "Se ha creado de manera correcta la categoria "+categorianame));
                categoria=null;
            } catch (Exception e) {

                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Solicitud categoria", Constantes.ERRORGENERAL.getTipoRol()));
                e.printStackTrace();
            }
        }

    }
  
  public List<Categoria> listarCategorias(){
    FacesContext context = FacesContext.getCurrentInstance();
      List<Categoria> categoriasActivas = null;
     
      try {
          categoriasActivas = categoriaFacade.listarCategoriasActivas();
          listaCategoriasCargue=categoriasActivas;

      } catch (Exception e) {

          context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Solicitud categoria", Constantes.ERRORCARGUE.getTipoRol()));
          e.printStackTrace();
      }

      return categoriasActivas;

 }
  
  
  public void eliminarCategoria( Categoria categoria){
  
      FacesContext context = FacesContext.getCurrentInstance();
      if (categoria!=null) {
          try {
           categoriaFacade.remove(categoria); 
          } catch (Exception e) {
          
          context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminar categoria", Constantes.ERRORGENERAL.getTipoRol()));
          e.printStackTrace();
              
         }
      }
  
  }
   
  public void limpiarVariables(){
  categorianame="";
  descripcionCategoria="";
  
  }
  
   public void referencia (Categoria categoriaselecionada){
   
   categoria= categoriaselecionada;
   
   }
   
    public void actualizarCategoria() {

        
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext context2 = RequestContext.getCurrentInstance();
         Boolean creacionCategoria= false;    
        if (categoria != null) {
            try {
                categoriaFacade.edit(categoria);
                creacionCategoria=true;
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                            "Actualizar categoria", "Se ha actualizado de manera correcta la categoria "
                                                            + categoria.getNombreCategoria()));
            } catch (Exception e) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Actualizar categoria", Constantes.ERRORGENERAL.getTipoRol()));
                e.printStackTrace();
            }
           
        }
        
        context2.addCallbackParam("ok",creacionCategoria);
    }
    public Categoria getcategoriaEntity(java.lang.Integer id) {
        return categoriaFacade.find(id);
    }
    
     @FacesConverter(forClass =Categoria.class, value = "c")
    public static class CategoriaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            categoriaController controller = (categoriaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "categoriaC");
            return controller.getcategoriaEntity(getKey(value));
                  
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Categoria) {
                Categoria o = (Categoria) object;
                return getStringKey(o.getSecuenciaCategoria());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Categoria.class.getName());
            }
        }

    }
}
