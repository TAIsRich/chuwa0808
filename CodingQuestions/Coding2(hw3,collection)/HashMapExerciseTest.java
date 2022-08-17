import java.util.HashMap;
import java.util.Map;

public class HashMapExerciseTest {
    
    public static void main(String[] args) {
        // learn_Inserting_And_Retrieving();
        learn_Remove_Replacing_Updating(); 
    }
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

    // @Test
    public static void learn_Inserting_And_Retrieving() {
        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.putIfAbsent("key2", 2);
        System.out.println(map);
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.putAll(map);
        System.out.println(map2);

        System.out.println(map2.get("key1"));
        System.out.println(map2.getOrDefault("key4",4));
        
        System.out.println(map2.containsKey("key4"));
        System.out.println(map2.containsValue(2));

        System.out.println(map2.keySet());
        System.out.println(map2.values());
        System.out.println(map2.isEmpty());


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
    // @Test
    public static void learn_Remove_Replacing_Updating() {
        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.putIfAbsent("key2", 2);

        map.replace("key1", 1, 11111);
        map.replace("key1", 1111);
        map.put("key1", 1);
        map.replaceAll((k,v)->v*v);
        System.out.println(map);

        // map.put("key1", 1);
        // map.remove("key1");
        System.out.println(map);

        map.compute("key1", (k,v)-> v+10);
        System.out.println(map);

    }
}
