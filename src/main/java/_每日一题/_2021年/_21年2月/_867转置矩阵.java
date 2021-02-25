package _每日一题._2021年._21年2月;

/**
 * @ClassName: _867转置矩阵
 * @Author: lerry_li
 * @CreateTime: 2021/02/25
 * @Description
 */
public class _867转置矩阵 {
    /**
     * 解法1：模拟 时间O(MN) 空间O(MN)
     */
    public int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        int m = matrix.length, n = matrix[0].length;

        if (m == n) {
            for (int i = 0; i < m; i++) {
                for (int j = i+1; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            return matrix;
        }

        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
