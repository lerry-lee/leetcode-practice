package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/17
 */
public class _79_单词搜索 {
    class Solution {
        boolean[][] visited;
        int m, n;

        public boolean exist(char[][] board, String word) {
            // check null
            if (board == null || board.length == 0 || word == null || word.length() == 0) return false;
            // dfs
            m = board.length;
            n = board[0].length;
            visited = new boolean[m][n];
            // enumerate each starting point
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, i, j, word.toCharArray(), 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int i, int j, char[] arr, int t) {
            // recursive exit
            // 1. successfully found a path(reach the end of the word)
            if (t == arr.length) {
                return true;
            }
            // 2. beyond grid boundaries
            if (i < 0 || i == m || j < 0 || j == n) {
                return false;
            }
            // 3. The current character of the grid do not match the current character of the word array
            // or the current grid value has already been visited
            if (board[i][j] != arr[t] || visited[i][j]) {
                return false;
            }
            // Marks that the current grid value has been visited
            visited[i][j] = true;
            // Depth-first search around
            // There is one that returns true to stop subsequent recursion
            boolean res = dfs(board, i + 1, j, arr, t + 1) || dfs(board, i - 1, j, arr, t + 1) || dfs(board, i, j + 1, arr, t + 1) || dfs(board, i, j - 1, arr, t + 1);
            // Reset the access state of the current grid value
            visited[i][j] = false;
            return res;
        }
    }
}
