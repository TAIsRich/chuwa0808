import java.util.LinkedList;

public class LinkedListExerciseTest {

    public static void main(String[] args) {
        learn_Inserting_And_Retrieving(); 
    }
    /**
     * e.g.
     * List<Integer> list = new LinkedList<Integer>();
     * Inserting:
     * add(E e) or addLast(E e)
     * addFirst(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addAll(int index, Collection c)
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    // @Test
    public static void learn_Inserting_And_Retrieving() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        System.out.println(list);
        System.out.println(list.get(0));

        System.out.println(list.getFirst());
        System.out.println(list.getLast());




    }


}
