package material.maps;



/**
 * An interface for a map which binds a key uniquely to a value.
 * 
 * @author  R. Cabido, A. Duarte, and J. Velez
 */

// A simple Map interface
public interface Map<K, V> extends Iterable<Entry<K,V>>{
	/** Returns the number of items in the map. */
	public int size();

	/** Returns whether the map is empty. */
	public boolean isEmpty();

	/**
	 * If there is an entry with the specified key, replaces the value of this
	 * entry with the specified value and returns the old value. Else, adds a
	 * new entry with the specified key and value and returns null.
	 */
	public V put(K key, V value) throws IllegalStateException;

	/**
	 * Returns the value of the entry containing the given key. Returns null if
	 * no such entry exists.
	 */
	public V get(K key) throws IllegalStateException;

	/**
	 * If there is an entry with the specified key, removes this entry and
	 * returns its value. Else, returns null.
	 */
	public V remove(K key) throws IllegalStateException;

	/** Returns an iterable object containing all the keys in the map. */
	public Iterable<K> keys();

	/** Returns an iterable object containing all the values in the map. */
	public Iterable<V> values();

	/** Returns an iterable object containing all the entries in the map. */
	public Iterable<Entry<K, V>> entries();
}
