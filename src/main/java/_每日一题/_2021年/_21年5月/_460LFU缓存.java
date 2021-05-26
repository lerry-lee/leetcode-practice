package _每日一题._2021年._21年5月;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName: _LFU缓存
 * @Author: lerry_li
 * @CreateDate: 2021/05/26
 * @Description
 */
public class _460LFU缓存 {
    /**
     * 解法1：双哈希表
     */
    class LFUCache {
        int minfreq, capacity;
        Map<Integer, Node> key_table;
        Map<Integer, LinkedList<Node>> freq_table;

        public LFUCache(int capacity) {
            this.minfreq = 0;
            this.capacity = capacity;
            key_table = new HashMap<Integer, Node>();
            ;
            freq_table = new HashMap<Integer, LinkedList<Node>>();
        }

        public int get(int key) {
            if (capacity == 0) {
                return -1;
            }
            if (!key_table.containsKey(key)) {
                return -1;
            }
            //接下来的操作可以描述为：
            //1.根据key找到对应的node
            //2.获得node的freq和val
            //3.根据freqMap找到对应的list
            //4.删除原node
            //5.若list的size==0，则删除对应的entry
            //5-1.考虑是否更新minFreq(删除node后list的size==0,并且该node所在的freq恰好==minFreq)
            //若更新，则更新minFreq+1(因为该key被访问了，freq+1)
            //6.将新node(key,val,freq+1)插入list的头部，然后freqMap和key_node分别执行put操作
            //7.最终返回val
            return addKeyVal(key, -1, false);
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            //若缓存中不含该key
            if (!key_table.containsKey(key)) {
                // 缓存已满，需要进行删除操作
                if (key_table.size() == capacity) {
                    // 通过 minFreq 拿到 freq_table[minFreq] 链表的末尾节点
                    Node node = freq_table.get(minfreq).pollLast();
                    key_table.remove(node.key);
                    if (freq_table.get(minfreq).size() == 0) {
                        freq_table.remove(minfreq);
                    }
                }
                LinkedList<Node> list = freq_table.getOrDefault(1, new LinkedList<Node>());
                list.offerFirst(new Node(key, value, 1));
                freq_table.put(1, list);
                key_table.put(key, freq_table.get(1).peekFirst());
                minfreq = 1;
            }
            //否则，缓存中已有该key
            else {
                // 与 get 操作基本一致，除了需要更新缓存的值
                addKeyVal(key, value, true);
            }
        }

        private int addKeyVal(int key, int value, boolean update) {
            //根据key获得对应的node
            Node node = key_table.get(key);
            int val = node.val, freq = node.freq;
            if (update) val = value;
            //根据node的freq，获得freq_table中的位置，然后删除该node
            freq_table.get(freq).remove(node);
            // 如果当前链表为空，我们需要在哈希表中删除，且更新minFreq
            if (freq_table.get(freq).size() == 0) {
                freq_table.remove(freq);
                //若minFreq为当前的freq，由于get操作后，freq+1，因此minFreq+1
                if (minfreq == freq) {
                    minfreq += 1;
                }
            }
            // 插入到 freq + 1 中
            //没有对应的list则创建
            LinkedList<Node> list = freq_table.getOrDefault(freq + 1, new LinkedList<Node>());
            //node插入list头部
            Node cur = new Node(key, val, freq + 1);
            list.offerFirst(cur);
            //(freq,list)插入到freq_table
            freq_table.put(freq + 1, list);
            //(key,node)插入到key_table
            key_table.put(key, cur);
            return val;
        }
    }

    class Node {
        int key, val, freq;

        Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }

}
