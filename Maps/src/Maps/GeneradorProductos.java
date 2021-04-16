package Maps;

import java.util.Random;

public class GeneradorProductos {
    public static Producto[] generarProductos(int n) {
        Random r = new Random();
        String[] listaclases = {"A", "B", "C"};
        Producto[] resultado = new Producto[n];

        for (int i = 0; i < n; i++) {
            Producto p = new Producto();
            p.setID(Integer.toString((int)(Math.random() * 1000000)));
            p.setValor(r.nextDouble() * 1000);
            p.setPeso(r.nextDouble() * 10);
            int valores[] = {0, 1};
            if (valores[r.nextInt(valores.length)] == 0) {
                p.setAsignado(false);
            }
            else {
                p.setAsignado(true);
            }
            //p.setAsignado(true);
            p.setClase(listaclases[r.nextInt(listaclases.length)]);

            resultado[i] = p;
        }
        return resultado;
    }
}
