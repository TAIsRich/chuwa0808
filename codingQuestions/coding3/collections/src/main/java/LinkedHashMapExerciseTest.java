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
        map.put("hello", 2);
        map.putIfAbsent("world", 3);
        map.putAll(new HashMap<>());
        int value = map.get("hello");
        int value2 = map.getOrDefault("mario", 2);
        boolean a = map.containsKey("super");
        boolean b = map.containsValue(3);
        Set<String> set = map.keySet();
        Collection<Integer> list = map.values();
        boolean c = map.isEmpty();
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
        map.put("hello", 2);
        map.putIfAbsent("world", 3);
        map.replace("hello", 3, 2);
        map.replace("world", 2);
        map.replaceAll((key, oldValue)
                -> oldValue + 1);

        map.remove("hello");
        map.remove("hello", 2);
        map.put("hello", 4);
        map.compute("hello", (key, oldValue)
                -> oldValue + 1);
        map.computeIfAbsent("hello", oldValue
                -> Integer.valueOf(oldValue + 1));
        map.computeIfPresent("hello", (key, oldValue)
                -> oldValue + 1);
    }
}
