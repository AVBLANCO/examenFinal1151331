package com.ufps.modelo;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "registro")


public class Registro {

  
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "tos")
    private Boolean tos;
    @Column(name = "malestar")
    private Boolean malestar;
    @Column(name = "fatiga")
    private Boolean fatiga;
    @Column(name = "nasal")
    private Boolean nasal;
    @Column(name = "garganta")
    private Boolean garganta;
    @Column(name = "dificultad")
    private Boolean dificultad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "temperatura")
    private BigDecimal temperatura;
    @Basic(optional = false)
    @Column(name = "fechareg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareg;
    @Column(name = "covid")
    private Boolean covid;
    @OneToMany(mappedBy = "registro")
    private List<Acceso> accesoList;
    @JoinColumn(name = "persona", referencedColumnName = "id")
    @ManyToOne
    private Basico persona;

    public Registro() {
    }

    public Registro(Integer id) {
        this.id = id;
    }

    public Registro(Integer id, Date fechareg) {
        this.id = id;
        this.fechareg = fechareg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getTos() {
        return tos;
    }

    public void setTos(Boolean tos) {
        this.tos = tos;
    }

    public Boolean getMalestar() {
        return malestar;
    }

    public void setMalestar(Boolean malestar) {
        this.malestar = malestar;
    }

    public Boolean getFatiga() {
        return fatiga;
    }

    public void setFatiga(Boolean fatiga) {
        this.fatiga = fatiga;
    }

    public Boolean getNasal() {
        return nasal;
    }

    public void setNasal(Boolean nasal) {
        this.nasal = nasal;
    }

    public Boolean getGarganta() {
        return garganta;
    }

    public void setGarganta(Boolean garganta) {
        this.garganta = garganta;
    }

    public Boolean getDificultad() {
        return dificultad;
    }

    public void setDificultad(Boolean dificultad) {
        this.dificultad = dificultad;
    }

    public BigDecimal getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(BigDecimal temperatura) {
        this.temperatura = temperatura;
    }

    public Date getFechareg() {
        return fechareg;
    }

    public void setFechareg(Date fechareg) {
        this.fechareg = fechareg;
    }

    public Boolean getCovid() {
        return covid;
    }

    public void setCovid(Boolean covid) {
        this.covid = covid;
    }


    public List<Acceso> getAccesoList() {
        return accesoList;
    }

    public void setAccesoList(List<Acceso> accesoList) {
        this.accesoList = accesoList;
    }

    public Basico getPersona() {
        return persona;
    }

    public void setPersona(Basico persona) {
        this.persona = persona;
    }

    
}
