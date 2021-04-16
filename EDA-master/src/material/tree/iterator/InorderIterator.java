/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.tree.iterator;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;
import material.tree.Position;
import material.tree.Tree;
import material.tree.binarytree.BinaryTree;

/**
 * Generic iterator for trees
 * 
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 * @param <E> the type of elements stored in the tree
 */
public class InorderIterator<E> implements Iterator<Position<E>> {

    private final Stack<Position<E>> nodeStack;
    private final BinaryTree<E> tree;

    public InorderIterator(BinaryTree<E> tree, Position<E> start) {
        nodeStack = new Stack<>();
        this.tree = tree;
        pushAllLeft(start);
    }   
    
    public InorderIterator(BinaryTree<E> tree) {
        nodeStack = new Stack<>();
        this.tree = tree;
        pushAllLeft(tree.root());
    }   
    
    @Override
    public boolean hasNext() {
        return (nodeStack.size() != 0);
    }

    @Override
    public Position<E> next() {
        Position<E> aux = nodeStack.pop();
        if (tree.hasRight(aux)) {
            pushAllLeft(tree.right(aux));
        }
        return aux;
    }
    
    private void pushAllLeft(Position<E> p) {
        Position<E> current = p;
        while (current != null) {
            nodeStack.push(current);
            if (tree.hasLeft(current)) {
                current = tree.left(current);
            } else {
                current = null;
            }                        
        }
    }
}
