package _力扣每日一题._20年8月;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/08/11 11:30
 * @description 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class _130被包围的区域 {
    /**
     * 解法：dfs递归，从边界出发，找到与边界相邻的区域并标记，最后遍历所有区域，未被标记的可填充
     * 时间复杂度O(n*m) 空间复杂度O(n*m)
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length, col = board[0].length;
        int[][] flag = new int[row][col];
        dfs(board, flag, 0, 0);
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') dfs(board, flag, i, 0);
            if (board[i][col - 1] == 'O') dfs(board, flag, i, col - 1);
        }
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') dfs(board, flag, 0, j);
            if (board[row - 1][j] == 'O') dfs(board, flag, row - 1, j);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (flag[i][j] == 1) continue;
                if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    public void dfs(char[][] board, int[][] flag, int i, int j) {
        if (i < 0 | i == board.length || j < 0 || j == board[0].length || flag[i][j] == 1 || board[i][j] == 'X') return;
        if (board[i][j] == 'O') flag[i][j] = 1;
        dfs(board, flag, i + 1, j);
        dfs(board, flag, i - 1, j);
        dfs(board, flag, i, j + 1);
        dfs(board, flag, i, j - 1);
    }
}
