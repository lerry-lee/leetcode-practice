package _每日一题._2021年._21年8月;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/08/23
 */
public class _1646获取生成数组中的最大值 {

    public static void main(String[] args) {
        _1646获取生成数组中的最大值 instance=new _1646获取生成数组中的最大值();
        System.out.println(instance.getMaximumGenerated(7));
        System.out.println(instance.getMaximumGenerated(2));
        System.out.println(instance.getMaximumGenerated(3));
    }

    /**
     * 解法1：模拟 时间O(N) 空间O(N)
     *
     */
    public int getMaximumGenerated(int n) {
        //特判
        if (n <= 1) return n;
        int res = 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i <= n/2; i++) {
            dp[2*i]=dp[i];
            if(2*i+1<=n) dp[2*i+1]=dp[i]+dp[i+1];
        }
        for(int dpi:dp) res=Math.max(res,dpi);
        return res;
    }
}
