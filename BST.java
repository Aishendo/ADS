import java.util.Iterator;
import java.util.Queue;

public class BST<K extends Comparable<K>,V> implements Iterable<K> {
    private Node root;

    private class Node {
        public Object length;
        private K key;
        private V value;
        private Node left, right;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int length;

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node curs, K key, V value) {
        if (curs == null) {
            length++;
            return curs;
        }
        int compres = key.compareTo(curs.key);
        if (compres > 0) curs.right = put(curs.right, key, value);
        curs.length = curs.right.length + 1;
        else if (compres < 0) curs.left = put(curs.left, key, value);
        curs.length = curs.left.length + 1;
        else System.out.println("ok");
        return curs;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node curs, K key) {
        if (curs == null)
            return null;
        if (curs.key.compareTo(key) == 0)
            return curs.value;
        if (curs.key.compareTo(key) > 0)
            return get(curs.left, key);
        return get(curs.right, key);
    }

    private Node delete(Node curs, K key) {
        if (curs == null) return curs;

        int compres = key.compareTo(curs.key);

        if (compres < 0) curs.left = delete(curs.left, key);
        else if (compres > 0) curs.right = delete(curs.right, key);
        else {
            if (curs.left == null) return curs.right;
            else if (curs.right == null) return curs.left;

            curs.key = minN(curs.right); //as shown on practice, tnx for idea
            curs.right = delete(curs.right, curs.key);
        }
        return curs;
    }

    private K minN(Node curs) {
        K min = (K) curs.key;
        while (curs.left != null) {
            min = (K) curs.left.key;
            curs = curs.left;
        }
        return min;
    }

    public Iterable<K> keys() {
        Queue<K> q = new Queue<K>() {

            @Override
            public K remove() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public Iterator<K> iterator() {
                return null;
            }
        }
    }
    public Iterator<K> iterator() {
        Iterator<K> I = (Iterator<K>) keys();
        return (Iterable<K>) I;
    }
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node curs){
        if (curs != null){
            inOrder(curs.left);

            System.out.println(curs);

            inOrder(curs.right);
        }
    }

}

