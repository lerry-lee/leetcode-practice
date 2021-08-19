package _每日一题._2021年._21年8月;

/**
 * @ClassName: _552学生出勤记录2
 * @Author: lerry_li
 * @CreateDate: 2021/08/18
 * @Description
 */
public class _552学生出勤记录2 {

    public static void main(String[] args) {
        _552学生出勤记录2 instance = new _552学生出勤记录2();
        System.out.println(instance.checkRecord(2));//8
        System.out.println(instance.checkRecord(1));//3
        System.out.println(instance.checkRecord(10101));
    }

    /**
     * 解法2：动态规划
     */
    public int checkRecord2(int n) {
        final int MOD = 1000000007;
        //dp[i][j][k]表示前i天有j次A(缺勤)并且有连续k个L(迟到)的情况下，符合奖励条件的出勤记录的数量
        int[][][] dp = new int[n + 1][2][3]; //
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            // 以 P 结尾的数量
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                }
            }
            // 以 A 结尾的数量
            for (int k = 0; k <= 2; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD;
            }
            // 以 L 结尾的数量
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                }
            }
        }
        int sum = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                sum = (sum + dp[n][j][k]) % MOD;
            }
        }
        return sum;
    }

    /**
     * 解法1：回溯+备忘录
     */
    public int checkRecord(int n) {
        if (n < 1) return 0;
        memo = new int[n][2][3];
        return dfs(n, 0, 0, 0);
    }

    int mod = 1000000007;
    int[][][] memo;

    private int dfs(int n, int index, int absentNum, int lateNum) {
        if (absentNum == 2 || lateNum == 3) return 0;
        if (index == n) {
            return 1;
        }
        //查备忘录
        if (memo[index][absentNum][lateNum] != 0) return memo[index][absentNum][lateNum];
        int res = 0;
        //添加一个A
        res = (res + dfs(n, index + 1, absentNum + 1, 0)) % mod;
        //添加一个L
        res = (res + dfs(n, index + 1, absentNum, lateNum + 1)) % mod;
        //添加一个P
        res = (res + dfs(n, index + 1, absentNum, 0)) % mod;
        memo[index][absentNum][lateNum] = res;
        return res;
    }

}
