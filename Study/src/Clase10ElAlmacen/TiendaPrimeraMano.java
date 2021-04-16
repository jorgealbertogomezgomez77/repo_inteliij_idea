package Clase10ElAlmacen;

import java.text.DecimalFormat;

public class TiendaPrimeraMano {
    private String nombre;
    private Producto[] Stock;

    public TiendaPrimeraMano(String nombre, Producto[] Stock) {
        this.nombre = nombre;
        this.Stock = Stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto[] getStock() {
        return Stock;
    }

    public void setStock(Producto[] stock) {
        Stock = stock;
    }

    public void imprimeEstadisticas() {
        DecimalFormat decimal = new DecimalFormat("00.00");
        System.out.println("--------------------------------------------------------------");
        System.out.println("----------Lista de productos de la tienda del centro----------");
        double beneficio = 0.0;
        for (int i = 0; i < Stock.length; i++) {
            Stock[i].imprime();
            beneficio += Stock[i].getValor();
        }
        System.out.println(" El beneficio de la tienda del centro es : " + decimal.format(beneficio));
        System.out.println("--------------------------------------------------------------");

    }
}
