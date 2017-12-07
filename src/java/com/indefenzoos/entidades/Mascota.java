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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "mascotas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mascota.findAll", query = "SELECT m FROM Mascota m")
    , @NamedQuery(name = "Mascota.findByIdMascota", query = "SELECT m FROM Mascota m WHERE m.idMascota = :idMascota")
    , @NamedQuery(name = "Mascota.findByNombre", query = "SELECT m FROM Mascota m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Mascota.findByEdad", query = "SELECT m FROM Mascota m WHERE m.edad = :edad")
    , @NamedQuery(name = "Mascota.findByPesoKg", query = "SELECT m FROM Mascota m WHERE m.pesoKg = :pesoKg")
    , @NamedQuery(name = "Mascota.findByColor", query = "SELECT m FROM Mascota m WHERE m.color = :color")
    , @NamedQuery(name = "Mascota.findByGenero", query = "SELECT m FROM Mascota m WHERE m.genero = :genero")
    , @NamedQuery(name = "Mascota.findByDiscapacidades", query = "SELECT m FROM Mascota m WHERE m.discapacidades = :discapacidades")
    , @NamedQuery(name = "Mascota.findByFechaIngreso", query = "SELECT m FROM Mascota m WHERE m.fechaIngreso = :fechaIngreso")})
public class Mascota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMascota")
    private Integer idMascota;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @Column(name = "peso (kg)")
    private int pesoKg;
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @Column(name = "discapacidades")
    private boolean discapacidades;
    @Basic(optional = false)
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "mascotaList")
    private List<Enfermedad> enfermedadList;
    @JoinTable(name = "vacunasmascotas", joinColumns = {
        @JoinColumn(name = "Mascotas_idMascota", referencedColumnName = "idMascota")}, inverseJoinColumns = {
        @JoinColumn(name = "Vacunas_idVacuna", referencedColumnName = "idVacuna")})
    @ManyToMany
    private List<Vacuna> vacunaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mascotasidMascota")
    private List<DarAdopcion> darAdopcionList;
    @JoinColumn(name = "Raza_idRaza", referencedColumnName = "idRaza")
    @ManyToOne(optional = false)
    private Raza razaidRaza;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mascotasidMascota")
    private List<SolicitarAdopcion> solicitarAdopcionList;

    public Mascota() {
    }

    public Mascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public Mascota(Integer idMascota, String nombre, int edad, int pesoKg, String genero, boolean discapacidades, Date fechaIngreso, String descripcion) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.edad = edad;
        this.pesoKg = pesoKg;
        this.genero = genero;
        this.discapacidades = discapacidades;
        this.fechaIngreso = fechaIngreso;
        this.descripcion = descripcion;
    }

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(int pesoKg) {
        this.pesoKg = pesoKg;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean getDiscapacidades() {
        return discapacidades;
    }

    public void setDiscapacidades(boolean discapacidades) {
        this.discapacidades = discapacidades;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Enfermedad> getEnfermedadList() {
        return enfermedadList;
    }

    public void setEnfermedadList(List<Enfermedad> enfermedadList) {
        this.enfermedadList = enfermedadList;
    }

    @XmlTransient
    public List<Vacuna> getVacunaList() {
        return vacunaList;
    }

    public void setVacunaList(List<Vacuna> vacunaList) {
        this.vacunaList = vacunaList;
    }

    @XmlTransient
    public List<DarAdopcion> getDarAdopcionList() {
        return darAdopcionList;
    }

    public void setDarAdopcionList(List<DarAdopcion> darAdopcionList) {
        this.darAdopcionList = darAdopcionList;
    }

    public Raza getRazaidRaza() {
        return razaidRaza;
    }

    public void setRazaidRaza(Raza razaidRaza) {
        this.razaidRaza = razaidRaza;
    }

    @XmlTransient
    public List<SolicitarAdopcion> getSolicitarAdopcionList() {
        return solicitarAdopcionList;
    }

    public void setSolicitarAdopcionList(List<SolicitarAdopcion> solicitarAdopcionList) {
        this.solicitarAdopcionList = solicitarAdopcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMascota != null ? idMascota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mascota)) {
            return false;
        }
        Mascota other = (Mascota) object;
        if ((this.idMascota == null && other.idMascota != null) || (this.idMascota != null && !this.idMascota.equals(other.idMascota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indefenzoos.entidades.Mascota[ idMascota=" + idMascota + " ]";
    }
    
}
