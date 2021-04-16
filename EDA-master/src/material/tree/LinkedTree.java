package material.tree;

import material.exceptionClasses.InvalidPositionException;
import material.tree.iterator.BFSIteratorFactory;
import java.util.*;
import material.tree.iterator.TreeIteratorFactory;

/**
 * A linked class for a tree where nodes have an arbitrary number of children.
 *
 * @author Raul Cabido, Abraham Duarte, Jose Velez, J. Sánchez-Oro
 * @param <E> the type of the elements in the tree
 */
public class LinkedTree<E> implements Tree<E> {

    /**
     * Inner class which represents a node of the tree
     *
     * @param <T> the type of the elements stored in a node
     */
    private class TreeNode<T> implements Position<T> {

        private T element; // The element stored in the position
        private TreeNode<T> parent; // The parent of the node
        private List<TreeNode<T>> children; // The children of the node
        private LinkedTree<T> myTree; // A reference to the tree where the node belongs

        /**
         * Constructor of the class
         * 
         * @param t the tree where the node is stored
         * @param e the element to store in the node
         * @param p the parent of the node
         * @param c the list of children of the node
         */
        public TreeNode(LinkedTree<T> t, T e, TreeNode<T> p, List<TreeNode<T>> c) {
            this.element = e;
            this.parent = p;
            this.children = c;
            this.myTree = t;
        }

        @Override
        public T getElement() {

            return element;
        }

        /**
         * Sets the element stored at this position
         * 
         * @param o the element to store in the node
         */
        public final void setElement(T o) {

            element = o;
        }

        /**
         * Accesses to the list of children of this node
         * 
         * @return the list of children
         */
        public List<TreeNode<T>> getChildren() {

            return children;
        }

        /**
         * Sets the children of this node
         * 
         * @param c the list of nodes to be used as children of this position
         */
        public final void setChildren(List<TreeNode<T>> c) {

            children = c;
        }

        /**
         * Accesses to the parent of this node
         * 
         * @return the parent of this node
         */
        public TreeNode<T> getParent() {

            return parent;
        }

        /**
         * Sets the parent of this node
         * 
         * @param v the node to be used as parent
         */
        public final void setParent(TreeNode<T> v) {

            parent = v;
        }

        /**
         * Consults the tree in which this node is stored
         * 
         * @return a reference to the tree where the node belongs
         */
        public LinkedTree<T> getMyTree() {

            return myTree;
        }

        /**
         * Sets the tree where this node belongs
         * 
         * @param myTree the tree where this node belongs
         */
        public void setMyTree(LinkedTree<T> myTree) {

            this.myTree = myTree;
        }
    }

    private TreeNode<E> root; // The root of the tree
    private int size; // The number of nodes in the tree
    private TreeIteratorFactory<E> iteratorFactory; // The factory of iterators

    /**
     * Creates an empty tree.
     */
    public LinkedTree() {
        root = null;
        size = 0;
        this.iteratorFactory = new BFSIteratorFactory<>();
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {

        return (size == 0);
    }

    @Override
    public boolean isInternal(Position<E> v) throws IllegalStateException {
        return !isLeaf(v);
    }

    @Override
    public boolean isLeaf(Position<E> p) throws IllegalStateException {
        TreeNode<E> node = checkPosition(p);
        return (node.getChildren() == null) || (node.getChildren().isEmpty());
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalStateException {
        TreeNode<E> node = checkPosition(p);
        return (node == this.root());
    }

    @Override
    public Position<E> root() throws IllegalStateException {
        if (root == null) {
            throw new IllegalStateException("The tree is empty");
        }
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalStateException,
            IndexOutOfBoundsException {
        TreeNode<E> node = checkPosition(p);
        Position<E> parentPos = (Position<E>) node.getParent();
        if (parentPos == null) {
            throw new IndexOutOfBoundsException("The node has not parent");
        }
        return parentPos;
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> p) {
        TreeNode<E> node = checkPosition(p);
        return node.getChildren();
    }

    /**
     * Modifies the element stored in a given position
     * @param p the position to be modified
     * @param e the new element to be stored
     * @return the previous element stored in the position
     * @throws IllegalStateException if the position is not valid 
     */
    public E replace(Position<E> p, E e) throws IllegalStateException {
        TreeNode<E> node = checkPosition(p);
        E temp = p.getElement();
        node.setElement(e);
        return temp;
    }
    
    @Override
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree already has a root");
        }
        size = 1;
        root = new TreeNode<>(this, e, null, new ArrayList<TreeNode<E>>());
        return root;
    }

    /**
     * Swap the elements stored in two given positions
     * @param p1 the first node to swap
     * @param p2 the second node to swap
     * @throws IllegalStateException if the position of any node is not valid
     */
    public void swapElements(Position<E> p1, Position<E> p2)
            throws IllegalStateException {
        TreeNode<E> node1 = checkPosition(p1);
        TreeNode<E> node2 = checkPosition(p2);
        E temp = p2.getElement();
        node2.setElement(p1.getElement());
        node1.setElement(temp);
    }

    /**
     * Validates the given position, casting it to TreeNode if valid
     * @param p the position to be converted
     * @return the position casted to TreeNode
     * @throws IllegalStateException if the position is not valid
     */
    private TreeNode<E> checkPosition(Position<E> p)
            throws IllegalStateException {
        if (p == null || !(p instanceof TreeNode)) {
            throw new IllegalStateException("The position is invalid");
        }
        TreeNode<E> aux = (TreeNode<E>) p;

        if (aux.getMyTree() != this) {
            throw new IllegalStateException("The node is not from this tree");
        }
        return aux;
    }

    /**
     * Adds a new node whose parent is pointed by a given position.
     *
     * @param element the element to be added
     * @param p the position of the parent
     * @return the position of the new node created
     * @throws IllegalStateException if the position is not valid
     */
    public Position<E> add(E element, Position<E> p) throws IllegalStateException {
        TreeNode<E> parent = checkPosition(p);
        TreeNode<E> newNode = new TreeNode<>(this, element, parent, new ArrayList<TreeNode<E>>());
        List<TreeNode<E>> l = parent.getChildren();
        l.add(newNode);
        size++;
        return newNode;
    }

    /**
     * Removes a node and its corresponding subtree rooted at node.
     *
     * @param p the position of the node to be removed.
     * @throws IllegalStateException if the position is not valid
     */
    public void remove(Position<E> p) throws IllegalStateException {
        TreeNode<E> node = checkPosition(p);
        if (node.getParent() != null) {
            Iterator<Position<E>> it = this.iteratorFactory.createIterator(this, p);
            int cont = 0;
            while (it.hasNext()) {
                it.next();
                cont++;
            }
            size = size - cont;
            TreeNode<E> parent = node.getParent();
            parent.getChildren().remove(node);
        } else {
            this.root = null;
            this.size = 0;
        }
        node.setMyTree(null);
    }
    
    public void setIterator(TreeIteratorFactory<E> iteratorFactory) {
        this.iteratorFactory = iteratorFactory;
    }
    
    @Override
    public Iterator<Position<E>> iterator() {

        return this.iteratorFactory.createIterator(this);
    }

    //Metodo moveSubtree- V-1.0 (con checkPosition)
    /*public Position<E> moveSubtree(Position<E> pOrig, Position<E> pDest)
            throws InvalidPositionException {
        TreeNode<E> origen = checkPosition(pOrig);
        TreeNode<E> destino = checkPosition(pDest);

        TreeNode<E> origen = (TreeNode<E>) pOrig;
        TreeNode<E> destino = (TreeNode<E>) pDest;

        //TreeNode<E> parent = origen.parent;
        TreeNode<E> parent = origen.getParent();

        Iterator<Position<E>> it = this.iteratorFactory.createIterator(this, origen);//Si el destino es interno al origen
        while(it.hasNext()){
            if(destino == it.next()){
                throw new InvalidPositionException("Invalid position");
            }
        }

        origen.setParent(destino);	//Establezco a destino como padre del nodo origen.
        List<LinkedTree<E>.TreeNode<E>> hijosDestino = destino.getChildren();
        hijosDestino.add(origen);//añadimos el nodo origen a la lista de hijos del nodo destino

        List<LinkedTree<E>.TreeNode<E>> hijosOrigen = parent.getChildren();
        hijosOrigen.remove(origen);

        return origen ;
    }*/

    public Position<E> moveSubtree(Position<E> pOrig, Position<E> pDest) throws IllegalStateException {
        TreeNode<E> origen = (TreeNode<E>) pOrig;
        TreeNode<E> destino = (TreeNode<E>) pDest;
        TreeNode<E> parentOrigen = origen.getParent();

        if (origen == this.root) {
            throw new IllegalStateException("el origen no puede ser la raiz");
        } else {
            moveSubtreeAux(origen, destino);

            origen.setParent(destino); //Establezco a destino como padre del nodo origen.

            List<LinkedTree<E>.TreeNode<E>> hijosDestino = destino.getChildren();
            hijosDestino.add(origen);//añadimos el nodo origen a la lista de hijos del nodo destino
            List<LinkedTree<E>.TreeNode<E>> hijosOrigen = parentOrigen.getChildren();
            hijosOrigen.remove(origen);
            //Eliminamos a origen de la lista de hijos de su padre y le añadimos como hijo de destino
            //parentOrigen.getChildren().remove(origen);
        }
        return pDest;
    }

    private void moveSubtreeAux(TreeNode<E> orig, TreeNode<E> dest){
        //cambiamos los mytree para que sean iguales al los del destino, para el metodo changeFamily()
        orig.setMyTree(dest.getMyTree());
        for(TreeNode<E> hijo : orig.children ){
            if((orig == dest)|| (hijo == dest)){
                throw new IllegalStateException("destino no puede ser hijo de origen");
            }
            moveSubtreeAux(hijo,dest);  //recursivamente vamos cambiando el mytree de cada hijo
        }
    }


    public void moveSubtree2 (TreeNode<E> orig, TreeNode<E> dest){

        orig.setMyTree(dest.getMyTree());

        for(TreeNode<E> child : orig.children){
            if((orig == dest)|| (child == dest)) {
                throw new IllegalStateException("el nodo destino es hijo del nodo origen");
            }

        }

    }














}

