package _剑指Offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: _40最小的k个数
 * @Author: lerry_li
 * @CreateDate: 2021/04/20
 * @Description
 */
public class _40最小的k个数 {
    /**
     * 解法1：优先队列（最小堆） 时间O(Nlog(N-k)) 空间O(N-k)
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int len = arr.length - k;
        int[] res = new int[k];
        int idx = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.offer(num);
            if (minHeap.size() > len) {
                res[idx++] = minHeap.poll();
            }
        }
        return res;
    }

    /**
     * 解法2：快排 时间O(NlogN) 空间O(N)
     * 快速排序的递归深度最好（平均）为 O(logN) ，最差情况（即输入数组完全倒序）为 O(N)。
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] res = new int[k];
        quickSort(arr, 0, arr.length, k);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void quickSort(int[] arr, int left, int right, int k) {
        if (left < right) {
            int p = partition(arr, left, right);
            quickSort(arr, left, p - 1, k);
            if (p < k) {
                quickSort(arr, p + 1, right, k);
            }
        }
    }

    private int partition(int[] arr, int left, int right) {
        int x=arr[left];
        while(left<right){
            while(l)
        }
    }
}
