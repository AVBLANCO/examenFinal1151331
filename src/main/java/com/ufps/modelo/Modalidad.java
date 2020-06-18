package com.ufps.modelo;

@Entity
@Table(name = "modalidad")


public class Modalidad implements Serializable {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "modalidad")
    private List<Basico> basicoList;

    public Modalidad() {
    }

    public Modalidad(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

  
    public List<Basico> getBasicoList() {
        return basicoList;
    }

    public void setBasicoList(List<Basico> basicoList) {
        this.basicoList = basicoList;
    }
}
