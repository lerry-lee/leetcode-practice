package _每日一题._2021年._21年10月;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/10/07
 */
public class _414_第三大的数 {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                continue;
            }
            minHeap.offer(num);
            hashSet.add(num);
            if (minHeap.size() > 3) {
                minHeap.poll();
            }
        }
        if (minHeap.size() == 3) {
            return minHeap.poll();
        }

        int size = minHeap.size();
        if (size < 3) {
            while (size > 1) {
                minHeap.poll();
                size--;
            }
        }
        return minHeap.poll();
    }
}
