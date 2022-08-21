package collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Flora Zhong
 * @description get, put, containsKey and remove method cost O(1) like HashMap
 *              an additional feature is maintaining an order of elements inserted into LinkedHashMap
 * @date 8/14/22
 */

public class LinkedHashMapExerciseTest {

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
    @Test
    public void learn_Inserting_And_Retrieving() {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("key1", 1);
        map.putIfAbsent("key1", 6);
        map.putIfAbsent("key2", 2);
        System.out.println("the original map: " + map);

        HashMap<String, Integer> subMap = new LinkedHashMap<>();
        subMap.put("apple", 1);
        subMap.put("orange", 6);
        map.putAll(subMap);
        System.out.println("the current map after inserting: " + map);

        int val1 = map.get("orange");
        int val2 = map.getOrDefault("banana", 0);

        if (map.containsKey("orange")) {
            System.out.println(val1 + " " + val2);
        }
        if (map.containsValue(6)) {
            System.out.println(val1 + " " + val2);
        }

        if (!map.isEmpty()) {
            for (String key : map.keySet()) {
                System.out.println(map.get(key));
            }
            System.out.println(map.keySet());

            for (int val : map.values()) {
                System.out.println(val);
            }
            System.out.println(map.values());
        }
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
    @Test
    public void learn_Remove_Replacing_Updating() {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.replace("key", 1, 2);
        map.replace("key", 6);
        System.out.println("the current map: " + map);

        map.put("key", 1);
        map.replace("key", 1, 2);
        System.out.println("the current map: " + map);

        map.replace("key", 6);
        System.out.println("the current map: " + map);

        map.put("key1", 66);
        map.remove("key");
        System.out.println("the current map: " + map);

        map.remove("key2");
        System.out.println("the current map: " + map);

        map.remove("key1", 1);
        System.out.println("the current map: " + map);

        map.remove("key1", 66);
        System.out.println("the current map: " + map);

        // compute method can change value but not key
        map.put("orange", 6);
        map.compute("orange", (key, val) -> val == null? 0 : val + 1);
        System.out.println("the current map: " + map);
        map.compute("apple", (key, val) -> val == null? 0 : val + 1);
        System.out.println("the current map: " + map);

        map.computeIfAbsent("peach", val -> Integer.valueOf(1));
        System.out.println("the current map: " + map);
        map.computeIfAbsent("orange", val -> Integer.valueOf(1));
        System.out.println("the current map: " + map);

        map.computeIfPresent("orange", (key, val) -> val + 2);
        System.out.println("the current map: " + map);
        map.computeIfPresent("grape", (key, val) -> val + 2);
        System.out.println("the current map: " + map);
    }
}
