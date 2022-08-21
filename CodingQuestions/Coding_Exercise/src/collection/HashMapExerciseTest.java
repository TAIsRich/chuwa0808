package collection;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Flora Zhong
 * @description compute(), computeIfAbsent(), computeIfPresent() can change value but not key
 * @date 8/14/22
 */

public class HashMapExerciseTest {

    /**
     * e.g.
     * Map<String, Integer> map = new HashMap<>();
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
        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.putIfAbsent("key1", 6);
        System.out.println("the original map: " + map);

        Map<String, Integer> subMap = new HashMap<>();
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
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("peach", 2);
        map.put("orange", 6);
        System.out.println("the original map: " + map);

        map.replace("peach", 2, 5);
        System.out.println("the current map after replace(peach, 1, 5): " + map);

        map.replace("peach", 57);
        System.out.println("the current map after replace(peach, 57): " + map);

        map.replaceAll((key, val) -> val + 1);
        System.out.println("the current map after replaceAll((key, val) -> val + 1): " + map);

        map.replaceAll((key, val) -> 66);
        System.out.println("the current map after replaceAll((key, val) -> 66): " + map);

        map.remove("peach");
        map.remove("apple", 66);
        System.out.println("the current map after deleting: " + map);

        map.remove("peach");
        map.remove("orange", 16);
        System.out.println("the current map after deleting: " + map);

        // compute method can change value but not key
        map.compute("orange", (key, val) -> val == null? 0 : val + 1);
        System.out.println("the current map: " + map);
        map.compute("apple", (key, val) -> val == null? 0 : val + 1);
        System.out.println("the current map: " + map);

        map.computeIfAbsent("peach", val -> Integer.valueOf(1));
        System.out.println("the current map: " + map);
        map.computeIfAbsent("orange", val -> Integer.valueOf(1));
        System.out.println("the current map: " + map);

        map.computeIfPresent("orange", (key, val) -> val + 1);
        System.out.println("the current map: " + map);
        map.computeIfPresent("grape", (key, val) -> val + 1);
        System.out.println("the current map: " + map);
    }
}
