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
@Table(name = "citas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c")
    , @NamedQuery(name = "Cita.findByIdCita", query = "SELECT c FROM Cita c WHERE c.idCita = :idCita")
    , @NamedQuery(name = "Cita.findByMotivo", query = "SELECT c FROM Cita c WHERE c.motivo = :motivo")
    , @NamedQuery(name = "Cita.findByFechaYHora", query = "SELECT c FROM Cita c WHERE c.fechaYHora = :fechaYHora")
    , @NamedQuery(name = "Cita.findByLugar", query = "SELECT c FROM Cita c WHERE c.lugar = :lugar")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCita")
    private Integer idCita;
    @Basic(optional = false)
    @Column(name = "motivo")
    private String motivo;
    @Basic(optional = false)
    @Column(name = "fechaYHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaYHora;
    @Basic(optional = false)
    @Column(name = "lugar")
    private String lugar;
    @JoinColumn(name = "Usuarios_idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Usuario usuariosidPersona;

    public Cita() {
    }

    public Cita(Integer idCita) {
        this.idCita = idCita;
    }

    public Cita(Integer idCita, String motivo, Date fechaYHora, String lugar) {
        this.idCita = idCita;
        this.motivo = motivo;
        this.fechaYHora = fechaYHora;
        this.lugar = lugar;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(Date fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
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
        hash += (idCita != null ? idCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.idCita == null && other.idCita != null) || (this.idCita != null && !this.idCita.equals(other.idCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indefenzoos.entidades.Cita[ idCita=" + idCita + " ]";
    }
    
}
