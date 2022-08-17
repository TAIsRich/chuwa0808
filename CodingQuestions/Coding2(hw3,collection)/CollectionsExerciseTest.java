import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionsExerciseTest {
    public static void main(String[] args) {
        // learn_common_collections_operations();
        learn_thread_safe_ArrayList();
    }
     /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    // @Test
    public static void learn_common_collections_operations() {
        List<Integer> list = new LinkedList<Integer>();
            list.add(-1);
            list.add(4);
            list.add(-5);
            list.add(1);
            list.add(1);
            list.add(1);
            System.out.println("Max value is: "
                               + Collections.max(list));
        
        System.out.println("Min value is: " + Collections.min(list));

        System.out.println("The frequency of the int 1 is: "+ 
                                Collections.frequency(list, 1));                        
    }

    /**
     * synchronizedList()
     */

    // @Test
    public static void learn_thread_safe_ArrayList() {
        // creating object of List<String>
        List<String> list = new ArrayList<String>();
  
        // populate the list
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        // printing the Collection
        System.out.println("List : " + list);

        // create a synchronized list
        List<String> synlist = Collections
                                   .synchronizedList(list);

        // printing the Collection
        System.out.println("Synchronized list is : " + synlist);
    }
}
