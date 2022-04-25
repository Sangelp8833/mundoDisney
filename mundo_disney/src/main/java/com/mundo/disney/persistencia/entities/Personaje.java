package com.mundo.disney.persistencia.entities;

import lombok.EqualsAndHashCode;


import javax.persistence.*;
import java.io.Serializable;

import java.util.HashSet;

import java.util.Set;

@Entity
@Table(name = "personajes")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Personaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personaje")
    private Integer idPersonaje;

    @Column(name = "imagen_personaje")
    private String imagenPersonaje;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "historia")
    private String historia;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
    })
    @JoinTable(name = "personajes_peliculas",
            joinColumns = @JoinColumn(name = "id_personaje"),
            inverseJoinColumns = @JoinColumn(name = "id_peli_series")
    )
    private Set<PeliculasSeries> peliculas = new HashSet<>();


    public Integer getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(Integer idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String getImagenPersonaje() {
        return imagenPersonaje;
    }

    public void setImagenPersonaje(String imagenPersonaje) {
        this.imagenPersonaje = imagenPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Set<PeliculasSeries> getPeliculas() {
        return peliculas;
    }

    public void setPersonajePeliculas(Set<PeliculasSeries> peliculas) {
        this.peliculas= peliculas;
    }

    public void enrollMovie(PeliculasSeries peliculasSeries){
        peliculas.add(peliculasSeries);
    }
}
