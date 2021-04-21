package _剑指Offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: _40最小的k个数
 * @Author: lerry_li
 * @CreateDate: 2021/04/20
 * @Description
 * 解法1：优先队列（最小堆）
 * 解法2：快排
 */
public class _40最小的k个数 {

    public static void main(String[] args) {
        _40最小的k个数 instance = new _40最小的k个数();
        System.out.println(Arrays.toString(instance.getLeastNumbers2(new int[]{0, 1, 1, 2, 4, 4, 1, 3, 3, 2}, 6)));
    }

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
     * 解法2：快排 时间O(N) 空间O(logN)
     * 快速排序的递归深度最好（平均）为 O(logN) ，最差情况（即输入数组完全倒序）为 O(N)。
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] res = new int[k];
        if (k == arr.length) {
            return arr;
        }
        quickSort(arr, 0, arr.length - 1, k);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void quickSort(int[] arr, int left, int right, int k) {
        if (left < right) {
            int p = partition(arr, left, right);
            if (p == k) {
                return;
            }
            if (p > k) {
                quickSort(arr, left, p - 1, k);
            } else {
                quickSort(arr, left, p - 1, k);
                quickSort(arr, p + 1, right, k);
            }
        }
    }

    private int partition(int[] arr, int left, int right) {
        int x = arr[left];
        int p = left;
        while (left < right) {
            while (left < right && arr[right] >= x) {
                right--;
            }
            while (left < right && arr[left] <= x) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, p, left);
        return left;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
