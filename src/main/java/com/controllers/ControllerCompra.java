/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.entidades.Categoria;
import com.entidades.Producto;
import com.facade.CategoriaFacade;
import com.facade.ProductoFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import recursos.Constantes;

/**
 *
 * @author pc lenovo
 */
@SessionScoped
@Named(value = "compraC")
public class ControllerCompra implements Serializable{
    
@EJB
    ProductoFacade productoFacade;
    @EJB
    CategoriaFacade categoriaFacade;
    private Producto producto;
    private Categoria categoria;
    private List<Producto> productosCategoria;
     private boolean noProductos = false;
    
      @PostConstruct
    public void init( ) {
    producto= new Producto();
    categoria= new Categoria();

    
    }
    
       public void obtenerProductosCategoria(){
        FacesContext context = FacesContext.getCurrentInstance();
        
         System.out.println("entra al change");
      
         System.out.println("categoria" + categoria.getSecuenciaCategoria());
      
         if (categoria!=null && categoria.getSecuenciaCategoria()>0) {
             try {
             List<Producto> productoscategoria  =  productoFacade.listarProductosPorCategoria(categoria.getSecuenciaCategoria());
                
             if (!productoscategoria.isEmpty()) {
                     
                    productosCategoria=productoscategoria;
                    noProductos=true;
                     
                 }else{
                 context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "cargue categorias", "No existe productos para la categoria "+ categoria.getNombreCategoria()));
                 }
              
             } catch (Exception e) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "cargue categorias", Constantes.ERRORCARGUE.getTipoRol()));
                e.printStackTrace();
             }
          
         }

     }
       
     public void asignarCategoria(ValueChangeEvent event){
         
     this.categoria = (Categoria) event.getNewValue();
     
     }  

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Producto> getProductosCategoria() {
        return productosCategoria;
    }

    public void setProductosCategoria(List<Producto> productosCategoria) {
        this.productosCategoria = productosCategoria;
    }

    public boolean isNoProductos() {
        return noProductos;
    }

    public void setNoProductos(boolean noProductos) {
        this.noProductos = noProductos;
    }

     
}
