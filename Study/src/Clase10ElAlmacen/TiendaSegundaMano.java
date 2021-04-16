package Clase10ElAlmacen;

import java.io.PrintWriter;
import java.text.DecimalFormat;

public class TiendaSegundaMano {
    private String nombre;
    private Producto[] Stock;

    public TiendaSegundaMano(String nombre, Producto[] Stock) {
        this.nombre = nombre;
        this.Stock = Stock;
        this.aplicarDescuento();
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

    public void imprimeEstadisticas(PrintWriter salida) {
        DecimalFormat decimal = new DecimalFormat("00.00");
        salida.println("--------------------------------------------------------------");
        salida.println("-------Lista de productos de la tienda de segunda mano--------");
        double beneficio = 0.0;
        for (int i = 0; i < Stock.length; i++) {
            Stock[i].imprime(salida);
            beneficio += Stock[i].getValor();
        }
        salida.println(" El beneficio de la tienda de segunda mano : " + decimal.format(beneficio));
        salida.println("--------------------------------------------------------------");
    }

    public void aplicarDescuento() {
        for (int i = 0; i < Stock.length - 1; i++) {
            if (Stock[i].getClase().compareTo("B") == 0) {
                Stock[i].setValor(Stock[i].getValor() * 0.75);
            }
            if (Stock[i].getClase().compareTo("C") == 0) {
                Stock[i].setValor(Stock[i].getValor() * 0.50);
            }
        }
    }
}
