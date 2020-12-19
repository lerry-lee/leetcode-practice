package _每日一题._20年12月;

import _工具类.CommonMethod;

/**
 * @ClassName: _48旋转图像
 * @Author: lerry_li
 * @CreateDate: 2020/12/19
 * @Description
 */
public class _48旋转图像 {
    /**
     * 解法1：原地变换 利用坐标关系 一圈一圈的变换 时间O(N^2) 空间O(1)
     * 解法2：先上下翻转，再按对角线翻转 时间O(N^2) 空间O(1)
     */

    /**
     * 解法1
     */
    public void rotate(Integer[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int row = matrix.length, col = matrix[0].length;
        /**
         * 1 1 1 1 1
         * 1 2 2 2 1
         * 1 2 3 2 1
         * 1 2 2 2 1
         * 1 1 1 1 1
         */
        //由于一次变换就完成了一圈，所以到行数的一半即可
        for (int i = 0; i < row / 2; i++) {
            //由于一次变换就完成了一圈，所以到列数-行号即可
            for (int j = i; j < col - i - 1; j++) {
                //每次把当前位置的元素变换到 顺时针旋转90度后的 位置上，同时保存覆盖位置上的元素
                int prev = matrix[i][j];
                for (int k = 0; k < 4; k++) {
                    int nextJ = row - i-1;
                    int nextI = j;
                    int temp = matrix[nextI][nextJ];
                    matrix[nextI][nextJ] = prev;
                    prev = temp;
                    i = nextI;
                    j = nextJ;
                }
            }
        }
    }

    /**
     * 解法2
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        _48旋转图像 instance = new _48旋转图像();
        Integer[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Integer[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        instance.rotate(matrix);
        instance.rotate(matrix2);
        CommonMethod.display(matrix);
        CommonMethod.display(matrix2);
    }
}
