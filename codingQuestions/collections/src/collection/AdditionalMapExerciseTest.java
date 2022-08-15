package collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Zhiyu Li
 * @date 08/14/22 9:00 PM
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
    HashMap is the Class which is under Traditional Collection and ConcurrentHashMap is a Class which is under Concurrent Collections,
     apart from this there are various differences between them which are:

    -HashMap is non-Synchronized in nature i.e. HashMap is not Thread-safe whereas ConcurrentHashMap is Thread-safe in nature.

    -HashMap performance is relatively high because it is non-synchronized in nature and any number of threads can perform simultaneously.
     But ConcurrentHashMap performance is low sometimes because sometimes Threads are required to wait on ConcurrentHashMap.

    -While one thread is Iterating the HashMap object, if other thread try to add/modify the contents of Object then we will get Run-time exception saying
     ConcurrentModificationException.Whereas In ConcurrentHashMap we wont get any exception while performing any modification at the time of Iteration.
     **/

    @Test
    public void learn_ConcurrentHashMap() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("key", 1);
        map.putIfAbsent("key", 2);
        map.putIfAbsent("key2", 2);
        ConcurrentHashMap<String, Integer> new_map = new ConcurrentHashMap<>();
        new_map.putAll(map);

        System.out.println("the origin ConcurrentHashMap is" + map + "\n\n-------The new ConcurrentHashMap---------\n");
        System.out.println("the new ConcurrentHashMap is" + new_map + "\n\n----------------------------------------\n");

    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */


    /**
     * The IdentityHashMap implements Map interface using Hashtable, using reference-equality in place of object-equality when comparing keys (and values).
     * This class is not a general-purpose Map implementation. While this class implements the Map interface, it intentionally violates Map’s general contract,
     * which mandates the use of the equals() method when comparing objects. This class is used when the user requires the objects to be compared via reference.
     * It belongs to java.util package.
     *
     * Features of IdentityHashMap:
     *
     * -It follows reference equality, instead of using the equals() method it uses the == operator.
     * -It is not synchronized and must be synchronized externally.
     * -Iterators are fail-fast, throw ConcurrentModificationException in an attempt to modify while iterating.
     * -This class provides constant-time performance for the basic operations (get and put), assuming the system identity hash function (System.identityHashCode(Object))
     * disperses elements properly among the buckets. IdentityHashMap doesn’t use hashCode() method instead it uses System.identityHashCode() method.
     * This is a significant difference because now you can use mutable objects as key in Map whose hash code is likely to change when the mapping is stored inside IdentityHashMap.
     */

    @Test
    public void learn_IdentityHashMap() {
        Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
        map.put(DayOfWeek.MONDAY, 1);
        map.putIfAbsent(DayOfWeek.MONDAY,7);
        map.putIfAbsent(DayOfWeek.SUNDAY,7);
        System.out.println("the IdentityHashMap is" + map + "\n\n----------------------------------------\n");
    }


    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */


    //EnumMap is a Map implementation that exclusively takes Enum as its keys.
    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.TUESDAY, 2);
        enumMap.putIfAbsent(DayOfWeek.TUESDAY, 6);
        enumMap.putIfAbsent(DayOfWeek.SATURDAY, 6);
        System.out.println("the EnumMap is" + enumMap + "\n\n----------------------------------------\n");
    }
}
