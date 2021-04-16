package material.tree.binarytree;

import java.util.ArrayList;
import java.util.Iterator;

import material.tree.*;
import material.tree.iterator.BFSIteratorFactory;
import material.tree.iterator.TreeIteratorFactory;

/**
 * *
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 * @param <E> The type of the elements in the tree
 * @see BinaryTree
 */
public class ArrayBinaryTree<E> implements BinaryTree<E> {

    private class BTPos<T> implements Position<T> {

        private T element;
        private int index;
        private ArrayBinaryTree<T> myTree;

        public BTPos(ArrayBinaryTree<T> myTree, T element, int index) {
            this.myTree = myTree;
            this.element = element;
            this.index = index;
        }

        @Override
        public T getElement() {

            return this.element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public ArrayBinaryTree<T> getMyTree() {
            return myTree;
        }

        public void setMyTree(ArrayBinaryTree<T> myTree) {
            this.myTree = myTree;
        }
    }

    /*private class ArrayBinaryTreeIterator<T> implements Iterator<Position<T>> {

        @Override
        public boolean hasNext() {

            throw new UnsupportedOperationException("Not yet implemented!!");
        }

        @Override
        public Position<T> next() {

            throw new UnsupportedOperationException("Not yet implemented!!");
        }
    }*/ //Usamos las fabricas de iteradores mejor.

    private BTPos<E>[] tree;
    private int size;
    private TreeIteratorFactory<E> iteratorFactory;

    /**
     * Constructor of the class.
     */
    public ArrayBinaryTree(int capacity) {
        this.size = 0;
        this.tree = (BTPos<E>[]) new BTPos[capacity];
        this.iteratorFactory = new BFSIteratorFactory<>();
    }

    @Override
    public int size() {

        return this.size;
    }

    @Override
    public boolean isEmpty() {

        return this.size == 0;
    }

    @Override
    public boolean isInternal(Position<E> p) throws IllegalStateException {
        checkPosition(p);
        return (hasLeft(p) || hasRight(p));
    }

    @Override
    public boolean isLeaf(Position<E> p) throws IllegalStateException {
        return !isInternal(p);
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalStateException {
        checkPosition(p);
        return (root() == p);
    }

    @Override
    public boolean hasLeft(Position<E> p) throws IllegalStateException {
        BTPos<E> pos = checkPosition(p);
        Boolean sol = false;

        if(  pos.getIndex() *2 < tree.length ){
            sol = tree[pos.getIndex()*2] != null;
        }
        //return (tree[pos.getIndex()*2] != null);//EL arbol está en anchura por lo que los hijos izquierdos tendrán un indice de justo el doble
        return sol;

    }

    @Override
    public boolean hasRight(Position<E> p) throws IllegalStateException {
        BTPos<E> pos = checkPosition(p);
        Boolean sol = false;
        if(  pos.getIndex() *2 +1 < tree.length ) {
            sol = tree[(pos.getIndex()*2 )+1 ] != null;
        }

        return sol;
    }

    @Override
    public Position<E> root() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("The tree is empty");
        } else {
            return tree[1];
        }
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalStateException, IndexOutOfBoundsException {

        BTPos<E> pos = checkPosition(p);
        if (hasLeft(pos)){
            return tree[pos.index * 2];
        }
        throw new IllegalStateException("No tiene hijo izquierdo");


    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalStateException, IndexOutOfBoundsException {
        BTPos<E> pos = checkPosition(p);
        if (hasRight(pos)){
            return tree[pos.index * 2 +1];
        }
        throw new IllegalStateException("No tiene hijo derecho");
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalStateException, IndexOutOfBoundsException {
        BTPos<E> pos = checkPosition(p);
        if(!isRoot(pos)){

            if(pos.index % 2 == 0){ //hijo izquierdo
                return tree[pos.index / 2];
            }
            else if (pos.index % 2 == 1){ //hijo derecho
                return tree[(pos.index -1) / 2];
            }

        }
        throw new IllegalStateException("El nodo introducido es la raiz, no tiene padre");

    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalStateException {
        ArrayList<Position<E>> childrenList = new  ArrayList<>();
        BTPos<E> pos = checkPosition(p);
        if(!isLeaf(pos)){
            if(hasLeft(pos)){
                childrenList.add(left(pos));
            }
            if(hasRight(pos)){
                childrenList.add(right(pos));
            }
        }
        return childrenList;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return this.iteratorFactory.createIterator(this);
    }

    @Override
    public E replace(Position<E> p, E e) throws IllegalStateException {
        BTPos<E> pos = checkPosition(p);
        E previousElement = pos.getElement();
        pos.setElement(e);
        return previousElement; //se devuelve el elemento que habia antes


    }

    // Additional Methods
    @Override
    public Position<E> sibling(Position<E> v) throws IllegalStateException,
            IndexOutOfBoundsException {
        BTPos<E> pos = checkPosition(v);
        BTPos<E> parent = (BTPos<E>) parent(pos);
        if(left(parent) == pos){ //es el hijo izquierdo, su hermano será el derecho
            return right(parent);
        }
        else if(right(parent) == pos){
            return left(parent);
        }
        else {
            throw new IllegalStateException("El nodo no tiene hermanos");
        }

    }

    /*@Override
    public Position<E> addRoot(E e) throws IllegalStateException {
        if(isEmpty()){

            this.size = 1;  //Establezco el tamaño a 1
            tree[1] = new BTPos<>(this, e, 1);  //Creo el nuevo nodo
            return tree[1];
        }
        else{
            throw new IllegalStateException("Ya hay una raiz, no s epuede añadir otra");
        }
    }*/
    @Override
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree already has a root");
        }
        BTPos<E> node = new BTPos<E>(this, e, 1);
        this.tree[1] = node;
        size++;
        return node;
    }


    @Override
    public Position<E> insertLeft(Position<E> p, E e) throws IllegalStateException {
        BTPos<E> pos = checkPosition(p);
        int indexParent = pos.getIndex();
        int indexLeftChild = indexParent * 2;

        if (!hasLeft(pos)){
            if(tree.length < (indexLeftChild*2)+1){//Si no caben en el array los hijos del nuevo nodo aumentamos el tamaño
                BTPos<E>[] newTree =  new BTPos[tree.length*2];
                newTree = this.tree; //metemos los datos del arbol en el nuevo arbol más grande
                this.tree = new BTPos[indexLeftChild*2]; //Aumentams el tamaño del arbol original
                int cont = 0;

                for(BTPos<E> newNode : newTree){//Metemos los datos de la copia en el tree original
                    tree[cont] = newNode;
                    cont++;
                }
            }
            BTPos<E> newLeftChild = new BTPos<>(this, e, indexLeftChild);
            tree[indexLeftChild] = newLeftChild;
            /*tree[ indexLeftChild * 2]= null;
            tree[ indexLeftChild * 2 +1]= null;*/
            size++;
            return newLeftChild;
        }
        throw new IllegalStateException("Ya hay un hijo izquierdo");
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e) throws IllegalStateException {
        BTPos<E> pos = checkPosition(p);
        int indexParent = pos.getIndex();
        int indexRightChild = indexParent * 2 +1;

        if (!hasRight(pos)){
            if(tree.length < (indexRightChild*2)+1){//Si no caben en el array los hijos del nuevo nodo aumentamos el tamaño
                BTPos<E>[] newTree =  new BTPos[tree.length*2];
                newTree = this.tree; //metemos los datos del arbol en el nuevo arbol más grande
                this.tree = new BTPos[indexRightChild*2]; //Aumentams el tamaño del arbol original
                int cont = 0;

                for(BTPos<E> newNode : newTree){//Metemos los datos de la copia en el tree original
                    tree[cont] = newNode;
                    cont++;
                }
            }
            BTPos<E> newRightChild = new BTPos<>(this, e, indexRightChild);
            tree[indexRightChild] = newRightChild;
            /*tree[ indexRightChild * 2]= null;
            tree[ indexRightChild * 2 +1]= null;*/
            size++;
            return newRightChild;
        }
        throw new IllegalStateException("Ya hay un hijo izquierdo");
    }

    @Override
    public E remove(Position<E> p) throws IllegalStateException {
        BTPos<E> pos = checkPosition(p);
        BTPos<E> leftPos = tree[pos.index *2];
        BTPos<E> rightPos = tree[pos.index *2 +1];

        if ((rightPos != null) && (leftPos != null)) {
            throw new IllegalStateException("Can't remove a node with two children");
        }

        if ( parent(pos) == null) {  //Si es raiz
            pos.setElement(null);
            pos.setMyTree(null);

        } else {  //node no es raiz
            if ((leftPos != null) && (rightPos != null)) { //Y tiene hijo derecho e izquierdo
                Iterator<Position<E>> it = this.iteratorFactory.createIterator(this, pos);
                while (it.hasNext()) {
                    BTPos<E> aux = (BTPos<E>) it.next();
                    aux.setMyTree(null);
                    it.next();
                }
            } else if ((rightPos != null) && (leftPos == null)) { //Y tiene hijo derecho pero no izquierdo
                Iterator<Position<E>> it = this.iteratorFactory.createIterator(this, pos);
                while (it.hasNext()) {
                    BTPos<E> aux = (BTPos<E>) it.next();
                    aux.setMyTree(null);
                    it.next();
                }
            } else if ((rightPos == null) && (leftPos != null)) { //Y tiene hijo izquierdo pero no derecho
                Iterator<Position<E>> it = this.iteratorFactory.createIterator(this, pos);
                while (it.hasNext()) {
                    BTPos<E> aux = (BTPos<E>) it.next();
                    aux.setMyTree(null);
                    it.next();
                }
            } //Si no tiene hijos, se elimina sin más
            pos.setMyTree(null);  //Se hace fuera porque se elimina despues del caso que sea
            tree[pos.getIndex()] = null;
        }
        size--;
        return pos.getElement();

    }

    @Override
    public void swapElements(Position<E> p1, Position<E> p2) throws IllegalStateException {
        BTPos<E> pos1 = checkPosition(p1);
        BTPos<E> pos2 = checkPosition(p2);

        int indexP1 = pos1.getIndex();
        int indexP2 = pos2.getIndex();

        E element1 = pos1.getElement();
        E element2 = pos2.getElement();
        tree[indexP1].setElement(element2);
        tree[indexP2].setElement(element1);
    }

    /**
     * Determines whether the given position is a valid node.
     *
     * @param v the position to be checked
     * @return the position casted to BTPos
     */
    private BTPos<E> checkPosition(Position<E> v) throws IllegalStateException {
        BTPos<E> pos = (BTPos<E>) v;

        if (pos.getMyTree() != this){
            throw new IllegalStateException("El position no pertenece a mismo arbol");

        }
        if(pos == null || !(v instanceof BTPos)){
            throw new IllegalStateException("En position no es valido");
        }
        return pos;
    }

    //@Override
    public String toString() {
        //toString Que?? no viene en el LinkedBinary, convierte en String el arbol?
        return "";
        //throw new UnsupportedOperationException("Not yet implemented!!");
    }

}
