package maps;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap<K,V> extends AbstractMap<K,V> {

    protected int n = 0;              // number of entries in the dictionary
    protected int capacity;           // length of the table
    private int prime;                // prime factor
    private long scale, shift;        // shift and scaling factors
    protected double mxLdFactor = 0.5;   // maximum load factor (user-configurable) - rana

    // full constructor: capacity, prime, load factor
    public AbstractHashMap(int cap, int p, double mxLdFactor) {
        prime = p;
        capacity = cap;
        this.mxLdFactor = mxLdFactor;
        Random rand = new Random();
        scale = rand.nextInt(prime-1) + 1;
        shift = rand.nextInt(prime);
        createTable();
    }

    // constructor: capacity + load factor, default prime
    public AbstractHashMap(int cap, double mxLdFactor) {
        this(cap, 109345121, mxLdFactor);
    }

    // default: capacity 17, load factor 0.5
    public AbstractHashMap() {
        this(17, 0.5);
    }

    // constructor: capacity only, default prime and load factor 0.5
    public AbstractHashMap(int cap) {
        this(cap, 109345121, 0.5);
    }

    @Override
    public int size() { return n; }

    @Override
    public V get(K key) { return bucketGet(hashValue(key), key); }

    @Override
    public V remove(K key) { return bucketRemove(hashValue(key), key); }

    @Override
    public V put(K key, V value) {
        V answer = bucketPut(hashValue(key), key, value);
        // use mxLdFactor instead of hard-coded 0.5
        if (n > mxLdFactor * capacity)
            resize(2 * capacity - 1);
        return answer;
    }

    private int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode()*scale + shift) % prime) % capacity);
    }

    private void resize(int newCap) {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>(n);
        for (Entry<K,V> e : entrySet())
            buffer.add(e);
        capacity = newCap;
        createTable();
        n = 0;
        for (Entry<K,V> e : buffer)
            put(e.getKey(), e.getValue());
    }

    protected abstract void createTable();

    protected abstract V bucketGet(int h, K k);

    protected abstract V bucketPut(int h, K k, V v);

    protected abstract V bucketRemove(int h, K k);
}
