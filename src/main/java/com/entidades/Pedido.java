/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc lenovo
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findBySecuenciaPedido", query = "SELECT p FROM Pedido p WHERE p.secuenciaPedido = :secuenciaPedido")
    , @NamedQuery(name = "Pedido.findByFechaSolicitudPedido", query = "SELECT p FROM Pedido p WHERE p.fechaSolicitudPedido = :fechaSolicitudPedido")
    , @NamedQuery(name = "Pedido.findByFechaCancelacion", query = "SELECT p FROM Pedido p WHERE p.fechaCancelacion = :fechaCancelacion")
    , @NamedQuery(name = "Pedido.findByCostoPedido", query = "SELECT p FROM Pedido p WHERE p.costoPedido = :costoPedido")
    , @NamedQuery(name = "Pedido.findByEstadoPedido", query = "SELECT p FROM Pedido p WHERE p.estadoPedido = :estadoPedido")
    , @NamedQuery(name = "Pedido.findByDirecionPedido", query = "SELECT p FROM Pedido p WHERE p.direcionPedido = :direcionPedido")
    , @NamedQuery(name = "Pedido.findByCiudadPedido", query = "SELECT p FROM Pedido p WHERE p.ciudadPedido = :ciudadPedido")
    , @NamedQuery(name = "Pedido.findByDepartamentoPedido", query = "SELECT p FROM Pedido p WHERE p.departamentoPedido = :departamentoPedido")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "secuencia_pedido",nullable = false)
    private Integer secuenciaPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_solicitud_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitudPedido;
    @Column(name = "fecha_cancelacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCancelacion;
    @Column(name = "costo_pedido")
    private Integer costoPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_pedido")
    private int estadoPedido;
    @Basic(optional = false)
    @NotNull
    @Size( max = 30)
    @Column(name = "direcion_pedido")
    private String direcionPedido;
    @Basic(optional = false)
    @NotNull
    @Size( max = 30)
    @Column(name = "ciudad_pedido")
    private String ciudadPedido;
    @Basic(optional = false)
    @NotNull
    @Size( max = 30)
    @Column(name = "departamento_pedido")
    private String departamentoPedido;
    @JoinColumn(name = "fk_secuencia_cliente", referencedColumnName = "secuencia_cliente")
    @ManyToOne(optional = false)
    private Cliente fkSecuenciaCliente;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkSecuenciaPedido")
    private List<SolicitudPedido> solicitudPedidoList;

    public Pedido() {
    }

    public Pedido(Integer secuenciaPedido) {
        this.secuenciaPedido = secuenciaPedido;
    }

    public Pedido(Integer secuenciaPedido, Date fechaSolicitudPedido, int estadoPedido, String direcionPedido, String ciudadPedido, String departamentoPedido) {
        this.secuenciaPedido = secuenciaPedido;
        this.fechaSolicitudPedido = fechaSolicitudPedido;
        this.estadoPedido = estadoPedido;
        this.direcionPedido = direcionPedido;
        this.ciudadPedido = ciudadPedido;
        this.departamentoPedido = departamentoPedido;
    }

    public Integer getSecuenciaPedido() {
        return secuenciaPedido;
    }

    public void setSecuenciaPedido(Integer secuenciaPedido) {
        this.secuenciaPedido = secuenciaPedido;
    }

    public Date getFechaSolicitudPedido() {
        return fechaSolicitudPedido;
    }

    public void setFechaSolicitudPedido(Date fechaSolicitudPedido) {
        this.fechaSolicitudPedido = fechaSolicitudPedido;
    }

    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public Integer getCostoPedido() {
        return costoPedido;
    }

    public void setCostoPedido(Integer costoPedido) {
        this.costoPedido = costoPedido;
    }

    public int getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(int estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public String getDirecionPedido() {
        return direcionPedido;
    }

    public void setDirecionPedido(String direcionPedido) {
        this.direcionPedido = direcionPedido;
    }

    public String getCiudadPedido() {
        return ciudadPedido;
    }

    public void setCiudadPedido(String ciudadPedido) {
        this.ciudadPedido = ciudadPedido;
    }

    public String getDepartamentoPedido() {
        return departamentoPedido;
    }

    public void setDepartamentoPedido(String departamentoPedido) {
        this.departamentoPedido = departamentoPedido;
    }

    public Cliente getFkSecuenciaCliente() {
        return fkSecuenciaCliente;
    }

    public void setFkSecuenciaCliente(Cliente fkSecuenciaCliente) {
        this.fkSecuenciaCliente = fkSecuenciaCliente;
    }

    @XmlTransient
    public List<SolicitudPedido> getSolicitudPedidoList() {
        return solicitudPedidoList;
    }

    public void setSolicitudPedidoList(List<SolicitudPedido> solicitudPedidoList) {
        this.solicitudPedidoList = solicitudPedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuenciaPedido != null ? secuenciaPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.secuenciaPedido == null && other.secuenciaPedido != null) || (this.secuenciaPedido != null && !this.secuenciaPedido.equals(other.secuenciaPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Pedido[ secuenciaPedido=" + secuenciaPedido + " ]";
    }
    
}
