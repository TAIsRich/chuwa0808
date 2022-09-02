import java.time.DayOfWeek;
import java.util.*;
//import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args){

        //Optional<Integer> a = Optional.ofNullable(null);

        //System.out.println(a);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
// 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());

        System.out.println(squaresList);

        Random ran = new Random();

        ran.doubles().limit(10).forEach(System.out::println);

        List<Integer> b = Arrays.asList(1,2,3,4,5);

        System.out.println(b);

        b.stream().forEach(System.out::println);

        Stream<Integer> y = Stream.of( 10, 0, 90, 86, 47, 24, 18, 73, 64, 55);
        double x = b.stream().mapToDouble(Integer::doubleValue).average().orElse(0d);
        System.out.println(x);

        learn_EnumMap();
        Main main1 = new Main();

        main1.learn_Inserting_And_Retrieving();




        main1.learn_search_and_sort();

        main1.learn_common_operations();

        main1.learn_Iterator();

        main1.learn_Iterator2();

        main1.learn_Inserting_And_Retrieving2();

        main1.learn_Remove_Replacing_Updating();

        //main1.learn_Inserting_And_Retrieving_Removing3();










    }

    public static void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
        DayOfWeek d1 = DayOfWeek.MONDAY;
        enumMap.put(d1, 100);
        enumMap.put(DayOfWeek.THURSDAY, 200);
        enumMap.putIfAbsent(DayOfWeek.FRIDAY, 500);

        System.out.println(enumMap); // {MONDAY=100, THURSDAY=200, FRIDAY=500}
    }

    public void learn_Inserting_And_Retrieving() {
        // new ArrayList
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<String>() {
            {
                add("a");
                add("b");
                add("c");
            }
        };
        List<String> list2 = new ArrayList<>(Arrays.asList("d", "e", "f"));


        System.out.println(list1); // [a, b, c]
        System.out.println(list2); // [d, e, f]

        // add elements
        list.add("Google");
        list.add("Meta");
        list.add("Amazon");

        // get element
        String s1 = list.get(0);
        System.out.println(s1); // Google

        // get size
        int size = list.size();
        System.out.println(size); // 3

        // list.addAll(anotherList)
        list.addAll(list1);
        System.out.println(list); // [Google, Meta, Amazon, a, b, c]

    }

    public void learn_search_and_sort() {
        int[] nums = { 1, 2, 5, 4, 3, 6, 7, 8, 9, 10 };
        int idx = Arrays.binarySearch(nums, 8);
        System.out.println(idx); // 3

        //Arrays.sort(nums);
        Arrays.sort(nums, 2, 3);
        System.out.println(Arrays.toString(nums)); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        Arrays.parallelSort(nums);
    }

    public void learn_common_operations() {
        Integer[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> list = Arrays.asList(nums);

        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        Arrays.equals(nums, arr); // false

        Arrays.fill(nums, 0, 9, 11);
        System.out.println(Arrays.toString(nums)); // [11, 11, 11, 11, 11, 11, 11, 11, 11, 11]

    }

    public void learn_Iterator() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        Iterator<String> iterator = list.iterator();
        boolean hasNext = iterator.hasNext();
        String curr = iterator.next();
        //System.out.println(curr); // a
        iterator.remove();
        iterator.forEachRemaining(s -> System.out.println(s));

    }

    public void learn_Iterator2() {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> itr = list.iterator();
        boolean hasNext = itr.hasNext();
        String s = itr.next();
        System.out.println(s);
        itr.remove();
        itr.forEachRemaining(x -> System.out.println(x));
    }

    public void learn_Inserting_And_Retrieving2() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Google", 1);
        map.put("Amazon", 2);
        map.put("Meta", 2);
        map.putIfAbsent("Apple", 4);

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Tiktok", 5);
        map1.put("Facebook", 0);

        map.putAll(map1);
        System.out.println(map); // {Google=1, Meta=3, Apple=4, Tiktok=5, Amazon=2}

        map.get("Apple");
        map.getOrDefault("Tiktok", 0);
        map.containsKey("Google");
        map.containsValue(1);

        System.out.println(map.keySet()); // [Google, Meta, Apple, Tiktok, Amazon]
        map.isEmpty();
        ArrayList<Integer> v = new ArrayList<>(map.values());
        System.out.println(v); // [1, 3, 4, 5, 2]


    }

    public void learn_Remove_Replacing_Updating() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Google", 1);
        map.put("Amazon", 2);
        map.put("Meta", 3);
        //map.putIfAbsent("Apple", 4);

        map.replace("Google",  10);
        //map.replace("Google", 1);
        map.replaceAll((k, v) -> v + 1);
        System.out.println(map);

        //map.compute("Apple", (k, v) -> 1);
        map.computeIfPresent("Apple", (k, v) -> 10);
        System.out.println(map); // Apple = 1
        map.computeIfAbsent("Apple", v -> 10);

        map.computeIfPresent("Apple", (k, v) ->  12);
        System.out.println(map); // Apple = 11
    }

    public void learn_Inserting_And_Retrieving_Removing3() {
        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.addAll(new ArrayList<>(Arrays.asList(4, 5, 6)));
        System.out.println(set);

        System.out.println(set.contains(1)); // true
        System.out.println(set.contains(3)); // false

        System.out.println(set.remove(1));
        System.out.println(set.remove(1));
        set.clear(); // []

        System.out.println(set.isEmpty()); // true
    }


}
