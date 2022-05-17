package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/17
 */
public class _36_有效的数独 {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}}
                ;
        _36_有效的数独 instance = new _36_有效的数独();
        instance.new Solution().isValidSudoku(board);
    }

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    if (!checkBox(board, i, j)) {
                        return false;
                    }
                }
            }

            for (int i = 0; i < 9; i++) {
                boolean[] row = new boolean[10];
                for (int j = 0; j < 9; j++) {
                    char num = board[i][j];
                    if (num == '.') continue;
                    if (row[num - '0']) {
                        return false;
                    }
                    row[num - '0'] = true;
                }
            }
            for (int j = 0; j < 9; j++) {
                boolean[] col = new boolean[10];
                for (int i = 0; i < 9; i++) {
                    char num = board[i][j];
                    if (num == '.') continue;
                    if (col[num - '0']) {
                        return false;
                    }
                    col[num - '0'] = true;
                }
            }
            return true;
        }

        private boolean checkBox(char[][] board, int startI, int startJ) {
            boolean[] all = new boolean[10];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char c = board[startI + i][startJ + j];
                    if (c == '.') continue;
                    int num = c - '0';
                    if (all[num]) {
                        return false;
                    }
                    all[num] = true;
                }
            }
            return true;
        }
    }
}
