package material.tree.iterator;
import java.util.Iterator;
import material.tree.Position;
import material.tree.Tree  ;
/**
 * Created by David R on 03/06/2016.
 */
public class FrontIteratorFactory<E> implements TreeIteratorFactory<E>{

    @Override
    public Iterator<Position<E>> createIterator(Tree<E> tree) {
        return new FrontIterator<>(tree);
    }

    @Override
    public Iterator<Position<E>> createIterator(Tree<E> tree, Position<E> pos) {
        return new FrontIterator<>(tree,pos);
    }

}
