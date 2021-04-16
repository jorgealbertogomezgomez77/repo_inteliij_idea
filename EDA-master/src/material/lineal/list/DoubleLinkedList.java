package material.lineal.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Realization of a PositionList using a doubly-linked list of nodes.
 *
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 * @param <E> the generic type of the list
 */
public class DoubleLinkedList<E> implements List<E> {

    private class DNode<T> implements Position<T> {

        private DNode<T> prev, next; // References to the nodes before and after
        private T element; // Element stored in this position
        private final DoubleLinkedList<T> myList; //Reference to the object that contains each node

        /**
         * Constructor
         */
        public DNode(DNode<T> newPrev, DNode<T> newNext, T elem, DoubleLinkedList<T> l) {
            prev = newPrev;
            next = newNext;
            element = elem;
            myList = l;
        }

        @Override
        public T getElement() {
            return element;
        }

        /**
         * Accesses to the next element
         *
         * @return the next element in the list
         */
        public DNode<T> getNext() {
            return next;
        }

        /**
         * Accesses to the previous element
         *
         * @return the previous element in the list
         */
        public DNode<T> getPrev() {
            return prev;
        }

        /**
         * Modifies the next element
         *
         * @param newNext the new next element
         */
        public void setNext(DNode<T> newNext) {
            next = newNext;
        }

        /**
         * Modifies the previous element
         *
         * @param newPrev the new previous element
         */
        public void setPrev(DNode<T> newPrev) {
            prev = newPrev;
        }

        /**
         * Modifies the current element
         *
         * @param newElement The new current element
         */
        public void setElement(T newElement) {
            element = newElement;
        }

        /**
         * Accesses to the list where the DNode belongs to
         *
         * @return the list of the DNode
         */
        DoubleLinkedList<T> getMyList() {
            return this.myList;
        }
    }

    /**
     * A simple iterator class for lists. The elements of a list are returned by
     * this iterator. No copy of the list is made, so any changes to the list
     * are reflected in the iterator.
     *
     * @author A. Duarte, J. Vélez, J. Sánchez-Oro
     */
    private class LinkedListIterator<T> implements Iterator<T> {

        private final List<T> list; // the underlying list
        private Position<T> cursor; // the next position


        public LinkedListIterator(List<T> l) {
            list = l;
            cursor = (list.isEmpty()) ? null : list.first();
        }


        @Override
        public boolean hasNext() {
            return (cursor != null);
        }


        @Override
        public T next() throws NoSuchElementException {
            if (cursor == null) {
                throw new NoSuchElementException("No next element");
            }
            T toReturn = cursor.getElement();
            cursor = (cursor == list.last()) ? null : list.next(cursor);
            return toReturn;
        }

        /**
         * Throws an {@link UnsupportedOperationException} in all cases, because
         * removal is not a supported operation in this iterator.
         *
         * @throws UnsupportedOperationException
         */
        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException("remove is not implemented");
        }
    }

    protected int size; // Number of elements in the list
    protected DNode<E> header, trailer; // Special sentinels

    /**
     * Constructor that creates an empty list; O(1) time
     */
    public DoubleLinkedList() {
        this.size = 0;
        this.header = null;
        this.trailer = null;
    }

    /**
     * Checks if position is valid for this list and converts it to DNode if it
     * is valid; O(1) time
     *
     * @param p the position to check
     * @return the position converted to DNode
     * @throws IllegalStateException
     */
    private DNode<E> checkPosition(Position<E> p) throws IllegalStateException {
        if (p == null || !(p instanceof DNode)) {
            throw new IllegalStateException("The position is either null or not an instance of DNode");
        }

        DNode<E> node = (DNode<E>) p;
        if (this != node.getMyList()) {
            throw new IllegalStateException("The position referst to a node not in this list");
        }
        return node;
    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public Position<E> first() throws IllegalStateException {
        if (this.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return this.header;
    }


    @Override
    public Position<E> last() throws IllegalStateException {
        if (this.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return this.trailer;
    }

    @Override
    public Position<E> prev(Position<E> p) throws IllegalStateException, IndexOutOfBoundsException {
        DNode<E> node = checkPosition(p);
        DNode<E> prev = node.getPrev();
        if (prev == null) {
            throw new IndexOutOfBoundsException("Cannot advance past the beginning of the list");
        }
        return prev;
    }

    @Override
    public Position<E> next(Position<E> p) throws IllegalStateException, IndexOutOfBoundsException {
        DNode<E> node = checkPosition(p);
        DNode<E> next = node.getNext();
        if (next == null) {
            throw new IndexOutOfBoundsException("Cannot advance past the end of the list");
        }
        return next;
    }

    
    @Override
    public Position<E> addBefore(Position<E> p, E element) throws IllegalStateException {
        DNode<E> node = checkPosition(p);
        DNode<E> newNode;
        if (node == this.header) {
            newNode = new DNode<E>(null, node, element, this);
            node.setPrev(newNode);
            this.header = newNode;
        } else {
            newNode = new DNode<E>(node.getPrev(), node, element, this);
            node.getPrev().setNext(newNode);
            node.setPrev(newNode);
        }
        this.size++;
        return newNode;
    }

    /**
     * BAD IMPLEMENTATION. WE CANNOT USE DNODE SINCE IT IS A PRIVATE CLASS
     */
//    public DNode<E> addBefore(DNode<E> node, E element) {
//        DNode<E> newNode;
//        if (node == this.header) {
//            newNode = new DNode<E>(null, node, element, this);
//            this.header = newNode;
//        } else {
//            newNode = new DNode<E>(node.getPrev(), node, element, this);
//            node.getPrev().setNext(newNode);
//            node.setPrev(newNode);
//        }
//        this.size++;
//        return newNode;
//    }

    /**
     * BAD IMPLEMENTATION. THE COMPLEXITY OF THIS METHOD IS O(n). ADDITIONALLY,
     * IT MAY HAVE PROBLEMS IF THERE ARE REPEATED ELEMENTS IN THE LIST *
     */
//    public void addBefore(E elem, E newElem) {
//        DNode<E> node = this.header;
//        while ((node != null) && node.element() != elem) {//The element is not in the list or the list is empty
//            node = node.getNext();
//        }
//
//        if (node == null) {// The element is in the list but is not the first element
//            System.out.println("The element is not in the list");
//        } else if (node != this.header) {
//            size++;
//            DNode<E> newNode = new DNode<E>(node.getPrev(), node, newElem, this);
//            node.getPrev().setNext(newNode);
//            node.setPrev(newNode);
//        } else {// The element is inserted in the first positon of the list
//            this.addFirst(newElem);
//        }
//    }

    
    @Override
    public Position<E> addAfter(Position<E> p, E element) throws IllegalStateException {
        DNode<E> node = checkPosition(p);
        DNode<E> newNode;
        if (node == this.trailer) {
            newNode = new DNode<E>(node, null, element, this);
            node.setNext(newNode);
            this.trailer = newNode;
        } else {
            newNode = new DNode<E>(node, node.getNext(), element, this);
            node.getNext().setPrev(newNode);
            node.setNext(newNode);
        }
        size++;
        return newNode;
    }

    @Override
    public Position<E> addFirst(E element) {
        DNode<E> newNode;
        if (this.isEmpty()) {
            newNode = new DNode<E>(null, null, element, this);
            this.header = newNode;
            this.trailer = newNode;
        } else {
            newNode = new DNode<E>(null, this.header, element, this);
            this.header.setPrev(newNode);
            this.header = newNode;
        }
        size++;
        return newNode;
    }

    @Override
    public Position<E> addLast(E element) {
        DNode<E> newNode;
        if (this.isEmpty()) {
            newNode = new DNode<E>(null, null, element, this);
            this.header = newNode;
            this.trailer = newNode;
        } else {
            newNode = new DNode<E>(this.trailer, null, element, this);
            this.trailer.setNext(newNode);
            this.trailer = newNode;
        }
        size++;
        return newNode;
    }

    
    @Override
    public E remove(Position<E> p) throws IllegalStateException {
        DNode<E> node = checkPosition(p);
        E elem = node.getElement();
        if (this.trailer == this.header) {
            this.trailer = null;
            this.header = null;
        } else if (node == this.header) {
            this.header = this.header.getNext();
        } else if (node == this.trailer) {
            this.trailer = this.trailer.getPrev();
        } else {
            DNode<E> nodePrev = node.getPrev();
            DNode<E> nodeNext = node.getNext();
            nodePrev.setNext(nodeNext);
            nodeNext.setPrev(nodePrev);
        }
        size--;
        return elem;
    }

    
    @Override
    public E set(Position<E> p, E element) throws IllegalStateException {
        DNode<E> node = checkPosition(p);
        E oldElt = node.getElement();
        node.setElement(element);
        return oldElt;
    }

    
    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<E>(this);
    }

    // Convenience methods
    /**
     * Checks if a position is the first one in the list; O(1) time
     *
     * @param p the position to check
     * @return TRUE if p is the first position, FALSE otherwise
     */
    public boolean isFirst(Position<E> p) throws IllegalStateException {
        DNode<E> v = checkPosition(p);
        return v == header;
    }

    /**
     * Checks if a position is the last one in the list; O(1) time
     *
     * @param p the position to check
     * @return TRUE if p is the last position, FALSE otherwise
     */
    public boolean isLast(Position<E> p) throws IllegalStateException {
        DNode<E> v = checkPosition(p);
        return v == trailer;
    }

    /**
     * Swaps the elements of two give positions; O(1) time
     *
     * @param a the first position to swap
     * @param b the second position to swap
     */
    public void swapElements(Position<E> a, Position<E> b)
            throws IllegalStateException {
        DNode<E> pA = checkPosition(a);
        DNode<E> pB = checkPosition(b);
        E temp = pA.getElement();
        pA.setElement(pB.getElement());
        pB.setElement(temp);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        for (E elem : this) {
            s.append(elem); // implicit cast of the element to String
            s.append(","); // separate elements with a comma
        }
        s.replace(s.length() - 1, s.length(), "]");
        return s.toString();
    }
}
