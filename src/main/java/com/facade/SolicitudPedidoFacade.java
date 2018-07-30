/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.entidades.SolicitudPedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pc lenovo
 */
@Stateless
public class SolicitudPedidoFacade extends AbstractFacade<SolicitudPedido> {

    @PersistenceContext(unitName = "dbProductos")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudPedidoFacade() {
        super(SolicitudPedido.class);
    }
    
}
