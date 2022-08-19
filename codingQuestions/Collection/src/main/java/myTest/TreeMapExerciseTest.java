package myTest;

import java.util.*;

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

    //@Test
    public static void learn_Inserting_And_Retrieving() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("a", 1);
        map.putIfAbsent("b", 2);
        TreeMap<String, Integer> map2 = new TreeMap<>();
        map2.putAll(map);
        System.out.println(map2);
        System.out.println(map.get("a"));
        System.out.println(map.getOrDefault("c", 0));
        System.out.println(map.containsKey("a"));
        System.out.println(map.containsValue(1));
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
    //@Test
    public static void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("a", 1);
        map.put("b", 1);
        map.replace("a", 1, 2);
        System.out.println(map);
        map.replace("a", 1);
        System.out.println(map);
        map.remove("a");
        System.out.println(map);
    }
}
