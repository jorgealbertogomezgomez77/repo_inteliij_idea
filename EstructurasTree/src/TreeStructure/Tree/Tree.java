package TreeStructure.Tree;

import java.util.Iterator;

public interface Tree<E> {

// int size()->devuelve el tamaño.
    public int size();

// boolean isEmpty()->true su esta vacío en caso contrario.
    public boolean isEmpty();

// Iterator iterator()->devolvemos un iterador con todos sus elementos.
    Iterator iterator();

// Iterable positions()->devolvemos una collection de todos sus nodos.
    Iterable<Position<E>> position();

// Position<E> root()->devolvemos la raíz del arbol.
    Position<E> root();

// Position<E> parent(Position<E> p)->devuelve el padre del nodo.
    Position<E> parent(Position<E> p);

// Iterable children(Position<E> p)->devuelve una lista con todos sus nodos hijo de un nodo.
    Iterable children(Position<E> p);

// boolean isLeaf(Position<E> p)->preguntamos si el nodo es hoja o no.
    boolean isLeaf(Position<E> p);

// boolean isInternal(Position<E> p)->preguntamos si un nodo es interno o no.
    boolean isInternal(Position<E> p);

// boolean isRoot(Position<E> p)->preguntamos si este nodo es raiz.
    boolean isRoot(Position<E> p);

// E replace(Position<E> p, E elemento)->remplaza el elemento del nodo p por el elemento e.
    E replace(Position<E> p, E elemento);
}
