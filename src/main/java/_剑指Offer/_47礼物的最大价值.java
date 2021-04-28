package _剑指Offer;

/**
 * @ClassName: _47礼物的最大价值
 * @Author: lerry_li
 * @CreateDate: 2021/04/28
 * @Description
 * 解法1：动态规划
 * 解法2：动态规划+空间优化
 */
public class _47礼物的最大价值 {

    public static void main(String[] args) {
        _47礼物的最大价值 instance = new _47礼物的最大价值();
        System.out.println(instance.maxValue2(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));//12
        System.out.println(instance.maxValue2(new int[][]{{9, 1, 4, 8}}));//22
    }

    /**
     * 解法1：动态规划 时间O(MN) 空间O(MN)
     * 状态定义：
     *      dp[i][j]表示从棋盘左上角grid[0][0]出发，到grid[i][j]时，获得礼物的最大值
     * 状态转移：
     *      dp[i][j]可由上方格子或左方格子转移得到，取转移得到的最大值，即
     *      dp[i][j]=max(dp[i-1][j],dp[i][j-1])+grid[i][j]
     * 初始化：
     *      初始化0行0列
     */
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        //初始化左上角
        dp[0][0] = grid[0][0];
        //初始化第0行
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        //初始化第0列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        //返回
        return dp[m - 1][n - 1];
    }

    /**
     * 解法2：动态规划+空间优化 时间O(MN) 空间O(M+N)
     */
    public int maxValue2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        //初始化左上角
        row[0] = grid[0][0];
        col[0] = grid[0][0];
        //初始化第0行
        for (int i = 1; i < n; i++) {
            col[i] = col[i - 1] + grid[0][i];
        }
        //初始化第0列
        for (int i = 1; i < m; i++) {
            row[i] = row[i - 1] + grid[i][0];
        }
        //状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int cur = Math.max(row[i], col[j]) + grid[i][j];
                row[i] = cur;
                col[j] = cur;
            }
        }
        //注意：返回row和col的最大值
        return Math.max(row[m - 1], col[n - 1]);
    }
}
