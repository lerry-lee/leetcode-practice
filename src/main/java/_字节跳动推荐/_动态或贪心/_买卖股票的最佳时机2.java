package _字节跳动推荐._动态或贪心;

/**
 * @author lerry_ang
 * @version 1.0
 * @create 2020/06/18 12:08
 * @description 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class _买卖股票的最佳时机2 {
    public int maxProfit(int[] prices) {
        int l = 0;
        int max = 0;
        int temp = 0;
        for (int r = 0; r < prices.length; r++) {
            if (prices[r] > prices[l]) {
                temp = Math.max(temp, prices[r] - prices[l]);
            }
            if (r > 0 && prices[r] < prices[r - 1]) {
                max += temp;
                l = r;
                temp = 0;
            }
        }
        return max + temp;
    }

    public int maxProfit_dp(int[] prices) {
        /**
         * 动态规划：如何理解？
         * cash：持有现金
         * hold：持有股票
         * 状态转移：cash → hold → cash → hold → cash → hold → cash
         */
        if(prices==null||prices.length<2) return 0;
        int cash=0,hold=-prices[0];
        int precash=0,prehold=hold;
        for(int i=1;i<prices.length;i++){
            cash=Math.max(precash,prehold+prices[i]);
            hold=Math.max(prehold,precash-prices[i]);
            precash=cash;
            prehold=hold;
        }
        return cash;
    }

    public int maxProfit_greed(int[] prices) {
        /**
         * 贪心法：只要当天价格比第二天的低，就买入，然后第二天就卖出（如果后面价格接着递增，相当于卖出后接着买入，实际上相当于保留）
         */
        int max = 0;
        for (int r = 1; r < prices.length; r++) {
            if (prices[r] > prices[r - 1]) {
                max += (prices[r] - prices[r - 1]);
            }
        }
        return max;
    }
}
