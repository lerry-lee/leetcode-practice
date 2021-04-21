package _每日一题._2021年._21年4月;

import java.util.HashMap;

/**
 * @ClassName: _91解码方法
 * @Author: lerry_li
 * @CreateDate: 2021/04/21
 * @Description
 * 解法1：dfs
 * 解法2：动态规划
 * 解法3：记忆化回溯
 */
public class _91解码方法 {

    public static void main(String[] args) {
        _91解码方法 instance = new _91解码方法();
        System.out.println(instance.numDecodings("11106"));//2
        System.out.println(instance.numDecodings("12"));//2
        System.out.println(instance.numDecodings("226"));//3
        System.out.println(instance.numDecodings("0"));//0
        System.out.println(instance.numDecodings("06"));//0
    }

    /**
     * 解法1：dfs
     */
    public int numDecodings3(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        char[] chars = s.toCharArray();
        res = 0;
        dfs(chars, 0);
        return res;
    }

    /**
     * 解法2：动态规划 时间O(N) 空间O(N)
     * 状态定义：
     *      dp[i]表示s[0,i]表示的字符串可以解码的总数
     * 状态转移：
     *      若s[i]在[1,9]则dp[i]+=dp[i-1]
     *      若s[i-1,i]在[11,26]则dp[i]+=dp[i-2]
     * 初始化：
     *      dp[0]=0/1
     *      dp[1]=0/1/2
     */
    public int numDecodings2(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        if (len == 1) {
            return 1;
        }
        int[] dp = new int[len];
        char[] chars = s.toCharArray();
        dp[0] = 1;
        if (chars[1] != '0') {
            dp[1] = 1;
        }
        if (chars[0] <= '2') {
            if ((chars[0] - '0') * 10 + (chars[1] - '0') <= 26) {
                dp[1] += 1;
            }
        }
        for (int i = 2; i < len; i++) {
            if (chars[i] >= '1' && chars[i] <= '9') {
                dp[i] += dp[i - 1];
            }
            if (chars[i - 1] <= '2' && chars[i - 1] >= '1') {
                int num = (chars[i - 1] - '0') * 10 + (chars[i] - '0');
                if (num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }

    private void dfs(char[] chars, int start) {
        if (start == chars.length) {
            res++;
            return;
        }
        if (chars[start] == 0) {
            return;
        }
        int num = chars[start] - '1' + 1;
        if (num >= 1 && num <= 9) {
            dfs(chars, start + 1);
        } else {
            return;
        }
        if (num <= 2 && start < chars.length - 1) {
            num = num * 10 + chars[start + 1] - '1' + 1;
            if (num >= 10 && num <= 26)
                dfs(chars, start + 2);
        }
    }

    int res;
    HashMap<Integer, Integer> memo;

    /**
     * 解法3：记忆化回溯
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        char[] chars = s.toCharArray();
        memo = new HashMap<>();
        return dfs3(chars, 0);
    }

    private int dfs3(char[] chars, int i) {
        if (i == chars.length) {
            return 1;
        }
        if (chars[i] == '0') {
            return 0;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        int res = 0;
        res += dfs3(chars, i + 1);
        if (i < chars.length - 1 && chars[i] <= '2') {
            int num = (chars[i] - '0') * 10 + (chars[i + 1] - '0');
            if (num <= 26) {
                res += dfs3(chars, i + 2);
            }
        }
        memo.put(i, res);
        return res;
    }
}
