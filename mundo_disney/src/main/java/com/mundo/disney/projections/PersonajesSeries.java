package com.mundo.disney.projections;


import com.mundo.disney.persistencia.entities.PeliculasSeries;

import java.util.List;
import java.util.Set;

public interface PersonajesSeries {

    String getNombre();
    String getImagenPersonaje();
    String getEdad();
    String getPeso();
    String getHistoria();
    String getPeliculas();

}
