/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.entidades.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author pc lenovo
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "dbProductos")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public Usuarios iniciarsesion(String usuario,String clave) throws Exception {
    
        Usuarios userLogeado= null;
        try {
            TypedQuery<Usuarios> query = em.createQuery("select u from Usuarios u where u.idUsuario = ?1 and u.claveUsuario = ?2",Usuarios.class);
            query.setParameter(1,usuario);
            query.setParameter(2, clave);
            List<Usuarios> usuariosLogueados = new ArrayList();
            usuariosLogueados = query.getResultList();
            if (!usuariosLogueados.isEmpty()) {
                
                userLogeado= usuariosLogueados.get(0);
            }
          
        } catch (Exception e) {
            throw e;
        }
        
        return userLogeado;
    }
    
}
