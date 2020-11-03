package realisation_my_hashmap;
/*
 * @author Bohdan Hnatusiv
 * 20.10.2020
 */
import java.util.*;


class ReferenceMusic<K, V> implements RockMusic<K, V> {
    public static void main(String[] args) {
      ReferenceMusic<String,String> referenceMusic = new ReferenceMusic<>();

      System.out.println(" Size of referenceMusic  =  " + referenceMusic.size());
        System.out.println(  " ReferenceMusic.toString()  =   "    + referenceMusic.toString());
        System.out.println("Doubling threshold "  +  referenceMusic.threshold + "    cells   of  hashTable ");

           //Если убрать "закоментированность "   - бросается NullPointerException !!!!!!!!!???????
     // referenceMusic.insert("1","b");

    }


    private Node<K, V>[] hashTable;
    private int size = 0;
    private float threshold;//workload of hashTable

    //create constructor of class ReferenceBook and initialization it
    public ReferenceMusic() {
        hashTable = new Node[16];
        threshold = hashTable.length * 0.75f;
    }

   // create method  calculations index of hashTable
   private int hash(Node<K, V> key) {
       return hashCode() % hashTable.length;
   }


    //Override and realisation methods of interface Book
    // 1)realisation method insert()
    @Override
    public boolean insert( final K key, final V value) {
        if ((size + 1) >= threshold) {
            threshold *= 2;
            arrayDoubling();
        }

        Node<K, V> newNode = new Node<>(key, value);
        int index = newNode.hash();

        if (hashTable == null) {
            return simpleAdd(index, newNode);
        }
        //collision handling!!
        List<Node<K, V>> nodeList = hashTable[index].getNodes();
        for (Node<K, V> node : nodeList) {
            if (keyExistButValueNew(node, newNode, value)// need to overwrite
                    ||
                    collisionProcession(node, newNode, nodeList))//if true collision
            {
                return true;
            }
        }
        return false;

    }

    // create method collisionProcession() for method insert() (if true collision)
    private boolean collisionProcession(Node<K, V> nodeFromList, Node<K, V> newNode, List<Node<K, V>> nodes) {
        if (newNode.hashCode() == nodeFromList.hashCode() &&
                !Objects.equals(newNode.key, nodeFromList.key) &&
                !Objects.equals(newNode.value, nodeFromList.value)) {
            nodes.add(newNode);
            size++;
            return true;
        }
        return false;
    }

    // create method keyExistButValueNew() for method insert()  (overwrite)
    private boolean keyExistButValueNew(Node<K, V> nodeFromList, Node<K, V> newNode, V value) {
        if (newNode.getKey().equals(nodeFromList.getKey()) &&
                !newNode.getValue().equals(nodeFromList.getValue())) {
            nodeFromList.setValue(value);
            return true;
        }
        return false;
    }

    // create method simpleAdd() for method insert()
    private boolean simpleAdd(int index, Node<K, V> newNode) {
        hashTable[index] = new Node<>(null, null);
        hashTable[index].getNodes().add(newNode);
        size++;
        return true;
    }

    // create method arrayDoubling() for method insert()
    private void arrayDoubling() {
        Node<K, V>[] oldHashTable = hashTable;
        hashTable = new Node[oldHashTable.length * 2];
        size = 0;
        for (Node<K, V> node : oldHashTable) {
            if (node != null) {
                for (Node<K, V> n : node.getNodes()) {
                    insert(n.key, n.value);
                }
            }
        }
    }

    // 2)realisation  method delete()
    @Override
    public boolean delete(K key) {
        int index = hash((Node<K, V>) key);
        if (hashTable[index] == null)
            return false;

        if (hashTable[index].getNodes().size() == 1) {
            hashTable[index] = null;
            return true;
        }
        List<Node<K, V>> nodeList = hashTable[index].getNodes();
        for (Node<K, V> node : nodeList) {
            if (key.equals(node.getValue())) {
                nodeList.remove(node);
                return true;
            }
        }
        return false;
    }



    // 3)realisation  method get()
    @Override
    public V get(K key) {
        int index = hash((Node<K, V>) key);
        if (index< hashTable.length &&
        hashTable[index] != null){

            if (hashTable[index].getNodes().size()==1){
                return hashTable[index].getNodes().get(0).getValue();
            }

            List<Node<K,V>>  list=  hashTable[index].getNodes();
            for (Node<K,V> node: list){
                if (key.equals(node.getKey())){
                    return  node.getValue();
                }
            }

        }
        return null;


    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<V> iterator() {
        return null;
    }


    // create nested class Node
    private class Node<K, V> {

        private final List<Node<K, V>> nodes;
        private int hash;
        private K key;
        private V value;

        //create constructor  of class Node
        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            nodes = new LinkedList<Node<K, V>>();
        }

        private List<Node<K, V>> getNodes() {
            return nodes;
        }

        // create method  calculations index of hashTable
        private int hash() {
            return hashCode() % hashTable.length;
        }

        //create getters & setters for Key & Value
        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        //Override my method hashCode()
        @Override
        public int hashCode() {
            hash = 37;
            hash = hash * 17 + key.hashCode();
            return hash;
        }

        //Override my method equals(Object obj
        @Override
        public boolean equals(Object obj) {
            //checking the links are the same
            if (this == obj)
                return true;
            // checking if objects belong to the same class
            if (obj instanceof Node) {
                Node<K, V> node = (Node<K, V>) obj;
                return (Objects.equals(key, node.getKey()) &&
                        Objects.equals(value, node.getValue()) ||
                        Objects.equals(hash, node.hashCode()));
            }

            return false;
        }
    }

}
