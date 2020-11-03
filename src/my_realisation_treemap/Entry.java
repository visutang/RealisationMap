package my_realisation_treemap;
/*
 * @author Bohdan Hnatusiv
 * 02.11.2020
 */

import java.util.Iterator;
import java.util.Map;


public class Entry<K, V> implements Map.Entry<K, V> {


    //create main fields of red-black tree
    boolean BLACK = true;
    boolean RED = true;
    K key;
    V value;
    Entry<K, V> left;
    Entry<K, V> right;
    Entry<K, V> parent;
    boolean color  = BLACK;

    //crete constructor
    public Entry(K key, V value, Entry<K, V> parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
    }

    //create getters and setters and toString
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    //  method for replacing value associated with the key with the given
    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
   }




    //  method for returns more of the specified entry
    public Entry<K, V> successor(Entry<K, V> el) {
        if (el == null)
            return null;
        else if (el.right != null) {
            Entry<K, V> par = el.right;
            while (par.left != null)
                par = par.left;
            return par;
        } else {
            Entry<K, V> par = el.parent;
            Entry<K, V> ch = el;
            while (par != null && ch == par.right) {
                ch = par;
                par = par.parent;
            }
            return par;
        }
    }

    //method for returns of the  less specified entry
    public Entry<K, V> predecessor(Entry<K, V> el) {
        if (el == null)
            return null;
        else if (el.left != null) {
            Entry<K, V> par = el.left;
            while (par.right != null)
                par = par.right;
            return par;
        } else {
            Entry<K, V> par = el.parent;
            Entry<K, V> ch = el;
            while (par != null && ch == par.left) {
                ch = par;
                par = par.parent;
            }
            return par;
        }
    }


    // balancing techniques of red-black tree
    private boolean colorOf(Entry<K, V> par) {
        return (par == null ? BLACK : par.color);
    }

    private Entry<K, V> parentOf(Entry<K, V> par) {
        return (par == null ? null : par.parent);
    }

    private void setColor(Entry<K, V> par, boolean col) {
        if (par != null)
            par.color = col;
    }

    private Entry<K, V> leftOf(Entry<K, V> par) {
        return (par == null) ? null : par.left;
    }

    private Entry<K, V> rightOf(Entry<K, V> par) {
        return (par == null) ? null : par.right;
    }



    //the actual balancing method of red-black tree(java -doc)
 public    void fixAfterInsertion(Entry<K, V> x) {
        x.color = RED;

        Entry<K, V> root = null;
        while (x != null && x != root && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                Entry<K, V> y = rightOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateRight(parentOf(parentOf(x)));
                }
            } else {
                Entry<K, V> y = leftOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        root.color = BLACK;
    }




    //balancing red-black tree by turning to the left
    private void rotateLeft(Entry<K, V> par) {
        if (par != null) {
            Entry<K, V> r = par.right;
            par.right = r.left;
            if (r.left != null)
                r.left.parent = par;
            r.parent = par.parent;
            Entry<K, V> root;
            if (par.parent == null)
                root = r;
            else if (par.parent.left == par)
                par.parent.left = r;
            else
                par.parent.right = r;
            r.left = par;
            par.parent = r;
        }
    }

    //balancing red-black tree by turning to the right
    private void rotateRight(Entry<K, V> par) {
        if (par != null) {
            Entry<K, V> l = par.left;
            par.left = l.right;
            if (l.right != null) l.right.parent = par;
            l.parent = par.parent;
            Entry<K, V> root;
            if (par.parent == null)
                root = l;
            else if (par.parent.right == par)
                par.parent.right = l;
            else par.parent.left = l;
            l.right = par;
            par.parent = l;
        }
    }


    //   method returns the value to which the specified key
    public V get(RockStar key) {
        Iterator<Object> i = get().iterator();
        if (key==null) {
            while (i.hasNext()) {
                Map.Entry e = (Map.Entry) i.next();
                if (e.getKey()==null)
                    return (V) e.getValue();
            }
        } else {
            while (i.hasNext()) {
                Map.Entry<K,V> e = (Map.Entry<K, V>) i.next();
                if (key.equals(e.getKey()))
                    return e.getValue();
            }
        }
        return null;
    }

    private Iterable<Object> get() {
        return null;
    }

}
