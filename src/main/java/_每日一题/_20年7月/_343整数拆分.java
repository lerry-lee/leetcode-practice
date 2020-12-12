package _每日一题._20年7月;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/30 11:48
 * @description 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class _343整数拆分 {
    /**
     * 解法一：动态规划
     * 对于的正整数 nn，当 n \ge 2n≥2 时，可以拆分成至少两个正整数的和。令 kk 是拆分出的第一个正整数，则剩下的部分是 n-kn−k，n-kn−k 可以不继续拆分，或者继续拆分成至少两个正整数的和。由于每个正整数对应的最大乘积取决于比它小的正整数对应的最大乘积，因此可以使用动态规划求解。
     * <p>
     * 创建数组 \text{dp}dp，其中 \text{dp}[i]dp[i] 表示将正整数 ii 拆分成至少两个正整数的和之后，这些正整数的最大乘积。特别地，00 不是正整数，11 是最小的正整数，00 和 11 都不能拆分，因此 \text{dp}[0]=\text{dp}[1]=0dp[0]=dp[1]=0。
     * <p>
     * 当 i \ge 2i≥2 时，假设对正整数 ii 拆分出的第一个正整数是 jj（1 \le j < i1≤j<i），则有以下两种方案：
     * <p>
     * 将 ii 拆分成 jj 和 i-ji−j 的和，且 i-ji−j 不再拆分成多个正整数，此时的乘积是 j \times (i-j)j×(i−j)；
     * <p>
     * 将 ii 拆分成 jj 和 i-ji−j 的和，且 i-ji−j 继续拆分成多个正整数，此时的乘积是 j \times \text{dp}[i-j]j×dp[i−j]。
     * <p>
     * 因此，当 jj 固定时，有 \text{dp}[i]=\max(j \times (i-j), j \times \text{dp}[i-j])dp[i]=max(j×(i−j),j×dp[i−j])。由于 jj 的取值范围是 11 到 i-1i−1，需要遍历所有的 jj 得到 \text{dp}[i]dp[i] 的最大值，因此可以得到状态转移方程如下：
     * <p>
     * \text{dp}[i]=\mathop{\max}\limits_{1 \le j < i}\{\max(j \times (i-j), j \times \text{dp}[i-j])\}
     * dp[i]=
     * 1≤j<i
     * max
     * ​
     * {max(j×(i−j),j×dp[i−j])}
     * <p>
     * 最终得到 \text{dp}[n]dp[n] 的值即为将正整数 nn 拆分成至少两个正整数的和之后，这些正整数的最大乘积。
     */
    public int integerBreak_dp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int k = 1; k < i; k++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - k], i - k) * k);
            }
        }
        return dp[n];
    }
}
