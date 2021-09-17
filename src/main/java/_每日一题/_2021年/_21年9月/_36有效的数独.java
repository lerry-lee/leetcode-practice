package _每日一题._2021年._21年9月;

import java.util.Arrays;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/17
 */
public class _36有效的数独 {

    public static void main(String[] args) {
        _36有效的数独 instance = new _36有效的数独();
        char[][] board = new char[][]{{'.', '.', '4', '.', '.', '.', '6', '3', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'5', '.', '.', '.', '.', '.', '.', '9', '.'}, {'.', '.', '.', '5', '6', '.', '.', '.', '.'}, {'4', '.', '3', '.', '.', '.', '.', '.', '1'}, {'.', '.', '.', '7', '.', '.', '.', '.', '.'}, {'.', '.', '.', '5', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
        char[][] board1 = new char[][]{{'.', '.', '.', '.', '5', '.', '.', '1', '.'}, {'.', '4', '.', '3', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '3', '.', '.', '1'}, {'8', '.', '.', '.', '.', '.', '.', '2', '.'}, {'.', '.', '2', '.', '7', '.', '.', '.', '.'}, {'.', '1', '5', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '2', '.', '.', '.'}, {'.', '2', '.', '9', '.', '.', '.', '.', '.'}, {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
        System.out.println(instance.isValidSudoku(board));
        System.out.println(instance.isValidSudoku(board1));
    }

    /**
     * 解法1：暴力 三次遍历
     * 解法2：一次遍历 （用三个数组或哈希表记录）
     */

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                if (rows[i][num]) {
                    return false;
                }
                if (cols[j][num]) {
                    return false;
                }
                int boxI = 3*(i / 3) + j / 3;
                if (boxes[boxI][num]) {
                    return false;
                }
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxI][num] = true;
            }
        }
        return true;
    }
}
