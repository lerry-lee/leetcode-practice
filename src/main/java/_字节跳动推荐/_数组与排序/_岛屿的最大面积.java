package _字节跳动推荐._数组与排序;


/**
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 * <p>
 * 示例
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 * <p>
 * 解法：递归
 * 注意：访问过的要记录，不然stack over flow
 */

public class _岛屿的最大面积 {
    int max_num;
    int[][] GRID;
    int[][] flag;
    int num;

    public int maxAreaOfIsland(int[][] grid) {
        GRID = grid;
        max_num = 0;
        flag = new int[GRID.length][];
        for (int i = 0; i < flag.length; i++) {
            flag[i] = new int[GRID[i].length];
        }
        for (int i = 0; i < GRID.length; i++) {
            for (int j = 0; j < GRID[i].length; j++) {
                if (GRID[i][j] == 1) {
//                    if (i > 0 && GRID[i - 1][j] == 1) continue;
//                    if (j > 0 && GRID[i][j - 1] == 1) continue;
//                    num=0;
//                    backTrack(i, j);
                    int temp = backTrack1(i, j);
                    System.out.println(temp);
                    max_num = Math.max(max_num, temp);
                }
            }
        }
        return max_num;
    }

    public void backTrack(int i, int j) {
        if (i < 0 || j < 0 || i > GRID.length - 1 || j > GRID[i].length - 1 || GRID[i][j] == 0) {
            max_num = Math.max(max_num, num);
        } else {
            if (flag[i][j] == 0 && GRID[i][j] == 1) {
                flag[i][j] = 1;
                num += 1;
                backTrack(i - 1, j);
                backTrack(i + 1, j);
                backTrack(i, j - 1);
                backTrack(i, j + 1);
            }
        }
    }

    //int类型的递归函数
    public int backTrack1(int i, int j) {

        if (i < 0 || j < 0 || i > GRID.length - 1 || j > GRID[i].length - 1 || GRID[i][j] == 0) {
            return 0;
        } else {

            GRID[i][j] = 0;

            int num1 = 1;
            num1 += backTrack1(i + 1, j);
            num1 += backTrack1(i - 1, j);
            num1 += backTrack1(i, j + 1);
            num1 += backTrack1(i, j - 1);

            return num1;
        }
    }
}
