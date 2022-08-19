package myTest;

import java.util.*;

public class LinkedHashMapExerciseTest {
    public static void main(String[] args) {
        learn_Inserting_And_Retrieving();
        learn_Remove_Replacing_Updating();
    }

    /**
     * e.g.
     * HashMap<String, Integer> map = new LinkedHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * getOrDefault(Object key, V defaultValue)
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
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("a", 1);
        map.putIfAbsent("b", 2);
        HashMap<String, Integer> map2 = new LinkedHashMap<>();
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
     * replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
     *
     * remove(Object key)
     * remove(Object key, Object value)
     *
     * compute(Key, BiFunction)
     * computeIfAbsent(Key, Function)
     * computeIfPresent(Key, BiFunction)
     */
    //@Test
    public static void learn_Remove_Replacing_Updating() {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("a", 1);
        map.putIfAbsent("b", 2);
        map.replace("a", 1, 3);
        System.out.println(map);
        map.replace("a", 1);
        map.replaceAll((k,v)->v*v);
        System.out.println(map);
        map.put("a", 1);
        map.remove("a");
        System.out.println(map);
        map.compute("b", (k,v)-> v+10);
        System.out.println(map);
    }
}
