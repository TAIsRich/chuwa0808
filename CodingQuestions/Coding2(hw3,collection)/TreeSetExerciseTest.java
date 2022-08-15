import java.util.Set;
import java.util.TreeSet;

public class TreeSetExerciseTest {

    public static void main(String[] args) {
        learn_Inserting_And_Retrieving_Removing(); 
    }

     /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    // @Test
    public static void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set= new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(1);

        System.out.println(set);
        System.out.println(set.contains(new Integer(1)));
        System.out.println(set.size());
        System.out.println(set.isEmpty());





    }
}
