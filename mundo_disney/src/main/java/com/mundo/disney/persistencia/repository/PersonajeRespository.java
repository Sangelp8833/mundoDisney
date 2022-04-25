package com.mundo.disney.persistencia.repository;

import com.mundo.disney.persistencia.entities.Personaje;
import com.mundo.disney.projections.PersonajesLite;
import com.mundo.disney.projections.PersonajesSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRespository extends JpaRepository<Personaje, Integer> {

    @Query(value = "SELECT p.imagen_personaje as ImagenPersonaje, p.nombre as Nombre FROM personajes p", nativeQuery = true)
    List<PersonajesLite> findAllImagenAndNombre();

    @Query(value = "SELECT p.imagen_personaje as ImagenPersonaje, p.nombre as Nombre, p.edad as Edad, p.peso as Peso, p.historia as Historia, GROUP_CONCAT(ps.titulo) as Peliculas " +
            "FROM personajes p " +
            "JOIN personajes_peliculas pp ON pp.id_personaje = p.id_personaje " +
            "JOIN peliculas_series ps ON ps.id_peli_series = pp.id_peli_series " +
            "WHERE p.id_personaje = ? " , nativeQuery = true)
    List<PersonajesSeries> findPersonajesAndPeliculas(Integer idPersonaje);

    @Query(value = "SELECT p.imagen_personaje as ImagenPersonaje, p.nombre as Nombre, p.edad as Edad, p.peso as Peso, p.historia as Historia, GROUP_CONCAT(ps.titulo) as Peliculas " +
            "FROM personajes p " +
            "JOIN personajes_peliculas pp ON pp.id_personaje = p.id_personaje " +
            "JOIN peliculas_series ps ON ps.id_peli_series = pp.id_peli_series " +
            "WHERE p.nombre = ? " , nativeQuery = true)
    List<PersonajesSeries> findByName(String Name);

    @Query(value = "SELECT p.imagen_personaje as ImagenPersonaje, p.nombre as Nombre, p.edad as Edad, p.peso as Peso, p.historia as Historia, GROUP_CONCAT(ps.titulo) as Peliculas " +
            "FROM personajes p " +
            "JOIN personajes_peliculas pp ON pp.id_personaje = p.id_personaje " +
            "JOIN peliculas_series ps ON ps.id_peli_series = pp.id_peli_series " +
            "WHERE p.edad = ? " , nativeQuery = true)
    List<PersonajesSeries> finByAge(Integer Age);

    @Query(value = "SELECT p.imagen_personaje as ImagenPersonaje, p.nombre as Nombre, p.edad as Edad, p.peso as Peso, p.historia as Historia, ps.titulo as Peliculas " +
            "FROM personajes p " +
            "JOIN personajes_peliculas pp ON pp.id_personaje = p.id_personaje " +
            "JOIN peliculas_series ps ON ps.id_peli_series = pp.id_peli_series " +
            "WHERE ps.titulo = ? " , nativeQuery = true)
    List<PersonajesSeries> finByMovieName(String movie);

    @Query(value = "SELECT p.imagen_personaje as ImagenPersonaje, p.nombre as Nombre, p.edad as Edad, p.peso as Peso, p.historia as Historia, ps.titulo as Peliculas " +
            "FROM personajes p " +
            "JOIN personajes_peliculas pp ON pp.id_personaje = p.id_personaje " +
            "JOIN peliculas_series ps ON ps.id_peli_series = pp.id_peli_series " +
            "WHERE ps.titulo = ?1 AND p.nombre = ?2 " , nativeQuery = true)
    List<PersonajesSeries> findByMovieAndCharacter(String movie, String name);

    @Query(value = "SELECT p.imagen_personaje as ImagenPersonaje, p.nombre as Nombre, p.edad as Edad, p.peso as Peso, p.historia as Historia, ps.titulo as Peliculas " +
            "FROM personajes p " +
            "JOIN personajes_peliculas pp ON pp.id_personaje = p.id_personaje " +
            "JOIN peliculas_series ps ON ps.id_peli_series = pp.id_peli_series " +
            "WHERE ps.titulo = ?1 AND p.edad = ?2 " , nativeQuery = true)
    List<PersonajesSeries> finByMovieAndAge(String movie, Integer age);
}
