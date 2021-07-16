package _每日一题._2021年._21年7月;

/**
 * @ClassName: _718最长重复子数组
 * @Author: lerry_li
 * @CreateDate: 2021/07/17
 * @Description
 */
public class _718最长重复子数组 {
    /**
     * 解法1：dp 时间O(NM) 空间O(NM)
     */
    public int findLength(int[] nums1, int[] nums2) {
        //特判
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return 0;
        //dp[i][j]表示nums1[i:]和nums2[j:]的最长重复子数组
        //最终返回dp最大值
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        //初始化
        dp[n1][n2] = 0;
        //状态转移
        int res = 0;
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
