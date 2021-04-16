package Clase13LaLibreria;

import java.io.PrintWriter;
import java.io.Serializable;
import java.text.DecimalFormat;

public class Libro implements Serializable {
    private String ISBN;
    private String titulo;
    private String autor;
    private double precio;

    public Libro() {

    }

    public Libro(String ISBN, String titulo, String autor, double precio) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void imprime() {
        DecimalFormat decimales = new DecimalFormat("00.00");
        System.out.println(" ISBN: " + this.getISBN() + " Título: " + this.getTitulo() + " Autor: " + this.getAutor() + " Presio: " + decimales.format(this.getPrecio()));
    }

    public void imprime(PrintWriter salida) {
        DecimalFormat decimales = new DecimalFormat("00.00");
        salida.println(" ISBN: " + this.getISBN() + " Título: " + this.getTitulo() + " Autor: " + this.getAutor() + " Presio: " + decimales.format(this.getPrecio()));
    }
}
