package _每日一题._2021年._21年9月;

import java.util.Arrays;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/10
 */
public class _16最接近的三数之和 {
    /**
     * 解法1：转变为两数之和 排序+双指针 时间O(N^2) 空间O(1)
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int bestSum = 10000000;

        // 枚举 a
        for (int a_i = 0; a_i < n; ++a_i) {
            // 保证和上一次枚举的元素不相等
            if (a_i > 0 && nums[a_i] == nums[a_i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int b_i = a_i + 1, c_i = n - 1;
            while (b_i < c_i) {
                int sum = nums[a_i] + nums[b_i] + nums[c_i];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(bestSum - target)) {
                    bestSum = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int temp = nums[c_i];
                    // 移动到下一个不相等的元素
                    while (b_i < c_i && temp == nums[c_i]) {
                        c_i--;
                    }
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int temp=nums[b_i];
                    // 移动到下一个不相等的元素
                    while (b_i < c_i && temp == nums[b_i]) {
                        b_i++;
                    }
                }
            }
        }
        return bestSum;
    }
}
