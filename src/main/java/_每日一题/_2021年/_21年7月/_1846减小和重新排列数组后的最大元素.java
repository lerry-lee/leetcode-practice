package _每日一题._2021年._21年7月;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName: _1846减小和重新排列数组后的最大元素
 * @Author: lerry_li
 * @CreateDate: 2021/07/16
 * @Description
 * 排序+贪心
 */
public class _1846减小和重新排列数组后的最大元素 {

    public static void main(String[] args) {
        _1846减小和重新排列数组后的最大元素 instance = new _1846减小和重新排列数组后的最大元素();
        System.out.println(instance.maximumElementAfterDecrementingAndRearranging(new int[]{73, 98, 9}));
        System.out.println(instance.maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1}));
        System.out.println(instance.maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 100}));
        System.out.println(instance.maximumElementAfterDecrementingAndRearranging(new int[]{1, 2, 3, 4, 5}));
        System.out.println(instance.maximumElementAfterDecrementingAndRearranging(new int[]{201, 201, 201, 201}));
    }

    /**
     * 优先队列(最小堆)
     */
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        //特判
        if (arr == null || arr.length == 0) return 0;
        //最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) minHeap.offer(num);
        //记录当前值
        int cur = -1;
        //从优先队列里一个一个取
        while (!minHeap.isEmpty()) {
            //第一个元素直接赋值
            if (cur == -1) {
                cur = 1;
                minHeap.poll();
                continue;
            }
            //比较堆顶元素和cur值的大小
            //当堆顶元素更大时，当前值+1
            if (minHeap.peek() > cur) {
                cur++;

            }
            minHeap.poll();
        }
        return cur;
    }

    /**
     * 排序
     */
    public int maximumElementAfterDecrementingAndRearranging2(int[] arr) {
        //特判
        if (arr == null || arr.length == 0) return 0;
        Arrays.sort(arr);
        int cur = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > cur) cur++;
        }
        return cur;
    }
}
