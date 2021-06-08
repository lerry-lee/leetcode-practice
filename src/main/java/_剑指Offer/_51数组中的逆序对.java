package _剑指Offer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @ClassName: _51数组中的逆序对
 * @Author: lerry_li
 * @CreateDate: 2021/05/07
 * @Description
 * 解法1：朴素暴力
 * 解法2：分治(归并排序思想)
 */
public class _51数组中的逆序对 {

    public static void main(String[] args) {
        _51数组中的逆序对 instance = new _51数组中的逆序对();
        System.out.println(instance.reversePairs2(new int[]{7, 5, 6, 4}));//5
        System.out.println(instance.reversePairs2(new int[]{7, 7, 5, 6, 4}));//8
        System.out.println(instance.reversePairs2(new int[]{233, 2000000001, 234, 2000000006, 235, 2000000003, 236, 2000000007, 237, 2000000002, 2000000005, 233, 233, 233, 233, 233, 2000000004}));//69
    }

    /**
     * 解法1：朴素暴力 时间O(N^2) 空间O(1)
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    res += 1;
                }
            }
        }
        return res;
    }

    /**
     * 解法2：分治(归并排序思想) 时间O(NlogN) 空间O(N)
     * 思路：
     *      对于两个有序数组，left和right(left的下标比right下标要小)，
     *      在归并排序的过程中，若left[i]比right[j]小，那不存在(left[i],y)组成的逆序对（因为right[j]后面的元素都比left[j]大）
     *      若left[i]比right[j]大，则存在逆序对(x,right[j])，其中x为left[i]到left[end]的任意元素，因此逆序对的个数为end-i+1
     */
    public int reversePairs2(int[] nums) {
        //特判
        if (nums == null || nums.length < 2) {
            return 0;
        }
        res = 0;
        func(nums, 0, nums.length-1);
        return res;
    }

    int res;

    private void func(int[] nums, int l, int r) {
        if (l == r) return;
        int mid = l + (r - l) / 2;
        func(nums, l, mid);
        func(nums, mid + 1, r);
        //得到两个有序数组
        int[] tempArr = new int[r - l + 1];
        int idx = 0;
        int i = l, j = mid+1;
        //在归并过程中，判断是否存在逆序对
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tempArr[idx] = nums[i];
                i++;
            } else {
                tempArr[idx] = nums[j];
                res += mid - i + 1;
                j++;
            }
            idx++;
        }
        while (i <= mid) tempArr[idx++] = nums[i++];
        while (j <= r) tempArr[idx++] = nums[j++];
        //拷贝回原数组
        idx = 0;
        i = l;
        while (idx < r - l + 1) {
            nums[i++] = tempArr[idx++];
        }
    }

}
