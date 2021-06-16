package _每日一题._2021年._21年6月;

/**
 * @ClassName: _486预测赢家
 * @Author: lerry_li
 * @CreateDate: 2021/06/16
 * @Description
 * 解法1：dp
 */
public class _486预测赢家 {
    /**
     * 解法1：dp 时间O(N^2) 空间O(N^2)
     */
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        //dp[i][j] 表示作为先手，在区间 nums[i..j] 里进行选择可以获得的 相对分数。
        // 相对分数的意思是：当前自己的选择得分为正，对手的选择得分为负。
        int[][] dp = new int[len][len];

        // dp[i][j]：作为先手，在区间 nums[i..j] 里进行选择可以获得的相对分数
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }
        //状态转移方程：dp[i][j] = max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1])
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }
}
