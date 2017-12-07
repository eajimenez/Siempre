/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indefenzoos.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DIANA GALAN
 */
@Entity
@Table(name = "enfermedades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfermedad.findAll", query = "SELECT e FROM Enfermedad e")
    , @NamedQuery(name = "Enfermedad.findByIdEnfermedades", query = "SELECT e FROM Enfermedad e WHERE e.idEnfermedades = :idEnfermedades")
    , @NamedQuery(name = "Enfermedad.findByNombreEnfermedad", query = "SELECT e FROM Enfermedad e WHERE e.nombreEnfermedad = :nombreEnfermedad")})
public class Enfermedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idEnfermedades")
    private Integer idEnfermedades;
    @Basic(optional = false)
    @Column(name = "nombreEnfermedad")
    private String nombreEnfermedad;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcionEnfermedad")
    private String descripcionEnfermedad;
    @JoinTable(name = "enfermedadesmascotas", joinColumns = {
        @JoinColumn(name = "Enfermedades_idEnfermedades", referencedColumnName = "idEnfermedades")}, inverseJoinColumns = {
        @JoinColumn(name = "Mascotas_idMascota", referencedColumnName = "idMascota")})
    @ManyToMany
    private List<Mascota> mascotaList;

    public Enfermedad() {
    }

    public Enfermedad(Integer idEnfermedades) {
        this.idEnfermedades = idEnfermedades;
    }

    public Enfermedad(Integer idEnfermedades, String nombreEnfermedad, String descripcionEnfermedad) {
        this.idEnfermedades = idEnfermedades;
        this.nombreEnfermedad = nombreEnfermedad;
        this.descripcionEnfermedad = descripcionEnfermedad;
    }

    public Integer getIdEnfermedades() {
        return idEnfermedades;
    }

    public void setIdEnfermedades(Integer idEnfermedades) {
        this.idEnfermedades = idEnfermedades;
    }

    public String getNombreEnfermedad() {
        return nombreEnfermedad;
    }

    public void setNombreEnfermedad(String nombreEnfermedad) {
        this.nombreEnfermedad = nombreEnfermedad;
    }

    public String getDescripcionEnfermedad() {
        return descripcionEnfermedad;
    }

    public void setDescripcionEnfermedad(String descripcionEnfermedad) {
        this.descripcionEnfermedad = descripcionEnfermedad;
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
        hash += (idEnfermedades != null ? idEnfermedades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfermedad)) {
            return false;
        }
        Enfermedad other = (Enfermedad) object;
        if ((this.idEnfermedades == null && other.idEnfermedades != null) || (this.idEnfermedades != null && !this.idEnfermedades.equals(other.idEnfermedades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indefenzoos.entidades.Enfermedad[ idEnfermedades=" + idEnfermedades + " ]";
    }
    
}
