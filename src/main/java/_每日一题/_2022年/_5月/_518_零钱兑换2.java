package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/08
 * @Description
 */
public class _518_零钱兑换2 {
    /**
     * 解法1：二维dp
     */
    class Solution {
        public int change(int amount, int[] coins) {
            //特判
            if (amount == 0) return 1;
            if (coins == null || coins.length == 0) return 0;
            int len = coins.length;
            //1.定义：dp[i][j]表示使用前i个硬币凑成金额j的组合数
            //最终求dp[len][amount]
            int[][] dp = new int[len + 1][amount + 1];
            //2.初始化
            //没有硬币时，设置为0
            for (int j = 0; j <= amount; j++) {
                dp[0][j] = 0;
            }
            //金额为0时，设置为1，表示不需要任何硬币的组合方式
            for (int i = 0; i <= len; i++) {
                dp[i][0] = 1;
            }
            //3.转移：
            for (int i = 1; i <= len; i++) {
                int coin = coins[i - 1];
                for (int j = 1; j <= amount; j++) {
                    //对于当前硬币coin，可以选择使用/不使用
                    //1.若coin>j，表示当前硬币面额超过总金额j，无法使用
                    if (coin > j) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    //2.否则，使用coin或者不使用coin的总数
                    else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
                    }
                }
            }
            return dp[len][amount];
        }
    }

    /**
     * 解法2：一维dp
     */
    class Solution2 {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] += dp[i - coin];
                }
            }
            return dp[amount];
        }
    }
}
