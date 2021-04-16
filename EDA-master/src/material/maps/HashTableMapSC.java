package material.maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Separate chaining table implementation of hash tables. Note that all
 * "matching" is based on the equals method.
 *
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 */

public class HashTableMapSC<K, V> implements Map<K, V> {

    private class HashEntry<T, U> implements Entry<T, U> {

        protected T key;
        protected U value;

        public HashEntry(T k, U v) {
            key = k;
            value = v;
        }

        @Override
        public U getValue() {
            return value;
        }

        @Override
        public T getKey() {
            return key;
        }

        public U setValue(U val) {
            U oldValue = value;
            value = val;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {

            if (o.getClass() != this.getClass()) {
                return false;
            }

            HashEntry<T, U> ent;
            try {
                ent = (HashEntry<T, U>) o;
            } catch (ClassCastException ex) {
                return false;
            }
            return (ent.getKey().equals(this.key)) && (ent.getValue().equals(this.value));
        }

        /**
         * Entry visualization.
         */
        @Override
        public String toString() {
            return "(" + key + "," + value + ")";
        }

    }

    private class HashTableMapIterator<T, U> implements Iterator<Entry<T, U>> {

        private int pos, posList; //tenemos la posicion en el hashmap, y la losicion en la lista en caso de colision
        private List<HashEntry<T, U>>[] bucket;//Ahora es un array de listas, para guardar las colisiones en la lista
        private Entry<T, U> AVAILABLE;

        public HashTableMapIterator(List<HashEntry<T, U>>[] b, Entry<T, U> av, int numElems) {

            this.bucket = b; //anyadir: para que no falle hasNext al comparar pos < bucket.length
            this.posList = 0;

            if (numElems == 0) {
                this.pos = bucket.length;
            } else {
                this.pos = 0;
                goToNextElement(0);
                this.AVAILABLE = av;
            }
        }

        private void goToNextElement(int start) {//exactamente igual que cuando no teniamos encadenamiento separado
            final int n = bucket.length;
            this.pos = start;
            while ((this.pos < n) && ((this.bucket[this.pos] == null)
                    || (this.bucket[this.pos] == this.AVAILABLE))) {
                this.pos++;
            }
        }

        @Override

        public boolean hasNext() {
            return (this.pos < this.bucket.length);
        }

        @Override

        public Entry<T, U> next() {
            if (hasNext()) {
                int currentPos = this.pos;
                Entry<T, U> a = this.bucket[currentPos].get(posList);
                if (this.bucket[currentPos+1] == null) {
                    goToNextElement(this.pos + 1);
                    this.posList = 0;
                } else {
                    this.posList++;
                }
                return a;
            } else {
                throw new IllegalStateException("The map has not more elements");
            }
        }

        @Override
        public void remove() {
            // NO HAY QUE IMPLEMENTARLO
            throw new UnsupportedOperationException("Not implemented.");
        }
    }

    private class HashTableMapKeyIterator<T, U> implements Iterator<T> {

        public HashTableMapIterator<T, U> it;

        public HashTableMapKeyIterator(HashTableMapIterator<T, U> it) {
            this.it = it;
        }

        @Override
        public T next() {
            return it.next().getKey();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public void remove() {
            // NO HAY QUE IMPLEMENTARLO
            throw new UnsupportedOperationException("Not implemented.");
        }
    }

    private class HashTableMapValueIterator<T, U> implements Iterator<U> {

        public HashTableMapIterator<T, U> it;

        public HashTableMapValueIterator(HashTableMapIterator<T, U> it) {
            this.it = it;
        }

        @Override
        public U next() {
            return it.next().getValue();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not implemented.");
        }
    }

    protected class HashEntryIndex {

        int index;
        boolean found;

        public HashEntryIndex(int index, boolean f) {
            this.index = index;
            this.found = f;
        }
    }




    protected int n = 0; // number of entries in the dictionary
    protected int prime, capacity; // prime factor and capacity of bucket array
    protected long scale, shift; // the shift and scaling factors
    protected List<HashEntry<K, V>>[] bucket;// bucket array
    protected final Entry<K, V> AVAILABLE = new HashEntry<>(null, null);

    /**
     * Creates a hash table
     */
    public HashTableMapSC() {
        this(109345121, 1000); // reusing the constructor HashTableMap(int p, int cap)
    }

    /**
     * Creates a hash table.
     *
     * @param cap initial capacity
     */
    public HashTableMapSC(int cap) {
        this(109345121, cap); // reusing the constructor HashTableMap(int p, int cap)
    }

    /**
     * Creates a hash table with the given prime factor and capacity.
     *
     * @param p prime number
     * @param cap initial capacity
     */
    public HashTableMapSC(int p, int cap) {
        this.n = 0;
        this.prime = p;
        this.capacity = cap;
        this.bucket = (List<HashEntry<K, V>>[]) new List[capacity]; // safe cast
        Random rand = new Random();
        this.scale = rand.nextInt(prime - 1) + 1;
        this.shift = rand.nextInt(prime);
    }

    /**
     * Hash function applying MAD method to default hash code.
     *
     * @param key Key
     * @return
     */
    protected int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
    }

    /**
     * Returns the number of entries in the hash table.
     *
     * @return the size
     */
    @Override
    public int size() {
        return n;
    }

    /**
     * Returns whether or not the table is empty.
     *
     * @return true if the size is 0
     */
    @Override
    public boolean isEmpty() {
        return (n == 0);
    }

    /**
     * Returns the value associated with a key.
     *
     * @param key
     * @return value
     */
    @Override
    public V get(K key) throws IllegalStateException {
        HashEntryIndex i = findEntry(key); // helper method for finding a key
        if (i.found == false) {
            return null; // there is no value for this key, so return null
        }
        if (bucket[i.index] != null) { //la clave esta en la lista
            for (HashEntry<K, V> h : bucket[i.index]) {//recorremos la lista
                if (h.getKey().equals(key)) {//comprobamos que la clave sea igual a la que buscamos
                    return h.getValue();
                }
            }
        }
        return null;
    }


    protected HashEntryIndex findEntry(K key) throws IllegalStateException {
        checkKey(key);
        int i = hashValue(key); // posicion que ocupa en la tabla
        if (bucket[i] != null) {//en esa posicion hay una lista
            for (HashEntry<K, V> e : bucket[i]) {//recorremos la lista
                if (e == null)
                    break;
                else
                if (key.equals(e.getKey())) // clave encontrada
                    return new HashEntryIndex(i, true);
            }
        }
        return new HashEntryIndex(i, false); // first empty or available slot
    }

    /**
     * Put a key-value pair in the map, replacing previous one if it exists.
     *
     * @param key
     * @param value
     * @return value
     */
    @Override
    public V put(K key, V value) throws IllegalStateException {
        HashEntryIndex i = findEntry(key); // find the appropriate spot for this entry
        V old = null; //valor que devolveremos

        if (i.found == true) { //actualizar el valor
            if (bucket[i.index] != null) { //la lista no está vacia
                for (HashEntry<K, V> e : bucket[i.index]) { //recorremos la lista
                    if (e.getKey().equals(key)) {//claves iguales
                        old = e.getValue();
                        e.setValue(value);
                    }
                }
            }
        } else {  //añadir nuevo
            if (n / capacity >= 0.75) {//el factor de carga es >= 0.75
                rehash(2*capacity);
                i = findEntry(key); // find again the appropriate spot for this entry
            }
            if (bucket[i.index] == null) { //la lista estaba vacia
                bucket[i.index] = new ArrayList<>(); //creamos la lista
                bucket[i.index].add(new HashEntry<>(key, value)); //insertamos
            } else {
                bucket[i.index].add(new HashEntry<>(key, value)); //insertamos
            }
            n++; //aumentamos el tamaño
        }
        return old; //devolvemos el valor
    }

    /**
     * Removes the key-value pair with a specified key.
     *
     * @param key
     * @return
     */
    @Override
    public V remove(K key) throws IllegalStateException {
        HashEntryIndex i = findEntry(key); // find this key first
        if (i.found == false) {
            return null; // nothing to remove
        }
        if (bucket[i.index] != null) { //la clave a borrar esta en la lista
            for (HashEntry<K, V> e : bucket[i.index]) { //recorremos la lista
                if (e.getKey().equals(key)) { //clave encontrada
                    bucket[i.index].remove(e); //borramos
                    n--; //disminuimos el tamaño
                    return e.getValue(); //devolvemos el valor borrado
                }
            }
        }
        return null;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new HashTableMapIterator<>(this.bucket, this.AVAILABLE, this.n);
    }

    /**
     * Returns an iterable object containing all of the keys.
     *
     * @return
     */
    @Override
    public Iterable<K> keys() {
        List<K> keys = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (bucket[i] != null) {
                for (HashEntry<K, V> e : bucket[i]) {
                    keys.add(e.getKey());
                }
            }
        }
        return keys;
    }

    /**
     * Returns an iterable object containing all of the values.
     *
     * @return
     */
    @Override
    public Iterable<V> values() {
        List<V> values = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (bucket[i] != null) {
                for (HashEntry<K, V> e : bucket[i]) { //recorremos la lista
                    values.add(e.getValue());
                }
            }
        }
        return values;
    }

    /**
     * Returns an iterable object containing all of the entries.
     *
     * @return
     */
    @Override
    public Iterable<Entry<K, V>> entries() {
        List<Entry<K, V>> entries = new ArrayList<>();
        for (int i = 0; i < capacity; i++) { //recorremos la tabla
            if (bucket[i] != null) { //la lista no es vacia
                for (HashEntry<K, V> e : bucket[i]) { //recorremos la lista
                    entries.add(e);
                }
            }
        }
        return entries;
    }

    /**
     * Determines whether a key is valid.
     *
     * @param k Key
     */
    protected void checkKey(K k) {
        if (k == null) {
            throw new IllegalStateException("Invalid key: null.");
        }
    }

    /**
     * Increase/reduce the size of the hash table and rehashes all the entries.
     */
    protected void rehash(int newCap) {
        capacity = newCap;
        List<HashEntry<K, V>>[] old = bucket;
        // new bucket is twice as big
        bucket = (List<HashEntry<K, V>>[]) new List[capacity];
        java.util.Random rand = new java.util.Random();
        // new hash scaling factor
        scale = rand.nextInt(prime - 1) + 1;
        // new hash shifting factor
        shift = rand.nextInt(prime);
        for (List<HashEntry<K, V>> e : old) {
            if ((e != null) && (e != AVAILABLE)) { // a valid entry
                for (HashEntry<K, V> entry : e) { //para la lista
                    if (bucket[findEntry(entry.getKey()).index] == null) { //la lista estaba vacia
                        bucket[findEntry(entry.getKey()).index] = new ArrayList<>(); //creamos la lista
                        bucket[findEntry(entry.getKey()).index].add(entry); //insertamos
                    } else {
                        bucket[findEntry(entry.getKey()).index].add(entry); //insertamos
                    }
                }
            }
        }
    }
}
