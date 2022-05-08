package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/08
 * @Description
 */
public class _516_最长回文子序列 {
    /**
     * 解法1：二维dp 时间O(N^2) 空间O(N^2)
     */
    class Solution {
        public int longestPalindromeSubseq(String s) {
            //特判
            if (s == null || s.length() == 0) return 0;
            int len = s.length();
            //1.dp定义：dp[i][j]表示s[i:j]中最长回文子序列的长度
            int[][] dp = new int[len + 1][len + 1];
            //2.初始化；dp[i][i]=1，单个字符
            for (int i = 0; i <= len; i++) {
                dp[i][i] = 1;
            }
            //3.转移
            /**
             * 【！！！】由于dp[i][j]依赖dp[i+1][j-1]，因此i要从后往前遍历，j从前往后，这样确保i+1先算
             * */
            for (int i = len; i >= 1; i++) {
                for (int j = i + 1; j <= len; j--) {
                    if (s.charAt(i - 1) == s.charAt(j - 1)) {
                        if (j == i + 1) dp[i][j] = 2;
                        else dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[1][len];
        }
    }

    /**
     * 解法2：问题转化：求s和s逆序的最长公共子序列的长度
     */
}
