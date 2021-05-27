package _每日一题._2021年._21年5月;

import java.util.Arrays;

/**
 * @ClassName: _72编辑距离
 * @Author: lerry_li
 * @CreateDate: 2021/05/27
 * @Description 牛客网的“最小编辑代价”是该题目变体
 * 解法1：带备忘录的递归版dp
 * 解法2：dp
 */
public class _72编辑距离 {

    public static void main(String[] args) {
        _72编辑距离 instance = new _72编辑距离();
        System.out.println(instance.minDistance("horse", "ros"));//3
        System.out.println(instance.minDistance("intention", "execution"));//5
    }

    /**
     * 解法1：带备忘录的递归版dp
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        //特判
        if (len2 == 0) return len1;
        //数组版备忘录初始化
        memo = new int[len1][len2];
        for (int[] memoi : memo) Arrays.fill(memoi, -1);
        //递归求解
        return dp(word1, len1 - 1, word2, len2 - 1);
    }

    private int dp(String word1, int i, String word2, int j) {
        if (j == -1) return i + 1;
        if (i == -1) return j + 1;
        if (memo[i][j] != -1) return memo[i][j];
        char c1 = word1.charAt(i), c2 = word2.charAt(j);
        //若当前字符c1,c2相等，则无须任何操作
        if (c1 == c2) memo[i][j] = dp(word1, i - 1, word2, j - 1);
            //否则，三个操作中选最优的
        else
            memo[i][j] = Math.min(dp(word1, i - 1, word2, j - 1), Math.min(dp(word1, i, word2, j - 1), dp(word1, i - 1, word2, j))) + 1;
        return memo[i][j];
    }

    int[][] memo;

    /**
     * 解法2：dp 时间O(MN) 空间O(MN)
     */
    public int minDistance2(String word1, String word2) {
        int dc = 1, ic = 1, rc = 1;//dc表示删除的代价，ic表示插入的代价，rc表示替换的代价
        char[] arr1 = word1.toCharArray(), arr2 = word2.toCharArray();
        int len1 = arr1.length, len2 = arr2.length;
        if (len2 == 0) return dc * len1;
        if (len1 == 0) return ic * len2;
        //初始
        int[][] dp = new int[len1 + 1][len2 + 1];
        //0列，str2为空
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = dc * i;
        }
        //0行，str1为空
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = ic * i;
        }
        //转移
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (arr1[i - 1] == arr2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + rc, dp[i - 1][j] + dc), dp[i][j - 1] + ic);
                }
            }
        }
        return dp[len1][len2];
    }
}
