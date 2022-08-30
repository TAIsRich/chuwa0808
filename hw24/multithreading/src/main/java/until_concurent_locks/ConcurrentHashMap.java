package until_concurent_locks;

import java.util.Map;

public class ConcurrentHashMap {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>(16);
        map.put("A", "1");
        map.put("B", "2");
        String a = map.get("A");
    }
}
