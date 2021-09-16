package _每日一题._2021年._21年7月;

/**
 * @ClassName: _322零钱兑换
 * @Author: lerry_li
 * @CreateDate: 2021/07/17
 * @Description
 * dp
 */
public class _322零钱兑换 {

    public static void main(String[] args) {
        _322零钱兑换 instance = new _322零钱兑换();
        System.out.println(instance.coinChange(new int[]{2}, 3));
    }

    /**
     * 解法1：二维dp
     * coins:硬币->物品，币值就是物品的重量
     * amount:总金额->背包容量
     */
    public int coinChange(int[] coins, int amount) {
        //特判:若无硬币或总金额<0，则返回-1
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        if (amount == 0) return 0;
        //dp[i][j]表示使用前i个物品装满总容量为j的背包中，最少的物品数量
        int[][] dp = new int[coins.length + 1][amount + 1];
        //初始化
        //当没有物品时，无论总容量为多少，都无法装(设置为不可达)
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = amount + 1;
        }
        //当总容量为0时，无论物品有多少个，都不用装(0)，即需要的最少硬币个数为0
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }
        //状态转移
        for (int i = 1; i <= coins.length; i++) {
            int coin = coins[i - 1];
            for (int j = 1; j <= amount; j++) {
                //若当前物品能装进去
                //则选择 装/不装
                if (coin <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coin] + 1);
                }
                //否则装不进去，和前一个一样
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        //最终返回dp[len][amount]
        return dp[coins.length][amount] == amount + 1 ? -1 : dp[coins.length][amount];
    }

    /**
     * 一维dp
     */
    public int coinChange2(int[] coins, int amount) {
        //特判:若无硬币或总金额<0，则返回-1
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        if (amount == 0) return 0;
        //dp[i]表示组成总金额为i的最少的硬币个数
        int[] dp = new int[amount + 1];
        //初始化：所有为不可达
        for (int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        //状态转移
        for (int i = 1; i <= amount; i++) {
            //枚举选择
            for (int coin : coins) {
                if (coin > i) continue;
                //选/不选
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
