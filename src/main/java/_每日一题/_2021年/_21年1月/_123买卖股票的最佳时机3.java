package _每日一题._2021年._21年1月;

/**
 * @ClassName: _123买卖股票的最佳时机3
 * @Author: lerry_li
 * @CreateDate: 2021/01/09
 * @Description
 */
public class _123买卖股票的最佳时机3 {

    /**
     * 解法1：动态规划
     * 状态定义：
     *      dp[i][j][0]表示第i天交易了j次时不持有股票的利润
     *      dp[i][j][1]表示第i天交易了j次时持有股票的利润
     * 状态转移：
     *      1.第i天交易了j次不持有股票的利润：
     *          1）前一天交易了j次不持有股票，当天什么也不做；
     *          2）前一天交易了j次持有股票，当天卖出;
     *      dp[i][j][0]=max(dp[i-1][j][0],dp[i-1][j-1][1]+prices[i])
     *
     *      2.第i天交易了j次持有股票的利润：
     *          1）前一天交易了j次持有股票，当天什么也不做；
     *          2）前一天交易了j-1次不持有股票，当天买入,交易次数为j；
     *      dp[i][j][1]=max(dp[i-1][j][1],dp[i-1][j][0]-prices[i])
     * 初始化：
     *      dp[0][j][0]=0
     *      dp[0][j][1]=-prices[0]
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int k=2;
        int n=prices.length;
        //定义二维数组，交易了多少次、当前的状态
        int[][][] dp = new int[n][k+1][2];
        for(int i=0;i<=k;++i) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for(int i=1;i<n;++i) {
            for(int j=k;j>0;--j) {
                //持有股票
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i]);
                //不持有股票
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]+prices[i]);

            }
        }
        int res=0;
        for (int i = 0; i <= k; i++) {
            res=Math.max(res,dp[n-1][i][0]);
        }
        return res;
    }

    /**
     * 解法2：动态规划+空间优化
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int k=2;
        int n=prices.length;
        //定义二维数组，交易了多少次、当前的状态
        int[][] dp = new int[k+1][2];
        for(int i=0;i<=k;++i) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for(int i=1;i<n;++i) {
            for(int j=k;j>0;--j) {
                //不持有股票
                dp[j][0] = Math.max(dp[j][0], dp[j][1]+prices[i]);
                //持有股票
                dp[j][1] = Math.max(dp[j][1], dp[j-1][0]-prices[i]);
            }
        }
        int res=0;
        for (int i = 0; i <= k; i++) {
            res=Math.max(res,dp[i][0]);
        }
        return res;
    }

    public static void main(String[] args) {
        _123买卖股票的最佳时机3 instance = new _123买卖股票的最佳时机3();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int[] prices1 = {1, 2, 3, 4, 5};
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(instance.maxProfit2(prices));
        System.out.println(instance.maxProfit2(prices1));
        System.out.println(instance.maxProfit2(prices2));
    }
}
