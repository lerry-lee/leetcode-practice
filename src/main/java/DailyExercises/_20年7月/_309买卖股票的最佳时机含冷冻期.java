package DailyExercises._20年7月;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/10 14:39
 * @description 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class _309买卖股票的最佳时机含冷冻期 {
    /**
     * 思路1：动态规划 时间复杂度O(n) 空间复杂度O(n)
     * 1.状态定义：
     * dp[i][j]表示第i天状态为j时的最大收益，j的值为{0:不持股,1:持股,2:冷冻期}
     * 2.状态转移：
     * （1）不持股
     * ①昨天不持股-->今天无操作，仍然不持股；
     * ②昨天持股-->今天卖出，状态变为不持股；
     * （2）持股
     * ①昨天持股-->今天无操作，仍然持股；
     * ②昨天是冷冻期-->今天买入，状态变为持股；
     * （3）冷冻期
     * 持股后卖出，第二天即为冷冻期。因此冷冻期只能由昨天的不持股状态转移得到
     * 3.初始化：
     * （1）dp[0][0]=0，表示第1天不持股的收益为0
     * （2）dp[0][1]=-prices[0]，表示第1天持股的收益为-prices[0]，相当于买入第一天的股票
     * （3）dp[0][2]=0，第一天冷冻期的收益为0，其实第一天也不可能是冷冻期，但初始化为0
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
            dp[i][2] = dp[i - 1][0];
        }
        if (dp[dp.length - 1][0] > dp[dp.length - 1][1]) return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][2]);
        return Math.max(dp[dp.length - 1][1], dp[dp.length - 1][2]);
    }

    /**
     * 思路2：动态规划，空间优化
     * 由于思路1的状态转移只用到了前一天的状态，因此可以用三个变量存储前一天的状态，使空间复杂度降为O(1)
     */
    public int maxProfit_improve(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        //初始化
        int shareholding = -prices[0];
        int not_shareholding = 0;
        int freezing = 0;

        for (int i = 1; i < prices.length; i++) {
            int not_shareholding_cp = not_shareholding;
            int shareholding_cp = shareholding;
            not_shareholding = Math.max(not_shareholding_cp, shareholding + prices[i]);
            shareholding = Math.max(shareholding, freezing - prices[i]);
            freezing = not_shareholding_cp;
        }
        return Math.max(Math.max(not_shareholding, shareholding), freezing);
    }
}
