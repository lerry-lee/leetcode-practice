package _每日一题._2022年._5月2日;

import java.util.Arrays;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/02
 * @Description
 */
public class _322_零钱兑换 {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (coins == null || coins.length == 0) return -1;
            int len = coins.length;
            Arrays.sort(coins);
            //1.dp定义：dp[i][j]表示使用前i个硬币凑成j金额的最少硬币数
            //  最终求dp[len-1][amount]
            int[][] dp = new int[len][amount + 1];
            //2.初始化：dp[i][0]=0 金额为0时，最少硬币数为0
            for (int i = 0; i < len; i++) {
                dp[i][0] = 0;
            }
            //3.转移
            for (int i = 0; i < len; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j >= coins[i]) {
                        if(dp[i][j - coins[i]]==-1) dp[i][j]=-1;
                        else dp[i][j] = dp[i][j - coins[i]] + 1;
                    } else {
                        if(i==0) dp[i][j]=-1;
                        else dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[len - 1][amount];
        }
    }
}
