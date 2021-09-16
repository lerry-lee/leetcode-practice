package _每日一题._2021年._21年9月;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/16
 */
public class _212单词搜索2 {

    public static void main(String[] args) {
        _212单词搜索2 instance = new _212单词搜索2();
        char[][] board = new char[][]{{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}};
        String[] words = new String[]{"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"};
        System.out.println(instance.findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || board == null || board.length == 0) return res;
        int m = board.length, n = board[0].length;
        boolean used = false;
        visited = new boolean[m][n];
        for (String word : words) {
            used = false;
            for (int i = 0; i < m; i++) {
                if (used) break;
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        for (int k = 0; k < m; k++) {
                            Arrays.fill(visited[k], false);
                        }
                        boolean flag = dfs(board, i, j, word, 0);
                        if (flag) {
                            res.add(word);
                            used = true;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    boolean[][] visited;

    private boolean dfs(char[][] board, int i, int j, String word, int k) {

        if (k == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
            return false;
        }

        if (visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }

        visited[i][j] = true;

        boolean res = dfs(board, i + 1, j, word, k + 1) || dfs(board, i - 1, j, word, k + 1)
                || dfs(board, i, j + 1, word, k + 1) || dfs(board, i, j - 1, word, k + 1);
        if (res) return true;
        visited[i][j] = false;
        return false;
    }
}
