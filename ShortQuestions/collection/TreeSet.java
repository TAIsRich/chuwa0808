package collection;

import java.util.NavigableSet;

public class TreeSet<I extends Number> {
    public static void main(String[] args) {
        NavigableSet<String> ts = new java.util.TreeSet<>();

        // Elements are added using add() method
        ts.add("Geek");
        ts.add("For");
        ts.add("Geeks");

        // Printing the elements inside the TreeSet object
        System.out.println("Tree Set is " + ts);

        String check = "Geeks";

        // Check if the above string exists in
        // the treeset or not
        System.out.println("Contains " + check + " "
                + ts.contains(check));

        // Print the first element in
        // the TreeSet
        System.out.println("First Value " + ts.first());

        // Print the last element in
        // the TreeSet
        System.out.println("Last Value " + ts.last());

        String val = "Geek";

        // Find the values just greater
        // and smaller than the above string
        System.out.println("Higher " + ts.higher(val));
        System.out.println("Lower " + ts.lower(val));

        //
        NavigableSet<String> ts2 = new java.util.TreeSet<>();

        // Elements are added
        // using add() method
        ts2.add("hi");
        ts2.add("ni");
        ts2.add("xianzai");
        ts2.add("A");
        ts2.add("B");
        ts2.add("Z");
        ts2.remove("B");
        ts2.pollFirst();
        ts2.pollLast();
        System.out.println("After removing last " + ts2);

        //subSet
        TreeSet<Integer> sub_set = new TreeSet<Integer>();
        NavigableSet tree_set = null;
        sub_set = (TreeSet<Integer>)tree_set.subSet(6, 30);

    }
    }


