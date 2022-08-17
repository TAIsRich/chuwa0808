package collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhiyu Li
 * @date 08/14/22 9:00 PM
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
        map.put("key", 1);
        map.putIfAbsent("key", 2);
        map.putAll(new HashMap<>());

        int val = map.get("key");
        int val2 = map.getOrDefault("key", 0);

        if(map.containsKey("key")){
            System.out.println(val + " " + val2);
        }
        if(map.containsValue(1)){
            System.out.println(val + " " + val2);
        }

        if(!map.isEmpty()){
            System.out.println(map.keySet());
            System.out.println(map.values());
        }


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

        map.replace("Key", 2, 1);
        map.replace("Key", 1);
        map.replaceAll((key, Value) -> Value + 1);

        map.remove(1);
        map.remove("1", 2);

        map.compute("1", (key, val) -> (val == null) ? 1 : val + 1);

        map.computeIfAbsent("key2", k -> Integer.valueOf("2"));

        map.computeIfPresent("1", (key, val) -> val + 1);
    }
}
