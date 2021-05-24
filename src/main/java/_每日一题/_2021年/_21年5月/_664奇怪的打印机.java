package _每日一题._2021年._21年5月;

/**
 * @ClassName: _664奇怪的打印机
 * @Author: lerry_li
 * @CreateDate: 2021/05/24
 * @Description
 * 解法1：动态规划
 */
public class _664奇怪的打印机 {
    /**
     * 解法1：动态规划 时间O(N^3) 空间O(N^2)
     */
    public int strangePrinter(String s) {
        //特判
        if (s == null || s.length() == 0) return 0;
        //dp[i][j]表示字符串s[i-j]最少打印次数
        int n = s.length();
        int[][] dp = new int[n][n];
        //状态转移
        for (int i = n - 1; i >= 0; i--) {
            //初始化dp[i][i]为1，表示单个字符需要打印1次
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                //若s[i]==s[j]，则可由dp[i][j-1]转移来
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i][j - 1];
                    //否则，枚举区间[i,j-1]，选最优
                else {
                    int temp = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        temp = Math.min(temp, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = temp;
                }
            }
        }
        //返回
        return dp[0][n-1];
    }
}
