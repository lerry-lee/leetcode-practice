package _每日一题._2021年._21年3月;

/**
 * @ClassName: _706设计哈希映射
 * @Author: lerry_li
 * @CreateTime: 2021/03/14
 * @Description
 */
public class _706设计哈希映射 {

    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static class MyHashMap {
        private int capacity;
        private Node[] bucket;

        /** Initialize your data structure here. */
        public MyHashMap() {
            capacity = 10000;
            bucket = new Node[capacity];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hash = key % capacity;
            Node cur = new Node(key, value);
            Node head = bucket[hash];
            if (head == null) {
                bucket[hash] = cur;
            } else {
                while (head.next != null) {
                    if (head.key == key) {
                        head.val = value;
                        return;
                    }
                    head = head.next;
                }
                if (head.key == key) {
                    head.val = value;
                } else {
                    head.next = cur;
                }
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hash = key % capacity;
            Node cur = bucket[hash];
            if (cur == null) {
                return -1;
            }
            while (cur != null) {
                if (cur.key == key) {
                    return cur.val;
                }
                cur = cur.next;
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hash = key % capacity;
            Node cur = bucket[hash];
            if (cur == null) {
                return;
            }
            if (cur.key == key) {
                Node newHead = cur.next;
                cur.next = null;
                bucket[hash] = newHead;
            }
            Node prev = cur;
            cur = cur.next;
            while (cur != null) {
                if (cur.key == key) {
                    prev.next = cur.next;
                    cur.next = null;
                    return;
                }
                cur = cur.next;
                prev = prev.next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }
}

