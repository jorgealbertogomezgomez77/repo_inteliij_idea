package Clase12Interfaces;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class GeneradorProductos {
    public static ArrayList<Producto> generarProductos(int n) {
        DecimalFormat form = new DecimalFormat("00.00");
        Random r = new Random();
        ArrayList<Producto> lprod = new ArrayList<Producto>();

        for (int i = 0; i < n; i++) {
            Producto p = new Producto();
            p.setID(Integer.toString((int)(Math.random() * 1000000)));
            p.setValor(r.nextDouble() * 1000);
            lprod.add(p);
        }
        return lprod;
    }
}
