package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, Integer> map2 = new HashMap<>();
        map.put("first", 1);
        map.putIfAbsent("second", 2);
        map2.putAll(map);

        System.out.println("should be 1: " + map.get("first"));
        System.out.println("should be 2: " + map.getOrDefault("second", 1));
        System.out.println("should be true: " + map.containsKey("first"));
        System.out.println("should be true: " + map.containsValue(1));

        System.out.println("loop through keyset");
        for(String i: map.keySet()){
            System.out.println(i);
        }

        System.out.println("loop through values");
        for(Integer i: map.values()){
            System.out.println(i);
        }

        System.out.println("should be false: " + map.isEmpty());
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
        Map<String, Integer> map2 = new HashMap<>();
        map.put("first", 1);
        map.put("second", 2);
        map.put("third", 3);
        map2.put("first", 1);
        map2.put("second", 2);
        map2.put("third", 3);

        map.replace("second", 2,4);
        map.replace("third", 5);
        System.out.println(map.toString());

        map.replaceAll((key, oldValue) -> oldValue+1);
        System.out.println(map.toString());

        map.remove("first");
        map.remove("second",5);
        System.out.println(map.toString());

        map.compute("third", (key,val) -> val+1);
        map.computeIfAbsent("first", val -> 1);
        map.computeIfPresent("second", (key,val) -> 2);
        System.out.println(map.toString());
    }
}
