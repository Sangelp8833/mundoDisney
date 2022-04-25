package com.mundo.disney.persistencia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.transaction.UserTransaction;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "peliculas_series")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PeliculasSeries implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_peli_series")
    private Integer idPeliSeries;

    @Column(name = "id_genero")
    private Integer idGenero;

    @Column(name = "imagen_peliculas")
    private String imagenPeliculas;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "calificacion")
    private Double calificacion;

    @JsonIgnore
    @ManyToMany(mappedBy = "peliculas")
    Set<Personaje> personajes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_genero",insertable = false,updatable = false)
    private Genero genero;

    public Integer getIdPeliSeries() {
        return idPeliSeries;
    }

    public void setIdPeliSeries(Integer idPeliSeries) {
        this.idPeliSeries = idPeliSeries;
    }

    public String getImagenPeliculas() {
        return imagenPeliculas;
    }

    public void setImagenPeliculas(String imagenPeliculas) {
        this.imagenPeliculas = imagenPeliculas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

        public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Set<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Set<Personaje> personajes) {
        this.personajes = personajes;
    }

}
