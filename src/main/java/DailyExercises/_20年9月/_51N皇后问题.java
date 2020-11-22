package DailyExercises._20年9月;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/09/03 13:53
 * @description 简单回溯
 */
public class _51N皇后问题 {
    List<List<String>> res = new ArrayList();

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) return res;
        int[] board = new int[n];
        Arrays.fill(board, -1);
        dfs(board, n, 0);
        return res;
    }

    public void dfs(int[] board, int n, int k) {
        if (k >= n) {
            res.add(new ArrayList());
            for (int position : board) {
                StringBuilder s = new StringBuilder("");
                for (int i = 0; i < n; i++) {
                    if (i == position) s.append("Q");
                    else s.append(".");
                }
                res.get(res.size() - 1).add(s.toString());
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(board, k, i)) {
                board[k] = i;
                dfs(board, n, k + 1);
                board[k] = -1;
            }
        }
    }

    public boolean isValid(int[] board, int k, int j) {
        for (int i = 0; i < k; i++) {
            if (board[i] == j) return false;
            if (Math.abs(j - board[i]) == k - i) return false;
        }
        return true;
    }
}
