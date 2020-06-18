package com.ufps.modelo;

@Entity
@Table(name = "visitante")


public class Visitante  {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "documento")
    private String documento;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Column(name = "eps")
    private Integer eps;
    @Column(name = "genero")
    private String genero;
    @OneToMany(mappedBy = "visitante")
    private List<Accesovisitante> accesovisitanteList;
    @JoinColumn(name = "empresa", referencedColumnName = "id")
    @ManyToOne
    private Empresa empresa;

    public Visitante() {
    }

    public Visitante(Integer id) {
        this.id = id;
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

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Integer getEps() {
        return eps;
    }

    public void setEps(Integer eps) {
        this.eps = eps;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    public List<Accesovisitante> getAccesovisitanteList() {
        return accesovisitanteList;
    }

    public void setAccesovisitanteList(List<Accesovisitante> accesovisitanteList) {
        this.accesovisitanteList = accesovisitanteList;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
