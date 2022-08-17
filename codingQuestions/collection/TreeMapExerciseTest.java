package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
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
        map.put("1",1);
        map.putIfAbsent("2",1);

        TreeMap<String, Integer> map2 = new TreeMap<>();
        map2.put("3",1);
        map.putAll(map2);

        map.get("1");
        map.firstKey();
        map.lastKey();

        map.containsKey("4");//false
        map.containsValue(2);//false

        Set<String> keySet = map.keySet();
        List<Integer> valueList = (List<Integer>) map.values();//need to cast as the returned type is a Collection
        map.isEmpty();

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
        map.replace("1", 1, 2);
        map.replace("1", 3);

        map.remove("1");
    }
}
