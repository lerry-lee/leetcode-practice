package _每日一题._2022年._befor5月;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/25
 */
public class _139_单词拆分 {
    public static void main(String[] args) {
        _139_单词拆分 instance=new _139_单词拆分();
        List<String> wordDict=new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(instance.new Solution2().wordBreak("leetcode", wordDict));
    }

    /**
     * 解法1：带备忘录的递归
     */
    class Solution {
        int maxLen;
        Set<String> hashSet;
        char[] arr;
        String s;
        int[] memo;
        public boolean wordBreak(String s, List<String> wordDict) {
            hashSet=new HashSet<>();
            for(String word:wordDict){
                hashSet.add(word);
                maxLen=Math.max(maxLen,word.length());
            }
            arr=s.toCharArray();
            memo=new int[arr.length];
            this.s=s;
            return dfs(0);
        }
        public boolean dfs(int t){
            if(t==arr.length) return true;
            if(memo[t]!=0) return memo[t] == 1;
            boolean flag=false;
            for(int i=t;i<arr.length;i++){
                if(i-t+1>maxLen) break;
                String word=s.substring(t,i+1);
                if(hashSet.contains(word)){
                    flag=dfs(i+1);
                }
                if(flag) {
                    memo[t]=1;
                    return true;
                }
            }
            memo[t]=-1;
            return false;
        }
    }

    /**
     * 解法2：动态规划
     * 思路：
     *      定义：
     *          dp[i]表示s[0:i-1]是否合法
     *      初始化：
     *          dp[0]=true，表示空串合法
     *      状态转移：
     *          对于i,枚举j=[0:i]如果dp[j]=true,那么判断s[j:i]是否为单词，如果是，那么dp[i]=true
     *      返回：dp[len]
     *      */
    class Solution2 {
        public boolean wordBreak(String s, List<String> wordDict) {
            int len=s.length();
            Set<String> hashSet=new HashSet();
            int maxLen=0;
            for(String word:wordDict) {
                hashSet.add(word);
                maxLen=Math.max(maxLen,word.length());
            }
            boolean[] dp=new boolean[len+1];
            dp[0]=true;
            for(int i=1;i<=len;i++){
                for(int j=i;j>=0;j--){
                    if(j-i+1>maxLen) break;
                    if(dp[j]){
                        String word=s.substring(j,i);
                        if(hashSet.contains(word)){
                            dp[i]=true;
                            break;
                        }
                    }
                }
            }
            return dp[len];
        }
    }
}
