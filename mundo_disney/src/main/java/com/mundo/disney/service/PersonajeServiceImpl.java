package com.mundo.disney.service;


import com.mundo.disney.persistencia.entities.Personaje;
import com.mundo.disney.persistencia.repository.PersonajeRespository;
import com.mundo.disney.projections.PersonajesLite;
import com.mundo.disney.projections.PersonajesSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Service
public class PersonajeServiceImpl implements PersonajeService{

    @Autowired
    private PersonajeRespository personajeRespository;

    @Override
    public Optional<Personaje> getPersonaje(int personajeId){
        return  personajeRespository.findById(personajeId);
    }

    @Override
    public List<PersonajesLite> getAllPersonajesLite() {
        return personajeRespository.findAllImagenAndNombre();
    }

    @Override
    public List<PersonajesSeries> getPersonajePeliculasSeries(int personajeId) {
        return personajeRespository.findPersonajesAndPeliculas(personajeId);
    }

    @Override
    public List<PersonajesSeries> getByName(String nombrePersonaje) {
        return personajeRespository.findByName(nombrePersonaje);
    }

    @Override
    public List<PersonajesSeries> getByAge(int edad) {
        return personajeRespository.finByAge(edad);
    }

    @Override
    public List<PersonajesSeries> getByMovieName(String movie) {
        return personajeRespository.finByMovieName(movie);
    }

    @Override
    public List<PersonajesSeries> getByCharacterAndMovie(String movie, String name) {
        return personajeRespository.findByMovieAndCharacter(movie, name);
    }

    @Override
    public List<PersonajesSeries> getByMovieAndAge(String movie, Integer age) {
        return personajeRespository.finByMovieAndAge(movie, age);
    }

    @Override
    public Personaje save(Personaje personaje) {
        return personajeRespository.save(personaje);
    }

    @Override
    public boolean delete(int personajeId) {
        return false;
    }
}
