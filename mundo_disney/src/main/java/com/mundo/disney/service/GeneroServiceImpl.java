package com.mundo.disney.service;

import com.mundo.disney.persistencia.entities.Genero;
import com.mundo.disney.persistencia.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService{

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public Optional<Genero> getGeneroById(int generoId) {
        return generoRepository.findById(generoId);
    }

    @Override
    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public boolean delete(Integer generoId) {
        return getGeneroById(generoId).map(g -> {
            generoRepository.delete(g);
            return true;
        }).orElse(false);
    }
}
