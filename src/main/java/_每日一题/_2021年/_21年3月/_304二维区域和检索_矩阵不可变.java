package _每日一题._2021年._21年3月;

/**
 * @ClassName: _304二维区域和检索_矩阵不可变
 * @Author: lerry_li
 * @CreateDate: 2021/03/02
 * @Description
 */
public class _304二维区域和检索_矩阵不可变 {

    /**
     * 解法1：一维前缀和 时间O(mn) 检索O(m) 空间O(mn)
     *      和一维数组做法一致
     * 解法2： 二维前缀和 时间O(mn) 检索O(1) 空间O(mn)
     *      思想：矩形面积=总面积-上方矩形面积-左方矩形面积+左上角重合部分矩形面积
     */

    class NumMatrix {

        private int[][] sum;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int m = matrix.length, n = matrix[0].length;
            sum = new int[m][n + 1];
            //每一行的第0列设置为0
            //。。。
            for (int i = 0; i < m; i++) {
                for (int j = 1; j < n + 1; j++) {
                    sum[i][j] = sum[i][j - 1] + matrix[i][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (sum == null) {
                return 0;
            }
            int res = 0;
            for (int i = row1; i <= row2; i++) {
                res += sum[i][col2 + 1] - sum[i][col1];
            }
            return res;
        }
    }

    static class NumMatrix2 {

        private int[][] sum;

        public NumMatrix2(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }
            int m = matrix.length, n = matrix[0].length;
            sum = new int[m + 1][n + 1];
            //每一行的第0行和第0列设置为0
            //。。。
            for (int i = 1; i < m+1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2 + 1][col2 + 1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1];
        }
    }

    public static void main(String[] args) {
        int[][] matrix={
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix2 instance=new NumMatrix2(matrix);
        instance.sumRegion(2,1,4,3);
    }
}
