package material.tree.binarytree;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.Iterator;
import java.util.List;

import material.tree.Position;
import material.tree.iterator.TreeIteratorFactory;
import material.tree.iterator.BFSIteratorFactory;

/**
 *
 * Implementation of a binary tree using dynamic memory
 *
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 * @param <E> the type of the elements stored in the tree
 * @see BinaryTree
 */
public class LinkedBinaryTree<E> implements BinaryTree<E> {

    protected class BTNode<T> implements Position<T> {

        private T element;
        private BTNode<T> left, right, parent;
        private LinkedBinaryTree<T> myTree;

        /**
         * Main constructor
         *
         * @param tree the tree where the node belongs
         * @param element the element of the node
         * @param parent the parent of the node
         * @param left the left child
         * @param right the right child
         */
        public BTNode(LinkedBinaryTree<T> tree, T element, BTNode<T> parent, BTNode<T> left,
                BTNode<T> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.myTree = tree;
        }

        @Override
        public T getElement() {

            return element;
        }

        /**
         * Sets the element stored at this position
         *
         * @param o the element to store
         */
        public void setElement(T o) {
            element = o;
        }

        /**
         * Gets the left child of the node
         *
         * @return the left child
         */
        public BTNode<T> getLeft() {

            return left;
        }

        /**
         * Sets the left child of the node
         *
         * @param v the new left child
         */
        public void setLeft(BTNode<T> v) {

            left = v;
        }

        /**
         * Gets the right child of the node
         *
         * @return the right child
         */
        public BTNode<T> getRight() {

            return right;
        }

        /**
         * Sets the right child of the node
         *
         * @param v the right child
         */
        public void setRight(BTNode<T> v) {

            right = v;
        }

        /**
         * Gets the parent of the node
         *
         * @return the parent of the node
         */
        public BTNode<T> getParent() {

            return parent;
        }

        /**
         * Sets the parent of the node
         *
         * @param v the new parent of the node
         */
        public void setParent(BTNode<T> v) {

            parent = v;
        }

        /**
         * Gets the tree where the node belongs
         *
         * @return a pointer to the tree where the node belongs
         */
        public LinkedBinaryTree<T> getMyTree() {

            return myTree;
        }

        /**
         * Sets the tree where the node belongs
         *
         * @param myTree the tree where the node belongs
         */
        public void setMyTree(LinkedBinaryTree<T> myTree) {

            this.myTree = myTree;
        }
    }

    private BTNode<E> root;
    private int size;
    private TreeIteratorFactory<E> iteratorFactory;

    /**
     * Constructor of the class that creates an empty binary tree.
     */
    public LinkedBinaryTree() {
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
        checkPosition(v);
        return (hasLeft(v) || hasRight(v));
    }

    @Override
    public boolean isLeaf(Position<E> p) throws IllegalStateException {
        return !isInternal(p);
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalStateException {
        checkPosition(p);
        return (p == root());
    }

    @Override
    public boolean hasLeft(Position<E> p) throws IllegalStateException {
        BTNode<E> node = checkPosition(p);
        return (node.getLeft() != null);
    }

    @Override
    public boolean hasRight(Position<E> p) throws IllegalStateException {
        BTNode<E> node = checkPosition(p);
        return (node.getRight() != null);
    }

    @Override
    public Position<E> root() throws IllegalStateException {
        if (root == null) {
            throw new IllegalStateException("The tree is empty");
        }
        return root;
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalStateException,
            IndexOutOfBoundsException {
        BTNode<E> node = checkPosition(p);
        Position<E> leftPos = node.getLeft();
        if (leftPos == null) {
            throw new IndexOutOfBoundsException("No left child");
        }
        return leftPos;
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalStateException,
            IndexOutOfBoundsException {
        BTNode<E> node = checkPosition(p);
        Position<E> rightPos = node.getRight();
        if (rightPos == null) {
            throw new IndexOutOfBoundsException("No right child");
        }
        return rightPos;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalStateException,
            IndexOutOfBoundsException {
        BTNode<E> node = checkPosition(p);
        Position<E> parentPos = node.getParent();
        if (parentPos == null) {
            throw new IndexOutOfBoundsException("No parent");
        }
        return parentPos;
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> p)
            throws IllegalStateException {
        List<Position<E>> children = new ArrayList<Position<E>>();
        if (hasLeft(p)) {
            children.add(left(p));
        }
        if (hasRight(p)) {
            children.add(right(p));
        }
        return children;
    }

    public void setIterator(TreeIteratorFactory<E> iteratorFactory) {
        this.iteratorFactory = iteratorFactory;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return this.iteratorFactory.createIterator(this);
    }

    @Override
    public E replace(Position<E> p, E e) throws IllegalStateException {
        BTNode<E> node = checkPosition(p);
        E temp = p.getElement();
        node.setElement(e);
        return temp;
    }

    @Override
    public Position<E> sibling(Position<E> p) throws IllegalStateException,
            IndexOutOfBoundsException {
        BTNode<E> node = checkPosition(p);
        BTNode<E> parentPos = node.getParent();
        if (parentPos != null) {
            BTNode<E> sibPos;
            BTNode<E> leftPos = parentPos.getLeft();
            sibPos = (leftPos == node) ? parentPos.getRight() : parentPos.getLeft();
            if (sibPos != null) {
                return sibPos;
            }
        }
        throw new IndexOutOfBoundsException("No sibling");
    }

    @Override
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree already has a root");
        }
        size = 1;
        root = new BTNode<E>(this, e, null, null, null);
        return root;
    }

    @Override
    public Position<E> insertLeft(Position<E> p, E e)
            throws IllegalStateException {
        BTNode<E> node = checkPosition(p);
        Position<E> leftPos = node.getLeft();
        if (leftPos != null) {
            throw new IllegalStateException("Node already has a left child");
        }
        BTNode<E> newNode = new BTNode<E>(this, e, node, null, null);
        node.setLeft(newNode);
        size++;
        return newNode;
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e)
            throws IllegalStateException {
        BTNode<E> node = checkPosition(p);
        Position<E> rightPos = node.getRight();
        if (rightPos != null) {
            throw new IllegalStateException("Node already has a right child");
        }
        BTNode<E> newNode = new BTNode<E>(this, e, node, null, null);
        node.setRight(newNode);
        size++;
        return newNode;
    }

    @Override
    public E remove(Position<E> p) throws IllegalStateException {
        BTNode<E> node = checkPosition(p);
        BTNode<E> leftPos = node.getLeft();
        BTNode<E> rightPos = node.getRight();
        if (leftPos != null && rightPos != null) {
            throw new IllegalStateException(
                    "Cannot remove node with two children");
        }
        BTNode<E> child; // the only child of v, if any
        if (leftPos != null) {
            child = leftPos;
        } else if (rightPos != null) {
            child = rightPos;
        } else { // v is a leaf
            child = null;
        }
        if (node == root) { // v is the root
            if (child != null) {
                child.setParent(null);
            }
            root = child;
        } else { // v is not the root
            BTNode<E> parent = node.getParent();
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
            if (child != null) {
                child.setParent(parent);
            }
        }
        size--;
        return p.getElement();
    }

    /**
     * Clears the tree leaving it empty.
     */
    private void clear() {
        root = null;
        size = 0;
    }


    @Override
    public void swapElements(Position<E> p1, Position<E> p2)
            throws IllegalStateException {
        BTNode<E> node1 = checkPosition(p1);
        BTNode<E> node2 = checkPosition(p2);
        E temp = p2.getElement();
        node2.setElement(p1.getElement());
        node1.setElement(temp);
    }

    // Auxiliary methods
    /**
     * If v is a good binary tree node, cast to BTPosition, else throw exception
     *
     * @param p the position to be converted in BTPosition
     * @return the position converted
     * @throws IllegalStateException if the position is not valid
     */
    private BTNode<E> checkPosition(Position<E> p)
            throws IllegalStateException {
        if (p == null || !(p instanceof BTNode)) {
            throw new IllegalStateException("The position is invalid");
        }
        BTNode<E> btpos = (BTNode<E>) p;
        if (btpos.getMyTree() != this) {
            throw new IllegalStateException("The position does not belong to this tree");
        }
        return (BTNode<E>) p;
    }

    /**
     * Calculates the size of a partial subtree
     *
     * @param n the root of the subtree
     * @return the size of the subtree
     */
    private int calculateSize(BTNode<E> n) {
        if (n != null) {
            return 1 + calculateSize(n.getLeft()) + calculateSize(n.getRight());
        } else {
            return 0;
        }
    }

    /**
     * Converts the node passed by parameter in the new root.
     *
     * @param v new root node
     */
    public void subTree(Position<E> v) {
        root = checkPosition(v);
        root.parent = null;
        size = calculateSize(root);
    }
    public Position<E> removeSubtree(Position<E> p) throws IllegalFormatCodePointException{
        BTNode<E> node = checkPosition(p);
        Integer totalSize = size();
        Integer subTreeSize = calculateSize(node);

        if(node == root){
            clear();
        }
        else if (node.getParent().getRight() == node){//el nodo raiz del subarbol a borrar es el hijo derecho
            node.getParent().right = null;
            size = totalSize - subTreeSize;
        }
        else if (node.getParent().getLeft() == node){//el nodo raiz del subarbol a borrar es el hijo izdo
            node.getParent().left = null;
            size = totalSize - subTreeSize;
        }
        return node;
    }

}
