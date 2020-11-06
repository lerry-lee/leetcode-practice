package DailyExercises._20年10月;

/**
 * @ClassName: _463岛屿的周长
 * @Signature: Created by lerry_li on 2020/10/30
 * @Description:
 */
public class _463岛屿的周长 {
    /**
     * 解法1：暴力遍历 时间复杂度O(MN) 空间O(1)
     * 遍历网格，判断每个网格上下左右四个位置的网格
     * 判断是1陆地还是0水域，若为0水域，则岛屿长度+1
     */
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += cal(grid, i, j);
                }
            }
        }
        return res;
    }

    public int cal(int[][] grid, int i, int j) {
        int cnt = 0;
        if (i == 0 || (i > 0 && grid[i - 1][j] == 0)) {
            cnt++;
        }
        if (i == grid.length - 1 || (i < grid.length - 1 && grid[i + 1][j] == 0)) {
            cnt++;
        }
        if (j == 0 || (j > 0 && grid[i][j - 1] == 0)) {
            cnt++;
        }
        if (j == grid[0].length - 1 || (j < grid[0].length - 1 && grid[i][j + 1] == 0)) {
            cnt++;
        }
        return cnt;
    }


}
