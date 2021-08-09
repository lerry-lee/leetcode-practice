package _每日一题._2021年._21年8月;

import java.util.Arrays;

/**
 * @ClassName: _313超级丑数
 * @Author: lerry_li
 * @CreateDate: 2021/08/09
 * @Description
 */
public class _313超级丑数 {
    /**
     * 解法1：最小堆
     * 解法2：多指针 时间O(NM) 空间O(N+M)
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        //1,2,4,7,8,13,14,16,19,26,28,32
        //res=32
        int m = primes.length;
        int[] pointer = new int[m];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                min = Math.min(min, dp[pointer[j]] * primes[j]);
            }
            dp[i] = min;
            for (int j = 0; j < m; j++) {
                if (dp[pointer[j]] * primes[j] == min) pointer[j]++;
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
}
