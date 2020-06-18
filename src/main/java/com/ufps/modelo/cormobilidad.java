package com.ufps.modelo;

@Entity
@Table(name = "cormobilidad")


public class Cormobilidad  {

    
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "diabetes")
    private Boolean diabetes;
    @Column(name = "cardio")
    private Boolean cardio;
    @Column(name = "cerebro")
    private Boolean cerebro;
    @Column(name = "vih")
    private Boolean vih;
    @Column(name = "cancer")
    private Boolean cancer;
    @Column(name = "corticoides")
    private Boolean corticoides;
    @Column(name = "epoc")
    private Boolean epoc;
    @Column(name = "nutricion")
    private Boolean nutricion;
    @Column(name = "fumador")
    private Boolean fumador;
    @Basic(optional = false)
    @Column(name = "fechareg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareg;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Basico basico;

    public Cormobilidad() {
    }

    public Cormobilidad(Integer id) {
        this.id = id;
    }

    public Cormobilidad(Integer id, Date fechareg) {
        this.id = id;
        this.fechareg = fechareg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Boolean diabetes) {
        this.diabetes = diabetes;
    }

    public Boolean getCardio() {
        return cardio;
    }

    public void setCardio(Boolean cardio) {
        this.cardio = cardio;
    }

    public Boolean getCerebro() {
        return cerebro;
    }

    public void setCerebro(Boolean cerebro) {
        this.cerebro = cerebro;
    }

    public Boolean getVih() {
        return vih;
    }

    public void setVih(Boolean vih) {
        this.vih = vih;
    }

    public Boolean getCancer() {
        return cancer;
    }

    public void setCancer(Boolean cancer) {
        this.cancer = cancer;
    }

    public Boolean getCorticoides() {
        return corticoides;
    }

    public void setCorticoides(Boolean corticoides) {
        this.corticoides = corticoides;
    }

    public Boolean getEpoc() {
        return epoc;
    }

    public void setEpoc(Boolean epoc) {
        this.epoc = epoc;
    }

    public Boolean getNutricion() {
        return nutricion;
    }

    public void setNutricion(Boolean nutricion) {
        this.nutricion = nutricion;
    }

    public Boolean getFumador() {
        return fumador;
    }

    public void setFumador(Boolean fumador) {
        this.fumador = fumador;
    }

    public Date getFechareg() {
        return fechareg;
    }

    public void setFechareg(Date fechareg) {
        this.fechareg = fechareg;
    }

    public Basico getBasico() {
        return basico;
    }

    public void setBasico(Basico basico) {
        this.basico = basico;
    }

    
}
