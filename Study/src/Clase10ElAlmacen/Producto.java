package Clase10ElAlmacen;

import java.io.PrintWriter;
import java.text.DecimalFormat;

public class Producto {
    private String ID;
    private double valor;
    private double peso;
    private boolean asignado;
    private String clase;

    public Producto() {

    }

    public Producto(String ID, double valor, double peso, boolean asignado, String clase) {
        this.ID = ID;
        this.valor = valor;
        this.peso = peso;
        this.asignado = asignado;
        this.clase = clase;
    }

    public String getID() {
        return ID;
    }

    public double getValor() {
        return valor;
    }

    public double getPeso() {
        return peso;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public boolean getAsignado() {
        return asignado;
    }

    public String getClase() {
        return clase;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public void imprime() {
        DecimalFormat decimales = new DecimalFormat("00.00");
        System.out.println(" ID: " + this.getID() + " Valor: " + decimales.format(this.valor) + " Clase " + this.clase + " Peso: " + decimales.format(this.peso) + " Asignado " + this.asignado);
    }

    public void imprime(PrintWriter salida) {
        DecimalFormat decimales = new DecimalFormat("00.00");
        salida.println(" ID: " + this.getID() + " Valor: " + decimales.format(this.valor) + " Clase " + this.clase + " Peso: " + decimales.format(this.peso) + " Asignado " + this.asignado);
    }
}
