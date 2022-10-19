import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MyHashMap<K, V> {
    private int size;
    private LinkedList<Node>[] myMap;
    private final static int DEFAULT_SIZE = 8;
    private final static double LOAD_FACTOR = 2;
    private final static double THRESHOLD = 0.75;
    private boolean isResizeable;
    private final static int MAX_CAPACITY = 128;


    class Node<K, V>{
        K key;
        V val;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * 1. capacity
     * 2. resize(No capacity para)
     * 3. load factor 0.75 , size >= 0.75 * default -> double capacity
     * 4. 0.75 threshold
     * 5. capacity can not add node if the size is
     * 6. 128 max capacity
     */
    MyHashMap() {
        size = 0;
        myMap = new LinkedList[DEFAULT_SIZE];
        isResizeable = true;
    }
    MyHashMap(int capacity) {
        size = 0;
        myMap = new LinkedList[capacity];
        isResizeable = false;
    }

    /**
     *  CRUD
     *  1. Create
     *  2. Read
     *  3. Update
     *  4. Delete(by key)
     *  5. ContainsKey()
     *  6. size()
     *  7. entrySet()
     *
     */

    /**
     * get method
     *  retrieve value by key
     */
    public V get(K key) {
        int idx = getHashCode(key);
        LinkedList<Node> target = find(idx);
        if (target == null) return null;
        Node rst = findValue(key, target);
        return rst == null ? null : (V) rst.val;
    }

    /**
     * put method
     *  put key-value pair into map
     */
    public boolean put(K key, V val) {
        int idx = getHashCode(key);
        LinkedList<Node> target = find(idx);
        if (target == null) {

            myMap[idx] = new LinkedList<>();
            myMap[idx].add(new Node(key, val));
            size++;
            return true;
        }
        Node node = findValue(key, target);
        if (node == null) {
            if (!resize()) return false;
            target.add(new Node(key, val));
            size++;
        } else node.val = val;
        return true;
    }

    public boolean delete(K key) {
        int idx = getHashCode(key);

        LinkedList<Node> target = find(idx);
        if (target == null) return true;
        for (int i = 0; i < target.size(); i++) {
            if (target.get(i).key.equals(key)) {
                target.remove(i);
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(K key) {
        int idx = getHashCode(key);
        LinkedList<Node> target = myMap[idx];
        if (target == null) return false;
        Node node = findValue(key, target);
        return node == null ? false : true;
    }

    public int size() {
        return size;
    }

    public Set<Node> entrySet() {
        Set<Node> rst = new HashSet<>();
        for (int i = 0; i < myMap.length; i++) {
            LinkedList<Node> cur = myMap[i];
            if (cur != null) {
                for (Node node : cur) {
                    rst.add(node);
                }
            }
        }
        return rst;
    }

    /**
     * 读取input key对应的hash code
     * @param key
     * @return
     */
    private int getHashCode(K key) {
        // 取余数
        if (isResizeable) return (Integer) key % DEFAULT_SIZE;
        return (Integer) key % myMap.length;
    }

    private LinkedList<Node> find(int idx) {
        return myMap[idx];
    }

    private Node findValue(K key, LinkedList<Node> target) {
        for (Node node : target) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    private boolean resize() {
        if (isResizeable) {
            if (1.0 * size >= THRESHOLD * myMap.length) {
                increaseCapacity((int) (myMap.length * LOAD_FACTOR));
            }
            return true;
        }
        return size >= myMap.length ? false : true;
    }

    public void increaseCapacity(int length) {
        if (length >= MAX_CAPACITY) return;
        final LinkedList<Node>[] oldMap = myMap;
        myMap = new LinkedList[length];
        size = 0;
        for (LinkedList<Node> list : oldMap) {
            if (list != null) {
                for (Node node : list) {
                    if (node != null) {
                        put((K) node.key, (V)node.val);
                    }
                }
            }
        }
    }
}
