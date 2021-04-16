package material.tree.iterator;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import material.tree.Position;
import material.tree.Tree;



/**
 * Created by David R on 06/06/2016.
 */
public class PreorderIterator<E> implements Iterator <Position<E>> {

    private final Queue<Position<E>> nodeQueue;

    private final Tree<E> tree;

    public PreorderIterator(Tree<E> tree, Position<E> start){
        nodeQueue = new ArrayDeque<>();
        this.tree = tree;
        preOrder(start, nodeQueue);

    }
    public PreorderIterator (Tree<E> tree){
        nodeQueue = new ArrayDeque<> ();
        this.tree = tree;
        preOrder(tree.root(), nodeQueue);

    }
    @Override
    public boolean hasNext(){
        return (nodeQueue.size() != 0);

    }
    @Override
    public Position<E> next() {
        Position<E> aux = nodeQueue.remove();
        return aux;
    }

    private void preOrder(Position<E> p, Queue<Position<E>> pos) {
        pos.add(p);
        for (Position<E> w : tree.children(p)) {
            preOrder(w, pos); // recurse on each child
        }
    }


}
