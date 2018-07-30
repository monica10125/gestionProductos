/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.entidades.Categoria;
import com.entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pc lenovo
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "dbProductos")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    
    
    public List<Producto> listarProductos() throws Exception{
        List<Producto> productos = new ArrayList();
        try {
            Query query = em.createQuery("SELECT p.nombreProducto,p.descripcionProducto,p.precioProducto, p.codigoBarra,p.cantidadStock FROM Producto p WHERE p.estadoProducto = 1");
            productos = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return productos;
    }

    public List<Producto> listarProductosPorCategoria(Integer categoria) throws Exception {
        List<Producto> productosCategoria = new ArrayList();
        try {
             
             
              System.out.println("entra al change por categoria");
          
    
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.fkSecuenciaCategoria.secuenciaCategoria = ?1");
            query.setParameter(1, categoria);
            productosCategoria = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return productosCategoria;
    }

}
