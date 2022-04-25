package com.mundo.disney.service;

import com.mundo.disney.persistencia.entities.Genero;

import java.util.Optional;

public interface GeneroService {

    Optional<Genero> getGeneroById(int generoId);
    Genero save(Genero genero);
    boolean delete(Integer generoId);

}
