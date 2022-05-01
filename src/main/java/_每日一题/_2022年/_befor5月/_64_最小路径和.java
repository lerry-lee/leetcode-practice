package _每日一题._2022年._befor5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/30
 */
public class _64_最小路径和 {

    public static void main(String[] args) {
        _64_最小路径和 instance=new _64_最小路径和();
        instance.new Solution().minPathSum(new int[][] {{1,3,1},{1,5,1},{4,2,1}});
    }

    class Solution {
        public int minPathSum(int[][] grid) {
            if(grid==null||grid.length==0) return 0;
            int m=grid.length,n=grid[0].length;
            int[][] dp=new int[m][n];
            dp[0][0]=grid[0][0];
            for(int i=1;i<m;i++){
                dp[i][0]=dp[i-1][0]+grid[i][0];
            }
            for(int j=1;j<n;j++){
                dp[0][j]=dp[0][j-1]+grid[0][j];
            }
            for(int i=1;i<m;i++){
                for(int j=1;j<n;j++){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
            return dp[m-1][n-1];
        }
    }

    class Solution2 {
        public int minPathSum(int[][] grid) {
            if(grid==null||grid.length==0) return 0;
            int m=grid.length,n=grid[0].length;
            int[] dp=new int[n];
            dp[0]=grid[0][0];
            for (int i = 1; i < n; i++) {
                dp[i]=dp[i-1]+grid[0][i];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(j==0) dp[j]=dp[0]+grid[i][0];
                    else dp[j]=Math.min(dp[j-1],dp[j])+grid[i][j];
                }
            }
            return dp[n-1];
        }
    }
}
