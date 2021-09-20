package _每日一题._2021年._21年9月;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/20
 */
public class _673最长递增子序列的个数 {

    public static void main(String[] args) {
        _673最长递增子序列的个数 instance = new _673最长递增子序列的个数();
        int[] nums = new int[]{1, 3, 5, 4, 7};
        int[] nums1 = new int[]{2, 2, 2, 2, 2};
        int[] nums2 = new int[]{1, 2, 4, 3, 5, 4, 7, 2};
        int[] nums3 = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3};
        System.out.println(instance.findNumberOfLIS(nums));//2
        System.out.println(instance.findNumberOfLIS(nums1));//5
        System.out.println(instance.findNumberOfLIS(nums2));//3
        System.out.println(instance.findNumberOfLIS(nums3));//27
    }

    /**
     * 解法1：dp  时间(N^2) 空间O(N)
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        //dp[i][0]表示前i个元素的最长递增子序列的长度
        //dp[i][1]表示前i个元素的最长递增子序列的个数
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = 1;
        }
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                }
            }
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i][0] == dp[j][0] + 1) {
                        dp[i][1] += dp[j][1];
                    }
                }
            }
            dp[i][1] -= dp[i][1] == 1 ? 0 : 1;
            maxLen = Math.max(maxLen, dp[i][0]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i][0] == maxLen) {
                res += dp[i][1];
            }
        }
        return res;
    }
}
