/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indefenzoos.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DIANA GALAN
 */
@Entity
@Table(name = "vacunas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacuna.findAll", query = "SELECT v FROM Vacuna v")
    , @NamedQuery(name = "Vacuna.findByIdVacuna", query = "SELECT v FROM Vacuna v WHERE v.idVacuna = :idVacuna")
    , @NamedQuery(name = "Vacuna.findByNombre", query = "SELECT v FROM Vacuna v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "Vacuna.findByUltimaVacuna", query = "SELECT v FROM Vacuna v WHERE v.ultimaVacuna = :ultimaVacuna")})
public class Vacuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVacuna")
    private Integer idVacuna;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "ultimaVacuna")
    @Temporal(TemporalType.DATE)
    private Date ultimaVacuna;
    @ManyToMany(mappedBy = "vacunaList")
    private List<Mascota> mascotaList;

    public Vacuna() {
    }

    public Vacuna(Integer idVacuna) {
        this.idVacuna = idVacuna;
    }

    public Integer getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Integer idVacuna) {
        this.idVacuna = idVacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getUltimaVacuna() {
        return ultimaVacuna;
    }

    public void setUltimaVacuna(Date ultimaVacuna) {
        this.ultimaVacuna = ultimaVacuna;
    }

    @XmlTransient
    public List<Mascota> getMascotaList() {
        return mascotaList;
    }

    public void setMascotaList(List<Mascota> mascotaList) {
        this.mascotaList = mascotaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVacuna != null ? idVacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacuna)) {
            return false;
        }
        Vacuna other = (Vacuna) object;
        if ((this.idVacuna == null && other.idVacuna != null) || (this.idVacuna != null && !this.idVacuna.equals(other.idVacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indefenzoos.entidades.Vacuna[ idVacuna=" + idVacuna + " ]";
    }
    
}
