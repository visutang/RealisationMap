package my_realisation_hashmap;
/*
* @author Bohdan Hnatusiv
* 28.10.2020
 */
import java.util.*;

public class RockMusicHashMap<K, V> extends HashMap<K,V> implements Map<K,V> {


    private int size;
      private int modCount;
    private int threshold;
    private V value;


    //method containsValue()  for definition value (use iterator())
    public boolean containsValue(Object value) {
        Iterator<Entry<K, V>> val = entrySet().iterator();
        if (value == null) {
            while (val.hasNext()) {
                Entry<K, V> e = val.next();
                if (e.getValue() == null)
                    return true;
            }
        } else {
            while (val.hasNext()) {
                Entry<K, V> e = val.next();
                if (value.equals(e.getValue()))
                    return true;
            }
        }
        return false;
    }

    // method iterator() implements interface Iterator
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private final Iterator<Entry<K, V>> i = entrySet().iterator();

            public boolean hasNext() {

                return i.hasNext();
            }

            public K next() {

                return i.next().getKey();
            }

            //method remove()
            public void remove() {

                i.remove();
            }
        };
    }


    //method containsKey()  for definition value (use iterator())
    public boolean containsKey(Object key) {
        Iterator<Map.Entry<K, V>> k = entrySet().iterator();
        if (key == null) {
            while (k.hasNext()) {
                Entry<K, V> e = k.next();
                if (e.getKey() == null)
                    return true;
            }
        } else {
            while (k.hasNext()) {
                Entry<K, V> e = k.next();
                if (key.equals(e.getKey()))
                    return true;
            }
        }
        return false;
    }


    // method get () for get Value (use iterator())
    public V get(Object key) {
        Iterator<Entry<K, V>> k = entrySet().iterator();
        if (key == null) {
            while (k.hasNext()) {
                Entry<K, V> el = k.next();
                if (el.getKey() == null)
                    return el.getValue();
            }
        } else {
            while (k.hasNext()) {
                Entry<K, V> el = k.next();
                if (key.equals(el.getKey()))
                    return el.getValue();
            }
        }
        return null;
    }


    //method setValue() for set value
    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    //method putIfAbsent()  for put key and put value
    public V putIfAbsent(K key, V value) {
        V val = get(key);
        if (val == null) {
            val = put(key, value);
        }

        return val;
    }

    //method clear() for clear  the collection
    public void clear() {
        Node<K, V>[] tabl;
        modCount++;
        Node<K, V>[] table = new Node[0];
        if ((tabl = table) != null && size > 0) {
            size = 0;
            for (int i = 0; i < tabl.length; ++i)
                tabl[i] = null;
        }
    }

}