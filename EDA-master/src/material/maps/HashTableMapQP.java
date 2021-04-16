package material.maps;

public class HashTableMapQP<K, V> extends AbstractHashTableMap<K, V> {

    public HashTableMapQP(int size) {
       super(size);
    }

    public HashTableMapQP() {
        super();
    }

    public HashTableMapQP(int p, int cap) {

       super(p, cap);
    }

    @Override
    protected int offset(K key, int attempt) {
        int sol = (1 * attempt) + (1 * attempt * attempt);
        return sol;
    }

}
