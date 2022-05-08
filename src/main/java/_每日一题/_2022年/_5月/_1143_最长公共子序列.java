package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/08
 * @Description
 */
public class _1143_最长公共子序列 {
    /**
     * 解法1：二维dp
     */
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            //特判
            if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) return 0;
            int len1 = text1.length(), len2 = text2.length();
            //1.定义：dp[i][j]表示text1[0:i]和text2[0:j]的最长公共子序列的长度
            //最终求dp[len1][len2]
            int[][] dp = new int[len1 + 1][len2 + 1];
            //2.初始化：空串为0
            //3.转移
            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[len1][len2];
        }
    }
}
