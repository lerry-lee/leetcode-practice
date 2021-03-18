package _每日一题._2021年._21年3月;

/**
 * @ClassName: _322零钱兑换
 * @Author: lerry_li
 * @CreateDate: 2021/03/18
 * @Description
 */
public class _322零钱兑换 {
    /**
     * 解法1：带备忘录的递归
     * @param coins 不同面额的硬币
     * @param amount 总金额
     * @return 凑成总金额所需的最少的硬币个数
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int[] memo = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            memo[i] = -1;
        }
        return dfs(coins, amount, memo);
    }

    public int dfs(int[] coins, int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -1) {
            return memo[amount];
        }
        int minRes = Integer.MAX_VALUE;
        for (int coin : coins) {
            //递归求解，为-1则跳过
            int subRes = dfs(coins, amount - coin, memo);
            if (subRes == -1) {
                continue;
            }
            minRes = Math.min(minRes, 1 + subRes);
        }
        //加入备忘录
        if (minRes == Integer.MAX_VALUE) {
            memo[amount] = -1;
        } else {
            memo[amount] = minRes;
        }
        return memo[amount];
    }

    /**
     * 解法2：动态规划
     * @param coins 不同面额的硬币
     * @param amount 总金额
     * @return 凑成总金额所需的最少的硬币个数
     */
    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        //dp数组赋初值为不可达
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        //初始化
        dp[0] = 0;
        //外层遍历所有状态
        for (int i = 1; i <= amount; i++) {
            //内层求所有选择的最优解
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                //子问题若问题，跳过，否则可能int溢出
                if(dp[i-coin]==Integer.MAX_VALUE){
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin]+1);
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        _322零钱兑换 instance=new _322零钱兑换();
        int[] coins={1,2,5};
        System.out.println(instance.coinChange2(coins,11));
    }
}
