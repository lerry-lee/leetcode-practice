package DailyProblem._20年12月;

/**
 * @ClassName: _62不同路径
 * @Author: lerry_li
 * @CreateDate: 2020/12/09
 * @Description
 */
public class _62不同路径 {
    /**
     * 解法1：动态规划 时间O(MN) 空间O(MN)
     */
    public int uniquePaths(int m, int n) {
        if(m<=0||n<=0){
            return 0;
        }
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        _62不同路径 instance=new _62不同路径();
        System.out.println(instance.uniquePaths(7,3));
    }
}
