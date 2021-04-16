package material.tree.iterator;

import java.util.Iterator;
import material.tree.Position;
import material.tree.Tree;

/**
 * Factory for creating preorder iterators
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 * @param <E> the type of the elements in the tree
 */
public class BFSIteratorFactory<E> implements TreeIteratorFactory<E> {

    @Override
    public Iterator<Position<E>> createIterator(Tree<E> tree) {

        return new BFSIterator<>(tree);
    }

    @Override
    public Iterator<Position<E>> createIterator(Tree<E> tree, Position<E> pos) {
        return new BFSIterator<>(tree,pos);
    }
    
    
    
}
