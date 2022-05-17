package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/17
 */
public class _42_接雨水 {
    /**
     * 解法1：找左右侧最大的高度 时间O(N) 空间O(N)
     */
    class Solution {
        public int trap(int[] height) {
            // check null
            if (height == null || height.length == 0) return 0;
            int len = height.length;
            int[] leftMax = new int[len], rightMax = new int[len];
            leftMax[0] = height[0];
            rightMax[len - 1] = height[len - 1];
            for (int i = 1; i < len; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }
            for (int i = len - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
            int res = 0;
            for (int i = 0; i < len; i++) {
                res += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return res;
        }
    }

    /**
     * 解法2：双指针 时间O(N) 空间O(1)
     */
    class Solution2 {
        public int trap(int[] height) {
            // check null
            if (height == null || height.length == 0) return 0;
            int len = height.length;
            int leftMax = 0;
            int rightMax = 0;
            int l = 0, r = len - 1;
            int res = 0;
            while (l < r) {
                leftMax = Math.max(leftMax, height[l]);
                rightMax = Math.max(rightMax, height[r]);
                if (leftMax < rightMax) {
                    res += leftMax - height[l];
                    l++;
                } else {
                    res += rightMax - height[r];
                    r--;
                }
            }
            return res;
        }
    }
}
