package _字节跳动推荐._数据结构;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/06/25 10:58
 * @description LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */

public class LRUCache {
    private int capacity;
    private Map<Integer, int[]> hashMap;
    private Deque<int[]> hashKey;

    public LRUCache(int capacity) {
        System.out.println("LRUCache初始化，容量为" + capacity);
        this.capacity = capacity;
        this.hashMap = new HashMap<>(capacity);
        this.hashKey = new LinkedList<>();
        display();
    }

    public int get(int key) {
        System.out.println("\n执行get，" + key);
        if (this.hashMap.containsKey(key)) {
            int[] key_value=hashMap.get(key);
            hashKey.remove(key_value);
            hashKey.addFirst(key_value);
            display();
            return key_value[1];
        } else {
            display();
            return -1;
        }
    }

    public void put(int key, int value) {
        System.out.println("\n执行put，" + key + ":" + value);
        if (this.hashMap.containsKey(key)) {
            int[] old_key_value=hashMap.get(key);
            int[] key_value={key,value};
            hashMap.replace(key, key_value);
            hashKey.remove(old_key_value);
            hashKey.addFirst(key_value);
        } else {
            if (hashMap.size() >= capacity) {
                int[] last = hashKey.removeLast();
                hashMap.remove(last[0]);
            }
            int[] key_value={key,value};
            hashMap.put(key, key_value);
            hashKey.addFirst(key_value);
        }


        display();
    }

    public void display() {
        System.out.println("cache数据：" + hashMap);
        System.out.println("最近使用序列：" + hashKey);
    }
}
