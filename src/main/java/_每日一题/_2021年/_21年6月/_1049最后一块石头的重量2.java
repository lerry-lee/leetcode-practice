package _每日一题._2021年._21年6月;

/**
 * @ClassName: _1049最后一块石头的重量2
 * @Author: lerry_li
 * @CreateDate: 2021/06/08
 * @Description
 * 解法1：动态规划
 */
public class _1049最后一块石头的重量2 {
    /**
     * 解法1：动态规划 时间O(N*SUM) 空间O(N*SUM)
     * 思路： 将石头分为两堆，使得两堆的分别的重量和趋近于sum的一半，这样抵消的时候剩下的便最小
     */
    public int lastStoneWeightII(int[] stones) {
        //1.对石头总重量求和
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }
        //2.计算总重量sum的一半
        int n = stones.length, m = sum / 2;
        //3.dp求解
        //将石头分为两堆，使得两堆的分别的重量和趋近于sum的一半，这样抵消的时候剩下的便最小
        //1)定义：dp[i][j]表示有i个石头，从里面选若干个，使得总重量为j，这种选择方案存在与否
        boolean[][] dp = new boolean[n + 1][m + 1];
        //1）初始化：0个石头，总重量为0，则什么石头都不选，存在这种方案
        dp[0][0] = true;
        //3）状态转移
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                //若当前石头的重量比j大，则状态由前一个石头转来
                if (j < stones[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }
                //否则，当前石头可以选/不选，有一个使得方案成立即可
                else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i-1]];
                }
            }
        }
        //最后返回，
        // 倒序遍历：使得总重量为j的可行方案，然后找到两堆重量的差值返回
        //差值可以有(sum-j)-j得到，即sum-2*j
        for (int j = m; ; --j) {
            if (dp[n][j]) {
                return sum - 2 * j;
            }
        }
    }
    /**
     * 解法2：动态规划+空间优化 时间O(N*SUM) 空间O(SUM)
     * tips：二维dp降到一维，可能需要倒序保证正确转移
     */
    public int lastStoneWeightII2(int[] stones) {
        //1.对石头总重量求和
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }
        //2.计算总重量sum的一半
        int n = stones.length, halfSum = sum / 2;
        //3.dp求解
        //将石头分为两堆，使得两堆的分别的重量和趋近于sum的一半，这样抵消的时候剩下的便最小
        //1)定义：dp[i][j]表示有i个石头，从里面选若干个，使得总重量为j，这种选择方案存在与否
        boolean[] dp = new boolean[halfSum + 1];
        //1）初始化：0个石头，总重量为0，则什么石头都不选，存在这种方案
        dp[0] = true;
        //3）状态转移
        for (int i = 1; i <= n; ++i) {
            for (int j = halfSum; j >=0; --j) {
                //若当前石头的重量比j大，则状态由前一个石头转来
                if (j < stones[i - 1]) {
                    dp[j] = dp[j];
                }
                //否则，当前石头可以选/不选，有一个使得方案成立即可
                else {
                    dp[j] = dp[j] || dp[j - stones[i-1]];
                }
            }
        }
        //最后返回，
        // 倒序遍历：使得总重量为j的可行方案(从hafSum递减遍历)，然后找到两堆重量的差值返回
        // 差值可以有(sum-j)-j得到，即sum-2*j
        for (int j = halfSum; ; --j) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
    }

}
