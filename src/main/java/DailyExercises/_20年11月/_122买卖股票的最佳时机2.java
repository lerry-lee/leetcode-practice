package DailyExercises._20年11月;

/**
 * @ClassName: _122买卖股票的最佳时机2
 * @Signature: Created by lerry_li on 2020/11/08
 * @Description: 给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class _122买卖股票的最佳时机2 {
    /**
     * 解法1:动态规划 时间O(N) 空间O(1)
     * 状态定义：
     * noStock：当天【不持有股票】的最大利润
     * hasStock：当天【持有股票】的最大利润
     * preNoStock：前一天【不持有股票】的最大利润
     * preHasStock：前一天【持有股票】的最大利润
     * 状态转移：
     * noStock：当天【不持有股票】
     * 1）前一天也【不持有股票】，当天什么也不做，noStock=preNoStock
     * 2）前一天【持有股票】，当天卖出，noStock=preHasStock+prices[i]
     * hasStock：当天【持有股票】
     * 1）前一天也【持有股票】，当天什么也不做，hasStock=preHasStock
     * 2）前一天【不持有股票】，当天买入，hasStock=preNoStock-prices[i]
     * 初始化：
     * noStock=0;//第1天【不持有股票】的最大利润为0
     * hasStock=-prices[0];//第1天【持有股票】的最大利润为-prices[0]
     * preNoStock=noStock;//第1天【不持有股票】的最大利润
     * preHasStock=hasStock;//第1天【持有股票】的最大利润
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int noStock = 0;
        int hasStock = -prices[0];
        int preNoStock = noStock;
        int preHasStock = hasStock;
        for (int i = 1; i < prices.length; i++) {
            noStock = Math.max(preNoStock, preHasStock + prices[i]);
            hasStock = Math.max(preHasStock, preNoStock - prices[i]);
            preNoStock = noStock;
            preHasStock = hasStock;
        }
        return noStock;
    }
}
