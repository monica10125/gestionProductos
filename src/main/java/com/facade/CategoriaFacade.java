/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.entidades.Categoria;
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
public class CategoriaFacade extends AbstractFacade<Categoria> {

    @PersistenceContext(unitName = "dbProductos")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaFacade() {
        super(Categoria.class);
    }
    
     

    
    
    public List<Categoria> listarCategoriasActivas() throws Exception{
        List<Categoria>categorias= new ArrayList();
        try {
            TypedQuery<Categoria> query = em.createQuery("SELECT c FROM Categoria c WHERE c.estadoCategoria = 1",Categoria.class);  
            categorias=  query.getResultList(); 
           
          } catch (Exception e) {
            throw e;
          }
         return  categorias; 
    }
    
}
