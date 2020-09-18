package _力扣每日一题._20年7月;

import java.util.Arrays;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/25 11:00
 * @description 分割数组的最大值 TODO:不会
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 * <p>
 * 注意:
 * 数组长度 n 满足以下条件:
 * <p>
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 * <p>
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 * <p>
 * 输出:
 * 18
 * <p>
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 */
public class _410分割数组的最大值 {
    /**
     * 思路1：动态规划
     * 本题中，我们可以令 f[i][j]f[i][j] 表示将数组的前 ii 个数分割为 jj 段所能得到的最大连续子数组和的最小值。在进行状态转移时，我们可以考虑第 jj 段的具体范围，即我们可以枚举 kk，其中前 kk
     * 个数被分割为 j-1j−1 段，而第 k+1k+1 到第 ii 个数为第 jj 段。此时，这 jj 段子数组中和的最大值，就等于 f[k][j-1]f[k][j−1] 与 \textit{sub}(k+1, i)sub
     * (k+1,i) 中的较大值，其中 \textit{sub}(i,j)sub(i,j) 表示数组 \textit{nums}nums 中下标落在区间 [i,j][i,j] 内的数的和。
     * <p>
     * 由于我们要使得子数组中和的最大值最小，因此可以列出如下的状态转移方程：
     * <p>
     * f[i][j] = \min_{k=0}^{i-1} \Big\{ \max(f[k][j-1], \textit{sub}(k+1,i)) \Big\}
     * f[i][j]=
     * k=0
     * min
     * i−1
     * ​
     * {max(f[k][j−1],sub(k+1,i))}
     * <p>
     * 对于状态 f[i][j]f[i][j]，由于我们不能分出空的子数组，因此合法的状态必须有 i \geq ji≥j。对于不合法（i <
     * ji<j）的状态，由于我们的目标是求出最小值，因此可以将这些状态全部初始化为一个很大的数。在上述的状态转移方程中，一旦我们尝试从不合法的状态 f[k][j-1]f[k][j−1] 进行转移，那么 \max(\cdots)
     * max(⋯) 将会是一个很大的数，就不会对最外层的 \min\{\cdots\}min{⋯} 产生任何影响。
     * <p>
     * 此外，我们还需要将 f[0][0]f[0][0] 的值初始化为 00。在上述的状态转移方程中，当 j=1j=1 时，唯一的可能性就是前 ii 个数被分成了一段。如果枚举的 k=0k=0，那么就代表着这种情况；如果 k
     * \neq 0k
     * 
     * ​
     * =0，对应的状态 f[k][0]f[k][0] 是一个不合法的状态，无法进行转移。因此我们需要令 f[0][0] = 0f[0][0]=0。
     * <p>
     * 最终的答案即为 f[n][m]f[n][m]。
     * <p>
     */
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length < m) return 0;
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int[] dpi : dp) Arrays.fill(dpi, Integer.MAX_VALUE);
        dp[0][0] = 0;
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 思路2：二分+贪心
     */
    public int splitArray_bSearch(int[] nums, int m) {
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (check(nums, mid, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int x, int m) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > x) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }

}
