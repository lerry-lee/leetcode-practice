package _每日一题._2020年._20年12月;

/**
 * @ClassName: _714买卖股票的最佳时机含手续费
 * @Author: lerry_li
 * @CreateDate: 2020/12/18
 * @Description
 */
public class _714买卖股票的最佳时机含手续费 {
    /**
     * 解法1：动态规划 时间O(N) 空间O(N)
     * 状态定义：
     *      dp[i][j]表示第i天状态为j时的最大利润
     *      j=0：不持股
     *      j=1：持股
     * 状态转移：
     *      第i天不持股：
     *      1）前一天不持股，当天啥也不做
     *      2）前一天持股，当天卖出，同时支付手续费
     *      第i天持股：
     *      1）前一天持股，当天啥也不做
     *      2）前一天不持股，当天买入
     * 初始化：
     *      dp[0][0]=0
     *      dp[0][1]=-prices[0]
     */
    public int maxProfit(int[] prices, int fee) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int n=prices.length;
        int[][] dp=new int[n][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }

    /**
     * 解法2：解法1空间优化 时间O(N) 空间O(1)
     */
    public int maxProfit2(int[] prices, int fee) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int n=prices.length;
        int noStock=0;
        int hasStock=-prices[0];
        int pre_noStock=0;
        int pre_hasStock=hasStock;
        for (int i = 1; i < n; i++) {
            noStock=Math.max(pre_noStock,pre_hasStock+prices[i]-fee);
            hasStock=Math.max(pre_hasStock,pre_noStock-prices[i]);
            pre_hasStock=hasStock;
            pre_noStock=noStock;
        }
        return noStock;
    }

    public static void main(String[] args) {
        _714买卖股票的最佳时机含手续费 instance=new _714买卖股票的最佳时机含手续费();
        int[] prices={1, 3, 2, 8, 4, 9};
        System.out.println(instance.maxProfit2(prices,2));
    }
}
