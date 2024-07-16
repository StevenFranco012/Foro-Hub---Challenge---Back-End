package com.alura.literatura.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class MenuService {
    private final BusquedaService busquedaService;
    private final Scanner scanner;

    public MenuService(BusquedaService busquedaService) {
        this.busquedaService = busquedaService;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("""
                    ----------------------------------------
                        MENU:
                    
                    1 - Buscar libros por titulo
                    2 - Mostrar libros registrados
                    3 - Mostrar autores registrados
                    4 - Mostrar autores vivos en determinado año
                    5 - Mostrar libros por idiomas
               
                        
                    0 - Salir
                    -----------------------------------------
                    """);
            opcion = scanner.nextInt();
            manejarOpcion(opcion);
        } while (opcion != 0);
    }

    private void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el título del libro");
                String titulo = scanner.next();
                busquedaService.buscarLibro(titulo);
                break;
            case 2:
                busquedaService.mostrarLibrosRegistrados().forEach(System.out::println);
                break;
            case 3:
                busquedaService.mostrarAutoresRegistrados().forEach(System.out::println);
                break;
            case 4:
                System.out.println("Ingrese año");
                int año = scanner.nextInt();
                busquedaService.buscarAutorVivoEnAño(año).forEach(System.out::println);
                break;
            case 5:
                System.out.println("Ingrese idioma");
                String idioma = scanner.next();
                busquedaService.buscarLibrosPorIdioma(idioma).forEach(System.out::println);
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
                break;
        }
    }
}