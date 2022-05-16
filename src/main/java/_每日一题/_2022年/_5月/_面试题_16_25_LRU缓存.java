package _每日一题._2022年._5月;

import java.util.*;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/09
 */
public class _面试题_16_25_LRU缓存 {

    /**
     * 解法1：使用linkedHashMap
     */
    public class LRUCache1{
        int capacity;
        Map<Integer, Integer> map;

        public LRUCache1(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            // 先删除旧的位置，再放入新位置
            Integer value = map.remove(key);
            map.put(key, value);
            return value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.remove(key);
                map.put(key, value);
                return;
            }
            map.put(key, value);
            // 超出capacity，删除最久没用的,利用迭代器删除第一个
            if (map.size() > capacity) {
                map.remove(map.keySet().iterator().next());
            }
        }
    }

    /**
     * 解法2：hashmap+双向链表
     */
    public class LRUCache2{

        private int capacity;
        private Map<Integer, ListNode> map; //key->node
        private ListNode head;  // dummy head
        private ListNode tail;  // dummy tail

        public LRUCache2(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            ListNode node = map.get(key);
            // 先删除该节点，再接到尾部
            node.pre.next = node.next;
            node.next.pre = node.pre;
            insertToTail(node);

            return node.val;
        }

        public void put(int key, int value) {
            // 直接调用这边的get方法，如果存在，它会在get内部被移动到尾巴，不用再移动一遍,直接修改值即可
            if (get(key) != -1) {
                map.get(key).val = value;
                return;
            }
            // 若不存在，new一个出来,如果超出容量，把头去掉
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            insertToTail(node);

            if (map.size() > capacity) {
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.pre = head;
            }
        }

        // 把节点移动到尾巴
        private void insertToTail(ListNode node) {
            node.pre = tail.pre;
            tail.pre = node;
            node.pre.next = node;
            node.next = tail;
        }

        // 定义双向链表节点
        private class ListNode {
            int key;
            int val;
            ListNode pre;
            ListNode next;

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
                pre = null;
                next = null;
            }
        }
    }

}
