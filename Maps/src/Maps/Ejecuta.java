package Maps;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejecuta {
    public static void main(String[] args) {
        /*Producto[] vp = GeneradorProductos.generarProductos(20);
        TablasHash tabla = new TablasHash();
        tabla.pasarTabla(vp);
        //Hashtable<String, Maps.Producto> nuevatabla = new Hashtable<String, Maps.Producto>(4, (float)0.2);
        ArrayList<Producto> listaprod = tabla.listaProd();
        Iterator<Producto> it = listaprod.iterator();
        int contador = 0;
        Producto aux = new Producto();
        while (it.hasNext()) {
            if (contador == 0) {
                aux = it.next();
                aux.imprime();
                contador ++;
            }
            else {
                Producto p = it.next();
                p.imprime();
            }
        }
        System.out.println("-------------------------------------------------------------");
        tabla.getP(aux.getID()).imprime();*/

        Producto[] vp = GeneradorProductos.generarProductos(5);
        DiccionarioHash dic = new DiccionarioHash();
        dic.pasarAatabla(vp);
        dic.filtrarPorClase("B");
    }
}
