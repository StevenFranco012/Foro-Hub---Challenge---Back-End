package com.alura.literatura;

import com.alura.literatura.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {

	@Autowired
	private MenuService menuService;

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		menuService.mostrarMenu();
		printAllThreads();
	}

	private void printAllThreads() {
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		for (Thread t : threadSet) {
			System.out.println(t);
		}
	}
}