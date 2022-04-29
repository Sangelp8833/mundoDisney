package com.mundo.disney.service;

import com.mundo.disney.persistencia.entities.Personaje;
import com.mundo.disney.projections.PersonajesLite;
import com.mundo.disney.projections.PersonajesSeries;


import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface PersonajeService  {

    Optional<Personaje> getPersonaje(int personajeId);
    List<PersonajesLite> getAllPersonajesLite();
    List<PersonajesSeries> getPersonajePeliculasSeries(int personajeId);
    List<PersonajesSeries> getByName(String nombrePersonaje);
    List<PersonajesSeries> getByAge(int edad);
    List<PersonajesSeries> getByMovieName(String movie);
    List<PersonajesSeries> getByCharacterAndMovie(String movie, String name);
    List<PersonajesSeries> getByMovieAndAge(String movie, Integer age);
    Personaje save(Personaje personaje);
    boolean delete(int personajeId);
}
