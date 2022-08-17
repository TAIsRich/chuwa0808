package collection;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @author Zhiyu Li
 * @date 08/14/22 9:00 PM
 */
public class TreeSetExerciseTest {
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

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {

        TreeSet<Integer> set= new TreeSet<>();
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.addAll(new TreeSet<>());
        if(set.contains(2)){
            System.out.println("True");
        }
        System.out.format("the first is %d \n", set.first());
        System.out.format("the last is %d \n", set.last());

        TreeSet<Integer> sub_set = new TreeSet<Integer>();
        sub_set = (TreeSet<Integer>)set.subSet(2,8);
        System.out.println(sub_set);


        sub_set = (TreeSet<Integer>)set.headSet(6);
        System.out.println(sub_set);

        sub_set = (TreeSet<Integer>)set.tailSet(6);
        System.out.println(sub_set);

        set.remove(Integer.valueOf(5));
        if(!set.isEmpty()){
            System.out.format("the size is %s \n", set.size() + "\nthe set:" + set );
        }

    }


}
