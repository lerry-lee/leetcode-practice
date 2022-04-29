package _每日一题._2022年;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/29
 * @Description
 */
public class _剑指Offer12_矩阵中的路径 {

    public static void main(String[] args) {
        _剑指Offer12_矩阵中的路径 instance=new _剑指Offer12_矩阵中的路径();
        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word="ABCESEEEFS";
        instance.new Solution().exist(board,word);
    }

    /**
     * 解法1：dfs
     */
    class Solution {
        char[][] board;
        char[] arr;
        public boolean exist(char[][] board, String word) {
            if(board==null||board.length==0||word==null||word.length()==0) return false;
            arr=word.toCharArray();
            this.board=board;
            //for loop
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]==arr[0]&&dfs(0,i,j)){
                        return true;
                    }
                }
            }
            return false;
        }
        public boolean dfs(int t,int i,int j){
            if(t==arr.length) return true;
            if(i<0||i==board.length||j<0||j==board[0].length) return false;
            if(board[i][j]=='#') return false;
            if(board[i][j]!=arr[t]){
                return false;
            }
            char origin=board[i][j];
            board[i][j]='#';
            if(dfs(t+1,i+1,j)){
                return true;
            }
            if(dfs(t+1,i-1,j)){
                return true;
            }
            if(dfs(t+1,i,j+1)){
                return true;
            }
            if(dfs(t+1,i,j-1)){
                return true;
            }
            board[i][j]=origin;
            return false;
        }
    }
}
