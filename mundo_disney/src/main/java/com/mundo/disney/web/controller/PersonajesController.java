package com.mundo.disney.web.controller;

import com.mundo.disney.persistencia.entities.PeliculasSeries;
import com.mundo.disney.persistencia.entities.Personaje;
import com.mundo.disney.projections.PersonajesLite;
import com.mundo.disney.projections.PersonajesSeries;
import com.mundo.disney.service.PeliculasSeriesImpl;
import com.mundo.disney.service.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class PersonajesController {

    @Autowired
    private PersonajeServiceImpl personajeServiceImpl;

    @Autowired
    private PeliculasSeriesImpl peliculasSeriesImpl;

    @GetMapping("/all")
    public ResponseEntity<List<PersonajesLite>>  getAll(){
        return new ResponseEntity<>(personajeServiceImpl.getAllPersonajesLite(),HttpStatus.OK);
    }


    @GetMapping("/detalles/{personajeId}")
    public ResponseEntity<List<PersonajesSeries>> getCharacter(@PathVariable("personajeId") int personajeId){
        return new ResponseEntity<>(personajeServiceImpl.getPersonajePeliculasSeries(personajeId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PersonajesSeries>> getFilter(@RequestParam(value = "name", required = false) String name,
                                                            @RequestParam(value = "age", required = false) Integer age,
                                                            @RequestParam(value = "movie",required = false) String movie) {
        if (name != null && movie != null){
            return new ResponseEntity<>(personajeServiceImpl.getByCharacterAndMovie(movie,name), HttpStatus.OK);
        }else if(movie != null && age != null){
            return new ResponseEntity<>(personajeServiceImpl.getByMovieAndAge(movie,age),HttpStatus.OK);
        }else if(name != null){
            return new ResponseEntity<>(personajeServiceImpl.getByName(name),HttpStatus.OK);
        }else if(age != null){
            return new ResponseEntity<>(personajeServiceImpl.getByAge(age),HttpStatus.OK);
        }else if(movie != null){
            return new ResponseEntity<>(personajeServiceImpl.getByMovieName(movie),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/save")
    public ResponseEntity<Personaje> save(@RequestBody Personaje personaje){
        return new ResponseEntity<>(personajeServiceImpl.save(personaje),HttpStatus.OK);
    }


    @PutMapping("/{characterId}/Movies/{moviesId}")
    public ResponseEntity<Personaje> enrollCharacterToMovie(@PathVariable("characterId") Integer characterId,
                                                 @PathVariable("moviesId") Integer moviesId){

        Personaje character = personajeServiceImpl.getPersonaje(characterId).get();
        PeliculasSeries movies = peliculasSeriesImpl.getMovie(moviesId).get();
        character.enrollMovie(movies);

        return new ResponseEntity(personajeServiceImpl.save(character), HttpStatus.OK);
    }





}
