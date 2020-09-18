package _力扣每日一题._20年7月;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/06 18:15
 * @description 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class _63不同路径2 {
    /**
     * 思路：动态规划，时间复杂度O(mn),空间复杂度O(mn)
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //特判
        if(obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0].length==0) return 0;
        //二维dp数组，dp[i][j]表示从出发点到第i行第j列共有多少种走法
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        //dp[0][0]取决于mxn网格的出发点的值；为0则dp[0][0]为1，表示无障碍；为1则dp[0][0]为0，表示有障碍
        dp[0][0]=obstacleGrid[0][0]==0?1:0;
        //填充第一列
        for(int i=1;i<dp.length;i++){
            if(dp[i-1][0]==1&&obstacleGrid[i][0]==0) dp[i][0]=1;
            else dp[i][0]=0;
        }
        //填充第一行
        for(int j=1;j<dp[0].length;j++){
            if(dp[0][j-1]==1&&obstacleGrid[0][j]==0) dp[0][j]=1;
            else dp[0][j]=0;
        }
        //遍历，dp[i][j]=dp[i-1][j]+dp[i][j-1]或者0
        //(1)若当前网格的值为0，即无障碍，则dp值等于上一行的dp值+左一列的dp值，意思为到上一行的格子的走法+到左一列的格子的走法
        //(2)若当前网格的值为1，即有障碍，则dp值等于0
        for(int i=1;i<obstacleGrid.length;i++){
            int[] row=obstacleGrid[i];
            for(int j=1;j<obstacleGrid[i].length;j++){
                if(obstacleGrid[i][j]==0) dp[i][j]=dp[i][j-1]+dp[i-1][j];
                else dp[i][j]=0;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
