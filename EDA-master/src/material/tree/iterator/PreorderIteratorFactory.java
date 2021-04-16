package material.tree.iterator;

import java.util.Iterator;

import material.tree.Position;
import material.tree.Tree;



/**
 * Created by David R on 06/06/2016.
 */
public class PreorderIteratorFactory<E> implements TreeIteratorFactory<E> {

    @Override
    public Iterator<Position<E>> createIterator(Tree<E> tree){
        return new PreorderIterator<>(tree);
    }

    @Override
    public Iterator<Position<E>> createIterator (Tree<E> tree, Position <E> pos){
        return new PreorderIterator<>(tree, pos);
    }


}
