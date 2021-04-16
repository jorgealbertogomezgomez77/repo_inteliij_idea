package Maps;

import List.DoubleLinkedList;
import List.Nodo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class DiccionarioHash {
    Hashtable<String, DoubleLinkedList<Producto>> tabla = new Hashtable<String, DoubleLinkedList<Producto>>();

    public void pasarAatabla(Producto[] vp) {
        for (int i = 0; i < vp.length; i++) {
            DoubleLinkedList<Producto> llinked = tabla.get(vp[i].getClase());
            if (llinked == null) {
                llinked = new DoubleLinkedList<Producto>();
                llinked.addLast(vp[i]);
                tabla.put(vp[i].getClase(), llinked);
            }
            else {
                llinked.addLast(vp[i]);
                tabla.put(vp[i].getClase(), llinked);
            }
        }
    }

    public void filtrarPorClase(String filtro) {
        DoubleLinkedList<Producto> lista = tabla.get(filtro);
        if (lista != null) {
            Iterable<Nodo<Producto>> iter = lista.iterator();
            Iterator<Nodo<Producto>> it = iter.iterator();
            while (it.hasNext()) {
                Nodo<Producto> n = it.next();
                n.getElemento().imprime();
            }
        }
        else {
            System.out.println("No hay elementos de la clase seleccionada.");
        }
    }
}
