package com.example.literAlura;

import com.example.literalura.GutendexClient;
import com.example.literalura.LiterAluraApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.print.Book;
import java.util.Scanner;

@SpringBootApplication
public class l implements CommandLineRunner {

    private final GutendexClient gutendexClient;

    public l(GutendexClient gutendexClient) {
        this.gutendexClient = gutendexClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(l.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Listar autores");
            System.out.println("4. Listar autores vivos en un determinado año");
            System.out.println("5. Salir");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String title = scanner.nextLine();
                    String json = gutendexClient.searchBookByTitle(title);
                    Book book = gutendexClient.getBookFromJson(json);
                    System.out.println(book);
                    break;
                case 2:
                    // Lógica para listar todos los libros
                    break;
                case 3:
                    // Lógica para listar autores
                    break;
                case 4:
                    // Lógica para listar autores vivos en un determinado año
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}
