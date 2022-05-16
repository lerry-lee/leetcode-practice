package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/12
 * @Description
 */
public class _123_买卖股票的最佳时机3 {
    /**
     * 解法1：dp 时间 空间O(NK) O(K)
     */
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int k = 2;
            int n = prices.length;
            //定义二维数组，交易了多少次、当前的状态
            int[][] dp = new int[k + 1][2];
            for (int i = 0; i <= k; ++i) {
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= k; j++) {
                    //不持有股票
                    dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                    //持有股票
                    dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
                }
            }
            int res = 0;
            for (int i = 0; i <= k; i++) {
                res = Math.max(res, dp[i][0]);
            }
            return res;
        }
    }
}
