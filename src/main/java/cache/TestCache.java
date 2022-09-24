package cache;

import lombok.Synchronized;

import java.util.HashMap;
import java.util.Map;

public class TestCache {

    private static final Map<String, Object> testCache = new HashMap<>();

    @Synchronized
    public static void putInTestCacheMap(String key, Object object) {
        testCache.put(key, object);
    }

    @Synchronized
    public static Object getFromTestCacheMap(String key) {
        return testCache.get(key);
    }

}
