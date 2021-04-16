package material.lineal.list;

import java.util.Iterator;

/**
 * An interface for positional lists.
 *
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 * @param <E> The generic type of the list
 */
public interface List<E> extends Iterable<E> {

    /**
     * Checks the number of elements in this list.
     *
     * @return number of elements in the list
     */
    public int size();

    /**
     * Checks if the list is empty.
     *
     * @return TRUE if the list is empty, FALSE otherwise
     */
    public boolean isEmpty();

    /**
     * Accesses to the first node in the list.
     * 
     * @return the first node in the list
     */
    public Position<E> first();

    /**
     * Accesses to the last node in the list.
     * @return the last node in the list
     */
    public Position<E> last();

    /**
     * Accesses the position after the given one; O(1) time
     *
     * @param p the position used as reference to access its next one
     * @return the next position with respect to p
     * @throws IllegalStateException
     * @throws IndexOutOfBoundsException
     */
    public Position<E> next(Position<E> p) throws IllegalStateException, IndexOutOfBoundsException;

    /**
     * Accesses to the position before a given one; O(1) time
     *
     * @param p the position used as reference to access its previous one
     * @return the previous position with respect to p
     * @throws IllegalStateException
     * @throws IndexOutOfBoundsException
     */
    public Position<E> prev(Position<E> p) throws IllegalStateException, IndexOutOfBoundsException;

    /**
     * Inserts the given element at the beginning of the list; O(1) time
     *
     * @param e the element to be inserted
     * @return the Position created after inserting element
     */
    public Position<E> addFirst(E e);

    /**
     * Inserts the given element at the end of the list; O(1) time
     *
     * @param e the element to be inserted
     * @return the Position created after inserting element
     */
    public Position<E> addLast(E e);

    /**
     * InsertS the given element after the given position; O(1) time
     *
     * @param p the position used as reference for inserting element after it
     * @param e the element to be inserted
     * @return the new Position created as a result of inserting element before
     * p
     * @throws IllegalStateException
     * @throws IndexOutOfBoundsException
     */
    public Position<E> addAfter(Position<E> p, E e) throws IllegalStateException;

    /**
     * Insert the given element before the given position; O(1) time
     *
     * @param p the position used as reference to insert element before
     * @param e the element to be inserted
     * @return the new position created as a result of inserting element before
     * p
     * @throws IllegalStateException
     * @throws IndexOutOfBoundsException
     */
    public Position<E> addBefore(Position<E> p, E e) throws IllegalStateException;

    /**
     * Removes the given position from the list; O(1) time
     *
     * @param p the position to be removed
     * @return the element removed
     * @throws IllegalStateException
     */
    public E remove(Position<E> p) throws IllegalStateException;

    /**
     * Replaces the element at the given position with the new element; O(1)
     * time
     *
     * @param p the position to be modified
     * @param e the new element to be set in p
     * @return the element previously contained in p
     * @throws IllegalStateException
     */
    public E set(Position<E> p, E e) throws IllegalStateException;

    /**
     * Creates an iterator of all the elements in the list.
     *
     * @return an iterator of the list
     */
    @Override
    public Iterator<E> iterator();
}
