/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indefenzoos.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DIANA GALAN
 */
@Entity
@Table(name = "solicitaradopcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitarAdopcion.findAll", query = "SELECT s FROM SolicitarAdopcion s")
    , @NamedQuery(name = "SolicitarAdopcion.findByIdSolicitarAdopcion", query = "SELECT s FROM SolicitarAdopcion s WHERE s.idSolicitarAdopcion = :idSolicitarAdopcion")
    , @NamedQuery(name = "SolicitarAdopcion.findByFechaSolicitud", query = "SELECT s FROM SolicitarAdopcion s WHERE s.fechaSolicitud = :fechaSolicitud")
    , @NamedQuery(name = "SolicitarAdopcion.findByEstado", query = "SELECT s FROM SolicitarAdopcion s WHERE s.estado = :estado")
    , @NamedQuery(name = "SolicitarAdopcion.findByFechaFinalizacionProceso", query = "SELECT s FROM SolicitarAdopcion s WHERE s.fechaFinalizacionProceso = :fechaFinalizacionProceso")
    , @NamedQuery(name = "SolicitarAdopcion.findByFechaEntrega", query = "SELECT s FROM SolicitarAdopcion s WHERE s.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "SolicitarAdopcion.findByLugar", query = "SELECT s FROM SolicitarAdopcion s WHERE s.lugar = :lugar")})
public class SolicitarAdopcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSolicitarAdopcion")
    private Integer idSolicitarAdopcion;
    @Basic(optional = false)
    @Column(name = "fechaSolicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "fechaFinalizacionProceso")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacionProceso;
    @Basic(optional = false)
    @Column(name = "fechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @Column(name = "lugar")
    private String lugar;
    @JoinColumn(name = "Mascotas_idMascota", referencedColumnName = "idMascota")
    @ManyToOne(optional = false)
    private Mascota mascotasidMascota;
    @JoinColumn(name = "Usuarios_idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Usuario usuariosidPersona;

    public SolicitarAdopcion() {
    }

    public SolicitarAdopcion(Integer idSolicitarAdopcion) {
        this.idSolicitarAdopcion = idSolicitarAdopcion;
    }

    public SolicitarAdopcion(Integer idSolicitarAdopcion, Date fechaSolicitud, String estado, Date fechaFinalizacionProceso, Date fechaEntrega, String lugar) {
        this.idSolicitarAdopcion = idSolicitarAdopcion;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.fechaFinalizacionProceso = fechaFinalizacionProceso;
        this.fechaEntrega = fechaEntrega;
        this.lugar = lugar;
    }

    public Integer getIdSolicitarAdopcion() {
        return idSolicitarAdopcion;
    }

    public void setIdSolicitarAdopcion(Integer idSolicitarAdopcion) {
        this.idSolicitarAdopcion = idSolicitarAdopcion;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaFinalizacionProceso() {
        return fechaFinalizacionProceso;
    }

    public void setFechaFinalizacionProceso(Date fechaFinalizacionProceso) {
        this.fechaFinalizacionProceso = fechaFinalizacionProceso;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Mascota getMascotasidMascota() {
        return mascotasidMascota;
    }

    public void setMascotasidMascota(Mascota mascotasidMascota) {
        this.mascotasidMascota = mascotasidMascota;
    }

    public Usuario getUsuariosidPersona() {
        return usuariosidPersona;
    }

    public void setUsuariosidPersona(Usuario usuariosidPersona) {
        this.usuariosidPersona = usuariosidPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitarAdopcion != null ? idSolicitarAdopcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitarAdopcion)) {
            return false;
        }
        SolicitarAdopcion other = (SolicitarAdopcion) object;
        if ((this.idSolicitarAdopcion == null && other.idSolicitarAdopcion != null) || (this.idSolicitarAdopcion != null && !this.idSolicitarAdopcion.equals(other.idSolicitarAdopcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indefenzoos.entidades.SolicitarAdopcion[ idSolicitarAdopcion=" + idSolicitarAdopcion + " ]";
    }
    
}
