package _剑指Offer;

/**
 * @ClassName: _19正则表达式匹配
 * @Author: lerry_li
 * @CreateDate: 2021/04/10
 * @Description
 */
public class _19正则表达式匹配 {

    /**
     * 解法1：动态规划 时间O(MN) 空间O(MN)
     * 思路：
     *      参考图解
     */
    public boolean isMatch(String s, String p) {
        int len_s = s.length(), len_p = p.length();
        boolean[][] dp = new boolean[len_s + 1][len_p + 1];
        //空串匹配true
        dp[0][0] = true;
        // 初始化首行
        // i=0表示s为空串，因此p的内容只能用*抵消掉它前面的字符
        for (int p_j = 2; p_j <= len_p; p_j += 2)
            dp[0][p_j] = dp[0][p_j - 2] && p.charAt(p_j - 1) == '*';
        // 状态转移
        for (int s_i = 1; s_i <= len_s; s_i++) {
            for (int p_j = 1; p_j <= len_p; p_j++) {
                //若p[p_j-1]为'*'
                if (p.charAt(p_j - 1) == '*') {
                    //1）若*匹配0次（*和它前面字符消失）
                    if (dp[s_i][p_j - 2]) dp[s_i][p_j] = true;
                        //2）若*匹配多次(1次及以上)
                        //则s[s_i-1]这个字符被匹配掉，相当于s[s_i-1]==p[p_j-2]
                    else if (dp[s_i - 1][p_j] && s.charAt(s_i - 1) == p.charAt(p_j - 2)) dp[s_i][p_j] = true;
                        //3）若*匹配多次，且p[p_j-2]=='.'，则s[s_i-1]为任意字符都可
                    else if (dp[s_i - 1][p_j] && p.charAt(p_j - 2) == '.') dp[s_i][p_j] = true;
                }
                //若p[p_j-1]不为'*'
                else {
                    //若s[s_i-1]==p[p_j-1]，则看dp[s_i - 1][p_j - 1](上一个状态)是否为true
                    if (dp[s_i - 1][p_j - 1] && s.charAt(s_i - 1) == p.charAt(p_j - 1)) dp[s_i][p_j] = true;
                        //否则，若p[p_j-1]为'.'，则s[s_i-1]可为任意字符，也只需看dp[s_i - 1][p_j - 1](上一个状态)是否为true
                    else if (dp[s_i - 1][p_j - 1] && p.charAt(p_j - 1) == '.') dp[s_i][p_j] = true;
                }
            }
        }
        return dp[len_s][len_p];
    }

    /**
     * 解法1自己写一遍
     */
    public boolean isMatch2(String s, String p) {
        int len_s = s.length(), len_p = p.length();
        boolean[][] dp = new boolean[len_s + 1][len_p + 1];
        //初始化
        dp[0][0] = true;
        //初始化第0行，即s为空串的情况
        char[] chars_s = s.toCharArray();
        char[] chars_p = p.toCharArray();
        for (int j = 2; j <= len_p; j++) {
            if (chars_p[j - 1] == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }
        //状态转移
        for (int i = 1; i <= len_s; i++) {
            for (int j = 1; j <= len_p; j++) {
                //p[j-1]为'*'
                if (chars_p[j - 1] == '*') {
                    //*匹配0次，并且去掉p[j-1]和p[j-2]后，能成功匹配
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    }
                    //*匹配[某个确定字符]多次，并且去掉s[i-1]后，能成功匹配
                    else if (chars_s[i - 1] == chars_p[j - 2] && dp[i - 1][j]) {
                        dp[i][j] = true;
                    }
                    //*匹配[.]多次，并且去掉s[i-1]后，能成功匹配
                    else if (chars_p[j - 2] == '.' && dp[i - 1][j]) {
                        dp[i][j] = true;
                    }
                }
                //p[j-1]为'.'
                else if (chars_p[j - 1] == '.') {
                    //.匹配s[i-1]，并且p去掉p[j-1]和s去掉s[i-1]，能成功匹配
                    if (dp[i - 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
                //p[j-1]为普通字符
                else {
                    //普通字符匹配，并且p去掉p[j-1]和s去掉s[i-1]，能成功匹配
                    if (chars_p[j - 1] == chars_s[i - 1] && dp[i - 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        //返回
        return dp[len_s][len_p];
    }

}
