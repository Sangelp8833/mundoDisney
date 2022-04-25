package com.mundo.disney.persistencia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "genero")
public class Genero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private Integer idCategoria;

    @Column(name = "descripcion")
    private String categoria;

    @Column(name = "imagen")
    private String imagen;

    @JsonIgnore
    @OneToMany(mappedBy = "genero", cascade = {CascadeType.ALL})
    private Set<PeliculasSeries> peliculaSeries;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Set<PeliculasSeries> getPeliculaSeries() {
        return peliculaSeries;
    }

    public void setPeliculaSeries(Set<PeliculasSeries> peliculaSeries) {
        this.peliculaSeries = peliculaSeries;
    }

    public void enrollMovies(PeliculasSeries peliculas){
        peliculaSeries.add(peliculas);
    }
}
