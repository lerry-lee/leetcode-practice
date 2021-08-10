package _每日一题._2021年._21年8月;

/**
 * @ClassName: _413等差数列划分
 * @Author: lerry_li
 * @CreateDate: 2021/08/10
 * @Description
 */
public class _413等差数列划分 {
    /**
     * 解法1：暴力 时间O(N^2) 空间O(1)
     * 解法2: dp 时间O(N) 空间O(N)
     */
    public int numberOfArithmeticSlices(int[] nums) {
        //特判
        if(nums==null||nums.length<3) return 0;
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=0;
        dp[1]=0;
        for (int i = 2; i < n; i++) {
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=0;
            }
        }
        int res=0;
        for(int dpi:dp) res+=dpi;
        return res;
    }
}
