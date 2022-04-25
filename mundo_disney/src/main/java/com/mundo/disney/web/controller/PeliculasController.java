package com.mundo.disney.web.controller;

import com.mundo.disney.persistencia.entities.Genero;
import com.mundo.disney.persistencia.entities.PeliculasSeries;
import com.mundo.disney.projections.PeliculasLite;
import com.mundo.disney.projections.PeliculasPersonajes;
import com.mundo.disney.service.GeneroServiceImpl;
import com.mundo.disney.service.PeliculasSeriesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class PeliculasController {

    @Autowired
    private PeliculasSeriesImpl peliculasSeriesImpl;

    @Autowired
    private GeneroServiceImpl generoServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<List<PeliculasLite>> listadoMovies(){
        return new ResponseEntity<>(peliculasSeriesImpl.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/detalles/{peliculasId}")
    public ResponseEntity<List<PeliculasPersonajes>> getMovie(@PathVariable("peliculasId") int peliculasId){
        return new ResponseEntity<>(peliculasSeriesImpl.getAllPeliculasPersonajes(peliculasId), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<PeliculasPersonajes>> getFilter(@RequestParam(value = "titulo", required = false) String titulo,
                                      @RequestParam(value = "genre", required = false) String genre){
        if(titulo != null && genre != null) {
            return new ResponseEntity<>(peliculasSeriesImpl.getByTitleAndGenre(genre,titulo),HttpStatus.OK);
        }else if(titulo != null){
            return new ResponseEntity<>(peliculasSeriesImpl.getByTitle(titulo),HttpStatus.OK);
        }else if(genre != null){
            return new ResponseEntity<>(peliculasSeriesImpl.getByGenre(genre),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<PeliculasSeries> save(@RequestBody PeliculasSeries peliculasSeries){
        return  new ResponseEntity<>(peliculasSeriesImpl.save(peliculasSeries), HttpStatus.OK);
    }


    @PutMapping("/{peliculasId}/genre/{genreId}")
    public ResponseEntity<PeliculasSeries> enrollMovieToGenre(@PathVariable("peliculasId") Integer peliculasId,
                                                              @PathVariable("genreId") Integer genreId){
        PeliculasSeries peliculas = peliculasSeriesImpl.getMovie(peliculasId).get();
        Genero genero = generoServiceImpl.getGeneroById(genreId).get();
        genero.enrollMovies(peliculas);
        return new ResponseEntity(generoServiceImpl.save(genero), HttpStatus.OK);
    }


}
