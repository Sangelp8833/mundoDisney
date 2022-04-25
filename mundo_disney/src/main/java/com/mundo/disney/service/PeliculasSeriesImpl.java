package com.mundo.disney.service;

import com.mundo.disney.persistencia.entities.PeliculasSeries;
import com.mundo.disney.persistencia.repository.PeliculasRepository;
import com.mundo.disney.projections.PeliculasLite;
import com.mundo.disney.projections.PeliculasPersonajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculasSeriesImpl implements PeliculasService{

    @Autowired
    private PeliculasRepository peliculasRepository;

    @Override
    public Optional<PeliculasSeries> getMovie(int moviesId) {
        return peliculasRepository.findById(moviesId);
    }

    @Override
    public List<PeliculasLite> getAllMovies() {
        return peliculasRepository.findAllPeliculas();
    }

    @Override
    public List<PeliculasPersonajes> getAllPeliculasPersonajes(int idPeliculas) {
        return peliculasRepository.finAllPeliculasAndPersonajes(idPeliculas);
    }

    @Override
    public List<PeliculasPersonajes> getByTitle(String title) {
        return peliculasRepository.findByTitle(title);
    }

    @Override
    public List<PeliculasPersonajes> getByGenre(String genre) {
        return peliculasRepository.findByGenre(genre);
    }

    @Override
    public List<PeliculasPersonajes> getByTitleAndGenre(String genre, String title) {
        return peliculasRepository.findByTitleAndGenre(genre,title);
    }

    @Override
    public PeliculasSeries save(PeliculasSeries peliculasSeries) {
        return peliculasRepository.save(peliculasSeries);
    }

    @Override
    public void delete(int peliSeriesId) {

    }
}
