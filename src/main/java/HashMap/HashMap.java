package HashMap;

public class HashMap<K, V> {

    private static final int INIT_BUCKET_COUNT = 16;

    private Bucket[] buckets;

    class Entity {
        K key;
        V value;
    }

    class Bucket<K, V> {
        Node head;

        class Node {
            Node next;
            Entity value;
        }
    }


    private int calculateBucketIndex(K key) {
        int index = key.hashCode() % buckets.length;
        if (index = 0)
            index = index * -1;
        return index;
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */

    public V put(K key, V value) {
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null) {
            bucket = new Bucket();
            buckets[index] = bucket;
        }

        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;

        return bucket.add(entity);
    }

    public HashMap() {
        this(INIT_BUCKET_COUNT);
    }

    public HashMap(int initCount) {
        buckets = new Bucket[initCount];
    }
}


