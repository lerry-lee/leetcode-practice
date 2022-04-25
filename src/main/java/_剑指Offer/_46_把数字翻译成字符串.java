package _剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/25
 */
public class _46_把数字翻译成字符串 {

    public static void main(String[] args) {
        _46_把数字翻译成字符串 instance = new _46_把数字翻译成字符串();
        instance.new Solution2().translateNum(12258);
    }

    /**
     * 解法1：带备忘录的递归
     */
    class Solution1 {
        int[] memo;

        public int translateNum(int num) {
            if (num < 0) return 0;
            int digit = 0;
            List<Integer> numDigit = new ArrayList();
            while (num > 0) {
                numDigit.add(num % 10);
                num /= 10;
                digit++;
            }
            memo = new int[digit];
            Arrays.fill(memo, -1);
            return dfs(numDigit, digit - 1);
        }

        public int dfs(List<Integer> numDigit, int t) {
            if (t < 0) return 1;
            if (memo[t] != -1) return memo[t];
            memo[t] = dfs(numDigit, t - 1);
            if (t > 0 && numDigit.get(t) > 0 && numDigit.get(t) * 10 + numDigit.get(t - 1) <= 25) {
                memo[t] += dfs(numDigit, t - 2);
            }
            return memo[t];
        }
    }

    /**
     * 解法2：动态规划
     */
    class Solution2 {
        public int translateNum(int num) {
            if (num < 0) return 0;
            List<Integer> numDigit = new ArrayList();
            while (num > 0) {
                numDigit.add(0, num % 10);
                num /= 10;
            }
            int[] dp = new int[numDigit.size() + 1];
            dp[0] = 1;
            for (int i = 1; i < dp.length; i++) {
                dp[i] = dp[i - 1];
                int n = numDigit.get(i - 1);
                if (i > 1 && numDigit.get(i - 2) > 0 && numDigit.get(i - 1) + numDigit.get(i - 2) * 10 <= 25) {
                    dp[i] += dp[i - 2];
                }
            }
            return dp[dp.length - 1];
        }
    }
}
