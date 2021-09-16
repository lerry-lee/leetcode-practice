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
}
