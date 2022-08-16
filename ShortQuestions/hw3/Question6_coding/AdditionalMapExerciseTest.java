package org.example;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
        HashMap<String, Integer> h_map = new HashMap<>();
        h_map.put("second", 2);

        map.put("first", 1);
        map.putIfAbsent("first", 1);
        map.putAll(h_map);
        System.out.println(map.toString());
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

        map.put(DayOfWeek.TUESDAY, 2);
        map.putIfAbsent(DayOfWeek.MONDAY, 1);
        System.out.println(map.toString());
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
        EnumMap<DayOfWeek, Integer> map = new EnumMap<>(DayOfWeek.class);

        map.put(DayOfWeek.TUESDAY, 2);
        map.putIfAbsent(DayOfWeek.MONDAY, 1);
        System.out.println(map.toString());
    }
}
