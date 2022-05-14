package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/14
 * @Description
 */
public class _剑指Offer19_正则表达式匹配 {
    /**
     * 解法1：dp
     */
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length() + 1, n = p.length() + 1;
            // 1.dp define
            // dp[i][j] represents whether s[0:i] can match p[0:j]
            // finally return dp[lenS][lenP]
            boolean[][] dp = new boolean[m][n];
            // 2.initialize
            // dp[0][0] represents empty string, can match
            dp[0][0] = true;
            // when s is empty, whether it can be matched depends on the even bit of p is '*'
            for (int j = 2; j < n; j += 2)
                dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
            // when p is empty, no match is possible except when s is empty
            // 3.state transition
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (p.charAt(j - 1) == '*') {
                        // 1.*匹配前一个字符p[j-1]0次，即p后面2字符没了，状态取决于dp[i][j-2]
                        if (dp[i][j - 2]) {
                            dp[i][j] = true;
                        }
                        // 2. s[0:i]==p[0:j-1]，s[0:i-1]和p[0:j]是匹配的，这样*让前面的p[j-1]多出现一次，也可以匹配
                        else if (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) {
                            dp[i][j] = true;
                        }
                        // 3. p[j-1]=='.' 且 s[0:i-1]和p[0:j]匹配，那么*让.再多出现1次即可，因为.可以匹配任意单个字符
                        else if (dp[i - 1][j] && p.charAt(j - 2) == '.') {
                            dp[i][j] = true;
                        }
                    }
                    // 如果不是*，那么必须dp[i-1][j-1]匹配，并且s[i]和p[j]能够匹配
                    else {
                        if (dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) dp[i][j] = true;  // 1.
                        else if (dp[i - 1][j - 1] && p.charAt(j - 1) == '.') dp[i][j] = true;         // 2.
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
