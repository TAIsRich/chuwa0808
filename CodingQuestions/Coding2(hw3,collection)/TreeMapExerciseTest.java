import java.util.TreeMap;

public class TreeMapExerciseTest {
    public static void main(String[] args) {
        learn_Inserting_And_Retrieving(); 
    }
    /**
     * e.g.
     * TreeMap<String, Integer> map = new TreeMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * firstKey()
     * lastKey()
     *
     * containsKey(Object key)
     * containsValue(Object value)
     *
     * keySet()
     * values()
     * isEmpty()
     */

    // @Test
    public static void learn_Inserting_And_Retrieving() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);
        // map.put("null", 1);

        System.out.println(map);
        System.out.println(map.get("key1"));

        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.isEmpty());
        




    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {

    }
}
