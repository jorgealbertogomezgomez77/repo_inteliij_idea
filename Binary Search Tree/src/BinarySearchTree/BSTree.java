package BinarySearchTree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class BSTree<E> {
    private int size;
    private LinkedBinaryTree<E> tree;
    private Comparator<E> comparator;

    public BSTree() {
        size = 0;
        tree = new LinkedBinaryTree<E>();
        tree.addRoot(null);
        comparator = new ComparadorSimple<E>();
    }

    public BSTree(Comparator<E> comp) {
        size = 0;
        tree = new LinkedBinaryTree<E>();
        tree.addRoot(null);
        comparator = comp;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int size() {
        return size;
    }
    // Método que nos sirve para insertar, borrar y buscar.
    protected Position<E> busquedaEnArbol(Position<E> p, E value) {
        if (tree.isLeaf(p)) { // En caso de que sea nodo externo.
            return p;
        }
        else {
            E valorActual = p.elemento();
            int comparacion = comparator.compare(value, valorActual);
            if (comparacion < 0) {
                // es menor recorrido por la izquierda.
                return busquedaEnArbol(tree.left(p), value);
            }
            else {
                return p;
            }
        }
    }

    public Position<E> expandirHoja(Position<E> p, E value1, E value2) {
        tree.addLeft(p, value1);
        tree.addRight(p, value2);
        return p;
    }

    public Position<E> insertarEnHoja(Position<E> p, E value) {
        this.expandirHoja(p, null, null);
        this.replace(p, value);
        this.size ++;
        return p;
    }

    public Position<E> replace(Position<E> p, E value) {
        tree.replace(p, value);
        return p;
    }

    public Position<E> insert(E value) {
        Position<E> p = this.busquedaEnArbol(tree.root(), value);
        if (p.elemento() != value) {
            this.insertarEnHoja(p, value);
        }
        return p;
    }

    public Position<E> sucesor(Position<E> p) {
        Position<E> sucesor = p;
        if (!tree.isLeaf(tree.right(p))) {
            sucesor = tree.right(p);
        }
        while (tree.isInternal(tree.left(sucesor))) {
            sucesor = tree.left(sucesor);
        }
        return sucesor;
    }

    public Position<E> remove(E value) {
        Position<E> posrem = this.busquedaEnArbol(tree.root(), value);
        Position<E> aux = posrem;
        // Caso 1 es un nodo con sus nodos extremos null.
        if ((tree.left(posrem) == null) && (tree.right(posrem) == null)) {
            posrem = null;
            this.size --;
        }
        if (((tree.left(posrem) != null) && (tree.right(posrem) != null))
            || ((tree.left(posrem) == null) && (tree.right(posrem) == null))) {
            tree.remove(posrem);
            this.size --;
        }
        else { // Tiene dos hijos.
            Position<E> sucesor = this.sucesor(posrem);
            this.replace(posrem, sucesor.elemento());
            tree.remove(tree.left(sucesor));
            //tree.remove(tree.right(sucesor));
            tree.remove(sucesor);
            this.size --;
        }
        return posrem;
    }

    public void addList(List<E> list) {
        List<E> l = list;
        Iterator<E> it = l.iterator();
        while (it.hasNext()) {
            E value = it.next();
            this.insert(value);
        }
    }
}
