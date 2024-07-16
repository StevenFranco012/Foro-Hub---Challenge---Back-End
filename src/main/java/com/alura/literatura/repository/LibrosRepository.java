package com.alura.literatura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alura.literatura.model.Libros;

/**
 * Repositorio para la entidad Libros.
 */
@Repository
public interface LibrosRepository extends JpaRepository<Libros,Long>{

    /**
     * Busca un libro por su título, ignorando mayúsculas y minúsculas.
     *
     * @param nombreLibro el título del libro
     * @return el libro encontrado, o null si no se encuentra ninguno
     */
    Libros findByTituloContainsIgnoreCase(String nombreLibro);

    /**
     * Busca libros por su idioma.
     *
     * @param idioma el idioma de los libros
     * @return una lista de libros en el idioma especificado
     */
    List<Libros> findByIdiomas(String idioma);
}