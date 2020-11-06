package Tecent._数组与字符串;

/**
 * @Class : _最长回文子串
 * @Date : 2020/09/13 10:15
 * @Author : lerry_li
 * @Description : 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class _最长回文子串 {
    /**
     * 解法1：中心扩展法
     */
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        int n=s.length()*2-1;
        int start=0,end=0;
        for(int i=0;i<n;i++){
            int p1,p2;
            if(i%2==0){
                p1=i/2;
                p2=p1+1;
            }
            else{
                p1=i/2-1;
                p2=p1+2;
            }
            while(p1>=0&&p2<s.length()){
                if(s.charAt(p1)==s.charAt(p2)){
                    p1--;
                    p2++;
                }
                else break;
            }
            if(end-start<p2-1-p1-1){
                start=p1+1;
                end=p2-1;
            }
        }
        return s.substring(start,end+1);
    }
    /**
     * 解法2：动态规划
     * 定义：dp[i][j]表示s[i]到s[j]是否为回文串，左闭右闭区间
     * 初始化：dp[i][i]=true，只有一个元素时，该元素为回文串，也就是dp表上的对角线的值
     * 转移方程：dp[i][j]=s[i]==s[j]&&dp[i+1][j-1]
     */
    public String longestPalindrome_dp(String s) {
        if(s.length()<2) return s;
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;i++) dp[i][i]=true;
        int start=0,end=0;
        for(int j=1;j<n;j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i)==s.charAt(j)){
                    if(i+1==j) dp[i][j]=true;
                    else dp[i][j]=dp[i+1][j-1];
                }
                if(dp[i][j]&&j-i>end-start){
                    start=i;
                    end=j;
                }
            }
        }
        return s.substring(start,end+1);
    }
}
