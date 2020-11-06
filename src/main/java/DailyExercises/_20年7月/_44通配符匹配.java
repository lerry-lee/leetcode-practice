package DailyExercises._20年7月;

import java.util.Arrays;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/05 15:24
 * @description 通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 */
public class _44通配符匹配 {


    /**
     * 贪心算法：
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int len_s=s.length(),len_p=p.length();
        int[][] dp=new int[len_s+1][len_p+1];
        //dp数组默认填充为0，表示false
        for(int[] dpi:dp) Arrays.fill(dpi,0);
        //dp[0][0]为1，表示空字符串与空字符串相匹配
        dp[0][0]=1;
        //p字符串开头为*的情况，与空字符串相匹配
        for(int i=1;i<len_p+1;i++){
            if(p.charAt(i-1)!='*') break;
            dp[0][i]=1;
        }
        //遍历dp数组，从第一行第一列开始，即从s和p的第一个字符开始
        for(int i=1;i<len_s+1;i++){
            char s_c=s.charAt(i-1);
            for(int j=1;j<len_p+1;j++){
                char p_c=p.charAt(j-1);
                //若p和s的当前字符相同或p的当前字符为?，则dp的值取决于p和s去掉当前字符的匹配情况
                //p[i]==s[j],dp[i][j]==dp[i-1][j-1]
                if(p_c=='?'||p_c==s_c) dp[i][j]=dp[i-1][j-1];
                    //若p的当前字符为*，则
                    //如果*匹配的是空字符串，那么dp[i][j]=dp[i-1][j]
                    //如果*匹配了s的当前字符，那么dp[i][j]=dp[i][j-1]
                else if(p_c=='*') dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    //否则，p和s的当前字符不同，dp值为0，false
                else dp[i][j]=0;
            }
        }
        display(dp);
        return dp[len_s][len_p]==1;
    }

    public void display(int[][] dp){
        for(int[] dpi:dp){
            for(int i:dpi) System.out.print(i+" ");
            System.out.println();
        }
        System.out.println();
    }

}
