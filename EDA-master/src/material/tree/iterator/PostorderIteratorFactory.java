package material.tree.iterator;

import material.tree.Position;
import material.tree.Tree;
import java.util.Iterator;

/**
 * Created by David R on 06/06/2016.
 */
public class PostorderIteratorFactory <E> implements TreeIteratorFactory<E>{

    @Override

    public Iterator<Position<E>> createIterator(Tree<E> tree) {
        return new PostorderIterator<> (tree);
    }

    @Override
    public Iterator<Position<E>> createIterator(Tree<E> tree, Position<E> pos) {
        return new PostorderIterator<>(tree,pos);
    }
}
