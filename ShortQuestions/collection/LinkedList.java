package collection;

import java.util.Iterator;

public class LinkedList<S> {
    public static void main(String[] args) {
        //List<Integer> list = new LinkedList<Integer>();

        LinkedList<String> list = new LinkedList<String>();

        //Adding elements to the Linked list
        list.add("Steve");
        list.add("Carl");
        list.add("Raj");

        //Adding an element to the first position
        list.addFirst("xiaoyi");

        //Adding an element to the last position
        list.addLast("chen");

        //Adding an element to the 3rd position
        list.add("summer");

        //Iterating LinkedList
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //getLast
        LinkedList<String> list2 = new LinkedList<String>();

        // Adding elements in the list
        // using add() method
        list2.add("lily");
        list2.add("for");
        list2.add("Geeks");
        list2.add("10");
        list2.add("20");
        // Displaying all elements of LinkedList
        System.out.println("LinkedList:" + list2);

        System.out.println("The last element is: "
                + list.getLast2());
        //remove
        LinkedList<String> list3 = new LinkedList<String>();

        list3.add("ke");
        list3.add("le");
        list3.add("hao");
        list3.add("1");
        list3.add("2");

        // Printing the elements inside LinkedList
        System.out.println("LinkedList:" + list3);

        // Removing the head from List
        // using remove() method
        list.remove();

        // Printing the final elements inside Linkedlist
        System.out.println("Final LinkedList:" + list);
    }

    private void remove() {
    }



    private S getLast2() {
        return null;
    }


    private void addFirst(S xiaoyi) {
    }

    private Iterator<S> iterator() {
        return new Iterator<S>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public S next() {
                return null;
            }
        };
    }

    private void add(S chen) {
    }

    private void addLast(S summer) {
    }




}



