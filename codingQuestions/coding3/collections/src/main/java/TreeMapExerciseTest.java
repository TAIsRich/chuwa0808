import org.junit.Test;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class TreeMapExerciseTest {
    TreeMap<String, Integer> map = new TreeMap<>();
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
        map.put("hello", 2);
        map.putIfAbsent("world", 2);
        map.putAll(new HashMap<>());

        map.get("hello");
        String s = map.firstKey();
        String d = map.lastKey();

        boolean a = map.containsKey("hello");
        boolean b = map.containsValue(2);

        map.keySet();
        map.values();
        map.isEmpty();
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        map.put("hello", 2);
        map.putIfAbsent("world", 2);

        map.replace("hello", 2, 3);
        map.replace("world", 3);

        map.remove("hello");
    }
}
