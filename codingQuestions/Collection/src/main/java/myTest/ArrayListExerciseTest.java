package myTest;

import java.util.*;

public class ArrayListExerciseTest {

    public static void main(String[] args) {
        //learn_Remove_Replacing_Updating();
        //learn_Iterator();
        learn_Sorting();
        //learn_Inserting_And_Retrieving();
        /**
        //new ArrayList()
        ArrayList<String> list = new ArrayList<String>();
        //add elements
        list.add("A");
        list.add("B");
        list.add("C");
        // get element
        String element = list.get(1);
        //get Size
        int size = list.size();
        //list.addAll(anotherList)
        List<Integer> l = new ArrayList<>();
        l.add(10);
        l.add(15);
        l.add(20);
        System.out.println(l);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(100);
        arr.add(200);
        arr.add(300);
        System.out.println(arr);
        l.addAll(arr);
        System.out.println(l);
        */
    }

    //@Test
    public static void learn_Inserting_And_Retrieving() {
        ArrayList<String> list = new ArrayList<String>();       //new ArrayList()
        list.add("a");                                          //add elements
        list.add("b");
        String element = list.get(0);                           //get element
        int size = list.size();                                 //get Size
        ArrayList<String> newList = new ArrayList<String>();
        newList.addAll(list);                                   //list.addAll(anotherList)
        System.out.println("first element: " + element);
        System.out.println("size: " + size);
        System.out.println("newList: " + newList);
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */

    //@Test
    public static void learn_Remove_Replacing_Updating() {
        List<String> list = new ArrayList<String>();       //new ArrayList()
        list.add("a");                                          //add elements
        list.add("b");
        list.add("c");
        list.add("d");
        list.remove(0); //remove(int index)
        list.remove("b"); //remove(Object o)
        System.out.println(list);
        //list.removeRange(0,1);
        List<String> newList = new ArrayList<>();
        newList.addAll(list);
        newList.add("a");
        newList.removeAll(list);
        System.out.println(newList);
        newList.clear();
        System.out.println(newList);

        list.set(0, "a");
        System.out.println(list);
        list.replaceAll((e) -> "b");
        System.out.println(list);

        System.out.println(list.contains("b") + ","+list.indexOf("b")+","+list.lastIndexOf("b"));
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    //@Test
    public static void learn_Iterator() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            it.remove();
            System.out.println(list);
        }

        list.add("c");
        list.add("d");
        it.forEachRemaining((e) -> System.out.println(e));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    //@Test
    public static void learn_Sorting() {
        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("a");

        Collections.sort(list);
        System.out.println(list);

        list.sort(Comparator.reverseOrder());
        System.out.println(list);

    }
}
