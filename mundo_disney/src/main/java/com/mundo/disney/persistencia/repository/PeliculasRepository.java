package com.mundo.disney.persistencia.repository;

import com.mundo.disney.persistencia.entities.PeliculasSeries;
import com.mundo.disney.projections.PeliculasLite;
import com.mundo.disney.projections.PeliculasPersonajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculasRepository extends JpaRepository<PeliculasSeries, Integer> {

    @Query(value = "SELECT pe.imagen_peliculas as imagenPeliculas, pe.titulo as titulo, pe.fecha_creacion as fechaCreacion FROM peliculas_series pe", nativeQuery = true)
    List<PeliculasLite> findAllPeliculas();

    @Query(value = "SELECT pe.titulo as Titulo, pe.imagen_peliculas as imagenPeliculas, pe.fecha_creacion as fechaCreacion, pe.calificacion as calificacion, GROUP_CONCAT(p.nombre) as Personajes, g.descripcion as Genero " +
            "FROM peliculas_series pe " +
            "JOIN genero g ON g.id_genero = pe.id_genero " +
            "JOIN personajes_peliculas pp ON pp.id_peli_series = pe.id_peli_series " +
            "JOIN personajes p ON p.id_personaje = pp.id_personaje " +
            "WHERE pe.id_peli_series = ? ", nativeQuery = true)
    List<PeliculasPersonajes> finAllPeliculasAndPersonajes(Integer idPeliculas);

    @Query(value = "SELECT pe.titulo as Titulo, pe.imagen_peliculas as imagenPeliculas, pe.fecha_creacion as fechaCreacion, pe.calificacion as calificacion, GROUP_CONCAT(p.nombre) as Personajes, g.descripcion as Genero " +
            "FROM peliculas_series pe " +
            "JOIN genero g ON g.id_genero = pe.id_genero " +
            "JOIN personajes_peliculas pp ON pp.id_peli_series = pe.id_peli_series " +
            "JOIN personajes p ON p.id_personaje = pp.id_personaje " +
            "WHERE pe.titulo = ? ", nativeQuery = true)
    List<PeliculasPersonajes> findByTitle(String title);

    @Query(value = "SELECT pe.titulo as Titulo, pe.imagen_peliculas as imagenPeliculas, pe.fecha_creacion as fechaCreacion, pe.calificacion as calificacion, GROUP_CONCAT(p.nombre) as personajes, g.descripcion as genero " +
            "FROM peliculas_series pe " +
            "JOIN genero g " +
            "ON g.id_genero = pe.id_genero " +
            "JOIN personajes_peliculas pp " +
            "ON pp.id_peli_series = pe.id_peli_series " +
            "JOIN personajes p " +
            "ON p.id_personaje = pp.id_personaje " +
            "WHERE g.descripcion = ? " +
            "GROUP BY pe.titulo ", nativeQuery = true)
    List<PeliculasPersonajes> findByGenre(String genre);

    @Query(value = "SELECT pe.titulo as Titulo, pe.imagen_peliculas as imagenPeliculas, pe.fecha_creacion as fechaCreacion, pe.calificacion as calificacion, GROUP_CONCAT(p.nombre) as personajes, g.descripcion as genero " +
            "FROM peliculas_series pe " +
            "JOIN genero g " +
            "ON g.id_genero = pe.id_genero " +
            "JOIN personajes_peliculas pp " +
            "ON pp.id_peli_series = pe.id_peli_series " +
            "JOIN personajes p " +
            "ON p.id_personaje = pp.id_personaje " +
            "WHERE g.descripcion = ?1 AND pe.titulo = ?2 " +
            "GROUP BY pe.titulo ", nativeQuery = true)
    List<PeliculasPersonajes> findByTitleAndGenre(String genre, String title);
}
