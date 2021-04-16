package material.tree.binarysearchtree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import material.tree.Position;
import material.tree.binarytree.LinkedBinaryTree;
import material.tree.iterator.InorderIterator;

/**
 * Realization of a dictionary by means of a binary search tree.
 *
 * @author R. Cabido, A. Duarte, J. Vélez and J. Sánchez-Oro
 * @param <E> the type of the elements stored in the tree
 */
public class LinkedBinarySearchTree<E> implements BinarySearchTree<E> {

    protected LinkedBinaryTree<E> binTree;
    protected Comparator<E> comparator;

    /**
     * Creates a BinarySearchTree with the default comparator.
     */
    public LinkedBinarySearchTree() {
        this(null);
    }

    /**
     * Creates a BinarySearchTree with the given comparator.
     *
     * @param c the comparator used to sort the nodes in the tree
     */
    public LinkedBinarySearchTree(Comparator<E> c) {
        if (c == null) {
            this.comparator = new DefaultComparator<>();
        } else {
            this.comparator = c;
        }
        this.binTree = new LinkedBinaryTree<>();
    }

    /**
     * Auxiliary method used by find, insert, and remove.
     *
     * @param value the value searched
     * @param pos the position to start the search
     * @return the position where value is stored
     */
    protected Position<E> treeSearch(E value, Position<E> pos) throws IllegalStateException, IndexOutOfBoundsException {
        if (this.binTree.isLeaf(pos)) {
            return pos; // key not found; return external node
        } else {
            E curValue = pos.getElement();
            int comp = comparator.compare(value, curValue);
            if ((comp < 0) && this.binTree.hasLeft(pos)) {
                return treeSearch(value, this.binTree.left(pos)); // search left
            } else if ((comp > 0) && this.binTree.hasRight(pos)) {
                return treeSearch(value, this.binTree.right(pos)); // search right
            }
            return pos; // return internal node where key is found
        }
    }

    /**
     * Adds to L all entries in the subtree rooted at pos having keys equal to
     * k.
     *
     * @param l the position to add all new entries
     * @param pos the starting position to scan entries
     * @param value the value of the nodes to be added to l
     */
    protected void addAll(List<Position<E>> l, Position<E> pos, E value) {
        Position<E> p = treeSearch(value, pos);
        if (p.getElement().equals(value)) {
            l.add(p);
            if (this.binTree.hasLeft(p)) {
                addAll(l, this.binTree.left(p), value);
            }
            if (this.binTree.hasRight(p)) {
                addAll(l, this.binTree.right(p), value);
            }
        }
    }

    @Override
    public int size() {
        return this.binTree.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Position<E> find(E value) {
        Position<E> curPos = treeSearch(value, this.binTree.root());
        return (curPos.getElement().equals(value)) ? curPos : null;
    }

    @Override
    public Iterable<Position<E>> findAll(E value) {
        List<Position<E>> l = new ArrayList<>();
        addAll(l, this.binTree.root(), value);
        return l;
    }

    @Override
    public Position<E> insert(E value) {
        if (this.binTree.isEmpty()) {
            return this.binTree.addRoot(value);
        }
        Position<E> insPos = treeSearch(value, this.binTree.root());
        if (insPos.getElement().equals(value)) {
            // To consider nodes already in the tree with the same key
            while (!this.binTree.isLeaf(insPos) && this.binTree.hasRight(insPos)) {
                insPos = treeSearch(value, this.binTree.right(insPos)); // iterative search for insertion position
            }
        }
        Position<E> retPos = null;
        if (this.comparator.compare(value, insPos.getElement()) < 0) {
            retPos = this.binTree.insertLeft(insPos, value);
        } else {
            retPos = this.binTree.insertRight(insPos, value);
        }
        return retPos;
    }

    @Override
    public E remove(Position<E> pos) throws IllegalStateException {
        E elemRemoved = pos.getElement();
        if (this.binTree.isLeaf(pos) || !this.binTree.hasLeft(pos) || !this.binTree.hasRight(pos)) {
            this.binTree.remove(pos);
        } else { // entry is at a node with internal children
            Position<E> remPos = this.binTree.right(pos);
            while (this.binTree.isInternal(remPos)) {
                remPos = this.binTree.left(remPos);
            }
            this.binTree.replace(pos, remPos.getElement());
            this.binTree.remove(remPos);
        }
        return elemRemoved;
    }

    @Override
    public Iterator<Position<E>> iterator() {

        return new InorderIterator<>(this.binTree);
    }

    //Implemenar FindRange
    public Iterable<Position<E>> findRange (E minValue, E maxValue){

        ArrayList<Position<E>> lista = new ArrayList<>();//aqui vamos a meter los position en el rango dado
        aux( minValue, maxValue, this.binTree.root(), lista);
        return lista;


    }

    public void aux(E minValue, E maxValue, Position<E> actual, ArrayList<Position<E>> lista){
        int compd = this.comparator.compare(actual.getElement(), maxValue); //Comparas el position del elemento actual por el que vas recorriendo coo el valor maximo
        int compi = this.comparator.compare(minValue, actual.getElement());
        if((compd<1 && compi<1)||(compd == 0)){ //si el valor esta en eso rango lo añado a la lista
            lista.add(actual);
        }
        if(this.binTree.hasLeft(actual)){
            aux(minValue,maxValue, this.binTree.left(actual), lista); //si tiene nodo izdo haces la llamada recursiva por la izda
        }
        if(this.binTree.hasRight(actual)){
            aux(minValue,maxValue, this.binTree.right(actual), lista);//igual por la derecha
        }

    }

    public Position<E> first (){
        Position<E> p = this.binTree.root();
        while(this.binTree.hasLeft(p)){
            p=this.binTree.left(p);
        }
        return p;
    }

    public Position<E> last(){
        Position<E> p = this.binTree.root();
        while(this.binTree.hasRight(p)){
            p=this.binTree.right(p);

        }
        return p;
    }

    public Iterable<Position<E>> successors(Position<E> pos){
        ArrayList<Position<E>> elementos =new ArrayList<>();
        if (this.binTree.hasRight(pos)){
            recorrido(elementos, this.binTree.right(pos));
        }
        while(!this.binTree.isRoot(pos)){
            if(this.binTree.left(this.binTree.parent(pos))==pos){
                elementos.add(this.binTree.parent(pos));
                recorrido(elementos, this.binTree.right(this.binTree.parent(pos)));
            }
            pos = this.binTree.parent(pos);
        }
        return elementos;

    }

    public void recorrido(ArrayList<Position<E>> elementos , Position<E> p){
        elementos.add(p);
        if(this.binTree.hasLeft(p)){
            recorrido(elementos, this.binTree.left(p));
        }
        if(this.binTree.hasRight(p)){
            recorrido(elementos, this.binTree.right(p));
        }
    }

    public Iterable<Position<E>> predecessors (Position<E> pos){
        ArrayList<Position<E>> elementos =new ArrayList<>();
        if (this.binTree.hasLeft(pos)){
            recorrido(elementos, this.binTree.left(pos));
        }
        while(!this.binTree.isRoot(pos)){
            if(this.binTree.right(this.binTree.parent(pos))==pos){
                elementos.add(this.binTree.parent(pos));
                recorrido(elementos, this.binTree.left(this.binTree.parent(pos)));
            }
            pos = this.binTree.parent(pos);
        }
        return elementos;

    }


}

class ReestructurableBinaryTree<T> extends LinkedBinaryTree<T> {

    public ReestructurableBinaryTree() {
//        this.addRoot(null);
    }

    /**
     * Performs a tri-node restructuring. Assumes the nodes are in one of
     * following configurations:
     *
     * <pre>
     *          z=c       z=c        z=a         z=a
     *         /  \      /  \       /  \        /  \
     *       y=b  t4   y=a  t4    t1  y=c     t1  y=b
     *      /  \      /  \           /  \         /  \
     *    x=a  t3    t1 x=b        x=b  t4       t2 x=c
     *   /  \          /  \       /  \             /  \
     *  t1  t2        t2  t3     t2  t3           t3  t4
     * </pre>
     *
     * @return the new root of the restructured subtree
     */
    public Position<T> restructure(Position<T> posNode, LinkedBinarySearchTree<T> bst) {
        BTNode<T> lowKey, midKey, highKey, t1, t2, t3, t4;
        Position<T> posParent = bst.binTree.parent(posNode); // assumes x has a parent
        Position<T> posGrandParent = bst.binTree.parent(posParent); // assumes y has a parent
//        boolean nodeLeft = (posNode == bst.binTree.left(posParent));
        boolean nodeLeft = (bst.binTree.hasLeft(posParent) && (posNode == bst.binTree.left(posParent)));
//        boolean parentLeft = (posParent == bst.binTree.left(posGrandParent));
        boolean parentLeft = (bst.binTree.hasLeft(posGrandParent) && (posParent == bst.binTree.left(posGrandParent)));
        BTNode<T> node = (BTNode<T>) posNode, parent = (BTNode<T>) posParent, grandParent = (BTNode<T>) posGrandParent;
        if (nodeLeft && parentLeft) {// Desequilibrio izda-izda
            lowKey = node;
            midKey = parent;
            highKey = grandParent;
            t1 = lowKey.getLeft();
            t2 = lowKey.getRight();
            t3 = midKey.getRight();
            t4 = highKey.getRight();
        } else if (!nodeLeft && parentLeft) {// Desequilibrio izda-dcha
            lowKey = parent;
            midKey = node;
            highKey = grandParent;
            t1 = lowKey.getLeft();
            t2 = midKey.getLeft();
            t3 = midKey.getRight();
            t4 = highKey.getRight();
        } else if (nodeLeft && !parentLeft) {// Desequilibrio dcha-izda
            lowKey = grandParent;
            midKey = node;
            highKey = parent;
            t1 = lowKey.getLeft();
            t2 = midKey.getLeft();
            t3 = midKey.getRight();
            t4 = highKey.getRight();
        } else { // Desequilibrio dcha-dcha
            lowKey = grandParent;
            midKey = parent;
            highKey = node;
            t1 = lowKey.getLeft();
            t2 = midKey.getLeft();
            t3 = highKey.getLeft();
            t4 = highKey.getRight();
        }

        // put b at z's place
        if (bst.binTree.isRoot(posGrandParent)) {
            bst.binTree.subTree(midKey);
        } else {
            BTNode<T> zParent = (BTNode<T>) bst.binTree.parent(posGrandParent);
            if (posGrandParent == bst.binTree.left(zParent)) {
                midKey.setParent(zParent);
                zParent.setLeft(midKey);
            } else { // z was a right child
                midKey.setParent(zParent);
                zParent.setRight(midKey);
            }
        }
        // place the rest of the nodes and their children
        midKey.setLeft(lowKey);
        lowKey.setParent(midKey);
        midKey.setRight(highKey);
        highKey.setParent(midKey);
        lowKey.setLeft(t1);
        if (t1 != null) {
            t1.setParent(lowKey);
        }
        lowKey.setRight(t2);
        if (t2 != null) {
            t2.setParent(lowKey);
        }
        highKey.setLeft(t3);
        if (t3 != null) {
            t3.setParent(highKey);
        }
        highKey.setRight(t4);
        if (t4 != null) {
            t4.setParent(highKey);
        }
        bst.binTree.subTree(bst.binTree.root());
        return midKey; // the new root of this subtree
    }
}
