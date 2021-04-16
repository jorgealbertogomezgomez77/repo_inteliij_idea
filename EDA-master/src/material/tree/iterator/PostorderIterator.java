package material.tree.iterator;

import material.tree.Position;
import material.tree.Tree;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by David R on 06/06/2016.
 */
public class PostorderIterator<E> implements Iterator<Position<E>> {
    private final Queue<Position<E>> nodeQueue;
    private final Tree<E> tree;

    public PostorderIterator(Tree<E> tree, Position<E> start) {
        nodeQueue = new ArrayDeque<>();
        this.tree = tree;
        posOrder(start, nodeQueue);
    }

    public PostorderIterator(Tree<E> tree) {
        nodeQueue = new ArrayDeque<>();
        this.tree = tree;
        posOrder(tree.root(), nodeQueue);
    }

    @Override
    public boolean hasNext() {
        return (nodeQueue.size() != 0);
    }

    @Override
    public Position<E> next() {
        Position<E> aux = nodeQueue.remove();
        return aux;
    }

    private void posOrder(Position<E> p, Queue<Position<E>> pos) {
        for (Position<E> w : tree.children(p)) {
            posOrder(w, pos); // recurse on each child
        }
        pos.add(p);
    }
}
