package _每日一题._2021年._21年8月;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _576出界的路径数
 * @Author: lerry_li
 * @CreateDate: 2021/08/15
 * @Description
 */
public class _576出界的路径数 {

    public static void main(String[] args) {
        _576出界的路径数 instance = new _576出界的路径数();
        System.out.println(instance.findPaths(2, 2, 2, 0, 0));//6
        System.out.println(instance.findPaths(1, 3, 3, 0, 1));//12
        System.out.println(instance.findPaths(8, 50, 23, 5, 26));//914783380
    }


    /**
     * 解法2：dp 时间O(maxMove*MN) 空间O(MN)
     */
    public int findPaths2(int m, int n, int maxMove, int startRow, int startColumn) {
        final int MOD = 1000000007;
        int outCounts = 0;
        //1.dp[k][i][j]表示移动k次后位于坐标(i,j)的路径数量
        //最终目标求dp[maxMove][][]
        int[][][] dp = new int[maxMove + 1][m][n];
        //上下左右四个方向
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //2.初始化
        //当位于起点(startRow,startColumn)且移动次数为0时，路径数为1
        dp[0][startRow][startColumn] = 1;
        //3.状态转移
        for (int k = 0; k < maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int count = dp[k][i][j];
                    if (count > 0) {
                        for (int[] direction : directions) {
                            int newI = i + direction[0], newJ = j + direction[1];
                            //上下左右选择一个方向(newI,newJ)移动
                            //1)若未出界，则累加到dp[k + 1][newI][newJ]
                            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
                                dp[k + 1][newI][newJ] = (dp[k + 1][newI][newJ] + count) % MOD;
                            }
                            //2)否则出界，加到结果上
                            else {
                                outCounts = (outCounts + count) % MOD;
                            }
                        }
                    }
                }
            }
        }
        return outCounts;
    }

    /**
     * 解法1：dfs+备忘录
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (m <= 0 || n <= 0 || maxMove <= 0) return 0;
        memo = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return dfs(m, n, maxMove, startRow, startColumn);
    }

    private int dfs(int m, int n, int curMove, int i, int j) {
        //没有步数了则返回0
        if (curMove < 0) return 0;
        //出界则结果+1
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        //查看备忘录
        if (memo[i][j][curMove] != -1) return memo[i][j][curMove];
        int sum = 0;
        sum = (sum + dfs(m, n, curMove - 1, i + 1, j)) % MOD;
        sum = (sum + dfs(m, n, curMove - 1, i - 1, j)) % MOD;
        sum = (sum + dfs(m, n, curMove - 1, i, j + 1)) % MOD;
        sum = (sum + dfs(m, n, curMove - 1, i, j - 1)) % MOD;
        memo[i][j][curMove] = sum;
        return sum;
    }

    int[][][] memo;
    int MOD = (int) 1e9 + 7;
}
