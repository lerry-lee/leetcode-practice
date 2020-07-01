package _字节跳动推荐._动态或贪心;

/**
 * @author lerry_ang
 * @version 1.0
 * @create 2020/06/18 11:30
 * @description 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class _买卖股票的最佳时机 {
    //双指针版
    public int maxProfit(int[] prices) {
        //左指针
        int l=0;
        //最大收益值
        int max=0;
        //右指针，遍历数组，找到和当前左指针价格差值最大的索引
        for (int r = 0; r < prices.length; r++) {
            //如果右指针的价格比左指针的价格要高，比较当前最大收益值和左右指针的价格差值，更新当前最大收益值
            if(prices[r]>prices[l]) max=Math.max(max,prices[r]-prices[l]);
            //如果右指针的价格比左指针低，更新左指针为当前索引
            else  l=r;
        }
        return max;
    }
    //动态规划版
    public int maxProfit_dp(int[] prices){
        if(prices==null||prices.length==0) return 0;
        int[] dp=new int[prices.length];
        dp[0]=0;
        //temp为0到当前索引的最低价格
        int temp=prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i]=Math.max(dp[i-1],prices[i]-temp);
            temp=Math.min(prices[i],temp);
        }
        return dp[dp.length-1];
    }
}
