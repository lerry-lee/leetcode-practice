package _每日一题._2020年._20年12月;

/**
 * @ClassName: _188买卖股票的最佳时机4
 * @Author: lerry_li
 * @CreateDate: 2020/12/28
 * @Description TODO
 */
public class _188买卖股票的最佳时机4 {
    /**
     * 解法1：动态规划 时间O(NK) 空间O(NK)
     * 状态定义：
     *      dp[i][j][0]：表示第i天交易了j次时卖出后的累计最大利润
     *      dp[i][j][1]：表示第i天交易了j次时买入后的累计最大利润
     *
     * 状态转移：
     *
     *      第k次买入： 从第k-1次卖出转换而来，或者第k次买入后保持不动
     *      dp[i][j-1][1] = max(dp[i-1][j-1][1],dp[i-1][j-1][0]-prices[i])
     *
     *      第k次卖出： 从第k次买入后转换而来，或者是第k次卖出后保持不动
     *      dp[i][j][0] = max(dp[i-1][j][0],dp[i-1][j-1][1]+prices[i])
     *
     *      第k+1次买入：
     *      dp[i][j][1] = max(dp[i-1][j][1],dp[i-1][j][0]-prices[i])
     *
     * 初始化：
     *
     */
    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length==0) {
            return 0;
        }
        int n = prices.length;
        //当k非常大时转为无限次交易
        if(k>=n/2) {
            int dp0=0,dp1=-prices[0];
            for(int i=1;i<n;++i) {
                int tmp = dp0;
                dp0 = Math.max(dp0,dp1+prices[i]);
                dp1 = Math.max(dp1,dp0-prices[i]);
            }
            return Math.max(dp0,dp1);
        }
        //定义二维数组，交易了多少次、当前的买卖状态
        int[][] dp = new int[k+1][2];
        for(int i=0;i<=k;++i) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for(int i=1;i<n;++i) {
            for(int j=k;j>0;--j) {
                //处理第k次买入
                dp[j-1][1] = Math.max(dp[j-1][1], dp[j-1][0]-prices[i]);
                //处理第k次卖出
                dp[j][0] = Math.max(dp[j][0], dp[j-1][1]+prices[i]);

            }
        }
        return dp[k][0];

    }

    /**
     * 解法2：动态规划+空间优化 时间O(NK) 空间O(K)
     * 思路：
     *      我们对三维数组进行压缩，去掉最高维度的天数n，用二维数组dp[k][2]来代替。
     *      这里的k就是交易了多少次，2表示买卖状态。
     *      由于对dp数组进行了压缩，所以内层循环采用的是逆序遍历。
     *      这是因为状态压缩之后，由于少了一个维度，正序遍历会出现状态覆盖的情况，所以改成了逆序遍历。
     */
    public int maxProfit2(int k, int[] prices) {
        if(prices==null || prices.length==0) {
            return 0;
        }
        int n = prices.length;
        //当k非常大时转为无限次交易
        if(k>=n/2) {
            int dp0=0,dp1=-prices[0];
            for(int i=1;i<n;++i) {
                int tmp = dp0;
                dp0 = Math.max(dp0,dp1+prices[i]);
                dp1 = Math.max(dp1,dp0-prices[i]);
            }
            return Math.max(dp0,dp1);
        }
        //定义二维数组，交易了多少次、当前的买卖状态
        int[][] dp = new int[k+1][2];
        int res = 0;
        for(int i=0;i<=k;++i) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for(int i=1;i<n;++i) {
            for(int j=k;j>0;--j) {
                //处理第k次买入
                dp[j-1][1] = Math.max(dp[j-1][1], dp[j-1][0]-prices[i]);
                //处理第k次卖出
                dp[j][0] = Math.max(dp[j][0], dp[j-1][1]+prices[i]);

            }
        }
        return dp[k][0];
    }

    public static void main(String[] args) {
        _188买卖股票的最佳时机4 instance=new _188买卖股票的最佳时机4();
        int[] prices={3,2,6,5,0,3};
        instance.maxProfit(2,prices);
    }
}
