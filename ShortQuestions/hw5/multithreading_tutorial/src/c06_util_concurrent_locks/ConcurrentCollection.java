package c06_util_concurrent_locks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollection {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();

        map.put("A", "1");
        map.put("B", "2");
        String a = map.get("A");

        Map<Object, Object> unsafeMap = new HashMap<>(16);
        Map<Object, Object> threadSafeMap = Collections.synchronizedMap(unsafeMap);
    }
}
