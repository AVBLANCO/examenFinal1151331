package com.ufps.modelo;

import java.sql.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "basico")


public class Basico  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "documento")
    private String documento;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Column(name = "genero")
    private String genero;
    @Column(name = "embarazo")
    private Boolean embarazo;
    @Column(name = "contactonombre")
    private String contactonombre;
    @Column(name = "contactotelefono")
    private String contactotelefono;
    @Column(name = "mas60")
    private Boolean mas60;
    @Column(name = "menos15")
    private Boolean menos15;
    @Column(name = "salud")
    private Boolean salud;
    @Basic(optional = false)
    @Column(name = "fechareg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareg;
    @OneToOne( mappedBy = "basico")
    private Cormobilidad cormobilidad;
    @JoinColumn(name = "eps", referencedColumnName = "id")
    @ManyToOne
    private Eps eps;
    @JoinColumn(name = "modalidad", referencedColumnName = "id")
    @ManyToOne
    private Modalidad modalidad;
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    @ManyToOne
    private Tipo tipo;
    @OneToMany(mappedBy = "persona")
    private List<Registro> registroList;

    public Basico() {
    }

    public Basico(Integer id) {
        this.id = id;
    }

    public Basico(Integer id, Date fechareg) {
        this.id = id;
        this.fechareg = fechareg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Boolean getEmbarazo() {
        return embarazo;
    }

    public void setEmbarazo(Boolean embarazo) {
        this.embarazo = embarazo;
    }

    public String getContactonombre() {
        return contactonombre;
    }

    public void setContactonombre(String contactonombre) {
        this.contactonombre = contactonombre;
    }

    public String getContactotelefono() {
        return contactotelefono;
    }

    public void setContactotelefono(String contactotelefono) {
        this.contactotelefono = contactotelefono;
    }

    public Boolean getMas60() {
        return mas60;
    }

    public void setMas60(Boolean mas60) {
        this.mas60 = mas60;
    }

    public Boolean getMenos15() {
        return menos15;
    }

    public void setMenos15(Boolean menos15) {
        this.menos15 = menos15;
    }

    public Boolean getSalud() {
        return salud;
    }

    public void setSalud(Boolean salud) {
        this.salud = salud;
    }

    public Date getFechareg() {
        return fechareg;
    }

    public void setFechareg(Date fechareg) {
        this.fechareg = fechareg;
    }

    public Cormobilidad getCormobilidad() {
        return cormobilidad;
    }

    public void setCormobilidad(Cormobilidad cormobilidad) {
        this.cormobilidad = cormobilidad;
    }

    public Eps getEps() {
        return eps;
    }

    public void setEps(Eps eps) {
        this.eps = eps;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

   
    public List<Registro> getRegistroList() {
        return registroList;
    }

    public void setRegistroList(List<Registro> registroList) {
        this.registroList = registroList;
    }

    
}
