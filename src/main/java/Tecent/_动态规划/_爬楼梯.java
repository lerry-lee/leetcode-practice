package Tecent._动态规划;

/**
 * @ClassName: _爬楼梯
 * @Signature: Created by lerry_li on 2020/10/30
 * @Description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 */
public class _爬楼梯 {
    /**
     * 解法1：回溯（超时？）
     */
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        res = 0;
        backtrack(n);
        return res;
    }

    int res;

    public void backtrack(int n) {
        if (n < 0) {
            return;
        }
        if (n == 0) {
            res++;
            return;
        }

        backtrack(n - 1);

        backtrack(n - 2);


    }

    /**
     * 解法2：动态规划
     * 状态定义：dp[i]表示到达i阶的爬楼梯方式数
     * 初始化：dp[0]=1,dp[1]=1
     * 状态转移：dp[i]=dp[i-2]+dp[i-1]
     * 到达n阶=（1）+（2）
     * （1）最后为1阶的方式，即到达n-1阶的个数
     * （2）最后为2阶的方式，即到达n-2阶的个数
     */
    public int climbStairs2(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        _爬楼梯 instance = new _爬楼梯();
        System.out.println(instance.climbStairs2(3));
    }
}
