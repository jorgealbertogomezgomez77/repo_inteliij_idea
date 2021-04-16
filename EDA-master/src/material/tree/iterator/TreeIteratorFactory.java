package material.tree.iterator;

import java.util.Iterator;
import material.tree.Position;
import material.tree.Tree;

/**
 * Abstract factory for tree iterators
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 * @param <E> the type of the elements in the tree
 */
public interface TreeIteratorFactory<E> {
    /**
     * Creates an iterator from the root of the tree
     * @param tree the tree to be iterated
     * @return the iterator of the tree
     */
    public Iterator<Position<E>> createIterator(Tree<E> tree);
    /**
     * Creates an iterator from the root of the tree
     * @param tree the tree to be iterated
     * @param pos the initial position of the iterator
     * @return the iterator of the tree
     */
    public Iterator<Position<E>> createIterator(Tree<E> tree, Position<E> pos);
}
