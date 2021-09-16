package _每日一题._2021年._21年9月;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/10
 */
public class _64最小路径和 {

    public static void main(String[] args) {
        _64最小路径和 instance = new _64最小路径和();
        int[][] grid = new int[][]{{1,2,3},{4,5,6}};
        System.out.println(instance.minPathSum(grid));
    }

    /**
     * 解法1：dp 时间O(MN) 空间O(MN)
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        //dp[i][j]表示从左上角出发到(i,j)的最小路径
        //最终目标dp[m][n]
        int[][] dp = new int[m][n];
        //初始化0行，0列
        dp[0][0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //枚举选择，可以从上面格子走来，也可以从左边格子走来，选最短的
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
