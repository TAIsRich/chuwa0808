package collection;

import java.util.Set;

public class HashSet<S> {
    public static void main(String[] args) {
        //Set<Integer> set= new HashSet<>();
        HashSet<String> set = new HashSet<String>();

        // Use add() method to add elements into the Set
        set.add("Welcome");

        //get
        Set<String> hashSet = (Set<String>) new HashSet<>();
        hashSet.add("A");
        hashSet.add("B");


        // get A
        // we already have String "A"
        // so we just only need to check if "A" exists in HashSet
        System.out.println(set.contains("A")); // true

        // get D
        System.out.println(set.contains("D")); // false

        //isEmpty
        HashSet<String> set4 = new HashSet<String>();

        // Use add() method to add elements into the Set
        set4.add("Welcome");
        set4.add("To");
        set4.add("Geeks");
        set4.add("4");
        set4.add("Geeks");

        // Displaying the HashSet
        System.out.println("HashSet: " + set);

        // Check for the empty set
        System.out.println("Is the set empty: " + set.isEmpty());
    }

    private S isEmpty() {
        return null;
    }

    private boolean contains(S a) {
        return true;
    }


    private void add(S welcome) {
    }
}
