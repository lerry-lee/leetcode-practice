package DailyExercises._20年9月;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/09/13 09:50
 * @description 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class _79单词搜索 {
    /**
     * 解法1：回溯+剪枝
     */
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0) return false;
        boolean flag=false;
        boolean[][] visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(!flag&&board[i][j]==word.charAt(0)) flag=dfs(board,i,j,word,0,visited);
                else if(flag) return true;
            }
        }
        return flag;
    }
    public boolean dfs(char[][] board,int bi,int bj,String word,int wi,boolean[][] visited){
        visited[bi][bj]=true;
        System.out.println(bi+" "+bj+" "+board[bi][bj]);
        if(wi==word.length()-1) return true;
        boolean flag=false;
        if(bi<board.length-1&&!visited[bi+1][bj]&&board[bi+1][bj]==word.charAt(wi+1)) {
            flag = dfs(board, bi + 1, bj, word, wi + 1,visited);
        }
        if(!flag&&bj<board[bi].length-1&&!visited[bi][bj+1]&&board[bi][bj+1]==word.charAt(wi+1)) {
            flag = dfs(board, bi, bj + 1, word, wi + 1,visited);
        }
        if(!flag&&bi>0&&!visited[bi-1][bj]&&board[bi-1][bj]==word.charAt(wi+1)) {
            flag = dfs(board, bi - 1, bj, word, wi + 1,visited);
        }
        if(!flag&&bj>0&&!visited[bi][bj-1]&&board[bi][bj-1]==word.charAt(wi+1)) {
            flag = dfs(board, bi, bj - 1, word, wi + 1,visited);
        }
        visited[bi][bj]=false;
        return flag;
    }
}
