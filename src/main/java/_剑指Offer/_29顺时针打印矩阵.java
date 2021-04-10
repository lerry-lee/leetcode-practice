package _剑指Offer;

import java.util.Arrays;

/**
 * @ClassName: _29顺时针打印矩阵
 * @Author: lerry_li
 * @CreateTime: 2021/04/10
 * @Description
 */
public class _29顺时针打印矩阵 {
    /**
     * 解法1：模拟(→↓←→) 时间O(MN) 空间O(1)
     * tips:注意当matrix为非正方形时，防止折回
     */
    public int[] spiralOrder(int[][] matrix) {

        //特判
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }

        int rowStart = 0, rowEnd = matrix.length - 1, colStart = 0, colEnd = matrix[0].length - 1;

        int[] res = new int[(rowEnd + 1) * (colEnd + 1)];
        int idx = 0;

        while (rowStart <= rowEnd && colStart <= colEnd) {

            //→
            for (int j = colStart; j <= colEnd; j++) {
                res[idx++] = matrix[rowStart][j];
            }
            //↓
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                res[idx++] = matrix[i][colEnd];
            }
            //←
            //防止折回
            if (rowEnd > rowStart) {
                for (int j = colEnd - 1; j >= colStart; j--) {
                    res[idx++] = matrix[rowEnd][j];
                }
            }
            //↑
            //防止折回
            if (colEnd > colStart) {
                for (int i = rowEnd - 1; i > rowStart; i--) {
                    res[idx++] = matrix[i][colStart];
                }
            }

            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
        return res;
    }

    public static void main(String[] args) {
        _29顺时针打印矩阵 instance = new _29顺时针打印矩阵();
        System.out.println(Arrays.toString(instance.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.toString(instance.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}})));
    }
}
