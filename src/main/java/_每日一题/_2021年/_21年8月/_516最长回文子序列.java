package _每日一题._2021年._21年8月;

/**
 * @ClassName: _516最长回文子序列
 * @Author: lerry_li
 * @CreateDate: 2021/08/12
 * @Description
 */
public class _516最长回文子序列 {
    /**
     * 解法1：dp 时间O(N^2) 空间O(N^2)
     */
    public int longestPalindromeSubseq(String s) {
        //特判
        if(s==null||s.length()==0) return 0;
        char[] arr=s.toCharArray();
        int len=arr.length;
        //dp[i][j]表示s[i:j]子串的最大回文子序列的长度
        //最终要求dp[0][len-1]
        int[][] dp=new int[len][len];
        //初始化dp[i][i]=1
        for (int i = 0; i < len; i++) {
            dp[i][i]=1;
        }
        //状态转移
        for (int i=len-1;i>=0;i--) {
            for (int j = i+1; j < len; j++) {
                //若i和j处的字符相等，则dp[i][j]=dp[i+1][j-1]+2;
                if(arr[i]==arr[j]){
                    dp[i][j]=dp[i+1][j-1]+2;
                }
                //否则，dp[i+1][j]和dp[i][j-1]取最优
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
