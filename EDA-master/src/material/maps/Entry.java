package material.maps;

/**
 * @author R. Cabido, A. Duarte, and J. Velez
 * 
*
 */
/**
 * Interface for a key-value pair entry
 *
 * @param <K> Key type
 * @param <V> value type
 *
 */
public interface Entry<K, V> {

    /**
     * Returns the key stored in this entry.
     *
     * @return The key
     */
    public K getKey();

    /**
     * Returns the value stored in this entry.
     *
     * @return The value
     */
    public V getValue();
}
