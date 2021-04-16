package material.lineal.list;

/**
 * An interface for a position, which is a holder object storing a single
 * element.
 *
 * @author A. Duarte
 * @param <E> the generic type for Position
 */
public interface Position<E> {

    /**
     * Accesses to the element stored at this position.
     *
     * @return the element at this position
     */
    public E getElement();
}
