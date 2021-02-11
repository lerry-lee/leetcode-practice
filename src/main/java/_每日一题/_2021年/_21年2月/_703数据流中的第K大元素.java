package _每日一题._2021年._21年2月;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: _703数据流中的第K大元素
 * @Author: lerry_li
 * @CreateTime: 2021/02/11
 * @Description
 */
public class _703数据流中的第K大元素 {

    /**
     * 解法1：优先队列（小顶堆） 时间O(NlogK) 空间(k)
     */

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        KthLargest instance = new KthLargest(3, nums);
        System.out.println(instance.add(3));
        System.out.println(instance.add(5));
        System.out.println(instance.add(10));
        System.out.println(instance.add(9));
        System.out.println(instance.add(4));
    }

    static class KthLargest {

        private int k;

        private PriorityQueue<Integer> minHeap;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (int num : nums) {
                minHeap.offer(num);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }

        public int add(int val) {
            if (minHeap.size() == k && minHeap.peek() >= val) {
                return minHeap.peek();
            }
            minHeap.offer(val);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            return minHeap.peek();
        }
    }
}
