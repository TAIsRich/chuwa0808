package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
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
        map.put("1",1);
        map.putIfAbsent("2",1);

        Map<String, Integer> map2 = new HashMap<>();
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
        Map<String, Integer> map = new HashMap<>();
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
