package com.mundo.disney.web.controller;

import com.mundo.disney.persistencia.entities.Genero;
import com.mundo.disney.service.GeneroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Genre")
public class GeneroController {

    @Autowired
    private GeneroServiceImpl generoServiceImpl;


    @PostMapping("/save")
    public ResponseEntity<Genero> save(@RequestBody Genero genero){
        return new ResponseEntity<>(generoServiceImpl.save(genero), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int generoId){
        if(generoServiceImpl.delete(generoId) == true){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
