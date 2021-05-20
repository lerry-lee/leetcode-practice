package _每日一题._2021年._21年5月;

import java.util.*;

/**
 * @ClassName: _692前K个高频单词
 * @Author: lerry_li
 * @CreateDate: 2021/05/20
 * @Description
 * 解法1：哈希表+优先队列(小顶堆)
 */
public class _692前K个高频单词 {

    public static void main(String[] args) {
        _692前K个高频单词 instance = new _692前K个高频单词();
        System.out.println(instance.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 3));
        System.out.println(instance.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    /**
     * 解法1：哈希表+优先队列(小顶堆) 时间O(NlogK) 空间O(N)
     */
    public List<String> topKFrequent1(String[] words, int k) {
        //特判
        if (words == null || words.length == 0 || k <= 0) return new ArrayList<>();
        //k判断
        k = Math.min(k, words.length);
        //word出现次数
        HashMap<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }
        //出现次数的word
        HashMap<Integer, PriorityQueue<String>> freqWord = new HashMap<>();
        //小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //遍历wordFreq
        for (String word : wordFreq.keySet()) {
            int freq = wordFreq.get(word);
            if (freqWord.containsKey(freq)) {
                freqWord.get(freq).offer(word);
            } else {
                //出现次数相同的word，按字母序排列
                PriorityQueue<String> priorityQueue = new PriorityQueue<>();
                priorityQueue.offer(word);
                //加入freqWord
                freqWord.put(freq, priorityQueue);
            }
            //维持minHeap不超过k个元素
            minHeap.offer(freq);
            if (minHeap.size() > k) minHeap.poll();
        }
        //遍历minHeap，取出k个freq
        List<String> res = new ArrayList<>();
        int[] freqs = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            freqs[i] = minHeap.poll();
            i += 1;
        }
        //按freq降序取对应的word
        for (i = k - 1; i >= 0; i--) {
            res.add(freqWord.get(freqs[i]).poll());
        }
        return res;
    }

    /**
     * 解法2：解法1写法优化
     */
    public List<String> topKFrequent(String[] words, int k) {
        //特判
        if (words == null || words.length == 0 || k <= 0) return new ArrayList<>();
        //k判断
        k = Math.min(k, words.length);
        //word出现次数
        HashMap<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }
        //小顶堆
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) return o2.getKey().compareTo(o1.getKey());
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        //遍历wordFreq
        for (Map.Entry entry : wordFreq.entrySet()) {
            //维持minHeap不超过k个元素
            minHeap.offer(entry);
            if (minHeap.size() > k) minHeap.poll();
        }
        //遍历minHeap，取出k个freq
        List<String> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(0,minHeap.poll().getKey());
        }
        return res;
    }
}
