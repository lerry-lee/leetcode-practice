package _其他._TODO;

/**
 * Created by lerry_li on 2020/10/17
 */

/**
 * N皇后 II
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class _52N皇后2 {
    /**
     * 解法1：回溯（二维数组保存结果） 时间复杂度O(n!) 空间O(n^2)
     */
    public int totalNQueens(int n) {
        if (n == 0) return 0;
        SOLUTIONS = 0;
        boolean[][] chessboard = new boolean[n][n];
        dfs(chessboard, n, 0);
        return SOLUTIONS;
    }

    int SOLUTIONS;

    public void dfs(boolean[][] chessboard, int n, int k) {
        if (k == n) {
            display(chessboard);
            System.out.println();
            SOLUTIONS++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (check(chessboard, n, k, j)) {
                chessboard[k][j] = true;
                dfs(chessboard, n, k + 1);
                chessboard[k][j] = false;
            }
        }

    }

    public boolean check(boolean[][] chessboard, int n, int k, int j) {
        for (int row = 0; row < k; row++) {
            for (int column = 0; column < n; column++) {
                if (chessboard[row][column]) {
                    if (j == column || Math.abs(k - row) == Math.abs(j - column)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void display(boolean[][] chessboard) {
        for (boolean[] array : chessboard) {
            for (boolean a : array) {
                if (a) {
                    System.out.print("Q");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    /**
     * 解法2：回溯（位运算） 时间O(n!) 空间O(n)
     * TODO
     */
    public int totalNQueens2(int n) {
        return solve(n, 0, 0, 0, 0);
    }

    public int solve(int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0) {
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                count += solve(n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
            }
            return count;
        }
    }


}
