/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findBySecuenciaCategoria", query = "SELECT c FROM Categoria c WHERE c.secuenciaCategoria = :secuenciaCategoria")
    , @NamedQuery(name = "Categoria.findByNombreCategoria", query = "SELECT c FROM Categoria c WHERE c.nombreCategoria = :nombreCategoria")
    , @NamedQuery(name = "Categoria.findByDescripcionCategoia", query = "SELECT c FROM Categoria c WHERE c.descripcionCategoia = :descripcionCategoia")
    , @NamedQuery(name = "Categoria.findByEstadoCategoria", query = "SELECT c FROM Categoria c WHERE c.estadoCategoria = :estadoCategoria")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "secuencia_categoria", nullable = false)
    private Integer secuenciaCategoria;
    @Basic(optional = false)
    @NotNull
    @Size( max = 50)
    @Column(name = "nombre_categoria")
    private String nombreCategoria;
    @Size(max = 100)
    @Column(name = "descripcion_categoia")
    private String descripcionCategoia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_categoria")
    private int estadoCategoria;
    
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkSecuenciaCategoria")
    private List<Producto> productoList;

    public Categoria() {
    }

    public Categoria(Integer secuenciaCategoria) {
        this.secuenciaCategoria = secuenciaCategoria;
    }

    public Categoria(Integer secuenciaCategoria, String nombreCategoria, int estadoCategoria) {
        this.secuenciaCategoria = secuenciaCategoria;
        this.nombreCategoria = nombreCategoria;
        this.estadoCategoria = estadoCategoria;
    }

    public Integer getSecuenciaCategoria() {
        return secuenciaCategoria;
    }

    public void setSecuenciaCategoria(Integer secuenciaCategoria) {
        this.secuenciaCategoria = secuenciaCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoia() {
        return descripcionCategoia;
    }

    public void setDescripcionCategoia(String descripcionCategoia) {
        this.descripcionCategoia = descripcionCategoia;
    }

    public int getEstadoCategoria() {
        return estadoCategoria;
    }

    public void setEstadoCategoria(int estadoCategoria) {
        this.estadoCategoria = estadoCategoria;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuenciaCategoria != null ? secuenciaCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.secuenciaCategoria == null && other.secuenciaCategoria != null) || (this.secuenciaCategoria != null && !this.secuenciaCategoria.equals(other.secuenciaCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Categoria[ secuenciaCategoria=" + secuenciaCategoria + " ]";
    }
    
}
