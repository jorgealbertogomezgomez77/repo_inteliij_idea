package Clase13LaLibreria;

import java.io.IOException;
import java.util.Scanner;

public class Clase13LaLibreria {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Libreria libreria = new Libreria();
        libreria.setNombre("Mi librería");
        GeneradorDeLibros gl = new GeneradorDeLibros();
        libreria.setLibros(gl.generarLibros(20));
        String opcion = "";
        while (opcion.compareTo("8") != 0) {
            mostrarMenu();
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextLine();

            switch (opcion) {
                case "1": {
                    Sesion s = new Sesion();
                    libreria.setLibros(s.cargarCatalogo());
                    break;
                }
                case "2": {
                    Sesion s = new Sesion();
                    s.setCatalogo(libreria.getLibros());
                    s.guardarCatalogo();
                    break;
                }
                case "3": {
                    System.out.println("Escribe el ISBN del libro");
                    String ISBN = sc.nextLine();
                    System.out.println("Escribe el título del libro");
                    String titulo = sc.nextLine();
                    System.out.println("Escribe el autor del libro");
                    String autor = sc.nextLine();
                    System.out.println("Escribe el precio del libro");
                    double precio = Double.parseDouble(sc.nextLine());
                    libreria.anadirLibro(ISBN, titulo, autor, precio);
                    break;
                }
                case "4": {
                    System.out.println("Escribe el ISBN del libro");
                    String ISBN = sc.nextLine();
                    libreria.borrarLibro(ISBN);
                    break;
                }
                case "5": {
                    System.out.println("Escribe el autor del libro");
                    String autor = sc.nextLine();
                    libreria.filtrarPorAutor(autor);
                    break;
                }
                case "6": {
                    System.out.println("Escribe el precio maximo");
                    double precio = Double.valueOf(sc.nextLine());
                    libreria.filtrarPorPrecio(precio);
                    break;
                }
                case "7": {
                    libreria.imprimirCatalogo();
                    break;
                }
                case "8": {
                    System.out.println("Hasta luego!!!");
                    break;
                }
                default: {
                    System.out.println("Opción Incorrecta");
                    break;
                }
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("----------------Menú-----------------");
        System.out.println("1. Cargar catálogo");
        System.out.println("2. Guardar catalogo");
        System.out.println("3. Añadir nuevo libro");
        System.out.println("4. Borrar libro del catálogo (ISBN)");
        System.out.println("5. Filtrar por autor");
        System.out.println("6. Filtrar por precio");
        System.out.println("7. Imprimir catálogo");
        System.out.println("8. Salir");
        System.out.println("-------------------------------------");

    }
}
