package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/08
 * @Description
 */
public class _115_不同的子序列 {

    /**
     * 解法1：二维dp 时间O(MN) 空间O(MN)
     */
    class Solution {
        public int numDistinct(String s, String t) {
            //特判
            if (s == null || t == null || s.length() < t.length()) return 0;
            //1.定义：dp[i][j]表示s[i]的子序列中等于t[j]的个数
            //最终求dp[lenS][lenT]
            int lenS = s.length(), lenT = t.length();
            int[][] dp = new int[lenS + 1][lenT + 1];
            //2.初始化
            //s为空串时
            for (int i = 0; i <= lenT; i++) {
                dp[0][i] = 0;
            }
            //t为空串时
            for (int i = 0; i <= lenS; i++) {
                dp[i][0] = 1;
            }
            //3.转移
            for (int i = 1; i <= lenS; i++) {
                //注意：s长度不能小于t
                for (int j = 1; j <= lenT && j <= i; j++) {
                    //若当前字符s[i]和t[j]相同
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        //选择该字符s[i]和t[i]匹配/不匹配
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    }
                    //否则
                    else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[lenS][lenT];
        }
    }
}
