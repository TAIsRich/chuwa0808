package collection;



public class LinkedHashMap<S, S1> {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> li_hash_map
                = new LinkedHashMap<Integer, String>();

        // Mapping string values to int keys
        // using put() method
        li_hash_map.put(10, "Geeks");
        li_hash_map.put(15, "4");
        li_hash_map.put(20, "Geeks");
        li_hash_map.put(25, "Welcomes");
        li_hash_map.put(30, "You");

        // Printing all elements of LinkedHashMap
        System.out.println("Initial Mappings are: "
                + li_hash_map);

        // Getting the value of 25
        System.out.println("The Value is: "
                + li_hash_map.get(25));

        //remove
        li_hash_map.remove(20);



    }

    private void remove(S i) {
    }

    private S1 get(S i) {
        return null;
    }

    private void put(S i, S1 geeks) {
    }
}
