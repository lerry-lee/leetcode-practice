package _每日一题._2021年._21年4月;

/**
 * @ClassName: _1143最长公共子序列
 * @Author: lerry_li
 * @CreateDate: 2021/04/03
 * @Description
 */
public class _1143最长公共子序列 {
    /**
     * 解法1：动态规划 时间O(N^2) 空间O(N)
     * 输入：text1,text2
     * 输出：最长公共子序列的长度
     * 状态定义：
     * dp[i][j]表示text1[0,i]和text2[0,j]的最长公共子序列的长度
     * 状态转移：
     * 1)若text1[i]==text2[j]，则dp[i][j]=dp[i-1][j-1]+1
     * 2)若text1[i]!=text2[j]，则
     * dp[i][j]=Math.max(dp[i-1][j],dp[i][j])
     * 初始化：
     * 第0行,第0列
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1][n2];
        if (text2.charAt(0) == text1.charAt(0)) {
            dp[0][0] = 1;
        }
        //初始化第0行
        for (int j = 1; j < n2; j++) {
            if (text1.charAt(0) == text2.charAt(j)) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }
        //初始化第0列
        for (int i = 1; i < n1; i++) {
            if (text2.charAt(0) == text1.charAt(i)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        //动态规划
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1 - 1][n2 - 1];
    }

    public static void main(String[] args) {
        _1143最长公共子序列 instance = new _1143最长公共子序列();
        System.out.println(instance.longestCommonSubsequence("abcde", "ace"));
        System.out.println(instance.longestCommonSubsequence("abc", "abc"));
        System.out.println(instance.longestCommonSubsequence("abc", "def"));
        System.out.println(instance.longestCommonSubsequence("aaa", "aaaaa"));
    }
}
