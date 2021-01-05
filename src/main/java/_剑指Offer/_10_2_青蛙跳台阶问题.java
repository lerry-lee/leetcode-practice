package _剑指Offer;

/**
 * @ClassName: _10_2_青蛙跳台阶问题
 * @Author: lerry_li
 * @CreateDate: 2021/01/05
 * @Description
 */
public class _10_2_青蛙跳台阶问题 {
    /**
     * 解法1：动态规划 时间O(N) 空间O(N)
     * 状态定义：
     *      dp[i]表示青蛙跳上i级的台阶总共跳法的个数
     * 状态转移：
     *      跳上第i级台阶可以从第i-1级台阶跳1步上来，也来从第i-2级台阶跳2步上来
     *      dp[i]=dp[i-1]+dp[i-2]
     * 初始化：
     *      dp[0]=0
     *      dp[1]=1
     *      dp[2]=2
     * 返回：
     *      dp[n]，n为台阶的级数
     */
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] % 1000000007 + dp[i - 2] % 1000000007;
        }
//        System.out.println(dp[n]);
        return dp[n] % 1000000007;
    }

    /**
     * 解法2：动态规划+空间优化 时间O(N) 空间O(1)
     */
    public int numWays2(int n) {
        int last2 = 1, last1 = 1;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = last2 % 1000000007 + last1 % 1000000007;
            last2 = last1;
            last1 = res;
        }
//        System.out.println(dp[n]);
        return res % 1000000007;
    }

    public static void main(String[] args) {
        _10_2_青蛙跳台阶问题 instance = new _10_2_青蛙跳台阶问题();
        System.out.println(instance.numWays2(7));
    }
}
