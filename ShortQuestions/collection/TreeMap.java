package collection;

public class TreeMap<I extends Number, S> {
    public static void main(String[] args) {
        //put //get
        TreeMap<Integer, String> tree_map = new TreeMap<Integer, String>();
        tree_map.put(10, "Geeks");
        tree_map.put(15, "4");
        System.out.println("The Value is: " + tree_map.get("Geeks"));

        //firstkey
        TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();
        // populating tree map
        treemap.put(2, "two");
        treemap.put(1, "one");
        treemap.put(3, "three");
        treemap.put(6, "six");
        treemap.put(5, "five");

        treemap.put(25, "Welcomes");

        //containsKey
        System.out.println("Is the key 'Welcomes' present? " +
                tree_map.containsKey("Welcomes"));
        
        //replace
        treemap.replace("six",100);

        System.out.println("Checking first key");
        System.out.println("First key is: "+ treemap.firstKey());

        //replace



    }

    private void replace(S six, I i) {
    }

    private S containsKey(S welcomes) {

        return welcomes;
    }

    private S firstKey() {
        return null;
    }

    private S get(S geeks) {
        return geeks;
    }

    private void put(int i, String geeks) {
    }
}
