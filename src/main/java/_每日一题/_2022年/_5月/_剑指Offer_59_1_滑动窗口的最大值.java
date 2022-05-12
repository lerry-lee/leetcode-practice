package _每日一题._2022年._5月;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/12
 * @Description
 */
public class _剑指Offer_59_1_滑动窗口的最大值 {
    /**
     * 解法1：滑动窗口+优先队列（大顶堆） 时间O(NlogK) 空间O(K)
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            //特判
            if (nums == null || nums.length == 0) return new int[]{};
            //大顶堆，保存下标和数值，按数值排序
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));
            //结果数组
            int[] res = new int[nums.length - k + 1];
            int idx = 0;
            //初始化滑动窗口[0,k-1]
            for (int r = 0; r < k; r++) {
                //保持大的在前，直接插入
                maxHeap.add(new int[]{r, nums[r]});
            }
            //插入初始窗口的最大值
            res[idx++] = maxHeap.peek()[1];
            //遍历nums，r从k开始
            for (int r = k; r < nums.length; r++) {
                //每次[l,r]->[l+1.r+1]
                //判断堆顶元素是否移除窗口了，根据下标判断，l=r-k，l超过的下标全部移除
                while (!maxHeap.isEmpty() && (r - k) >= maxHeap.peek()[0]) {
                    maxHeap.poll();
                }
                //加入r窗口的元素
                maxHeap.add(new int[]{r, nums[r]});
                //更新结果数组
                res[idx++] = maxHeap.peek()[1];
            }
            return res;
        }
    }

    /**
     * 解法2：滑动窗口+单调队列 时间O(K) 空间O(K)
     */
    class Solution2 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            //特判
            if (nums == null || nums.length == 0) return new int[]{};
            //单调队列，保持单调递减，因为来一个更大的元素，前面所有更小的元素都失效了
            //存下标
            Deque<Integer> decreasingQueue = new LinkedList<>();
            //结果数组
            int[] res = new int[nums.length - k + 1];
            int idx = 0;
            //初始化滑动窗口
            for (int r = 0; r < k; r++) {
                //单调递减队列不为空，并且新来的元素更大的话，弹出队尾
                while (!decreasingQueue.isEmpty() && nums[r] >= nums[decreasingQueue.peekLast()]) {
                    decreasingQueue.removeLast();
                }
                //加入新元素
                decreasingQueue.addLast(r);
            }
            res[idx++] = nums[decreasingQueue.peekFirst()];
            //滑动窗口移动
            for (int r = 0; r < nums.length; r++) {
                //判断左窗口元素及其左边的是否已经出界，l=r-k
                while (!decreasingQueue.isEmpty() && (r - k) >= decreasingQueue.peekFirst()) {
                    decreasingQueue.removeFirst();
                }
                //保持队列单调递减
                while (!decreasingQueue.isEmpty() && nums[r] >= nums[decreasingQueue.peekLast()]) {
                    decreasingQueue.removeLast();
                }
                decreasingQueue.addLast(r);
                res[idx++] = nums[decreasingQueue.peekFirst()];
            }
            return res;
        }
    }
}
