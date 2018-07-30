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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findBySecuenciaCliente", query = "SELECT c FROM Cliente c WHERE c.secuenciaCliente = :secuenciaCliente")
    , @NamedQuery(name = "Cliente.findByTipoIdentiicacionCliente", query = "SELECT c FROM Cliente c WHERE c.tipoIdentiicacionCliente = :tipoIdentiicacionCliente")
    , @NamedQuery(name = "Cliente.findByNumeroIdentificacionCliente", query = "SELECT c FROM Cliente c WHERE c.numeroIdentificacionCliente = :numeroIdentificacionCliente")
    , @NamedQuery(name = "Cliente.findByNombreCliente", query = "SELECT c FROM Cliente c WHERE c.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "Cliente.findByApellidosCliente", query = "SELECT c FROM Cliente c WHERE c.apellidosCliente = :apellidosCliente")
    , @NamedQuery(name = "Cliente.findByTelefonoContacto", query = "SELECT c FROM Cliente c WHERE c.telefonoContacto = :telefonoContacto")
    , @NamedQuery(name = "Cliente.findByCorreoElectronicoCliente", query = "SELECT c FROM Cliente c WHERE c.correoElectronicoCliente = :correoElectronicoCliente")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "secuencia_cliente",nullable = false)
    private Integer secuenciaCliente;
    @Basic(optional = false)
    @NotNull
    @Size( max = 2)
    @Column(name = "tipo_identiicacion_cliente")
    private String tipoIdentiicacionCliente;
    @Basic(optional = false)
    @NotNull
    @Size(max = 20)
    @Column(name = "numero_identificacion_cliente")
    private String numeroIdentificacionCliente;
    @Basic(optional = false)
    @NotNull
    @Size( max = 60)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Basic(optional = false)
    @NotNull
    @Size( max = 60)
    @Column(name = "apellidos_cliente")
    private String apellidosCliente;
    @Size(max = 12)
    @Column(name = "telefono_contacto")
    private String telefonoContacto;
    @Size(max = 50)
    @Column(name = "correo_electronico_cliente")
    private String correoElectronicoCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkSecuenciaCliente")
    private List<Pedido> pedidoList;

    public Cliente() {
    }

    public Cliente(Integer secuenciaCliente) {
        this.secuenciaCliente = secuenciaCliente;
    }

    public Cliente(Integer secuenciaCliente, String tipoIdentiicacionCliente, String numeroIdentificacionCliente, String nombreCliente, String apellidosCliente) {
        this.secuenciaCliente = secuenciaCliente;
        this.tipoIdentiicacionCliente = tipoIdentiicacionCliente;
        this.numeroIdentificacionCliente = numeroIdentificacionCliente;
        this.nombreCliente = nombreCliente;
        this.apellidosCliente = apellidosCliente;
    }

    public Integer getSecuenciaCliente() {
        return secuenciaCliente;
    }

    public void setSecuenciaCliente(Integer secuenciaCliente) {
        this.secuenciaCliente = secuenciaCliente;
    }

    public String getTipoIdentiicacionCliente() {
        return tipoIdentiicacionCliente;
    }

    public void setTipoIdentiicacionCliente(String tipoIdentiicacionCliente) {
        this.tipoIdentiicacionCliente = tipoIdentiicacionCliente;
    }

    public String getNumeroIdentificacionCliente() {
        return numeroIdentificacionCliente;
    }

    public void setNumeroIdentificacionCliente(String numeroIdentificacionCliente) {
        this.numeroIdentificacionCliente = numeroIdentificacionCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidosCliente() {
        return apellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        this.apellidosCliente = apellidosCliente;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getCorreoElectronicoCliente() {
        return correoElectronicoCliente;
    }

    public void setCorreoElectronicoCliente(String correoElectronicoCliente) {
        this.correoElectronicoCliente = correoElectronicoCliente;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuenciaCliente != null ? secuenciaCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.secuenciaCliente == null && other.secuenciaCliente != null) || (this.secuenciaCliente != null && !this.secuenciaCliente.equals(other.secuenciaCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Cliente[ secuenciaCliente=" + secuenciaCliente + " ]";
    }
    
}
