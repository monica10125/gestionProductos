/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc lenovo
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findBySecuenciaProducto", query = "SELECT p FROM Producto p WHERE p.secuenciaProducto = :secuenciaProducto")
    , @NamedQuery(name = "Producto.findByCodigoBarra", query = "SELECT p FROM Producto p WHERE p.codigoBarra = :codigoBarra")
    , @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Producto.findByDescripcionProducto", query = "SELECT p FROM Producto p WHERE p.descripcionProducto = :descripcionProducto")
    , @NamedQuery(name = "Producto.findByPrecioProducto", query = "SELECT p FROM Producto p WHERE p.precioProducto = :precioProducto")
    , @NamedQuery(name = "Producto.findByCantidadStock", query = "SELECT p FROM Producto p WHERE p.cantidadStock = :cantidadStock")
    , @NamedQuery(name = "Producto.findByEstadoProducto", query = "SELECT p FROM Producto p WHERE p.estadoProducto = :estadoProducto")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
     @Column(name = "secuencia_producto",nullable = false)
    private Integer secuenciaProducto;
    @Column(name = "codigo_barra")
    private BigInteger codigoBarra;
    @Basic(optional = false)
    @NotNull
    @Size( max = 50)
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Size(max = 100)
    @Column(name = "descripcion_producto")
    private String descripcionProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_producto")
    private int precioProducto;
    @Column(name = "cantidad_stock")
    private Integer cantidadStock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_producto")
    private int estadoProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkSecuenciaProducto")
    private List<SolicitudPedido> solicitudPedidoList;
    @JoinColumn(name = "fk_secuencia_categoria", referencedColumnName = "secuencia_categoria")
    @ManyToOne(optional = false)
    private Categoria fkSecuenciaCategoria;

    public Producto() {
    }

    public Producto(Integer secuenciaProducto) {
        this.secuenciaProducto = secuenciaProducto;
    }

    public Producto(Integer secuenciaProducto, String nombreProducto, int precioProducto, int estadoProducto) {
        this.secuenciaProducto = secuenciaProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.estadoProducto = estadoProducto;
    }

    public Integer getSecuenciaProducto() {
        return secuenciaProducto;
    }

    public void setSecuenciaProducto(Integer secuenciaProducto) {
        this.secuenciaProducto = secuenciaProducto;
    }

    public BigInteger getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(BigInteger codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public int getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(int estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    @XmlTransient
    public List<SolicitudPedido> getSolicitudPedidoList() {
        return solicitudPedidoList;
    }

    public void setSolicitudPedidoList(List<SolicitudPedido> solicitudPedidoList) {
        this.solicitudPedidoList = solicitudPedidoList;
    }

    public Categoria getFkSecuenciaCategoria() {
        return fkSecuenciaCategoria;
    }

    public void setFkSecuenciaCategoria(Categoria fkSecuenciaCategoria) {
        this.fkSecuenciaCategoria = fkSecuenciaCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuenciaProducto != null ? secuenciaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.secuenciaProducto == null && other.secuenciaProducto != null) || (this.secuenciaProducto != null && !this.secuenciaProducto.equals(other.secuenciaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Producto[ secuenciaProducto=" + secuenciaProducto + " ]";
    }
    
}
