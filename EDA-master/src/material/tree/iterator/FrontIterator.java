package material.tree.iterator;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import material.tree.Position;
import material.tree.Tree;

/**
 * Created by David R on 03/06/2016.
 */
public class FrontIterator<E> implements Iterator<Position<E>> {
    private final Queue<Position<E>> nodeQueue;
    private final Tree<E> tree;

    public FrontIterator(Tree<E> tree, Position<E> start) {
        nodeQueue = new ArrayDeque<>();
        this.tree = tree;
        front(start, nodeQueue);
    }

    public FrontIterator(Tree<E> tree) {
        nodeQueue = new ArrayDeque<>();
        this.tree = tree;
        front(tree.root(), nodeQueue);
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

    private void front(Position<E> p, Queue<Position<E>> pos) {
        for (Position<E> w : tree.children(p)) {
            if (tree.isLeaf(w)) {
                nodeQueue.add(w);   //Si no tiene mas hijos es que es hoja y se añade
            } else {
                front(w, nodeQueue);
            }
        }
    }
}
