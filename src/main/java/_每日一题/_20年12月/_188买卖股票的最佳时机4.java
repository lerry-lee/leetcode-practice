package _每日一题._20年12月;

import _工具类.CommonMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _188买卖股票的最佳时机4
 * @Author: lerry_li
 * @CreateDate: 2020/12/28
 * @Description TODO
 */
public class _188买卖股票的最佳时机4 {
    /**
     * 解法1：动态规划 时间O(N) 空间O(N)
     * 思路：
     *      1.首先求出dp数组
     *      2.遍历dp数组，找出k个最大的
     */
    public int maxProfit(int k, int[] prices) {
        if(k<1||prices==null||prices.length==0){
            return 0;
        }
        int n=prices.length;
        int[][] dp=new int[n][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        System.out.print("[");
        for(int[] dpi:dp){
            System.out.print("[");
            for(int em:dpi){
                System.out.print(em+" ");
            }
            System.out.print("]");
        }
        System.out.println("]");

        //遍历dp数组

        return 0;
    }

    public static void main(String[] args) {
        _188买卖股票的最佳时机4 instance=new _188买卖股票的最佳时机4();
        int[] prices={3,2,6,5,0,3};
        instance.maxProfit(2,prices);
    }
}
