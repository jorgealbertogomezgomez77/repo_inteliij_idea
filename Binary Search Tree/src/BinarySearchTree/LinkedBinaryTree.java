package BinarySearchTree;

import Exceptions.BadPosition;
import Exceptions.EmptyTreeException;
import Exceptions.InaccesibleException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedBinaryTree<E> implements InterfazBinaryTree<E> {
    BTNode<E> root;
    int size;

    @Override
    public Position<E> left(Position<E> p) {
        BTNode<E> node = checkPosition(p);
        BTNode<E> left;
        if (this.hasLeft(p)) {
            left = node.getLeft();
        }
        else {
            throw new InaccesibleException("No existe el hijo izquierdo.");
        }
        return left;
    }

    @Override
    public Position<E> right(Position<E> p) {
        BTNode<E> node = checkPosition(p);
        BTNode<E> right;
        if (this.hasRight(p)) {
            right = node.getRight();
        }
        else {
            throw new InaccesibleException("No existe el hijo izquierdo.");
        }
        return right;
    }

    @Override
    public boolean hasRight(Position<E> p) {
        BTNode<E> node = checkPosition(p);
        if (node.getRight() == null) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public boolean hasLeft(Position<E> p) {
        BTNode<E> node = checkPosition(p);
        if (node.getLeft() == null) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Iterator iterator() {
        Iterable<Position<E>> pos = (Iterable<Position<E>>) position();
        List<Position<E>> resultado = new ArrayList<Position<E>>();
        for (Position<E> p: pos) {
            resultado.add(p);
        }
        return resultado.iterator();
    }

    @Override
    public Iterable<Position<E>> position() {
        List<Position<E>> lista = new ArrayList<Position<E>>();
        preOrden(this.root, lista);
        return (Iterable) lista;
    }

    @Override
    public Position<E> root() throws EmptyTreeException{
        if (this.isEmpty() == true) throw new EmptyTreeException("El árbol está vacío.");
        return this.root;
    }

    @Override
    public E replace(Position<E> p, E elemento) {
        BTNode<E> node = checkPosition(p);
        E element = node.getElemento();
        node.setElemento(elemento);
        return element;
    }

    @Override
    public boolean isRoot(Position<E> p) {
        BTNode<E> node = checkPosition(p);
        return node.equals(root);
    }

    @Override
    public boolean isInternal(Position<E> p) {
        return !this.isLeaf(p);
    }

    @Override
    public boolean isLeaf(Position<E> p) {
        BTNode<E> node = checkPosition(p);
        if ((node.getLeft() == null) && (node.getRight() == null)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Iterable children(Position<E> p) {
        BTNode<E> node = checkPosition(p);
        List<Position<E>> hijos = new ArrayList<Position<E>>();
        if (!this.isLeaf(p)) {
            if (node.getLeft() != null) {
                hijos.add((Position<E>) node.getLeft());
            }
            if (node.getRight() != null) {
                hijos.add((Position<E>) node.getRight());
            }
        }
        return hijos;
    }

    @Override
    public Position<E> parent(Position<E> p) {
        BTNode<E> node = checkPosition(p);
        BTNode<E> parent;
        if (node.equals(root)) {
            throw new InaccesibleException("El nodo raíz no tiene padre");
        }
        else {
            parent = node.getParent();
        }
        return parent;
    }

    public BTNode<E> addRight(Position<E> p, E elemento) {
        BTNode<E> node = checkPosition(p);
        E element = node.getElemento();
        BTNode<E> newnode = this.crearNodo(elemento, null, null, node);
        if (node.getRight() == null) {
            node.setRight(newnode);
            this.size ++;
        }
        else {
            throw new InaccesibleException("Ya tiene un hijo derecho.");
        }
        return newnode;
    }

    public BTNode<E> addLeft(Position<E> p, E elemento) {
        BTNode<E> node = checkPosition(p);
        BTNode<E> newnode = this.crearNodo(elemento, null, null, node);
        if (node.getLeft() == null) {
            node.setLeft(newnode);
            this.size ++;
        }
        else {
            throw new InaccesibleException("Ya tiene un hijo izquierdo.");
        }
        return newnode;
    }

    public BTNode<E> addRoot(E elemento) {
        BTNode<E> newnode = this.crearNodo(elemento, null, null, null);
        if (this.root == null) {
            this.root = newnode;
            this.size ++;
        }
        else {
            throw new BadPosition("El árbol ya contiene una raíz.");
        }
        return newnode;
    }

    public E remove(Position<E> p) {
        BTNode<E> node = checkPosition(p);
        BTNode<E> nleft = node.getLeft();
        BTNode<E> nright = node.getRight();
        E element = node.getElemento();
        if ((nleft != null) && (nright != null)) {
            throw new BadPosition("No se pueden borrar nodos con dos hijos");
        }
        else {
            BTNode<E> hijo;
            // Solo hijo derecho.
            if (nright != null) {
                hijo = nright;
            }
            // Solo hijo izqierdo.
            if (nleft != null) {
                hijo = nright;
            }
            else {
                hijo = null;
            }
            // Si el nodo es raíz.
            if (node.equals(root)) {
                if (hijo == null) {
                    root = null;
                    size = 0;
                }
                else {
                    hijo.setParent(null);
                    root = hijo;
                }
            }
            // Si el nodo no es raíz.
            else {
                BTNode<E> grandpa = node.getParent();
                if (node.equals(grandpa.getLeft())) {
                    grandpa.setLeft(hijo);
                }
                else {
                    if (node.equals(grandpa.getRight())) {
                        grandpa.setRight(hijo);
                    }
                }
                if (hijo != null) {
                    hijo.setParent(grandpa);
                }
            } // Fin de si no es un nodo raíz.
            this.size --;
        }
        return element;
    }

    // Métodos auxiliares.
    protected BTNode<E> checkPosition(Position<E> p) {
        if ((p == null) || !(p instanceof BTNode)) throw new BadPosition("Posición no válida.");
        BTNode<E> n = (BTNode<E>) p;
        return n;
    }

    protected BTNode<E> crearNodo(E elemento, BTNode<E> r, BTNode<E> l, BTNode<E> p) {
        return new BTNode<E>(elemento, r, l, p);
    }

    protected void preOrden(Position<E> p, List<Position<E>> lista) {
        lista.add(p);
        if (hasLeft(p)) {
            preOrden(left(p), lista);
        }
        if (hasRight(p)) {
            preOrden(right(p), lista);
        }
    }
}
