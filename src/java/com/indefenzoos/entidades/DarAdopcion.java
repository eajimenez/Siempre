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
@Table(name = "daradopcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DarAdopcion.findAll", query = "SELECT d FROM DarAdopcion d")
    , @NamedQuery(name = "DarAdopcion.findByIdDarAdopcion", query = "SELECT d FROM DarAdopcion d WHERE d.idDarAdopcion = :idDarAdopcion")
    , @NamedQuery(name = "DarAdopcion.findByFechaPublicacion", query = "SELECT d FROM DarAdopcion d WHERE d.fechaPublicacion = :fechaPublicacion")
    , @NamedQuery(name = "DarAdopcion.findByEstado", query = "SELECT d FROM DarAdopcion d WHERE d.estado = :estado")
    , @NamedQuery(name = "DarAdopcion.findByFechaFinalizacionProceso", query = "SELECT d FROM DarAdopcion d WHERE d.fechaFinalizacionProceso = :fechaFinalizacionProceso")
    , @NamedQuery(name = "DarAdopcion.findByFechaEntrega", query = "SELECT d FROM DarAdopcion d WHERE d.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "DarAdopcion.findByLugar", query = "SELECT d FROM DarAdopcion d WHERE d.lugar = :lugar")})
public class DarAdopcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDarAdopcion")
    private Integer idDarAdopcion;
    @Basic(optional = false)
    @Column(name = "fechaPublicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
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

    public DarAdopcion() {
    }

    public DarAdopcion(Integer idDarAdopcion) {
        this.idDarAdopcion = idDarAdopcion;
    }

    public DarAdopcion(Integer idDarAdopcion, Date fechaPublicacion, String estado, Date fechaFinalizacionProceso, Date fechaEntrega, String lugar) {
        this.idDarAdopcion = idDarAdopcion;
        this.fechaPublicacion = fechaPublicacion;
        this.estado = estado;
        this.fechaFinalizacionProceso = fechaFinalizacionProceso;
        this.fechaEntrega = fechaEntrega;
        this.lugar = lugar;
    }

    public Integer getIdDarAdopcion() {
        return idDarAdopcion;
    }

    public void setIdDarAdopcion(Integer idDarAdopcion) {
        this.idDarAdopcion = idDarAdopcion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
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
        hash += (idDarAdopcion != null ? idDarAdopcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DarAdopcion)) {
            return false;
        }
        DarAdopcion other = (DarAdopcion) object;
        if ((this.idDarAdopcion == null && other.idDarAdopcion != null) || (this.idDarAdopcion != null && !this.idDarAdopcion.equals(other.idDarAdopcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indefenzoos.entidades.DarAdopcion[ idDarAdopcion=" + idDarAdopcion + " ]";
    }
    
}
