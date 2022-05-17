package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/17
 */
public class _706_设计哈希映射 {

    public static void main(String[] args) {
        _706_设计哈希映射 instance = new _706_设计哈希映射();
        _706_设计哈希映射.MyHashMap myHashMap = instance.new MyHashMap();
        myHashMap.remove(1);
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        myHashMap.get(1);
        myHashMap.get(3);
        myHashMap.put(2, 1);
        myHashMap.get(2);
        myHashMap.remove(2);
        myHashMap.get(2);
    }

    /**
     * solution1：Zipper method, no expansion
     */
    class MyHashMap {

        Entry[] buckets;
        int capacity;

        public MyHashMap() {
            capacity = 1024;
            buckets = new Entry[capacity];
        }

        public void put(int key, int value) {
            // get bucket index
            int index = getBucketIndex(key);
            if (buckets[index] == null) {
                buckets[index] = new Entry(key, value);
            } else {
                Entry entryNode = buckets[index];
                while (entryNode.key != key) {
                    if (entryNode.next == null) {
                        break;
                    }
                    entryNode = entryNode.next;
                }
                if (entryNode.key == key) {
                    entryNode.val = value;
                } else {
                    entryNode.next = new Entry(key, value);
                }
            }
        }

        public int get(int key) {
            // get bucket index
            int index = getBucketIndex(key);
            if (buckets[index] == null) {
                return -1;
            }
            Entry entryNode = buckets[index];
            while (entryNode != null) {
                if (entryNode.key == key) {
                    return entryNode.val;
                }
                entryNode = entryNode.next;
            }
            return -1;
        }

        public void remove(int key) {
            // get bucket index
            int index = getBucketIndex(key);
            if (buckets[index] == null) {
                return;
            }
            Entry entryNode = buckets[index];
            Entry dummy = new Entry(0, 0);
            dummy.next = entryNode;
            Entry prev = dummy;
            while (entryNode != null) {
                if (entryNode.key == key) {
                    prev.next = entryNode.next;
                    entryNode.next = null;
                }
                entryNode = entryNode.next;
                prev = prev.next;
            }
            buckets[index] = dummy.next;
        }

        private int getBucketIndex(int key) {
            key = key ^ (key >> 16);
            return key & (capacity - 1);
        }

        private class Entry {
            int key;
            int val;
            Entry next;

            public Entry(int key, int val) {
                this.key = key;
                this.val = val;
                this.next = null;
            }
        }
    }
}
