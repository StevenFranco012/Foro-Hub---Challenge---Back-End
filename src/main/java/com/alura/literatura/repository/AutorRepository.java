package com.alura.literatura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alura.literatura.model.Autor;

/**
 * Repositorio para la entidad Autor.
 */
@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {

    /**
     * Busca un autor por su nombre.
     *
     * @param nombre el nombre del autor
     * @return el autor encontrado, o null si no se encuentra ninguno
     */
    Autor findByNombre(String nombre);

    /**
     * Busca autores que estaban vivos en un año determinado.
     *
     * @param año el año de interés
     * @return una lista de autores que estaban vivos en ese año
     */
    @Query("SELECT a FROM Autor a WHERE a.fechaNacimiento <= :año AND a.fechaDefuncion >= :año")
    List<Autor> autoresVivosEnDeterminadoAño (int año);
}