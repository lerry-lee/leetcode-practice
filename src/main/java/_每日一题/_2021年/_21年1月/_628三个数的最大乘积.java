package _每日一题._2021年._21年1月;

import java.util.Arrays;

/**
 * @ClassName: _628三个数的最大乘积
 * @Author: lerry_li
 * @CreateTime: 2021/01/28
 * @Description
 */
public class _628三个数的最大乘积 {
    /**
     * 解法1：回溯（超时）
     */
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        //全是正数/全是负数
        if (nums[0] >= 0 || nums[n - 1] <= 0) {
            return nums[n - 1] * nums[n - 2] * nums[n - 3];
        }
        maxRes = 0;
        dfs(nums, 0, 3, 1);
        return maxRes;
    }

    int maxRes;

    public void dfs(int[] nums, int t, int n, int temp) {
        if (n == 0) {
            maxRes = Math.max(maxRes, temp);
            return;
        }
        int temp_copy = temp;
        for (int i = t; i < nums.length; i++) {
            temp *= nums[i];
            dfs(nums, i + 1, n - 1, temp);
            temp = temp_copy;
        }
    }

    /**
     * 解法2：分情况讨论 时间O(NlogN) 空间O(1)
     */
    public int maximumProduct2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int last3 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        //全是正数/全是负数
        if (nums[0] >= 0 || nums[n - 1] <= 0) {
            return last3;
        }
        //有正数有负数
        //要么最大的3个正数的乘积，要么最大的正数*绝对值最大的两个负数的乘积
        return Math.max(last3, nums[0] * nums[1] * nums[n - 1]);
    }

    public static void main(String[] args) {
        _628三个数的最大乘积 instance = new _628三个数的最大乘积();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {-1, -2, -3, 1, 2, 3};
        int[] nums4 = {-1, -2, -3, 3, 4, 5};
        System.out.println(instance.maximumProduct2(nums1));
        System.out.println(instance.maximumProduct2(nums2));

        System.out.println(instance.maximumProduct2(nums3));

        System.out.println(instance.maximumProduct2(nums4));

    }
}
