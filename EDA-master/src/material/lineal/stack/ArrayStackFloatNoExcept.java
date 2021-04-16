package material.lineal.stack;

/**
 * Implementation of a stack using an array. This example does not consider
 * neither exceptions nor generics
 *
 * @author J. Vélez, A. Duarte, J. Sánchez-Oro
 */
public class ArrayStackFloatNoExcept {

    private int top; // Top of the stack
    private float[] s; // Array used to store the stack.

    /**
     * Constructor of the class with the initial capacity
     *
     * @param capacity Maximum size of the stack.
     */
    public ArrayStackFloatNoExcept(int capacity) {
        top = 0;
        s = new float[capacity];
    }

    /**
     * Checks if the stack is empty
     *
     * @return TRUE if the stack is empty, FALSE otherwise
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Retrieves and deletes the first element of the stack
     *
     * @return The top element of the stack
     */
    public float pop() {
        if (!isEmpty()) {
            top--;
            return s[top];
        }
        System.out.println(" The stack is empty");
        return 0;
    }

    /**
     * Checks the size of the stack
     *
     * @return The number of elements in the stack
     */
    public int size() {
        return top;
    }

    /**
     * Retrieves the first element in the stack
     *
     * @return the top element in the stack
     */
    public float top() {
        if (top != 0) {
            return s[top];
        }
        System.out.println(" The stack is empty");
        return 0;
    }

    /**
     * Inserts a new element in the stack
     *
     * @param element the value to be inserted
     */
    public void push(float element) {
        if (top < s.length) {
            s[top] = element;
            top++;
        }
        System.out.println(" The stack is empty");
    }
}
