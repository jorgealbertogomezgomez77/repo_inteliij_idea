package BinarySearchTree;

import java.util.Comparator;

public class ComparadorSimple<E> implements Comparator<E> {

    /*
    * Clase comparadora de objetos
    * Método compar(E a, E b):
    * x < 0 si a es menor que b
    * x == 0 si a es igual a b
    * x > 0 si a es mayor que b
    */

    @Override
    public int compare(E a, E b) {
        return ((Comparable<E>) a).compareTo(b);
    }
}
