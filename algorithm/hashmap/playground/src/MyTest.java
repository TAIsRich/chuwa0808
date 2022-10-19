import java.util.Set;

public class MyTest {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 2);
        map.put(2, 4);
        map.put(3, 4);
        map.put(4,6);

        map.put(5,8);
        map.put(6,8);
        map.put(7,8);
        map.put(8,8);
        map.put(9,8);
        map.put(10,8);
        map.put(11,8);
        map.put(12,8);
        map.put(13,8);

        map.put(14,8);
        map.put(15,8);
        map.put(16,8);

//
//        System.out.println(map.put(1, 6));
//        System.out.println(map.put(5, -5));
//        System.out.println(map.put(1, 7));
//
//        System.out.println(map.get(4));
//
//        map.delete(7);
//        System.out.println(map.get(4));

//        System.out.println(map.get(1));
//        System.out.println(map.get(2));
//          System.out.println(map.containsKey(7));
        System.out.println(map.size());

        Set<MyHashMap.Node> set = map.entrySet();
        set.stream().forEach(node -> System.out.println("key: " + node.key + " " +  "val: " + node.val));
    }
}
