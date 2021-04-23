package _每日一题._2021年._21年4月;

/**
 * @ClassName: _363矩形区域不超过K的最大数值和
 * @Author: lerry_li
 * @CreateDate: 2021/04/23
 * @Description
 * 解法1：二维前缀和+枚举矩形
 */
public class _363矩形区域不超过K的最大数值和 {

    public static void main(String[] args) {
        _363矩形区域不超过K的最大数值和 instance = new _363矩形区域不超过K的最大数值和();
        System.out.println(instance.maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));//2
        System.out.println(instance.maxSumSubmatrix(new int[][]{{2, 2, -1}}, 3));//3
        System.out.println(instance.maxSumSubmatrix(new int[][]{{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}}, 10));//10
    }

    /**
     * 解法1：二维前缀和+枚举矩形 时间O(M^2N^2) 空间O(MN)
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m][n];
        //填充0行0列
        sum[0][0] = matrix[0][0];
        //填充m行0列
        for (int i = 1; i < m; i++) {
            sum[i][0] += sum[i - 1][0] + matrix[i][0];
        }
        //填充0行n列
        for (int i = 1; i < n; i++) {
            sum[0][i] += sum[0][i - 1] + matrix[0][i];
        }
        //填充其它行列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1]+matrix[i][j];
            }
        }
        //求解
        int maxSum = Integer.MIN_VALUE;
        //枚举矩形左上角元素
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //若有元素==k，直接返回k
                if (matrix[i][j] == k) {
                    return k;
                }
                //若元素<k，则考虑赋值给maxSum
                if (matrix[i][j] < k) {
                    maxSum = Math.max(maxSum, matrix[i][j]);
                }
                //枚举矩形
                for (int row = i; row < m; row++) {
                    for (int col = j; col < n; col++) {
                        //当i和j都>0时
                        //矩形sum=右下角+左上角-左边-上边
                        int rightBottom = sum[row][col];
                        int leftTop = 0;
                        if (i > 0 && j > 0) {
                            leftTop = sum[i - 1][j - 1];
                        }
                        int left = 0;
                        if (j > 0) {
                            left = sum[row][j - 1];
                        }
                        int top = 0;
                        if (i > 0) {
                            top = sum[i - 1][col];
                        }
                        int temSum = rightBottom + leftTop - left - top;
                        if (temSum == k) {
                            return k;
                        }
                        if (temSum < k) {
                            maxSum = Math.max(maxSum, temSum);
                        }
                    }
                }
            }
        }

        return maxSum;
    }
}
