package _每日一题._2021年._21年1月;

/**
 * @ClassName: _674最长连续递增序列
 * @Author: lerry_li
 * @CreateDate: 2021/01/24
 * @Description
 */
public class _674最长连续递增序列 {
    /**
     * 解法1：暴力 时间O(N) 空间O(1)
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLen = 1;
        int tempLen = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                tempLen++;
            } else {
                tempLen = 1;
            }
            maxLen = Math.max(maxLen, tempLen);
        }

        return maxLen;
    }

    /**
     * 解法2 动态规划
     */
    public int findLengthOfLCIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        int res = 0;
        for (int dpi : dp) {
            res = Math.max(dpi, res);
        }
        return res;
    }

    public static void main(String[] args) {
        _674最长连续递增序列 instance = new _674最长连续递增序列();
//        int[] nums={1,3,5,4,7};
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println(instance.findLengthOfLCIS(nums));
    }
}
