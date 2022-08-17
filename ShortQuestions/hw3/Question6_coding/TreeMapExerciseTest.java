package org.example;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

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
        TreeMap<String, Integer> map2 = new TreeMap<>();
        map.put("first", 1);
        map.put("second", 2);
        map.put("third", 3);

        map.putIfAbsent("fourth" , 4);
        map2.putAll(map);
        System.out.println(map2.toString());

        System.out.println("should be second" + map2.get("second"));
        System.out.println("FIRST KEY: " + map2.firstKey());
        System.out.println("LAST KEY: " + map2.lastKey());
        System.out.println("should be true: " + map2.containsKey("first"));
        System.out.println("should be true: " + map2.containsValue(1));

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
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();
        TreeMap<String, Integer> map2 = new TreeMap<>();

        map.put("first", 1);
        map.put("second", 2);
        map.put("third", 3);

        map.replace("first" , 1, 11);
        map.replace("second" , 22);
        map.remove("third");
        System.out.println(map.toString());
    }
}
