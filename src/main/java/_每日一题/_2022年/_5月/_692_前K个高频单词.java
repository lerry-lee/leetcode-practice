package _每日一题._2022年._5月;

import java.util.*;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/09
 * @Description
 */
public class _692_前K个高频单词 {

    public static void main(String[] args) {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        _692_前K个高频单词 instance = new _692_前K个高频单词();
        instance.new Solution().topKFrequent(words, 2);
    }

    /**
     * 解法1：大顶堆 时间O(NlogN) 空间O(N)
     */
    class Solution {

        private class Node {
            public String word;
            public int freq;

            public Node(String word, int freq) {
                this.word = word;
                this.freq = freq;
            }
        }

        public List<String> topKFrequent(String[] words, int k) {
            List<String> res = new ArrayList<>();
            //特判
            if (words == null || words.length == 0) return res;
            Map<String, Integer> freq = new HashMap<>();
            for (String word : words) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
            //大顶堆
            PriorityQueue<Node> minHeap = new PriorityQueue<>((o1, o2) -> {
                if (o1.freq == o2.freq) {
                    return o1.word.compareTo(o2.word);
                }
                return Integer.compare(o2.freq, o1.freq);
            });
            for (String word : freq.keySet()) {
                minHeap.offer(new Node(word, freq.get(word)));

            }
            for (int i = 0; i < k; i++) {
                res.add(minHeap.poll().word);
            }
            //最后
            return res;
        }
    }
}
