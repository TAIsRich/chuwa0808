import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetExerciseTest {

    public static void main(String[] args) {
        learn_Inserting_And_Retrieving_Removing(); 
    }
     /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    // @Test
    public static void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set= new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);

        Set<Integer> set2 = new HashSet<>();
        set2.addAll(set);
        set2.addAll(Arrays.asList(new Integer[]{4,5,6,7}));
        // System.out.println(set2);
        System.out.println(set2);

        System.out.println(set2.contains(2));
        set2.clear();
        System.out.println(set2);
        System.out.println(set2.isEmpty());
        
    }
}
