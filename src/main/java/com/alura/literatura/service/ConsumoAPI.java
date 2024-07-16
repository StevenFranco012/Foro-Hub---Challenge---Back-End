package com.alura.literatura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    public String obtenerDatos(String url) {
        HttpClient client = crearHttpClient();
        HttpRequest request = crearHttpRequest(url);
        HttpResponse<String> response = enviarRequest(client, request);

        if (response != null) {
            return response.body();
        } else {
            throw new RuntimeException("La respuesta del servidor es nula");
        }
    }

    private HttpClient crearHttpClient() {
        return HttpClient.newHttpClient();
    }

    private HttpRequest crearHttpRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
    }

    private HttpResponse<String> enviarRequest(HttpClient client, HttpRequest request) {
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}