package _剑指Offer;

/**
 * @ClassName: _63股票的最大利润
 * @Author: lerry_li
 * @CreateDate: 2020/12/01
 * @Description
 */
public class _63股票的最大利润 {
    /**
     * 解法0：一次遍历
     * 算法：
     *      由于只能买卖股票一次，因此只要找到一个最大的差值且左小右大。
     *      1.遍历过程中，不断更新最低值
     *      2.计算当前值与最低值的差值，更新maxProfit
     */
    public int maxProfit0(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice=Math.min(minPrice,prices[i]);
            maxProfit=Math.max(maxProfit,prices[i]-minPrice);
        }
        return maxProfit;
    }
    /**
     * 解法1：转换为每天都卖出和买入 时间O(N) 空间(1)
     * 思路：
     *      1.初始化最大利润为0，当前利润为0；
     *      2.第1天（i=0）只能买入，从第2天（i=1）开始，每天卖出前一天（i-1）买入的股票，并买入当天（i）的股票
     *      3.累加利润，并更新最大利润
     *      4.若累加利润小于0，则之后再怎么赚钱都要弥补之前的亏钱，所以把利润重置为0，表示从下一天开始重新卖出买入
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += prices[i] - prices[i - 1];
            if (profit < 0) {
                profit = 0;
            }
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }

    /**
     * 解法2：动态规划 时间O(N) 空间()
     * 状态定义：dp[i][j]表示0~i天状态为j时的最大利润
     *      j=0：不持股
     *      j=1：持股
     * 状态转移：
     *      第i天的最大利润分为两种情况：
     *      1.不持股：max
     *          1）啥也不做：第i-1天不持股的利润
     *          2）卖出：第i-1天持股+卖出的价格
     *      2.持股：max
     *          1)啥也不做：第i-1天持股的利润
     *          2）买入：由于只能买卖一次，利润为-price
     * 初始化；
     *      dp[0][0]=0
     *      dp[0][1]=-prices[0]
     * 空间优化：
     *      使用两个变量
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[dp.length - 1][0];
    }
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int noStock=0,hasStock=-prices[0];
        for (int i = 1; i < prices.length; i++) {
            noStock=Math.max(noStock,hasStock+prices[i]);
            hasStock=Math.max(hasStock,-prices[i]);
        }
        return noStock;
    }

    public static void main(String[] args) {
        _63股票的最大利润 instance = new _63股票的最大利润();
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(instance.maxProfit(prices));
    }
}
