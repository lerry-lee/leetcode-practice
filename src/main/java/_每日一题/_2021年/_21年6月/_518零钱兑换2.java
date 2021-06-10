package _每日一题._2021年._21年6月;

/**
 * @ClassName: _518零钱兑换2
 * @Author: lerry_li
 * @CreateDate: 2021/06/10
 * @Description
 * 解法1：动态规划
 */
public class _518零钱兑换2 {
    /**
     * 解法1：动态规划 时间O(amount*n) 空间O(amount)
     * 要点：
         * 动态规划的边界是 dp[0]=1。只有当不选取任何硬币时，金额之和才为 0，因此只有 1 种硬币组合。
         * 对于面额为 coin 的硬币，当 coin≤i≤amount 时，
         * 如果存在一种硬币组合的金额之和等于i−coin，则在该硬币组合中增加一个面额为 coin 的硬币，
         * 即可得到一种金额之和等于i 的硬币组合。因此需要遍历 coins，
         * 对于其中的每一种面额的硬币，更新数组 dp 中的每个大于或等于该面额的元素的值。
     *
     */
    public int change(int amount, int[] coins) {
        //特判
        if (amount == 0) return 1;
        if (coins == null || coins.length == 0) return 0;
        //dp[x]表示组成面额x的硬币组合数目，目标就是求dp[amount]
        int[] dp = new int[amount+1];
        //初始化dp[0]=1，表示组成面额0的硬币组合数目为1，即0个硬币
        dp[0] = 1;
        //状态转移
        //这里外层循环是硬币，内存循环是金额，这个顺序不能换，可以和[leetcode-爬楼梯]做个对比
        //先走2步再走1步和先走1步再走2步不同，先拿2块再拿1块和先拿1块再拿2块相同，一个是排列数，一个是组合数
        for (int coin : coins) {
            //j从coin开始，因为当j<coin时，当前硬币就已经超过了面额j，已经无法组合了
            for (int j = coin; j <= amount; j++) {
                //当使用了当前一枚硬币时，面额变为j-coin，然后看组成j-coin的硬币组合数是多少，累加上来即可
                dp[j] += dp[j - coin];
            }
        }
        //最终返回dp[amount]
        return dp[amount];
    }
}
