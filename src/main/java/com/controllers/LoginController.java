/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.entidades.Usuarios;
import com.facade.UsuariosFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import recursos.Constantes;

/**
 *
 * @author pc lenovo
 */
@Named(value = "login")
@SessionScoped
public class LoginController implements Serializable {

    @EJB
    UsuariosFacade usuarioFacade;
    private Usuarios usuario;
    private String identificacion;
    private String clave;

    @PostConstruct
    public void init() {

        usuario = new Usuarios();
        identificacion = "";
        clave = "";
    }

    public String iniciarSesion() {

        String redireccion = "";
        Boolean estarLogueado = false;
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext context2 = RequestContext.getCurrentInstance();
        

          
        try {
            Usuarios userLogeado = usuarioFacade.iniciarsesion(identificacion, clave);
              
            if (userLogeado!=null && userLogeado.getIdUsuario() != null 
                                   && !userLogeado.getIdUsuario().equals("")
                                   && userLogeado.getRol() != null && !userLogeado.getRol().equals("")) {
                 
                context.getExternalContext().getSessionMap().put(Constantes.SESIONUSER.getTipoRol(), userLogeado);
                estarLogueado = true;
                
                
                // si el usuario existe con rol ingresa aqui 
                if (userLogeado.getRol().equals(Constantes.ROLADMINISTRADOR.getTipoRol())) {

                    redireccion = "app/administrador/gestionProductos?faces-redirect=true";

                }

                if (userLogeado.getRol().equals(Constantes.ROLCLIENTE.getTipoRol())) {

                    redireccion = "app/cliente/compra?faces-redirect=true";
                }

            } else {

                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "login", Constantes.LOGININCONRRECTO.getTipoRol()));

            }
        } catch (Exception e) {

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "login", Constantes.ERRORINICIOSESION.getTipoRol()));
            e.printStackTrace();
        }

        context2.addCallbackParam("estarLogueado", estarLogueado);
        return redireccion;

    }
    
    
public String nombreUser(){
FacesContext context= FacesContext.getCurrentInstance();
String varId="";
Usuarios user= (Usuarios) context.getExternalContext().getSessionMap().get(Constantes.SESIONUSER.getTipoRol());
    if (user!=null) {
        varId= "Bienvenido "+user.getIdUsuario();
    } else {
    
         context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Usuario", Constantes.ERRORESSESION.getTipoRol()));
    
    }
return  varId;
    
}

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
