package com.alura.literatura.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Clase que representa un autor.
 */
@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;

    private String fechaNacimiento;
    private String fechaDefuncion;

    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Libros> libros = new HashSet<>();

    public Autor() {
    }

    /**
     * Constructor que crea un autor a partir de los datos proporcionados.
     *
     * @param datosAutor los datos del autor
     */
    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.fechaNacimiento = datosAutor.fechaNacimiento();
        this.fechaDefuncion = datosAutor.fechaDefuncion();
    }

    @Override
    public String toString() {
        return String.format("AUTOR: %s%nFecha de Nacimiento: %s%nFecha de Defuncion: %s%nLibros: %s%n",
                nombre, fechaNacimiento, fechaDefuncion,
                (libros != null ? libros.stream().map(Libros::getTitulo).collect(Collectors.joining(", ")) : "N/A"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(String fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public Set<Libros> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libros> libros) {
        this.libros = libros;
        for (Libros libro : libros) {
            libro.setAutor(this);
        }
    }
}