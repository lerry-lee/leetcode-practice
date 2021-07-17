package _每日一题._2021年._21年7月;

/**
 * @ClassName: _518零钱兑换2
 * @Author: lerry_li
 * @CreateDate: 2021/07/17
 * @Description
 */
public class _518零钱兑换2 {

    public static void main(String[] args) {
        _518零钱兑换2 instance = new _518零钱兑换2();
        System.out.println(instance.change(5, new int[]{1, 2, 5}));
    }

    //二维dp
    public int change(int amount, int[] coins) {
        //特判
        if (amount == 0) return 1;
        if (coins == null || coins.length == 0 || amount < 0) return 0;
        int len = coins.length;
        //dp[i][j]表示使用前i个物品装满容量为j的背包的装法个数
        //最终返回dp[len][amount]
        int[][] dp = new int[len + 1][amount + 1];
        //初始化
        //没有硬币时，无法装，初始化dp[0][j]为0
        //amount为0是，只有一种装法，就是不装，初始化dp[i][0]=1
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }
        //状态转移
        for (int i = 1; i <= len; i++) {
            int coin = coins[i - 1];
            for (int j = 1; j <= amount; j++) {
                //当前硬币超过总金额时，无法装
                if (coin > j) dp[i][j] = dp[i - 1][j];
                    //否则，装了当前硬币coin，剩余金额变为j-coin，剩余硬币？
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
                }
            }
        }
        //返回
        return dp[len][amount];
    }

    //一维优化
    public int change2(int amount, int[] coins) {
        //特判
        if (amount == 0) return 1;
        if (coins == null || coins.length == 0 || amount < 0) return 0;
        int len = coins.length;
        //dp[j]表示必须选择硬币coin时，总金额为j的硬币组合数
        //最终返回dp[amount]
        int[] dp = new int[amount + 1];
        //初始化
        dp[0] = 1;
        //状态转移
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
