package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/10
 */
public class _130_被围绕的区域 {

    /**
     * 解法1：dfs
     * 思路：
     *      柿子挑软的捏！
     *      从不符合条件的入手，标记它们，这样最后符合条件的就一目了然了！
     */
    class Solution {
        int m,n;
        public void solve(char[][] board) {
            if(board==null||board.length==0) return;
            m=board.length;
            n=board[0].length;
            for (int i = 0; i < m; i++) {
                if(board[i][0]=='O') dfs(board,i,0);
                if(board[i][n-1]=='O') dfs(board,i,n-1);
            }
            for (int j = 0; j < n; j++) {
                if(board[0][j]=='O') dfs(board,0,j);
                if(board[m-1][j]=='O') dfs(board,m-1,j);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(board[i][j]=='#') board[i][j]='O';
                    else if(board[i][j]=='O') board[i][j]='X';
                }
            }
        }
        private void dfs(char[][] board,int i,int j){
            if(i<0||i==m||j<0||j==n) return;
            if(board[i][j]!='O') return;
            board[i][j]='#';
            dfs(board,i+1,j);
            dfs(board,i-1,j);
            dfs(board,i,j+1);
            dfs(board,i,j-1);
        }
    }
}
