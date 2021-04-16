package Clase13LaLibreria;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Libreria {
    ArrayList<Libro> libros;
    String nombre;

    public Libreria() {

    }

    public Libreria(ArrayList<Libro> libros, String nombre) {
        this.libros = libros;
        this.nombre = nombre;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void anadirLibro(String ISBN, String titulo, String autor, double presio) {
        Libro l = new Libro(ISBN, titulo, autor, presio);
        libros.add(l);
    }

    public void imprimirCatalogo() throws IOException {
        System.out.println("¿Desea guardar el catálogo en un fichero de texto?");
        // Leer cadenas por teclado o por archivo.
        Scanner sc = new Scanner(System.in);
        String respuesta = sc.nextLine();
        if (respuesta.compareToIgnoreCase("s") == 0) {
            System.out.println("Escribe el nombre del archivo destino");
            String filename = sc.nextLine();
            FileWriter escritor = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(escritor);

            Iterator<Libro> it = libros.iterator();
            while (it.hasNext()) {
                Libro l = it.next();
                l.imprime(pw);
            }
            pw.close();
        }// Fin de escritura por fichero.

        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            Libro l = it.next();
            l.imprime();
        }
    }

    public Libro borrarLibro(String ISBN) {
        boolean encontrado = false;
        Iterator<Libro> it = libros.iterator();
        while ((it.hasNext()) && (encontrado == false)) {
            Libro l = it.next();
            if (l.getISBN().compareTo(ISBN) == 0) {
                it.remove();
                encontrado = true;
                return l;
            }
        }
        return null;
    }

    public ArrayList<Libro> filtrarPorAutor(String autor) throws IOException {
        ArrayList<Libro> sublista = new ArrayList<Libro>();
        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            Libro l = it.next();
            if (l.getAutor().compareToIgnoreCase(autor) == 0) {
                sublista.add(l);
            }
        } // Rellenar sublista.

        System.out.println("¿Desea guardar el catalogo en un fichero de texto?");
        // Leer cadenas por teclado o por archivo.
        Scanner sc = new Scanner(System.in);
        String respuesta = sc.nextLine();
        if (respuesta.compareToIgnoreCase("s") == 0) {
            System.out.println("Escribe el nombre del archivo destino.");
            String filename = sc.nextLine();
            FileWriter escritor = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(escritor);

            Iterator<Libro> it2 = sublista.iterator();
            while (it2.hasNext()) {
                Libro l = it2.next();
                l.imprime(pw);
            }
            pw.close();
        } // Fin de la escritura por fichero.
        // Salida por consola.
        Iterator<Libro> it3 = sublista.iterator();
        while (it3.hasNext()) {
            Libro l = it3.next();
            l.imprime();
        }
        return sublista;
    } // Fin del método filtradoPorAutor.

    public ArrayList<Libro> filtrarPorPrecio(double preciomax) throws IOException {
        ArrayList<Libro> sublista = new ArrayList<Libro>();
        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            Libro l = it.next();
            if (l.getPrecio() <= preciomax) {
                sublista.add(l);
            }
        } // Rellenar sublista.

        System.out.println("¿Desea guardar el catalogo en un fichero de texto?");
        // Leer cadenas por teclado o por archivo.
        Scanner sc = new Scanner(System.in);
        String respuesta = sc.nextLine();
        if (respuesta.compareToIgnoreCase("s") == 0) {
            System.out.println("Escribe el nombre del archivo destino.");
            String filename = sc.nextLine();
            FileWriter escritor = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(escritor);

            Iterator<Libro> it2 = sublista.iterator();
            while (it2.hasNext()) {
                Libro l = it2.next();
                l.imprime(pw);
            }
            pw.close();
        } // Fin de la escritura por fichero.
        // Salida por consola.
        Iterator<Libro> it3 = sublista.iterator();
        while (it3.hasNext()) {
            Libro l = it3.next();
            l.imprime();
        }
        return sublista;
    } // Fin del método filtrado Por Autor.
}
