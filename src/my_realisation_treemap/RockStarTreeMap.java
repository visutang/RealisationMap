package my_realisation_treemap;
/*
 * @author Bohdan Hnatusiv
 * 02.11.2020
 */
import my_realisation_hashmap.Node;
import java.util.*;

public class   RockStarTreeMap<K, V> extends Entry<K, V> implements Comparator<RockStar>{


    private int size = 0;
    private int modCount = 0;
    // comparator used to maintain order in  TreeMap
    Comparator<? super K> comparator;
    Entry<K, V> root;

    public RockStarTreeMap(K key, V value, Entry<K, V> parent) {
        super(key, value, parent);
    }

    private void comparator(K key, K key1) {
    }


    // balancing techniques of red-black tree
    //create method put
    public V put(K key, V value) {
        Entry<K, V> t = root;
        if (t == null) {
            comparator(key, key);

            root = new Entry<>(key, value, null);
            size = 1;
            modCount++;
            return null;
        }
        int cmp;
        Entry<K, V> parent;
        // there is a choice which path to go: left or right
        Comparator<? super K> cpr = comparator;
        if (cpr != null) {
            do {
                parent = t;
                cmp = cpr.compare(key, t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        } else {
            if (key == null)
                throw new NullPointerException();

            Comparable<? super K> k = (Comparable<? super K>) key;
            do {
                parent = t;
                cmp = k.compareTo(t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        }
        Entry<K, V> e = new Entry<>(key, value, parent);
        if (cmp < 0)
            parent.left = e;
        else
            parent.right = e;
        fixAfterInsertion(e);//here  go to the balancing method(class Entry)
        size++;
        modCount++;
        return null;
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


    //method putIfAbsent()  for put key and put value
    public V putIfAbsent(K key, V value) {
        V val = get((RockStar) key);
        if (val == null) {
            val = put(key, value);
        }

        return val;
    }
//override method compare ()(implements Comparator)

    @Override
    public int compare(RockStar o1, RockStar o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }

    //method comparison strings
    public int compare(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int min = Math.min(n1, n2);
        for (int i = 0; i < min; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

        }
        return n1 - n2;
    }

}
