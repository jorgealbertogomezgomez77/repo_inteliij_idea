package material.tree.binarytree;


import material.tree.*;

/**
 * An interface for a binary tree, where each node can have zero, one, or two
 * children.
 *
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 * @param <E> the type of the elements stored in the tree
 */
public interface BinaryTree<E> extends Tree<E>, Iterable<Position<E>> {

    /**
     * Accesses to the left child of a node.
     * 
     * @param v the position to check the left child
     * @return the left child of v
     * @throws IllegalStateException if the position is not valid
     * @throws IndexOutOfBoundsException if the node has not left child
     */
    public Position<E> left(Position<E> v)
            throws IllegalStateException, IndexOutOfBoundsException;

    /**
     * Accesses to the right child of a node.
     * 
     * @param v the position to check the right child
     * @return the right child of v
     * @throws IllegalStateException if the position is not valid
     * @throws IndexOutOfBoundsException if the node has not right child
     */
    public Position<E> right(Position<E> v)
            throws IllegalStateException, IndexOutOfBoundsException;

    /**
     * Checks if a position has a left child
     * @param v the position to check
     * @return TRUE if v has a left child, FALSE otherwise
     * @throws IllegalStateException if the position is not valid
     */
    public boolean hasLeft(Position<E> v) throws IllegalStateException;

    /**
     * Checks if a position has a right child
     * @param v the position to check
     * @return TRUE if v has a right child, FALSE otherwise
     * @throws IllegalStateException if the position is not valid
     */
    public boolean hasRight(Position<E> v) throws IllegalStateException;

    @Override
    public boolean isInternal(Position<E> v) throws IllegalStateException;


    @Override
    public boolean isLeaf(Position<E> p) throws IllegalStateException;


    @Override
    public boolean isRoot(Position<E> p) throws IllegalStateException;


    @Override
    public Position<E> root() throws IllegalStateException;

    /**
     * Replace the element in a given node
     * @param p the node to modify
     * @param e the new element
     * @return the previously stored element
     * @throws IllegalStateException if the position is not valid
     */
    public E replace(Position<E> p, E e) throws IllegalStateException;

    /**
     * Accesses to the sibling of the node.
     * @param p the node to search sibling
     * @return the sibling of the node
     * @throws IllegalStateException if the position is not valid
     * @throws IndexOutOfBoundsException if the node has not sibling
     */
    public Position<E> sibling(Position<E> p) throws IllegalStateException,
            IndexOutOfBoundsException;

    @Override
    public Position<E> addRoot(E e) throws IllegalStateException;

    /**
     * Inserts a left child at a given node.
     * @param p the node to insert the left child
     * @param e the element to be used as left child
     * @return the left child created
     * @throws IllegalStateException if the node already has a left child
     */
    public Position<E> insertLeft(Position<E> p, E e)
            throws IllegalStateException;

    /**
     * Inserts a right child at a given node.
     * @param p the node to insert the right child
     * @param e the element to be used as right child
     * @return the right child created
     * @throws IllegalStateException if the node already has a right child
     */
    public Position<E> insertRight(Position<E> p, E e)
            throws IllegalStateException;

    /**
     * Removes a node in the tree if it has, at most, one child
     * @param p the node to be removed
     * @return the element removed
     * @throws IllegalStateException if the position is not valid or if the node
     * has two children
     */
    public E remove(Position<E> p) throws IllegalStateException;

    /**
     * Swaps the elements in two positions of the tree
     * @param p1 the first element to swap
     * @param p2 the second element to swap
     * @throws IllegalStateException 
     */
    public void swapElements(Position<E> p1, Position<E> p2)
            throws IllegalStateException;

}
