package com.alura.literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Clase que representa los datos de los libros.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        /**
         * Título del libro.
         */
        @JsonAlias("title") String titulo,
        /**
         * Lista de autores del libro.
         */
        @JsonAlias("authors")  List<DatosAutor> autor,
        /**
         * Lista de idiomas del libro.
         */
        @JsonAlias("languages")  List<String> idiomas,
        /**
         * Total de descargas del libro.
         */
        @JsonAlias("download_count")  Double totalDescargas ) {
}