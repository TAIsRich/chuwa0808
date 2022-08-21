package collection;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Flora Zhong
 * @date 8/14/22
 */

public class TreeMapExerciseTest {

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
    @Test
    public void learn_Inserting_And_Retrieving() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("key1", 1);
        map.putIfAbsent("key1", 6);
        map.putIfAbsent("key2", 2);
        System.out.println("the original map: " + map);

        TreeMap<String, Integer> subMap = new TreeMap<>();
        subMap.put("key3", 3);
        subMap.put("key6", 6);
        map.putAll(subMap);
        System.out.println("the current map: " + map);

        int val1 = map.get("key1");
        int val2 = map.getOrDefault("key", 0);

        if (map.containsKey("key1")) {
            System.out.println(val1 + " " + val2);
        }
        if (map.containsValue(1)) {
            System.out.println(val1 + " " + val2);
        }

        String firstKey = map.firstKey();
        String lastKey = map.lastKey();
        System.out.println("the first key: " + firstKey);
        System.out.println("the last key: " + lastKey);

        Map.Entry<String, Integer> firstEntry = map.firstEntry();
        Map.Entry<String, Integer> lastEntry = map.lastEntry();
        System.out.println("the first entry: " + firstEntry);
        System.out.println("the last entry: " + lastEntry);

        map.pollFirstEntry();
        map.pollLastEntry();
        System.out.println("the current map: " + map);

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
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        Map<String, Integer> map = new TreeMap<>();
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
    }
}
