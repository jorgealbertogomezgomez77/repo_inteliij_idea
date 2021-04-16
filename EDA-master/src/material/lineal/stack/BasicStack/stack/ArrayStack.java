package material.lineal.stack.BasicStack.stack;

import material.lineal.stack.BasicStack.stack.Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Stack implemented using an array
 *
 * @author J. Vélez, A. Duarte, J. Sánchez-Oro
 *
 * @param <E> Type of the elements stored in the stack
 */
public class ArrayStack<E> implements Stack<E> {

    private int top; // Position of the top of the stack
    private E[] s; // Array containing the elements in the stack

    /**
     * Constructor of the class with the initial capacity.
     *
     * @param capacity maximum initial size of the stack.
     */
    public ArrayStack(final int capacity) {
        top = 0;
        s = (E[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public E pop() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        top--;
        return s[top];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public E top() throws IllegalStateException {
        if (top == 0) {
            throw new IllegalStateException();
        }
        return s[top - 1];
    }

    @Override
    public void push(final E elemento) {
        if (top == s.length) {
            s = Arrays.copyOf(s, 2*s.length);
        }
        s[top] = elemento;
        top++;
    }
}
