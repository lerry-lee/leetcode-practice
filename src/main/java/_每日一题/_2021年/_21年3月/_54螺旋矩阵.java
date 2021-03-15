package _每日一题._2021年._21年3月;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _54螺旋矩阵
 * @Author: lerry_li
 * @CreateDate: 2021/03/15
 * @Description
 */
public class _54螺旋矩阵 {
    /**
     * 解法1：按圈遍历 时间O(MN) 空间O(1)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int n = matrix.length - 1, m = matrix[0].length - 1;
        return dfs(res, matrix, 0, n, 0, m);
    }

    /**
     * 按圈遍历，右下左上
     *
     * @param res    结果列表
     * @param matrix 二维矩阵
     * @param rowS   当前圈开始的行号
     * @param rowE   当前圈终止的行号
     * @param colS   当前圈开始的列号
     * @param colE   当前圈终止的列号
     */
    public List<Integer> dfs(List<Integer> res, int[][] matrix, int rowS, int rowE, int colS, int colE) {
        int i = rowS, j = colS;
        //只有当当前圈是一个合法的圈时才计算
        while (rowS <= rowE && colS <= colE) {
            //向右遍历,i=rowS
            for (j = colS; j <= colE; j++) {
                res.add(matrix[rowS][j]);
            }
            //向下遍历,j=colE
            for (i = rowS+1; i <= rowE; i++) {
                res.add(matrix[i][colE]);
            }
            //大于一行&&大于1列才可以，不然就回转了
            if (colE > colS&&rowE > rowS) {
                //向左遍历,i=rowE
                for (j=colE-1; j >= colS; j--) {
                    res.add(matrix[rowE][j]);
                }
                //向上遍历,j=colS
                for (i=rowE-1; i > rowS; i--) {
                    res.add(matrix[i][colS]);
                }
            }

            //圈收缩
            rowS++;
            rowE--;
            colS++;
            colE--;
        }

        return res;
    }

    public static void main(String[] args) {
        _54螺旋矩阵 instance = new _54螺旋矩阵();
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(instance.spiralOrder(matrix1));//[1,2,3,6,9,8,7,4,5]
        System.out.println(instance.spiralOrder(matrix2));//[1,2,3,4,8,12,11,10,9,5,6,7]
    }
}
