package com.alura.literatura.service;

import java.util.Scanner;

public class InputService {
    private final Scanner scanner;

    public InputService() {
        this.scanner = new Scanner(System.in);
    }

    public String readString() {
        return scanner.nextLine();
    }

    public int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }

    public double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }
}