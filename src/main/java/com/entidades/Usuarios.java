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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc lenovo
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findBySecuenciaUsuario", query = "SELECT u FROM Usuarios u WHERE u.secuenciaUsuario = :secuenciaUsuario")
    , @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuarios.findByClaveUsuario", query = "SELECT u FROM Usuarios u WHERE u.claveUsuario = :claveUsuario")
    , @NamedQuery(name = "Usuarios.findByRol", query = "SELECT u FROM Usuarios u WHERE u.rol = :rol")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "secuencia_usuario",nullable = false)
    private Integer secuenciaUsuario;
    @Basic(optional = false)
    @NotNull
    @Size( max = 20)
    @Column(name = "id_usuario")
    private String idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size( max = 20)
    @Column(name = "clave_usuario")
    private String claveUsuario;
    @Basic(optional = false)
    @NotNull
    @Size( max = 14)
    @Column(name = "rol")
    private String rol;

    public Usuarios() {
    }

    public Usuarios(Integer secuenciaUsuario) {
        this.secuenciaUsuario = secuenciaUsuario;
    }

    public Usuarios(Integer secuenciaUsuario, String idUsuario, String claveUsuario, String rol) {
        this.secuenciaUsuario = secuenciaUsuario;
        this.idUsuario = idUsuario;
        this.claveUsuario = claveUsuario;
        this.rol = rol;
    }

    public Integer getSecuenciaUsuario() {
        return secuenciaUsuario;
    }

    public void setSecuenciaUsuario(Integer secuenciaUsuario) {
        this.secuenciaUsuario = secuenciaUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuenciaUsuario != null ? secuenciaUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.secuenciaUsuario == null && other.secuenciaUsuario != null) || (this.secuenciaUsuario != null && !this.secuenciaUsuario.equals(other.secuenciaUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Usuarios[ secuenciaUsuario=" + secuenciaUsuario + " ]";
    }
    
}
