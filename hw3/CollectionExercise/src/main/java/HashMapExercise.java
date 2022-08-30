import java.util.HashMap;
import java.util.Map;

public class HashMapExercise {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 2);
        System.out.println(map.get("1"));
        System.out.println(map.containsKey("1"));
        System.out.println(map.containsKey("2"));
        map.put("1", 4);
        System.out.println(map);
    }
}
