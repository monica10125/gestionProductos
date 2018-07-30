/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc lenovo
 */
@Entity
@Table(name = "solicitud_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudPedido.findAll", query = "SELECT s FROM SolicitudPedido s")
    , @NamedQuery(name = "SolicitudPedido.findByCantidadProducto", query = "SELECT s FROM SolicitudPedido s WHERE s.cantidadProducto = :cantidadProducto")
    , @NamedQuery(name = "SolicitudPedido.findBySecuenciaSolicitudProducto", query = "SELECT s FROM SolicitudPedido s WHERE s.secuenciaSolicitudProducto = :secuenciaSolicitudProducto")})
public class SolicitudPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "secuencia_solicitud_producto",nullable = false)
    private Integer secuenciaSolicitudProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_producto")
    private int cantidadProducto;
   
    @JoinColumn(name = "fk_secuencia_pedido", referencedColumnName = "secuencia_pedido")
    @ManyToOne(optional = false)
    private Pedido fkSecuenciaPedido;
    @JoinColumn(name = "fk_secuencia_producto", referencedColumnName = "secuencia_producto")
    @ManyToOne(optional = false)
    private Producto fkSecuenciaProducto;

    public SolicitudPedido() {
    }

    public SolicitudPedido(Integer secuenciaSolicitudProducto) {
        this.secuenciaSolicitudProducto = secuenciaSolicitudProducto;
    }

    public SolicitudPedido(Integer secuenciaSolicitudProducto, int cantidadProducto) {
        this.secuenciaSolicitudProducto = secuenciaSolicitudProducto;
        this.cantidadProducto = cantidadProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Integer getSecuenciaSolicitudProducto() {
        return secuenciaSolicitudProducto;
    }

    public void setSecuenciaSolicitudProducto(Integer secuenciaSolicitudProducto) {
        this.secuenciaSolicitudProducto = secuenciaSolicitudProducto;
    }

    public Pedido getFkSecuenciaPedido() {
        return fkSecuenciaPedido;
    }

    public void setFkSecuenciaPedido(Pedido fkSecuenciaPedido) {
        this.fkSecuenciaPedido = fkSecuenciaPedido;
    }

    public Producto getFkSecuenciaProducto() {
        return fkSecuenciaProducto;
    }

    public void setFkSecuenciaProducto(Producto fkSecuenciaProducto) {
        this.fkSecuenciaProducto = fkSecuenciaProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuenciaSolicitudProducto != null ? secuenciaSolicitudProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudPedido)) {
            return false;
        }
        SolicitudPedido other = (SolicitudPedido) object;
        if ((this.secuenciaSolicitudProducto == null && other.secuenciaSolicitudProducto != null) || (this.secuenciaSolicitudProducto != null && !this.secuenciaSolicitudProducto.equals(other.secuenciaSolicitudProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.SolicitudPedido[ secuenciaSolicitudProducto=" + secuenciaSolicitudProducto + " ]";
    }
    
}
