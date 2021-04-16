package Clase12Interfaces;

import java.util.ArrayList;
import java.util.Iterator;

public class Clase12Interfaces {
    public static void main(String[] args) {
        Producto p1 = new Producto();
        ArrayList<Producto> lprod = GeneradorProductos.generarProductos(10);
        Iterator<Producto> it = lprod.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (i == 4) {
                it.remove();
            }
            else {
                it.next().imprime();
                System.out.println("Posición  " + i);
            }
            i++;
        }
    }
}
