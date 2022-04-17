package _其他._笔试题._外企;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/17
 * @Description
 */
public class _329_矩阵中的最长递增路径 {

    /**
     * 解法1：记忆化递归（带备忘录的递归）
     */

    private int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        memo=new int[matrix.length][matrix[0].length];
        int res=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(memo[i][j]!=0) continue;
                res=Math.max(res,dp(matrix,i,j));
            }
        }
        return res;
    }
    public int dp(int[][] matrix,int i,int j){
        if(i<0||i>=matrix.length||j<0||j>=matrix[i].length){
            return 0;
        }
        if(memo[i][j]!=0){
            return memo[i][j];
        }
        int down=0,up=0,right=0,left=0;
        if(bigThan(matrix,i,j,i+1,j)){
            down=dp(matrix,i+1,j);
        }
        if(bigThan(matrix,i,j,i-1,j)){
            up=dp(matrix,i-1,j);
        }
        if(bigThan(matrix,i,j,i,j+1)){
            right=dp(matrix,i,j+1);
        }
        if(bigThan(matrix,i,j,i,j-1)){
            left=dp(matrix,i,j-1);
        }
        memo[i][j]=max4(down,up,right,left)+1;
        return memo[i][j];
    }

    public boolean bigThan(int[][] matrix,int i,int j,int x,int y){
        if(x<0||x>=matrix.length||y<0||y>=matrix[i].length){
            return false;
        }
        return matrix[x][y]>matrix[i][j];
    }

    public int max4(int a,int b,int c,int d){
        return Math.max(a,Math.max(b,Math.max(c,d)));
    }
}
