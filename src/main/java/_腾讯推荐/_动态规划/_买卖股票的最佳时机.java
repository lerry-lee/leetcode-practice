package _腾讯推荐._动态规划;

/**
 * @ClassName: _买卖股票的最佳时机
 * @Signature: Created by lerry_li on 2020/11/02
 * @Description: 给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 */
public class _买卖股票的最佳时机 {
    /**
     * 解法1：动态规划 时间O(N) 空间O(N)
     * 状态定义：dp[i][j]：下标为 i 这一天结束的时候，手上持股状态为 j 时，我们持有的现金数。
     *      j = 0，表示当前不持股；
     *      j = 1，表示当前持股。
     * 推导状态转移方程：
     *  dp[i][0]：规定了今天不持股，有以下两种情况：
     *      昨天不持股，今天什么都不做；
     *      昨天持股，今天卖出股票（现金数增加），
     *  dp[i][1]：规定了今天持股，有以下两种情况：
     *      昨天持股，今天什么都不做（现金数增加）；
     *      昨天不持股，今天买入股票（注意：只允许交易一次，因此手上的现金数就是当天的股价的相反数）。
     *
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;

        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];

    }

    /**
     * 解法2：动态规划（解法1的空间优化） 时间O(N) 空间O(1)
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int noStock=0;
        int hasStock=-prices[0];
        for (int i = 1; i < len; i++) {
            noStock=Math.max(noStock,hasStock+prices[i]);
            hasStock=Math.max(hasStock,-prices[i]);
        }
        return noStock;
    }

    /**
     * 解法3：一次遍历 时间O(N) 空间O(1)
     * 每天都买入股票，第二天就卖出，如果赚钱就累积利润，如果利润为负就清零（相当于遇到了目前为止的股票价格最低值，之后再遇到股票高值便不必再看该值之前的价格了）
     * 全局维护一个变量记录最大利润
     */

    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int tempProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            tempProfit += prices[i] - prices[i - 1];
            if (tempProfit < 0) {
                tempProfit = 0;
            }
            maxProfit = Math.max(maxProfit, tempProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 3, 5, 1, 6, 4};
        System.out.println(new _买卖股票的最佳时机().maxProfit(prices));
    }
}
