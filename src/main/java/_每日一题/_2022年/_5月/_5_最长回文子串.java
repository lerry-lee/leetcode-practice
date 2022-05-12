package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/12
 * @Description
 */
public class _5_最长回文子串 {
    /**
     * 解法1：中心扩展 时间O(N^2) 空间O(1)
     */
    class Solution {
        public String longestPalindrome(String s) {
            //特判
            if (s == null || s.length() == 0) return "";
            char[] arr = s.toCharArray();
            int len = arr.length;
            int maxLen = 0, maxL = 0, maxR = 1;
            for (int i = 0; i < len * 2; i++) {
                int l, r, temp;
                if (i % 2 == 0) {
                    l = i / 2 - 1;
                    r = l + 2;
                    temp = 1;
                } else {
                    l = i / 2;
                    r = l + 1;
                    temp = 0;
                }
                while (l >= 0 && r < len) {
                    if (arr[l] == arr[r]) {
                        l--;
                        r++;
                        temp += 2;
                    } else {
                        break;
                    }
                }
                if (temp > maxLen) {
                    maxLen = temp;
                    maxL = l + 1;
                    maxR = r;
                }
            }
            return s.substring(maxL, maxR);
        }
    }

    /**
     * 解法2：dp 时间O(N^2) 空间O(N^2)
     */
    class Solution2 {
        public String longestPalindrome(String s) {
            char[] arr = s.toCharArray();
            int len = arr.length;
            //1,定义：dp[i][j]表示s[i:j]是否是回文串
            boolean[][] dp = new boolean[len][len];
            //2.初始化：dp[i][i]=1
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }
            //3.转移：
            //if s[i]==s[j] :
            //  dp[i][j]=dp[i+1][j-1]
            //else:
            //  dp[i][j](dp[i+1][j]||dp[i][j-1]
            for (int i = len - 2; i >= 0; i--) {
                for (int j = i + 1; j < len; j++) {
                    if (arr[i] == arr[j]) {
                        if (i + 1 == j) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
            //最后反推出来回文子串
            int l=0,r=0,maxLen=0;
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    if(dp[i][j]&&maxLen<j-i+1){
                        maxLen=j-i+1;
                        l=i;
                        r=j+1;
                    }
                }
            }
            return s.substring(l, r);
        }
    }
}
