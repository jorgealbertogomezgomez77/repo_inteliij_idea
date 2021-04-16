/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.tree.iterator;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import material.tree.Position;
import material.tree.Tree;

/**
 * Generic iterator for trees
 * 
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 * @param <E> the type of elements stored in the tree
 */
public class BFSIterator<E> implements Iterator<Position<E>> {

    private final Queue<Position<E>> nodeQueue;
    private final Tree<E> tree;

    public BFSIterator(Tree<E> tree, Position<E> start) {
        nodeQueue = new ArrayDeque<>();
        this.tree = tree;
        nodeQueue.add(start);
    }   
    
    public BFSIterator(Tree<E> tree) {
        nodeQueue = new ArrayDeque<>();
        this.tree = tree;
        nodeQueue.add(tree.root());
    }   
    
    @Override
    public boolean hasNext() {

        return (nodeQueue.size() != 0);
    }

    @Override
    public Position<E> next() {
        Position<E> aux = nodeQueue.remove();
        for (Position<E> node : tree.children(aux)) {
            nodeQueue.add(node);
        }
        return aux;
    }
    
}
