import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class HashMapExerciseTest {
    Map<String, Integer> map = new HashMap<>();
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
        map.put("price", 3);
        map.putIfAbsent("applePrice", 3);
        HashMap<String, Integer> test = new HashMap<>();
        map.putAll(test);
        int a = map.get(2);
        int value = map.getOrDefault("price", 0);
        boolean b = map.containsKey(" ");
        boolean c = map.containsValue(3);
        Set<String> s = map.keySet();
        Collection<Integer> values = map.values();
        boolean d = map.isEmpty();
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
        map.put("price", 3);
        map.putIfAbsent("applePrice", 3);
        map.replace("price", 3, 4);
        map.replace("price", 3);
        map.replaceAll((key, oldValue)
                -> oldValue + 1);

        int a = map.remove("price");
        map.remove("applePrice", 3);
        map.compute("price", (key, oldValue)
                -> oldValue + 1);
        map.computeIfAbsent("price", oldValue
                -> Integer.valueOf(oldValue + 1));
        map.computeIfPresent("price", (key, oldValue)
                -> oldValue + 1);
    }
}
