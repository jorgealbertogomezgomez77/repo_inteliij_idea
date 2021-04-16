package Clase13LaLibreria;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Sesion {
    ArrayList<Libro> catalogo;

    public Sesion() {

    }

    public Sesion(ArrayList<Libro> catalogo) {
        this.catalogo = catalogo;
    }

    public ArrayList<Libro> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<Libro> catalogo) {
        this.catalogo = catalogo;
    }

    public void guardarCatalogo() throws IOException {
        System.out.println("Escribe un nombre de archivo destino.");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        FileOutputStream escritor = new FileOutputStream(filename);
        ObjectOutputStream salida = new ObjectOutputStream(escritor);
        salida.writeObject(catalogo);
        salida.close();
    }

    public ArrayList<Libro> cargarCatalogo() throws IOException, ClassNotFoundException {
        System.out.println("Escribe un nombre de archivo origen.");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        FileInputStream lector = new FileInputStream(filename);
        ObjectInputStream entrada = new ObjectInputStream(lector);
        ArrayList<Libro> lista = (ArrayList<Libro>) entrada.readObject();

        return lista;
    }
}
