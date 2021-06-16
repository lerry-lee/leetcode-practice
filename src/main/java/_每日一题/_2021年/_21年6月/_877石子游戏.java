package _每日一题._2021年._21年6月;

/**
 * @ClassName: _877石子游戏
 * @Author: lerry_li
 * @CreateDate: 2021/06/16
 * @Description
 * 解法1：dp
 */
public class _877石子游戏 {
    /**
     * 解法1：dp 时间O(N^2) 空间O(N^2)
     * 思路：
     *      dp难在定义和转移，可以参考另一个类似的题解
     *      https://leetcode-cn.com/problems/predict-the-winner/solution/ji-yi-hua-di-gui-dong-tai-gui-hua-java-by-liweiwei/
     */
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        //dp[i][j]表示有第i到第j堆石子，(A先手)A和B最终拿到石头的最大差值
        //最终目标是判断dp[0][n-1]>0
        int[][] dp = new int[n][n];
        //初始化，当i>j时，无意义
        //当i=j时，即只剩下1堆石子，则最大差值为这堆石子的个数piles[i]
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        //状态转移
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                //每次[i,j]堆石子，可以从两头拿，即i或者j
                //因此从两种选择里面选最优
                //piles[]-dp[][]如何理解呢
                //假设当前piles[]的石子拿了，那么下一次拿就轮到对方了，因此dp[][]表示对方与当前玩家的最大查值，所以要-
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        //返回
        return dp[0][n - 1] > 0;
    }

    /**
     * 解法2：dp+空间优化 时间O(N^2) 空间O(N)
     */

    /**
     * 解法3：找规律
     * 先手的人可以控制自己拿到全部奇数组或者偶数组，又因为不可能平局，所以必然能够选择较大的一组，那么就是必胜的
     */
    public boolean stoneGame3(int[] piles) {
        return true;
    }
}
