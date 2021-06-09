package _每日一题._2021年._21年6月;

/**
 * @ClassName: _879盈利计划
 * @Author: lerry_li
 * @CreateDate: 2021/06/09
 * @Description
 * 解法1：动态规划
 */
public class _879盈利计划 {

    public static void main(String[] args) {
        _879盈利计划 instance = new _879盈利计划();
        System.out.println(instance.profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3}));//2
        System.out.println(instance.profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));//7
        System.out.println(instance.profitableSchemes(1, 1, new int[]{2, 2, 2, 2, 2}, new int[]{1, 2, 1, 1, 0}));//0
    }

    /**
     * 解法1：动态规划(三维) 时间O(len*n*minProfit) 空间O(len*n*minProfit)
     */
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length, MOD = (int) 1e9 + 7;
        //dp[i][j][k] 表示在前 i 个工作中选择了 j 个员工，并且满足工作利润至少为 k 的情况下的盈利计划的总数目
        int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
        //初始化：没有任务 没有人 利润需求为0的情况 这时候什么都不做就是一种方法
        dp[0][0][0] = 1;
        // 状态转移
        // 对于每个工作 i，我们根据当前工作人数上限 j，有能够开展当前工作和无法开展当前工作两种情况
        for (int i = 1; i <= len; i++) {
            int members = group[i - 1], earn = profit[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    //如果无法开展当前工作 i，那么显然：
                    if (j < members) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                    //如果能够开展当前工作 i
                    else {
                        if (k > earn) dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - members][k - earn]) % MOD;
                        //如果当前盈利earn已经超过了k，即满足了工作利润至少为k的约束，那么前面任务盈利为0就可以了
                        else dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - members][0]) % MOD;
                    }
                }
            }
        }
        int sum = 0;
        for (int j = 0; j <= n; j++) {
            sum = (sum + dp[len][j][minProfit]) % MOD;
        }
        return sum;
    }
}
