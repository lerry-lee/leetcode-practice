package _每日一题._2021年._21年9月;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/10
 */
public class _42接雨水 {
    /**
     * 解法1：dp 时间O(N) 空间O(N)
     */
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(leftMax[i], rightMax[i])-height[i];
        }
        return res;
    }

    /**
     * 解法2：双指针 时间O(N) 空间O(1)
     * 思路：(https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/327718/)
     *      我们先明确几个变量的意思：
     *      left_max：左边的最大值，它是从左往右遍历找到的
     *      right_max：右边的最大值，它是从右往左遍历找到的
     *      left：从左往右处理的当前下标
     *      right：从右往左处理的当前下标
     *      |`定理一：在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。
     *      |
     *      |-定理二：当我们从左往右处理到left下标时，左边的最大值left_max对它而言是可信的，但right_max对它而言是不可信的。（见下图，由于中间状况未知，对于left下标而言，right_max未必就是它右边最大的值）
     *      |
     *      |_定理三：当我们从右往左处理到right下标时，右边的最大值right_max对它而言是可信的，但left_max对它而言是不可信的。
     *      对于位置left而言，它左边最大值一定是left_max，右边最大值“大于等于”right_max，这时候，如果left_max<right_max成立，那么它就知道自己能存多少水了。无论右边将来会不会出现更大的right_max，都不影响这个结果。 所以当left_max<right_max时，我们就希望去处理left下标，反之，我们希望去处理right下标。
     */
    class Solution2 {
        public int trap(int[] height) {
            int ans = 0;
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            while (left < right) {
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if (height[left] < height[right]) {
                    ans += leftMax - height[left];
                    ++left;
                } else {
                    ans += rightMax - height[right];
                    --right;
                }
            }
            return ans;
        }
    }
}
