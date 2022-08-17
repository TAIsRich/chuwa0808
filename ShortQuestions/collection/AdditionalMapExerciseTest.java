package collection;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AdditionalMapExerciseTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        // put(K key, V value)
        map.put("xiaoyi",23);
        //putIfAbsent(K key, V value)


        //putAll(Map<? extends K, ? extends V> m)
        ConcurrentHashMap<Integer, String> chm =
                new ConcurrentHashMap<Integer, String>();
        chm.put(100, "Geeks");
        chm.put(101, "for");
        chm.put(102, "Geeks");
        chm.put(103, "Gfg");
        chm.put(104, "GFG");

        // Displaying the existing HashMap
        System.out.println("Initial Mappings are: "
                + chm);

        ConcurrentHashMap<Integer, String> new_chm =
                new ConcurrentHashMap<Integer, String>();
        new_chm.putAll(chm);

        // Displaying the new map
        System.out.println("New mappings are: "
                + new_chm);
    }

    public void learn_IdentityHashMap() {
        Map<String, Integer> identityHashMap = new IdentityHashMap<>();
        //put(K key, V value)
        identityHashMap.put(new String("one"),1);
        identityHashMap.put(new String("one"),2);
        System.out.println("identityHashMap");


        //putIfAbsent(K key, V value)


    }

    public enum gfg {
        Global_today,
        India_today,
        China_today
    }


    public void learn_EnumMap() {
        // put(K key, V value)
        EnumMap<gfg, Integer> mp = new
                EnumMap<gfg, Integer>(gfg.class);

        // Values are associated
        mp.put(gfg.Global_today, 799);
        mp.put(gfg.India_today, 69);

        // Display the initial map
        System.out.println("The map is: " + mp);

        // Stores the old value associated with the key
        int prev_value = mp.put(gfg.India_today, 72);

        // Prints the old value
        System.out.println("Previous value: " + prev_value);

        // Display the final map
        System.out.println("The final map is: " + mp);
    }

}




