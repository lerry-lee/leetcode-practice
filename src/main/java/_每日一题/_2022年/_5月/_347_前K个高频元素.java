package _每日一题._2022年._5月;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/09
 * @Description
 */
public class _347_前K个高频元素 {
    /**
     * 解法1：小顶堆（自定义排序） 时间O(NlogK) 空间O(N)
     */
    class Solution {
        private class Node {
            public int val;
            public int freq;

            public Node(int val, int freq) {
                this.val = val;
                this.freq = freq;
            }
        }

        public int[] topKFrequent(int[] nums, int k) {
            //特判
            if (nums == null || nums.length == 0) return new int[]{};
            //统计频次
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
            //将数字和它的频次加入小顶堆，按照freq降序，size超过k时，弹出
            PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.freq));
            for (int num : freq.keySet()) {
                minHeap.offer(new Node(num, freq.get(num)));
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
            //最后小顶堆里面的元素就是前k个高频元素
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = minHeap.poll().val;
            }
            return res;
        }
    }
}
