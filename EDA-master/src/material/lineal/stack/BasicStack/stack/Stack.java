package material.lineal.stack.BasicStack.stack;

/**
 * Interface for stack
 *
 * @author J. Vélez, A. Duarte, J. Sánchez-Oro
 *
 * @param <E> Type of the elements of the stack
 */
public interface Stack<E> {

    /**
     * Checks the number of elements in the stack
     *
     * @return the number of elements in the stack.
     */
    int size();

    /**
     * Checks if a stack is empty
     *
     * @return TRUE if it is empty, FALSE otherwise.
     */
    boolean isEmpty();

    /**
     * Accesses to the top of the stack.
     *
     * @return the element in the top.
     * @throws IllegalStateException
     */
    E top() throws IllegalStateException;

    /**
     * Inserts a new element in the stack
     *
     * @param element the new element so insert.
     */
    void push(final E element);

    /**
     * Extracts the top element of the stack and move the cursor to the next
     * element
     *
     * @return the top element of the stack
     * @throws IllegalStateException
     */
    E pop() throws IllegalStateException;
}
