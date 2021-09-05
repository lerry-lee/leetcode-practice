package _每日一题._2021年._21年9月;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/05
 */
public class _239滑动窗口最大值 {

    public static void main(String[] args) {
        _239滑动窗口最大值 instance = new _239滑动窗口最大值();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        instance.maxSlidingWindow1(nums, k);
    }

    /**
     * 解法1：优先队列(大顶堆) 时间O(NlogK) 空间O(K)
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o2[1], o1[1]);
        });
        //初始化窗口大小从0到k
        for (int i = 0; i < k; i++) {
            maxHeap.offer(new int[]{i, nums[i]});
        }
        int[] res = new int[nums.length - k + 1];
        int end = 0;
        res[end++] = maxHeap.peek()[1];
        //窗口滑动
        for (int right = k; right < nums.length; right++) {
            //若大顶堆的堆顶元素超出窗口左边界，弹出
            //窗口边界为[right-k+1,right]
            while (!maxHeap.isEmpty() && maxHeap.peek()[0] < right - k + 1) maxHeap.poll();//注意这里要用while
            // ，因为可能之前滞留的不在堆顶，超过一个
            //加入窗口右边界刚扫到的元素
            maxHeap.offer(new int[]{right, nums[right]});
            //输出当前窗口最大值
            res[end++] = maxHeap.peek()[1];
        }
        return res;
    }

    /**
     * 解法2：单调队列(递减，从大到小) 时间O(N) 空间O(N)
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        //需要用到双端队列
        Deque<Integer> deque = new LinkedList<>();//存数组下标
        //形成窗口
        for (int i = 0; i < k; i++) {
            //维护单调递减
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] res = new int[nums.length - k + 1];
        int end = 0;
        res[end++] = nums[deque.peekFirst()];
        //窗口移动
        for (int right = k; right < nums.length; right++) {
            //循环删除队首的越界元素
            while (!deque.isEmpty() && deque.peekFirst() < right - k + 1) deque.pollFirst();
            //新元素加入队尾
            //维护单调递减
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }
            deque.offerLast(right);
            //输出当前单调队列最大值
            res[end++] = nums[deque.peekFirst()];
        }
        return res;
    }
}
