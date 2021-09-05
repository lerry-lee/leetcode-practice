package _其他._笔试题._中金所;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/03
 */
public class _最相似公共子序列 {

    public static void main(String[] args) {
        String s1="ABCDFDFFEE";
        String s2="ABCDD";
        System.out.println(longestCommonSubSequence(s1,s2));
    }

    /**
     * 解法1：dp 时间(mn) 空间O(mn)
     */
    public static int longestCommonSubSequence(String s1, String s2) {
        //特判略
        int len1 = s1.length(), len2 = s2.length();
        //dp[i][j]表示s1[0:i]和s2[0:j]的最长公共子序列
        //最终目标是求dp[len1][len2]
        int[][] dp = new int[len1 + 1][len2 + 1];
        //初始化空串的最长公共子序列为0
        //dp[0][i]=0 and dp[i][0]=0
        //状态转移
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                //若s1[i]==s2[j]，则由上一个状态转移而来
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                //否则，枚举所有选择，取最优
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
