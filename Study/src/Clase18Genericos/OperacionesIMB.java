package Clase18Genericos;

import java.util.ArrayList;
import java.util.Iterator;

public class OperacionesIMB <E> {
    public void insertarElemento(ArrayList<E> lista, E elemento) {
        lista.add(elemento);
    }

    public E buscarElemento(ArrayList<E> lista, E elemento) {
        Iterator<E> it = lista.iterator();
        while (it.hasNext()) {
            E item = it.next();
            if (item.equals(elemento)) {
                return item;
            }
        }
        return null;
    }

    public E borrarElemento(ArrayList<E> lista, E elemento) {
        Iterator<E> it = lista.iterator();
        while (it.hasNext()) {
            E item = it.next();
            if (item.equals(elemento)) {
                it.remove();
                return item;
            }
        }
        return null;
    }

    public void imprimirElemento(ArrayList<E> lista) {
        Iterator<E> it = lista.iterator();
        while (it.hasNext()) {
            E item  = it.next();
            System.out.println(item);
        }
    }
}
