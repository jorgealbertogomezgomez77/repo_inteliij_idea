package TreeStructure.LinkedTree;

import Exceptions.BadPosition;
import Exceptions.InaccesibleException;
import TreeStructure.Tree.Position;
import TreeStructure.Tree.Tree;
import Exceptions.EmptyTreeException;
import javafx.geometry.Pos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedTree<E> implements Tree<E> {
    private TreeNode<E> root;
    private int size;

    public LinkedTree() {
        root = null;
        size = 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (this.size == 0) {
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
    public Position<E> root() throws EmptyTreeException {
        if (root == null) {
            throw new EmptyTreeException("The tree is empty.");
        }
        else {
            return (Position<E>) this.root;
        }
    }

    @Override
    public Position<E> parent(Position<E> p) throws InaccesibleException{
        TreeNode<E> nodo = cPosition(p);
        TreeNode<E> padre = nodo.getPadre();
        if (padre == null) throw new InaccesibleException("Don't have parent");
            return (Position<E>) padre;
    }

    @Override
    public Iterable children(Position<E> p) {
        return null;
    }

    @Override
    public boolean isLeaf(Position<E> p) {
        TreeNode<E> nodo = cPosition(p);
        boolean resultado = false;
        List<TreeNode<E>> hijos = nodo.getHijos();
        if ((hijos == null) || (hijos.isEmpty())) {
            resultado = true;
        }
        else {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean isInternal(Position<E> p) {
        boolean resultado = false;
        if (isLeaf(p)) {
            return false;
        }
        else {
            resultado =true;
        }
        return resultado;
    }

    @Override
    public boolean isRoot(Position<E> p) {
        TreeNode<E> nodo = cPosition(p);
        return (nodo == this.root);
    }

    @Override
    public E replace(Position<E> p, E elemento) {
        TreeNode<E> nodo = cPosition(p);
        E aux = nodo.elemento();
        nodo.setElemento(elemento);
        return aux;
    }

    public Position<E> add(Position<E> padre, E elemento) {
        TreeNode<E> nodopadre = cPosition(padre);
        TreeNode<E> newnode = crearNodo(nodopadre, elemento, new ArrayList<TreeNode<E>>());
        List<TreeNode<E>> children = nodopadre.getHijos();
        children.add(newnode);
        this.size ++;
        return (Position<E>) newnode;
    }

    public Position<E> addRoot(E elemento) {
        TreeNode<E> newnode = crearNodo(null, elemento, new ArrayList<TreeNode<E>>());
        this.root = newnode;
        this.size ++;
        return (Position<E>) newnode;
    }

    public Position<E> remove(Position<E> p) {
        TreeNode<E> nodo = cPosition(p);
        TreeNode<E> padre = nodo.getPadre();
        List<TreeNode<E>> children = padre.getHijos();
        children.remove(nodo);
        List<Position<E>> list = new ArrayList<Position<E>>();
        this.preOrden(p, list);
        size = size - list.size();
        return (Position<E>) nodo;
    }

    /* Castea un Position a TreeNode si es posible*/
    protected TreeNode<E> cPosition(Position<E> p) throws BadPosition {
        if ((p == null) || !(p instanceof TreeNode))
            throw new BadPosition("Invalid position");
        TreeNode<E> n = (TreeNode<E>) p;
        return n;
    }

    protected TreeNode<E> crearNodo(TreeNode<E> padre, E elemento, List<TreeNode<E>> hijos) {
        TreeNode<E> newnode = new TreeNode<>(padre,elemento, hijos);
        return newnode;
    }

    public void preOrden(Position<E> p, List<Position<E>> list) {
        list.add(p);
        TreeNode<E> nodo = cPosition(p);
        if (!this.isLeaf(p)) {
            for (Position<E> h: nodo.getHijos()) {
                preOrden(h, list);
            }
        }
    }
}
