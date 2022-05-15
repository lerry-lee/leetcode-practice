package _每日一题._2022年._5月;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/15
 * @Description
 */
public class _面试题08_12_八皇后 {
    /**
     * 解法1：经典回溯
     */
    class Solution {
        List<List<String>> res;
        int n;

        public List<List<String>> solveNQueens(int n) {
            res = new ArrayList<>();
            this.n = n;
            if (n < 1) return res;
            boolean[][] board = new boolean[n][n];
            dfs(board, 0);
            return res;
        }

        private void dfs(boolean[][] board, int t) {
            if (t == n) {
                List<String> oneSolution = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        if (board[i][j]) {
                            sb.append('Q');
                        } else {
                            sb.append('.');
                        }
                    }
                    oneSolution.add(sb.toString());
                }
                res.add(oneSolution);
                return;
            }
            for (int j = 0; j < n; j++) {
                if (isValid(board, t, j)) {
                    board[t][j]=true;
                    dfs(board, t + 1);
                    board[t][j]=false;
                }
            }
        }

        private boolean isValid(boolean[][] board, int t, int j) {
            if (t == 0) return true;
            for (int row = 0; row < t; row++) {
                for (int col = 0; col < n; col++) {
                    if (board[row][col]) {
                        if (col == j || Math.abs(t - row) == Math.abs(j - col)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}
