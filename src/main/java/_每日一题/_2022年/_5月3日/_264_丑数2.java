package _每日一题._2022年._5月3日;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/03
 * @Description
 */
public class _264_丑数2 {
    /**
     * 解法1：dp 时间O(N) 空间O(N)
     */
    class Solution {
        public int nthUglyNumber(int n) {
            if (n == 1) return 1;
            int[] dp = new int[n];
            dp[0] = 1;
            int p2 = 0, p3 = 0, p5 = 0;
            for (int i = 1; i < n; i++) {
                int n2 = dp[p2] * 2, n3 = dp[p3] * 3, n5 = dp[p5] * 5;
                int minN = Math.min(n2, Math.min(n3, n5));
                if (minN == n2) p2++;
                if (minN == n3) p3++;
                if (minN == n5) p5++;
                dp[i] = minN;
            }
            return dp[n - 1];
        }
    }
}
