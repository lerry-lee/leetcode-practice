package _每日一题._2021年._21年5月;

/**
 * @ClassName: _最长公共子序列2
 * @Author: lerry_li
 * @CreateDate: 2021/05/27
 * @Description
 * 解法1：动态规划
 */
public class _最长公共子序列2 {
    /**
     * 给定两个字符串str1和str2，输出两个字符串的最长公共子序列。如果最长公共子序列为空，则返回"-1"。
     * 目前给出的数据，仅仅会存在一个最长的公共子序列
     */
    //解法1：动态规划 时间(MN) 空间O(MN)
    public String LCS (String s1, String s2) {
        //特判
        if(s1==null||s1.length()==0||s2==null||s2.length()==0) return "-1";
        char[] arr1=s1.toCharArray(),arr2=s2.toCharArray();
        int len1=arr1.length,len2=arr2.length;
        //状态定义：
        //dp[i][j]表示s1[i-1]和s2[j-1]的最长公共子序列的长度
        int[][] dp=new int[len1+1][len2+1];
        //这里省略初始化0行0列均为0
        //coding...
        //状态转移：
        //dp[i][j]可由
        //1)当s1[i-1]==s2[j-1]时，dp[i][j]=dp[i-1][j-1]
        //2)当s1[i-1]!=s2[j-1]时，dp[i][j]=max(dp[i][j-1],dp[i][j-1])
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(arr1[i-1]==arr2[j-1]) {
                    dp[i][j]=dp[i-1][j-1]+1;

                }
                else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        //若公共子序列长度为0，则返回"-1"
        if(dp[len1][len2]==0) return "-1";
//         for(int[] dpi:dp)    System.out.println(Arrays.toString(dpi));
        StringBuilder sb=new StringBuilder();
        //构造LCS(以s1为基础)
        //1.若s1[i-1]==s2[j-1]，则添加当前字符s1[i-1]到结果字符串中
        //  然后i-1,j-1，因为相同的字符串用掉了，相当于s1和s2都要去掉这个字符
        //2.若s1[i-1]!=s2[j-1]，则看dp[i-1][j]和dp[i][j-1]哪个和dp[i][j]相等，这样就可以往那个方向继续找
        //  若都相等，则随便那个都行，最终走到步骤1的情况就可以添加一个相同的字符了。
        //最终i或者j=0就退出循环
        int i=len1,j=len2;
        while(i>0&&j>0){
            if(arr1[i-1]==arr2[j-1]){
                sb.append(arr1[i-1]);
                i--;
                j--;
            }else{
                if(dp[i][j-1]==dp[i][j]){
                    j--;
                }else{
                    i--;
                }
            }
        }
        return sb.reverse().toString();
    }
}
