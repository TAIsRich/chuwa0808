package collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Flora Zhong
 * @date 8/14/22
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

    /**
     HashMap is a Class under the Traditional Collections; ConcurrentHashMap is a Class under the Concurrent Collections
     HashMap is non-synchronized in nature, i.e. HashMap is not thread-safe; ConcurrentHashMap is thread-safe in nature
     HashMap performance is relatively high because it is non-synchronized in nature, and any number of threads can perform simultaneously; ConcurrentHashMap performance is low sometimes because threads are required to wait on ConcurrentHashMap sometimes
     while one thread is iterating the HashMap object, if the other threads are trying to add/modify the contents of the HashMap object, a runtime exception: ConcurrentModificationException will be thrown; for a ConcurrentHashMap object, we will not get any exception in the same situation
     **/
    @Test
    public void learn_ConcurrentHashMap() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("key1", 1);
        map.putIfAbsent("key1", 2);
        map.putIfAbsent("key2", 2);

        ConcurrentHashMap<String, Integer> newMap = new ConcurrentHashMap<>();
        newMap.putAll(map);

        System.out.println("the origin concurrent hashmap is \n" + map);
        System.out.println("\nthe new ConcurrentHashMap is \n" + newMap + "\n\n----------------------------------------\n");
    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */

    /**
     * IdentityHashMap implements Map interface using Hashtable, using reference-equality in place of object-equality when comparing keys (and values).
     * This class is not a general-purpose Map implementation. While this class implements the Map interface, it intentionally violates the Map’s general contract, which mandates the use of the equals() method when comparing objects. This class is used when the user requires the objects to be compared via reference.
     * It belongs to java.util package.
     *
     * Features of IdentityHashMap:
     * provide constant-time performance for the basic operations such as put, remove, contain and get, assuming the system identity hash function (System.identityHashCode(Object)) disperses elements properly among the buckets
     * IdentityHashMap does not use hashCode() method, instead it uses System.identityHashCode() method, this is a significant difference because now you can use mutable objects as key in a map whose hash code is likely to change when the mapping is stored inside IdentityHashMap
     * follow the reference-equality using == operator, instead of using the equals() method
     * non-synchronized and must be synchronized externally
     * iterators are fail-fast, and throw ConcurrentModificationException in an attempt to modify while iterating
     */
    @Test
    public void learn_IdentityHashMap() {
        Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
        map.put(DayOfWeek.MONDAY, 1);
        map.putIfAbsent(DayOfWeek.MONDAY, 2);
        map.put(DayOfWeek.SATURDAY, 6);
        System.out.println("the identity hashmap is " + map + "\n\n----------------------------------------\n");
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    // EnumMap is a map implementation which exclusively takes Enum as its keys
    public void learn_EnumMap() {
        // enum: a special class containing a fixed set of constants, these constants are static and final implicitly
        //       the type of these constants is this enum itself, such as DayOfWeek here
        // create an empty EnumMap object making key as enum state (key为枚举状态), such as DayOfWeek here
        // DayOfWeek是一个enum, DayOfWeek.Monday...是DayOfWeek类型的
        // key order in a EnumMap object ia same as the nature order of the enum
        EnumMap<DayOfWeek, Integer> map = new EnumMap<> (DayOfWeek.class);
        map.putIfAbsent(DayOfWeek.SATURDAY, 6);
        map.put(DayOfWeek.TUESDAY, 2);
        map.putIfAbsent(DayOfWeek.TUESDAY, 6);
        System.out.println("the enum map is " + map + "\n\n----------------------------------------\n");
    }
}
