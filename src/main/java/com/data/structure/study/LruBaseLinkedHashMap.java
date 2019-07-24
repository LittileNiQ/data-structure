package com.data.structure.study;

import java.util.LinkedHashMap;
import java.util.Map;

/**在 O(1) 时间复杂度内完成 lru缓存机制
 * Created by Naqi on 2019/7/24.
 */
public class LruBaseLinkedHashMap extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LruBaseLinkedHashMap(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
