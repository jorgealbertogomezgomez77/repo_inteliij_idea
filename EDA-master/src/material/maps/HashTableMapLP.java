package material.maps;

public class HashTableMapLP<K, V> extends AbstractHashTableMap<K, V> {

    /**
     * Collision solved with linear probe
     *
     * @param //key
     * @return
     */
    public HashTableMapLP(int size) {
        super(size);
    }

    public HashTableMapLP() {

       super();
    }

    public HashTableMapLP(int p, int cap) {

       super(p, cap);
    }

    @Override
    protected int offset(K key, int i) {
        return i;
    }

}
