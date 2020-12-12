package _腾讯推荐._动态规划;

/**
 * @ClassName: _买卖股票的最佳时机2
 * @Signature: Created by lerry_li on 2020/11/03
 * @Description: 给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class _买卖股票的最佳时机2 {
    /**
     * 解法1：动态规划 时间O(N) 空间O(N)
     * 状态定义：dp[i][j]表示第i天状态为j时的最大利润
     * j=0表示不持股
     * j=1表示持有股票
     * 状态转移：
     * 第i天不持股：
     * 前一天不持股，利润不变
     * 前一天持有股票，需要卖出，利润+prices[i]
     * 第i天持有股票:
     * 前一天持有股票，利润不变
     * 前一天不持股，需要购入，利润-prices[i]
     * 初始化：
     * 第0天（i=0，即实际中的第1天）
     * dp[0][0]=0
     * dp[0][1]=-prices[0]
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[dp.length - 1][0];
    }

    /**
     * 解法2：动态规划（解法1空间优化） 时间O(N) 空间O(1)
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int noStock = 0;
        int hasStock = -prices[0];
        int preNoStock = noStock;
        int preHasStock = hasStock;
        for (int i = 1; i < prices.length; i++) {
            noStock = Math.max(preNoStock, preHasStock + prices[i]);
            hasStock = Math.max(hasStock, preNoStock - prices[i]);
            preNoStock = noStock;
            preHasStock = hasStock;
        }
        return noStock;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        _买卖股票的最佳时机2 instance = new _买卖股票的最佳时机2();
        System.out.println(instance.maxProfit2(prices));
    }
}
