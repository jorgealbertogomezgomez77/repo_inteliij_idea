package material.tree;

import java.util.Iterator;

/**
 * An interface for a tree where nodes can have an arbitrary number of children.
 *
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 * @param <E> the type of the elements stored in the tree
 */
public interface Tree<E> extends Iterable<Position<E>> {

    /**
     * Checks the number of nodes in the tree.
     *
     * @return the number of nodes in the tree
     */
    public int size();

    /**
     * Checks if the tree is empty.
     * 
     * @return TRUE if the tree is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Checks the root of the tree.
     * 
     * @return the root of the tree 
     * @throws IllegalStateException if the tree is empty
     */
    public Position<E> root() throws IllegalStateException;

    /**
     * Consults the parent of a given node.
     * 
     * @param v the position of the node whose parent is being consulted
     * @return the position of the parent of v
     * @throws IllegalStateException if the position is not valid
     * @throws IndexOutOfBoundsException if the node has not parent (i.e., it is the root)
     */
    public Position<E> parent(Position<E> v) throws IllegalStateException, IndexOutOfBoundsException;

    /**
     * Creates an iterable collection of the children of a given node.
     * 
     * @param v the position of the node whose children are checked
     * @return an iterable collection with the children of the consulted node
     * @throws IllegalStateException if the position is not valid
     */
    public Iterable<? extends Position<E>> children(Position<E> v) throws IllegalStateException;

    /**
     * Checks if a given node is internal.
     * 
     * @param v the position of the node to check
     * @return TRUE is the node is internal, FALSE otherwise
     * @throws IllegalStateException if the position is not valid
     */
    public boolean isInternal(Position<E> v) throws IllegalStateException;

    /**
     * Checks if a given node is external.
     * 
     * @param v the position of the node to check
     * @return TRUE if the node is a leaf, FALSE otherwise
     * @throws IllegalStateException if the position is not valid
     */
    public boolean isLeaf(Position<E> v) throws IllegalStateException;

    /**
     * Checks if a given node is the root of the tree.
     * 
     * @param v the position of the node to check
     * @return TRUE if the node is the root, FALSE otherwise
     * @throws IllegalStateException if the position is not valid
     */
    public boolean isRoot(Position<E> v) throws IllegalStateException;

    /**
     * Sets the root of the tree
     * 
     * @param e the element to be used as a root
     * @return the position of the root added
     * @throws IllegalStateException if the tree already has a root
     */
    public Position<E> addRoot(E e) throws IllegalStateException;
}
