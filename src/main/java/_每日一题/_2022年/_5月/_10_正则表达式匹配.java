package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/15
 * @Description
 */
public class _10_正则表达式匹配 {

    public static void main(String[] args) {
        _10_正则表达式匹配 instance = new _10_正则表达式匹配();
        System.out.println(instance.new Solution().isMatch("ab", ".*"));
    }

    /**
     * solution: dp time-complexity O(mn) space-complexity O(mn)
     * 思路：
     *      看p的当前字符是否是*，是*就分情况，不是就看能不能匹配s的字符
     * 【注意】：
     *      初始化时，p的*只能出现在偶数位才有用，因为*必须和前面的字符匹配发挥作用
     */
    class Solution {
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) return false;
            int lenS = s.length(), lenP = p.length();
            char[] arrS = s.toCharArray(), arrP = p.toCharArray();
            // 1. dp define: dp[i][j] represents s[0:i] is match p[0:j]
            // finally return dp[lenS][lenP]
            boolean[][] dp = new boolean[lenS + 1][lenP + 1];
            // 2. initialize
            // when s and p is empty, they can match
            dp[0][0] = true;
            // when p is empty and s is not empty, they can not match
            for (int i = 1; i < lenS; i++) {
                dp[i][0] = false;
            }
            // when s is empty
            for (int j = 2; j <= lenP; j += 2) {
                if (arrP[j - 1] == '*') {
                    dp[0][j] = dp[0][j - 2];
                }
            }
            // 3. state transition
            for (int i = 1; i <= lenS; i++) {
                for (int j = 1; j <= lenP; j++) {
                    // when arrP[j] is '*'
                    if (arrP[j - 1] == '*') {
                        // '*' match 0 time
                        if (dp[i][j - 2]) {
                            dp[i][j] = true;
                        }
                        // '*' match several times
                        else if (dp[i - 1][j] && (arrS[i - 1] == arrP[j - 2] || arrP[j - 2] == '.')) {
                            dp[i][j] = true;
                        }
                    }
                    // not '*'
                    else {
                        if (arrS[i - 1] == arrP[j - 1] && dp[i - 1][j - 1]) {
                            dp[i][j] = true;
                        } else if (arrP[j - 1] == '.' && dp[i - 1][j - 1]) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
            // finally
            return dp[lenS][lenP];
        }
    }
}
