package com.chuwa.exercise.collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class AdditionalMapExerciseTest {

    /**
     * e.g.
     * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     */
    @Test
    public void learn_ConcurrentHashMap() {

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("1",1);
        map.putIfAbsent("2",1);

        TreeMap<String, Integer> map2 = new TreeMap<>();
        map2.put("3",1);
        map.putAll(map2);//ConcurrentHashMap can also add other types of map

    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {

        Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
        map.put(DayOfWeek.FRIDAY, 6);
        map.putIfAbsent(DayOfWeek.SATURDAY, 7);

    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY, 2);
        enumMap.putIfAbsent(DayOfWeek.TUESDAY, 3);

    }
}
