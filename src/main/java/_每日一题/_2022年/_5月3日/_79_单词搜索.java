package _每日一题._2022年._5月3日;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/03
 * @Description
 */
public class _79_单词搜索 {

    public static void main(String[] args) {
        _79_单词搜索 instance=new _79_单词搜索();
        char[][] arr=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="SEE";
        instance.new Solution().exist(arr,word);
    }

    /**
     * 解法1：dfs
     */
    class Solution {
        char[][] board;
        char[] wordArr;
        boolean[][] visited;
        public boolean exist(char[][] board, String word) {
            if(board==null||board.length==0||word==null|| word.length()==0) return false;
            int m=board.length,n=board[0].length;
            visited=new boolean[m][n];
            this.board=board;
            wordArr=word.toCharArray();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(board[i][j]==wordArr[0]){
                        if(dfs(i,j,0)) return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(int i, int j, int t) {
            if(t== wordArr.length) return true;
            if(i<0||i== board.length||j<0||j== board[0].length) return false;
            if(visited[i][j]) return false;
            if(board[i][j]!=wordArr[t]) return false;
            visited[i][j]=true;
            boolean flag=dfs(i+1,j,t+1)||dfs(i-1,j,t+1)||dfs(i,j+1,t+1)||dfs(i,j-1,t+1);
            visited[i][j]=false;
            return flag;
        }
    }
}
