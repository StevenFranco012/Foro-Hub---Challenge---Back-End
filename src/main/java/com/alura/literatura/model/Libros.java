package com.alura.literatura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que representa un libro.
 */
@Entity
@Table(name = "libros")
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private final String titulo;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> idiomas; // Removed 'final' keyword

    private Double descargas;
    private String nombreAutor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Libros() {
        this.titulo = null;
        this.idiomas = null;
    }

    /**
     * Constructor que crea un libro a partir de los datos proporcionados.
     *
     * @param datosLibros los datos del libro
     * @param autor el autor del libro
     */
    public Libros(DatosLibros datosLibros, Autor autor) {
        this.titulo = datosLibros.titulo();
        this.nombreAutor = datosLibros.autor().stream().map(DatosAutor::nombre).collect(Collectors.toList()).toString();
        this.idiomas = datosLibros.idiomas();
        this.descargas = datosLibros.totalDescargas();
        this.autor = autor;
    }

    @Override
    public String toString() {
        return String.format("------------LIBRO-----------%nTitulo: %s%nAutor: %s%nIdiomas: %s%nDescargas: %s%n----------------------------%n",
                titulo, nombreAutor, idiomas, descargas);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
        if (autor != null && !autor.getLibros().contains(this)) {
            autor.getLibros().add(this);
        }
    }

    public Double getDescargas() {
        return descargas;
    }

    public void setDescargas(Double descargas) {
        this.descargas = descargas;
    }
}