package _0146;

import java.util.*;

/**
 * @author yiezi
 * url: https://leetcode-cn.com/problems/lru-cache/
 * tag: design
 */
public class LRUCache {
    Queue<Integer> limit;
    Map<Integer,Integer> cache;
    private final int capacity;
    public LRUCache(int capacity) {
        limit = new LinkedList<>();
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        int result = cache.getOrDefault(key, -1);
        if (result==-1) return result;
        updateIndex(key);
        return result;
    }
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            updateIndex(key);
        } else {
            if (limit.size()==capacity)
            cache.remove(limit.poll());
            limit.add(key);
        }
        cache.put(key, value);
    }

    private void updateIndex(int e) {
        limit.remove(e);
        limit.add(e);
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);

        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}
