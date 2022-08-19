import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

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

        map.put("first", 1);
        map.putIfAbsent("second", 2);
        map.putAll(new HashMap<>());

        map.get("first");
        map.getOrDefault("third", 3);

        map.containsKey("first");
        map.containsValue(1);

        map.keySet();
        map.values();
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
        map.put("first", 1);

        map.replace("first", 1, 11);
        map.replace("first", 11);
        map.replaceAll((k,v) -> v+1);

        map.remove("first");
        map.remove("first", 1);

        map.compute("first", (k,v) -> v+1);
        map.computeIfAbsent("first", v -> 2);
        map.computeIfPresent("first", (k,v) -> v+1);
    }
}
