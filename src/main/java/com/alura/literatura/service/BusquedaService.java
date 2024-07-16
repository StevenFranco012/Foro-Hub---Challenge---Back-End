package com.alura.literatura.service;

import com.alura.literatura.model.*;
import com.alura.literatura.repository.AutorRepository;
import com.alura.literatura.repository.LibrosRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BusquedaService {

    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private LibrosRepository repository;
    private AutorRepository repositoryAutor;
    private List<Libros> libros;
    private List<Autor> autor;

    public BusquedaService(AutorRepository autorRepository, LibrosRepository librosRepository) {
        this.repositoryAutor = autorRepository;
        this.repository = librosRepository;
    }

    public void buscarLibro(String buscaLibro) {
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + buscaLibro.replace(" ", "+"));
        var buscador = convierteDatos.obtenerDatos(json, DatosGenerales.class);

        Optional<DatosLibros> libroBuscado = buscador.resultado().stream()
                .filter(l -> l.titulo().toUpperCase().contains(buscaLibro.toUpperCase()))
                .findFirst();

        if (libroBuscado.isPresent()) {
            DatosLibros datosLibros = libroBuscado.get();
            DatosAutor datosAutor = datosLibros.autor().get(0);
            Autor autor = repositoryAutor.findByNombre(datosAutor.nombre());

            if (autor == null) {
                autor = new Autor(datosAutor);
                repositoryAutor.save(autor);
            }

            Libros libro = repository.findByTituloContainsIgnoreCase(datosLibros.titulo());

            if (libro == null) {
                System.out.println("¡Libro encontrado!");
                libro = new Libros(datosLibros, autor);
                repository.save(libro);
                System.out.println(libro);
            } else {
                System.out.println("Libro ya esta Registrado");
            }
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    public List<Libros> mostrarLibrosRegistrados(){
        libros = repository.findAll();
        return libros;
    }

    public List<Autor> mostrarAutoresRegistrados(){
        autor = repositoryAutor.findAll();
        return autor;
    }

    public List<Libros> buscarLibrosPorIdioma(String idioma){
        try {
            libros = repository.findByIdiomas(idioma);
            if (libros == null) {
                System.out.println("No hay Libros registrados");
            }
            return libros;
        } catch (Exception e){
            System.out.println("Error en la busqueda");
            return Collections.emptyList();
        }
    }

    public List<Autor> buscarAutorVivoEnAño(int año) {
        autor = repositoryAutor.autoresVivosEnDeterminadoAño(año);
        if (autor == null) {
            System.out.println("No hay registro de autores en ese año");
            return Collections.emptyList();
        } else {
            return autor;
        }
    }
}