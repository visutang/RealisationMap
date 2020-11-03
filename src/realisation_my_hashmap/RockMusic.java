package realisation_my_hashmap;
/*
* @Bohdan Hnatusiv
* 20.10.2020
* */
//create interface     (extends Iterable) with Iterator
interface RockMusic<K,V> extends Iterable<V>{
    //set main methods
    boolean insert(K key,V value);
    boolean delete(K key);
    V get(K key);
    int size();
}
