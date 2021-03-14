package _每日一题._2021年._21年3月;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @ClassName: _手写LRU
 * @Author: lerry_li
 * @CreateTime: 2021/03/14
 * @Description
 */
public class _手写LRU {

    /**
     * 解法1：使用LinkedHashMap实现
     */
    class LRU1<K, V> {
        private LinkedHashMap<K, V> cache;
        private int capacity;

        public LRU1(int capacity) {
            this.capacity = capacity;
            cache = new LinkedHashMap<>();
        }

        //访问一个元素，有就放到最近访问的位置（头部/尾部），没有就插入
        public void visit(K key, V val) {
            //如果已存在，就先删除
            if (cache.containsKey(key)) {
                cache.remove(key);
            }
            //不存在，首先看是否需要执行LRU算法，即删除最近最久未访问的
            if (cache.size() == capacity) {
                Iterator<K> iterator = cache.keySet().iterator();
                K leastVisited = iterator.next();
                cache.remove(leastVisited);
            }
            //添加该元素
            cache.put(key, val);
        }
    }

    /**
     * 解法2：使用hashMap+双向链表实现
     * 思路：
     *      hashMap维护key->node（链表里的节点）的映射
     *      双向链表维护插入顺序，以及保存val
     */
    class LRU2 {
        //哈希表存key->Node(key,val)的映射
        private HashMap<Integer, Node> hashMap;
        //双向链表维护Node顺序，以及key-val值
        private DoubleList doubleList;
        //最大容量
        private int capacity;

        //初始化
        public LRU2(int capacity) {
            this.capacity = capacity;
            hashMap = new HashMap<>();
            doubleList = new DoubleList();
        }

        //get方法，访问一个元素，将其提升为最近访问
        public int get(int key) {
            //不存在则返回-1
            if (hashMap.containsKey(key)) {
                return -1;
            }
            //提升key为最近访问
            makeRecently(key);
            //返回key对应的val
            return hashMap.get(key).val;
        }

        //put方法，添加一个元素，添加后其即为最近访问
        public void put(int key, int val) {
            //如果元素已经存在，删除原来的，并插入新的
            if (hashMap.containsKey(key)) {
                //删除旧数据
                deleteKey(key);
                //插入新的
                addRecently(key, val);
                return;
            }
            //如果元素不存在，则插入
            //如果容量满了，需要执行LRU，删除最近最久未访问的
            if (doubleList.size == capacity) {
                removeLeastRecently();
            }
            //添加
            addRecently(key, val);
        }

        //将某个key提升为最近使用的
        private void makeRecently(int key) {
            //通过hashMap拿到Node
            Node x = hashMap.get(key);
            //先从链表中删除x
            doubleList.remove(x);
            //再将x插入到链表尾部
            doubleList.addLast(x);
        }

        //添加一个key-val，其称为最近使用的元素
        private void addRecently(int key, int val) {
            //创建一个新节点x
            Node x = new Node(key, val);
            //插入x到链表尾部
            doubleList.addLast(x);
            //添加hashMap中的key->Node映射
            hashMap.put(key, x);
        }

        //删除某一个key
        private void deleteKey(int key) {
            Node x = hashMap.get(key);
            //从链表中删除
            doubleList.remove(x);
            //从hashMap中删除
            hashMap.remove(key);
        }

        //删除最久未使用的元素
        private void removeLeastRecently() {
            //删除链表头部
            Node node = doubleList.removeFirst();
            //同时删除hashMap中的键值对
            hashMap.remove(node.key);
        }
    }

    class Node {
        private int key;
        private int val;
        public Node prev;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {
        //头尾虚节点
        private Node head;
        private Node tail;
        //链表元素的个数
        private int size;

        public DoubleList() {
            //初始化
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        //链表尾部插入一个节点x,O(1)
        public void addLast(Node x) {
            //x的prev指向原来的尾结点
            x.prev = tail.prev;
            //x的next指向tail
            x.next = tail;
            //原尾结点的next指向x
            tail.prev.next = x;
            //tail的prev指向x
            tail.prev = x;
            //size+1
            size++;
        }

        //删除链表中的节点x（x一定存在）,O(1)
        public void remove(Node x) {
            //x的前驱节点的next指向x的后继节点
            x.prev.next = x.next;
            //x的后继节点的prev指向x的前驱节点
            x.next.prev = x.prev;
            //x的prev和next是否需要断开？
            //x.prev=null
            //x.next=null
            //size-1
            size--;
        }

        //删除链表的第一个节点，并返回该节点，O(1)
        public Node removeFirst() {
            //如果链表元素个数=0，则返回null
            if (size == 0) {
                return null;
            }
            //取第一个节点并执行remove操作
            Node first = head.next;
            remove(first);
            return first;
        }

        //返回链表长度
        public int getSize() {
            return size;
        }
    }
}
