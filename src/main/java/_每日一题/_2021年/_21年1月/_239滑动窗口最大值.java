package _每日一题._2021年._21年1月;

import _工具类.CommonMethod;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @ClassName: _239滑动窗口最大值
 * @Author: lerry_li
 * @CreateDate: 2021/01/02
 * @Description
 */
public class _239滑动窗口最大值 {
    /**
     * 解法1：优先队列 时间O(NlogN) 空间O(N)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0||k<0) {
            return new int[]{};
        }
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            bigHeap.add(nums[i]);
            if(bigHeap.size()<k){
                continue;
            }
            if (bigHeap.size() > k) {
                bigHeap.remove(nums[i - k]);
            }
            res[idx++] = bigHeap.peek();
        }
        return res;
    }

    /**
     * 解法2：双向队列 时间O(N) 空间N(N)
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() < i+1-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _239滑动窗口最大值 instance=new _239滑动窗口最大值();
        int[] nums={1,-1};
        int k=2;
        int[] res=instance.maxSlidingWindow(nums,k);
        CommonMethod.display(res);
    }
}
