package _每日一题._2022年._befor5月;

import java.util.Arrays;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/29
 * @Description
 */
public class _72_编辑距离 {

    public static void main(String[] args) {
        _72_编辑距离 instance=new _72_编辑距离();
        instance.new Solution2().minDistance("horse","ros");
    }


    /**
     * 解法1：带备忘录的递归
     */
    class Solution1 {
        int[][] memo;
        public int minDistance(String word1, String word2) {
            int n1=word1.length(),n2=word2.length();
            memo=new int[n1][n2];
            for(int[] arr:memo) Arrays.fill(arr,-1);
            return dp(word1,0,word2,0);
        }
        public int dp(String word1,int i,String word2,int j){
            if(i==word1.length()){
                return word2.length()-j;
            }
            if(j==word2.length()){
                return word1.length()-i;
            }
            if(memo[i][j]!=-1) return memo[i][j];
            if(word1.charAt(i)==word2.charAt(j)){
                memo[i][j]=dp(word1,i+1,word2,j+1);
            }else{
                memo[i][j]=Math.min(dp(word1,i,word2,j+1),Math.min(dp(word1,i+1,word2,j),dp(word1,i+1,word2,j+1)))+1;
            }
            return memo[i][j];
        }
    }

    /**
     * 解法2：dp
     */
    class Solution2 {
        public int minDistance(String word1, String word2) {
            int n1=word1.length(),n2=word2.length();
            //1.定义：dp[i][j]表示word1[0:i]到word2[0:j]最少操作数
            //最终求dp[n1][n2]
            int[][] dp=new int[n1+1][n2+1];
            //2.初始化：空串到空串操作数为0
            dp[0][0]=0;
            //空串到非空串，操作数为插入的字符数
            for(int j=1;j<=n2;j++){
                dp[0][j]=j;
            }
            //非空串到空串，操作数为删除的字符数
            for(int i=1;i<=n1;i++){
                dp[i][0]=i;
            }
            //3.状态转移：dp[i][j]的状态可由下列情况推出：
            //  1)如果word1[i]==word2[j]，那么不需要增加操作数，和去掉这两个字符的状态相同，即dp[i][j]=dp[i-1][j-1]
            //  2)否则，从下面情况里选最优：
            //      ①可以选择替换，即将word1[i]替换成word2[j]，操作数+1，dp[i][j]=dp[i-1][j-1]+1
            //      ②可以选择删除word1[i]，然后变成word1[0:i-1]->word2[0:j]，操作数+1，dp[i][j]=dp[i-1][j]+1
            //      ③可以选择插入word2[j]这个字符，然后变成word1[0:i]->word2[0:j-1]，操作数+1，dp[i][j]=dp[i][j-1]
            //遍历
            for(int i=1;i<=n1;i++){
                for(int j=1;j<=n2;j++){
                    if(word1.charAt(i-1)==word2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1];
                    }else{
                        dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                    }
                }
            }
            return dp[n1][n2];
        }
    }
}
