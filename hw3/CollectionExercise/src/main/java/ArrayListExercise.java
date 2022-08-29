import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.sort;

public class ArrayListExercise {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        System.out.println(lst.get(0));
        System.out.println(lst.size());
        lst.addAll(Arrays.asList(1,2,3));
        System.out.println(lst);
        sort(lst);
        System.out.println(lst);

        lst.add(0);
        Collections.sort(lst);
        System.out.println(lst);
    }
}
