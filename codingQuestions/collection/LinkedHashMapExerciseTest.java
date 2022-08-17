package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
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
        map.put("1",1);
        map.putIfAbsent("2",1);

        Map<String, Integer> map2 = new LinkedHashMap<>();
        map2.put("3",1);
        map.putAll(map2);

        map.get("1");
        map.getOrDefault("2", 0);

        map.containsKey("4");//false
        map.containsValue(2);//false

        Set<String> keySet = map.keySet();
        List<Integer> valueList = (List<Integer>) map.values();//need to cast as the returned type is a Collection
        map.isEmpty();

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
        map.put("1",1);
        map.putIfAbsent("2",1);

        map.replace("1", 1, 2);
        map.replaceAll((key, oldValue) -> oldValue + 1);

        map.remove("1");
        map.remove("1", 1);

        //need to review the following methods as still not familiar with them
        map.compute("1", (key, oldValue) -> oldValue + 1);
        map.computeIfAbsent("1", oldValue -> Integer.valueOf(oldValue) + 1);
        map.computeIfPresent("1", (key, oldValue) -> oldValue + 1);

    }
}
