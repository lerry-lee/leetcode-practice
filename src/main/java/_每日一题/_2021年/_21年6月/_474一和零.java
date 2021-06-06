package _每日一题._2021年._21年6月;

/**
 * @ClassName: _474一和零
 * @Author: lerry_li
 * @CreateDate: 2021/06/06
 * @Description
 * 解法1：dp
 * 解法2：dp+空间优化
 */
public class _474一和零 {

    public static void main(String[] args) {
        _474一和零 instance=new _474一和零();
        System.out.println(instance.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,3));
    }

    /**
     * 解法1：dp 时间O(len*l*M*N) 空间O(l*M*N)
     */
    public int findMaxForm1(String[] strs, int m, int n) {
        //特判
        if (strs == null || strs.length == 0) return 0;
        //dp
        //dp[i][j][k]表示在前 i 个字符串中，使用 j 个 0 和 k 个 1 的情况下最多可以得到的字符串数量
        int len = strs.length;
        int[][][] dp = new int[len + 1][m+1][n+1];
        //初始化
        dp[0][0][0] = 0;
        //状态转移
        for (int i = 1; i <= len; i++) {
            //计算当前字符串 0和1的个数
            int[] counts = countZeroOne(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    //若当前字符串的0或1的个数超过了当前的限制k或j，则当前字符串不能加入子集
                    if (counts[0] > j || counts[1] > k) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                    //否则，考虑当前第i个字符串选还是不选
                    else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-counts[0]][k - counts[1]]+1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }
    /**
     * 解法2：dp+空间优化 时间O(len*l*M*N) 空间O(l*M*N)
     */
    public int findMaxForm(String[] strs, int m, int n) {
        //特判
        if (strs == null || strs.length == 0) return 0;
        //dp
        //dp[j][k]表示使用 j 个 0 和 k 个 1 的情况下最多可以得到的字符串数量
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];
        //初始化
        dp[0][0] = 0;
        //状态转移
        for (int i = 1; i <= len; i++) {
            //计算当前字符串 0和1的个数
            int[] counts = countZeroOne(strs[i - 1]);
            //内层循环使用倒序遍历
            for (int j = m; j >=0; j--) {
                for (int k = n; k >=0; k--) {
                    //若当前字符串的0或1的个数超过了当前的限制k或j，则当前字符串不能加入子集
                    if (counts[0] > j || counts[1] > k) {
                        dp[j][k] = dp[j][k];
                    }
                    //否则，考虑当前第i个字符串选还是不选
                    else {
                        dp[j][k] = Math.max(dp[j][k], dp[j-counts[0]][k - counts[1]]+1);
                    }
                }
            }
        }
        return dp[m][n];
    }


    private int[] countZeroOne(String str) {
        int[] res = new int[2];
        for (int i = 0; i < str.length(); i++) {
            res[str.charAt(i) - '0']++;
        }
        return res;
    }
}
