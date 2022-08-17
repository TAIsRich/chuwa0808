package collection;

import java.util.*;

import static java.util.Collections.addAll;

public class ArrayListExerciseTest {
    public static void main(String[] args) {
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
    }
    public void learn_Inserting_And_Retrieving() {
        //remove(int index)
        List<Integer> list = new ArrayList<Integer>(5);

        // Add elements to the list
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);

        // Index from which you want to remove element
        int index = 2;

        // Initial list
        System.out.println("Initial List: " + list);

        // remove element
        list.remove(index);

        // Final list
        System.out.println("Final List: " + list);

        //remove(Object o)
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2); numbers.add(3);
        System.out.println("ArrayList contains : " + numbers);
        numbers.remove(1);
       //removeAll(Collection<?> c)
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("JavaFX");
        list1.add("Java");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("JOGL");
        list2.add("Hadoop");
        list1.removeAll(list2);
        System.out.println("Contents of the Array List after removal: \n"+list1);

        //Update:
        ArrayList<String> names = new ArrayList<String>();
        names.add("Google");
        names.add("Apple");
        names.add("Samsung");

        //update element of arraylist
        names.set(1, "Asus");

        for(String name: names) {
            System.out.println(name);
        }
        //replaceAll(UnaryOperator<E> operator)
        ArrayList<String> languages = new ArrayList<>();

        // add elements to the ArrayList
        languages.add("java");
        languages.add("javascript");
        languages.add("swift");
        languages.add("python");
        System.out.println("ArrayList: " + languages);

        // replace all elements to uppercase
        languages.replaceAll(e -> e.toUpperCase());
        System.out.println("Updated ArrayList: " + languages);

        // indexOf
        ArrayList<Integer> arr = new ArrayList<Integer>(5);

        // using add() to initialize values
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        // printing initial value
        System.out.print("The initial values in ArrayList are : ");
        for (Integer value : arr) {
            System.out.print(value);
            System.out.print(" ");
        }

        // using indexOf() to find index of 3
        int pos =arr.indexOf(3);

        // prints 2
        System.out.println("\nThe element 3 is at index : " + pos);
    }

    public void learn_Remove_Replacing_Updating() {
        //iterator()
        ArrayList<String> list
                = new ArrayList<>();

        list.add("Geeks");
        list.add("for");
        list.add("Geeks");
        list.add("is");
        list.add("a");
        list.add("CS");
        list.add("Students");
        list.add("Portal");

        // Displaying the list
        System.out.println("The list is: \n"
                + list);

        // Create an iterator for the list
        // using iterator() method
        Iterator<String> iter
                = list.iterator();

        // Displaying the values after iterating
        // through the list
        System.out.println("\nThe iterator values"
                + " of list are: ");
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

        //hasNext()
        List<String> aList = new ArrayList<String>();
        aList.add("Adam");
        aList.add("John");
        aList.add("Nancy");
        aList.add("Peter");
        aList.add("Mary");
        Iterator i = aList.iterator();
        System.out.println("The ArrayList elements are:");
        while (i.hasNext()) {
            System.out.println(i.next());
        }

//           // sort
//            ArrayList<String> list2 = new ArrayList<String>();
//            list2.add("Volkswagen");
//            list2.add("Toyota");
//            System.out.println("Before Sorting: "+ list2);
//            Collections.sort(list);
//            System.out.println("After Sorting: "+ list2);
//
//            //Comparator.reverseOrder()
//         List<Integer> values
//                = Arrays.asList(212, 324,
//                435, 566,
//                133, 100,
//                121);
//
//         values.sort(Comparator.reverseOrder());
//         System.out.println(values);



    }


    }

















