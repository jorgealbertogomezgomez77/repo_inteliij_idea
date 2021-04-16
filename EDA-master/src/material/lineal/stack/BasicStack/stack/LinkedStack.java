package material.lineal.stack.BasicStack.stack;

import material.lineal.stack.BasicStack.stack.Stack;

import java.util.EmptyStackException;

/**
 * Stack implemented using a linked list
 *
 * @author J. Vélez, A. Duarte, J. Sánchez-Oro
 *
 * @param <E> Type of the elements stored in the stack
 */
public class LinkedStack<E> implements Stack<E> {

    private class Node<T> {

        private final T element; // Reference to the element
        private final Node next; // Reference to the next node

        /**
         * Constructor of the class with the element to be stored and a
         * reference to the next node
         *
         * @param e element of the node
         * @param n next node
         */
        public Node(T e, Node n) {
            // Produce: 
            element = e;
            next = n;
        }

        /**
         * Getter for the element in the node
         *
         * @return the element stored in the node
         */
        public T getElement() {
            return element;
        }

        /**
         * Getter for the next node
         *
         * @return the next node
         */
        public Node getNext() {
            return next;
        }
    }

    private Node<E> top; // The top node in the stack
    private int size; // The number of elements in the stack

    /**
     * Constructor of an empty stack.
     */
    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public E top() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return top.getElement();
    }

    @Override
    public void push(final E e) {
        Node<E> n = new Node(e, top);
        top = n;
        size++;
    }

    @Override
    public E pop() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        E e = top.getElement();
        top = top.getNext();
        size--;
        return e;
    }
}
