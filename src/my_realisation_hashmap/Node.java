package my_realisation_hashmap;
/*
 * @author Bohdan Hnatusiv
 * 28.10.2020
 */

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;

public abstract class  Node<K, V> extends AbstractMap implements Map.Entry<K, V> {
    //create fields
    int hash;
    K key;
    V value;
    Node<K, V> next;//use for collision

    // create constructor
    Node(int hash, K key, V value, Node<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Node(K key, V value) {
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    //create getters and method .toString()
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public String toString() {
        return key + "=" + value;
    }

    // create method for hashCode()
    public int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }
     //rewriting (rubbing)
    public V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }
      //create method  .equals()
    public final boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof Map.Entry) {
            Map.Entry<?, ?> el = (Map.Entry<?, ?>) obj;
            return Objects.equals(key, el.getKey()) &&
                    Objects.equals(value, el.getValue());
        }
        return false;
    }

}

