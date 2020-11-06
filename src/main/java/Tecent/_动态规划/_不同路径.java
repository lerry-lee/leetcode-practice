package Tecent._动态规划;

/**
 * @ClassName: _不同路径
 * @Signature: Created by lerry_li on 2020/11/03
 * @Description:
 */
public class _不同路径 {
    /**
     * 解法1：回溯（超时）
     */
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        paths = 0;
        dfs(m - 1, n - 1, 0, 0);
        return paths;
    }

    int paths;

    public void dfs(int m, int n, int i, int j) {
        if (i == m && j == n) {
            paths++;
            return;
        }
        if (i < m) {
            dfs(m, n, i + 1, j);
        }
        if (j < n) {
            dfs(m, n, i, j + 1);
        }
    }

    /**
     * 解法2：动态规划 时间O(MN) 空间O(MN)
     * 状态定义：dp[i][j]表示走到第i行j列可能的路径总数
     * 状态转移：
     * dp[i][j]=dp[i-1][j]+dp[i][j-1]
     * 初始化：
     * dp[0][j]=1,dp[i][0]=1
     */
    public int uniquePaths2(int m, int n) {
        if (m <= 0 || n <= 0) {
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

    /**
     * 解法3：动态规划（解法2空间优化）时间O(MN) 空间O(M+N)
     */
    public int uniquePaths3(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[] dpm=new int[m];
        int[] dpn=new int[n];
        for (int i = 0; i < m; i++) {
            dpm[i]=1;
        }
        for (int i = 0; i < n; i++) {
            dpn[i]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dpm[i]=dpm[i]+dpn[j];
                dpn[j]=dpm[i];
            }
        }
        return dpm[m-1];
    }

    public static void main(String[] args) {
        System.out.println(new _不同路径().uniquePaths2(7, 3));
    }
}
