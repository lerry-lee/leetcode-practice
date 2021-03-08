package _每日一题._2021年._21年3月;

import java.util.Arrays;

/**
 * @ClassName: _132分割回文串2
 * @Author: lerry_li
 * @CreateDate: 2021/03/08
 * @Description
 */
public class _132分割回文串2 {

    /**
     * 解法1：中心扩展预存所有回文串+回溯：超时
     */

    int res;

    public int minCut(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();

        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] array = s.toCharArray();

        //中心扩展法预处理所有回文串
        for (int i = 0; i < 2 * len; i++) {
            int l, r;
            if (i % 2 == 0) {
                l = i / 2 - 1;
                r = i / 2 + 1;
            } else {
                l = i / 2;
                r = i / 2 + 1;
            }
            while (l >= 0 && r < len) {
                if (array[l] != array[r]) {
                    break;
                }
                dp[l][r] = true;
                l--;
                r++;
            }
        }
        res = len;
        dfs(array, dp, 0, 0);

        return res - 1;

    }

    public void dfs(char[] array, boolean[][] dp, int t, int count) {

        if (count > res) {
            return;
        }

        if (t >= array.length) {
            res = Math.min(res, count);
            return;
        }

        for (int i = array.length - 1; i >= t; i--) {
            if (!dp[t][i]) {
                continue;
            }
            dfs(array, dp, i + 1, count + 1);
        }
    }

    /**
     * 解法2：动态规划
     */
    public int minCut2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
//            Arrays.fill(dp[i], true);
            dp[i][i] = true;
        }

        //动态规划预处理所有回文串
        //状态定义：dp[i][j]表示区间[i,j]的字符串是否是回文串
        //状态转移：dp[i][j]为回文串，当且仅当
        //      1)i和j所指的字符相同
        //      2)dp[i+1][j-1]为回文串
        //初始化：dp[i][i]=true
        for (int i = n-1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }

        //动态规划计算回文串的最小分割个数
        //状态定义：f[i]表示区间[0,i]的字符串的回文串的最少分割个数
        //状态转移：f[i]可以由f[j](j<i)转移而来，如果区间[j,i]的子串是回文串，那么f[i]可以为f[j]+1，如果有多个j满足条件，取f[j]最小值
        //初始化：int最大值
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        //遍历字符串
        for (int i = 0; i < n; ++i) {
            //若当前串为回文串，则区间[0,i]需要分割的次数为0（因为整个都是回文串了）
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                //否则，从0开始遍历到i-1
                for (int j = 0; j < i; ++j) {
                    //如果区间[j+1,i]的子串是回文串，则f[i]的值为f[i]和f[j]+1的最小值
                    if (dp[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n - 1];
    }

    public static void main(String[] args) {
        _132分割回文串2 instance = new _132分割回文串2();
        System.out.println(instance.minCut("aab"));
        System.out.println(instance.minCut("a"));
        System.out.println(instance.minCut("ab"));
        System.out.println(instance.minCut("ababababababababababababcbabababababababababababa"));
    }
}
