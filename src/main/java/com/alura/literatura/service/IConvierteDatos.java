package com.alura.literatura.service;

/**
 * Interfaz para la conversión de datos JSON a objetos de una clase específica.
 */
public interface IConvierteDatos {

    /**
     * Convierte una cadena JSON en un objeto de la clase especificada.
     *
     * @param json la cadena JSON a convertir
     * @param clase la clase del objeto al que se debe convertir el JSON
     * @param <T> el tipo del objeto al que se debe convertir el JSON
     * @return un objeto de la clase especificada
     */
    <T> T obtenerDatos(String json, Class<T> clase);
}