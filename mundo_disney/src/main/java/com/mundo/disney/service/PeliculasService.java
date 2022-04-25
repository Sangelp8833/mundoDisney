package com.mundo.disney.service;

import com.mundo.disney.persistencia.entities.PeliculasSeries;
import com.mundo.disney.projections.PeliculasLite;
import com.mundo.disney.projections.PeliculasPersonajes;

import java.util.List;
import java.util.Optional;

public interface PeliculasService {

    Optional<PeliculasSeries> getMovie(int moviesId);
    List<PeliculasLite> getAllMovies();
    List<PeliculasPersonajes> getAllPeliculasPersonajes(int idPelicula);
    List<PeliculasPersonajes> getByTitle(String title);
    List<PeliculasPersonajes> getByGenre(String genre);
    List<PeliculasPersonajes> getByTitleAndGenre(String genre, String title);
    PeliculasSeries save(PeliculasSeries peliculasSeries);
    void delete(int peliSeriesId);
}
