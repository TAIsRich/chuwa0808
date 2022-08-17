package collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author Zhiyu Li
 * @date 08/14/22 9:00 PM
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
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();

        map.replace("Key", 2, 1);
        map.replace("Key", 1);


        map.remove(Integer.valueOf(1));

    }
}
