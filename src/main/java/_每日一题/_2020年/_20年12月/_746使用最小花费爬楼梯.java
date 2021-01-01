package _每日一题._2020年._20年12月;

/**
 * @ClassName: _746使用最小花费爬楼梯
 * @Author: lerry_li
 * @CreateDate: 2020/12/23
 * @Description
 */
public class _746使用最小花费爬楼梯 {
    /**
     * 解法1：动态规划 时间O(N) 空间O(N)
     * 状态定义：
     *      dp[i]表示到达第i个阶梯的最小花费,要求到达楼层顶部的最低花费，因此最终返回dp[n]，n为阶梯数
     * 状态转移：
     *      到达第i个阶梯的最小花费为“i-1的最小花费+从i-1过来的花费”或者“i-2的最小花费+从i-2过来的花费”
     *      即：dp[i]=min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
     * 初始化：
     *      第0个阶梯和第1个阶梯的花费为0
     *      即：dp[0]=dp[1]=0
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length < 2) {
            return 0;
        }
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    /**
     * 解法2：dp空间优化 时间O(N) 空间O(1)
     */
    public int minCostClimbingStairs2(int[] cost) {
        if (cost == null || cost.length < 2) {
            return 0;
        }
        int n = cost.length;
        int cost_last2 = 0;
        int cost_last1 = 0;
        int cost_curr = 0;
        for (int i = 2; i <= n; i++) {
            cost_curr = Math.min(cost_last1 + cost[i - 1], cost_last2 + cost[i - 2]);
            cost_last2 = cost_last1;
            cost_last1 = cost_curr;
        }
        return cost_curr;
    }

    public static void main(String[] args) {
        _746使用最小花费爬楼梯 instance = new _746使用最小花费爬楼梯();
        int[] cost = {10, 15, 20};
        int[] cost1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(instance.minCostClimbingStairs2(cost));
        System.out.println(instance.minCostClimbingStairs2(cost1));
    }
}
