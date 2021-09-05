package _每日一题._2021年._21年9月;

import java.util.PriorityQueue;

/**
 * @ClassName: _面试题17_14_最小K个数
 * @Author: lerry_li
 * @CreateTime: 2021/09/04
 * @Description
 */
public class _面试题17_14_最小K个数 {
    /**
     * 解法1：大顶堆 时间O(NlogK) 空间O(K)
     */
    public int[] smallestK(int[] arr, int k) {
        //特判
        if (arr == null || arr.length == 0 || k <= 0) return new int[]{};
        k = Math.min(k, arr.length);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2, o1)));
        for (int num : arr) {
            priorityQueue.offer(num);
            if (priorityQueue.size() > k) priorityQueue.poll();
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }

    /**
     * 解法2：快排
     */
}
