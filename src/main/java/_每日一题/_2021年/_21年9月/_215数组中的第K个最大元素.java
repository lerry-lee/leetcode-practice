package _每日一题._2021年._21年9月;

import java.util.Random;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/10
 */
public class _215数组中的第K个最大元素 {

    public static void main(String[] args) {
        _215数组中的第K个最大元素 instance = new _215数组中的第K个最大元素();
        System.out.println(instance.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    /**
     * 解法1：快排 时间O(n) 空间O(logn) 递归栈开销
     */
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, k, 0, nums.length - 1);
        return nums[k - 1];
    }

    private void quickSort(int[] nums, int k, int l, int r) {
        if (l >= r) {
            return;
        }
        //p下标是分界线，p左边的元素都比p所指的元素大，p右边的元素都比p所指的元素小
        int p = partition(nums, l, r);
        //如果p刚好就是第k个，那么直接返回
        if (p == k - 1) return;
        //如果p比k-1大，说明只需要排序p左边的元素
        if(p>k-1) quickSort(nums, k, l, p - 1);
        //否则，只需要排右边的元素
        else quickSort(nums, k, p + 1, r);

    }

    private int partition(int[] nums, int l, int r) {
        int p = new Random().nextInt(r - l) + l;
        int x = nums[p];
        swap(nums, l, p);
        p = l;
        while (l < r) {
            while (l < r && nums[r] <= x) r--;
            while (l < r && nums[l] >= x) l++;
            if (l < r) swap(nums, l, r);
        }
        swap(nums, l, p);
        return l;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
