package com.alura.literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Clase que representa los datos generales de los libros.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosGenerales(
        /**
         * Lista de los datos de los libros.
         */
        @JsonAlias("results") List<DatosLibros> resultado) {

}