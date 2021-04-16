package material.lineal.stack;

public class LinkedStackFloatNoExcept {

    /**
     * Implementation of a stack using linked list. This example does not
     * consider neither exceptions nor generics
     *
     * @author J. Vélez, A. Duarte, J. Sánchez-Oro
     */
    class Node {

        private float element; // Element
        private Node next; // Reference to the next node

        /**
         * Constructor of the class with the element and the next node
         *
         * @param e element
         * @param n next node
         */
        public Node(float e, Node n) {
            element = e;
            next = n;
        }

        /**
         * Getter of the element
         *
         * @return the element in this node
         */
        public float getElement() {
            return element;
        }

        /**
         * Getter of the next node
         *
         * @return the next node with respect to this
         */
        public Node getNext() {
            return next;
        }
    }

    private Node top; // The node in the top of the stack
    private int size; // The size of the stack

    /**
     * Constructor of an empty stack
     */
    public LinkedStackFloatNoExcept() {
        top = null;
        size = 0;
    }

    /**
     * Checks the number of elements in the stack
     *
     * @return the number of elements in the stack.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if a stack is empty
     *
     * @return TRUE if it is empty, FALSE otherwise.
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Accesses to the top of the stack.
     *
     * @return the element in the top.
     */
    public float top() {
        if (!isEmpty()) {
            return top.getElement();
        }
        System.out.println(" The stack is empty");
        return 0;
    }

    /**
     * Inserts a new element in the stack
     *
     * @param e the new element so insert.
     */
    public void push(float e) {
        Node n = new Node(e, top);
        top = n;
        size++;
    }

    /**
     * Extracts the top element of the stack and move the cursor to the next
     * element
     *
     * @return the top element of the stack
     */
    public float pop() {
        if (!isEmpty()) {
            float e = top.getElement();
            top = top.getNext();
            size--;
            return e;
        }
        System.out.println(" The stack is empty");
        return 0;
    }
}
