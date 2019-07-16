package material.tree;

/**
 * An interface for a position, which is a holder object storing a single
 * element.
 *
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 * @param <E> the type of the element stored in the position
 */
public interface Position<E> {

    /**
     * Checks the element stored at this position.
     * 
     * @return the element stored in the given position
     */
    E getElement();
}
