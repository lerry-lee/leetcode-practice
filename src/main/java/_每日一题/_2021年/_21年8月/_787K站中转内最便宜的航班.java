package _每日一题._2021年._21年8月;

import java.util.Arrays;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/08/25
 */
public class _787K站中转内最便宜的航班 {
    /**
     * 解法1：dp 时间O(N^2) 空间O(N^2)
     * @param n n个节点
     * @param flights flights[i]={from,to,price}表示｛出发节点，达到节点，路径距离｝
     * @param src 起始节点
     * @param dst 目标节点
     * @param k 最多走k步
     * @return 最短距离
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //初始化INF表示不可达的一个值
        final int INF = 10000 * 101 + 1;
        //dp[i][j]表示从i出发到dst走j步的最短距离
        int[][] dp = new int[n][k + 2];
        //初始化所有点到dst的最短距离为INF
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], INF);
        }
        //初始化dst到dst走0步的距离为0
        dp[dst][0] = 0;
        //状态转移
        //枚举步数
        for (int t = 1; t <= k + 1; ++t) {
            //枚举点
            for (int[] flight : flights) {
                //取出当前节点，后继结点，路径距离
                int cur = flight[0], next = flight[1], cost = flight[2];
                //从i出发到dst走t步的最短距离=min（自己，从j出发到dst走t-1的最短距离）
                dp[cur][t] = Math.min(dp[cur][t], dp[next][t - 1] + cost);
            }
        }
        //最终结果
        int ans = INF;
        //遍历从src出发到dst的所有路径和，找到最短的
        for (int t = 1; t <= k + 1; ++t) {
            ans = Math.min(ans, dp[src][t]);
        }
        return ans == INF ? -1 : ans;
    }
}
