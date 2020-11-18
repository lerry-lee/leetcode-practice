package SwordFingerOffer;

/**
 * @ClassName: _12矩阵中的路径
 * @Signature: Created by lerry_li on 2020/11/18
 * @Description:
 */
public class _12矩阵中的路径 {
    /**
     * 解法1：回溯
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, new boolean[board.length][board[0].length], i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, int row, int col, String word, int wordIdx) {
        char c = word.charAt(wordIdx);
        if (row < 0 || col < 0 || row == board.length || col == board[row].length || visited[row][col] || board[row][col] != c) {
            return false;
        }
        if (wordIdx == word.length() - 1) {
            return true;
        }

        visited[row][col] = true;
        boolean res = dfs(board, visited, row - 1, col, word, wordIdx + 1) ||
                dfs(board, visited, row + 1, col, word, wordIdx + 1) ||
                dfs(board, visited, row, col - 1, word, wordIdx + 1) ||
                dfs(board, visited, row, col + 1, word, wordIdx + 1);
        visited[row][col] = false;
        return res;
    }

    public static void main(String[] args) {
        _12矩阵中的路径 instance = new _12矩阵中的路径();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] board = {{'a', 'b'}, {'c', 'd'}};
//        String word = "abcd";
        String word = "ABCCED";
        System.out.println(instance.exist(board, word));
    }
}
