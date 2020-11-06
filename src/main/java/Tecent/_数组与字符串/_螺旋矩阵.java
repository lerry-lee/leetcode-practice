package Tecent._数组与字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lerry_li on 2020/09/25
 */

/**
 * 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class _螺旋矩阵 {
    /**
     * 解法1：按圈遍历，一圈就是→↓←↑
     * tips：尤其注意边界条件!
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int is = 0, ie = matrix.length - 1, js = 0, je = matrix[0].length - 1;
        int i, j;
        while (is <= ie && js <= je) {
            for (j = js; j <= je; j++) {
                res.add(matrix[is][j]);
            }

            for (i = is + 1; i <= ie; i++) {
                res.add(matrix[i][je]);
            }
            //这一个判断条件，防止只有一行或者一列时还要折回
            //若is==ie，表示只有一行，js==je表示只有一列
            if (is < ie && js < je) {
                for (j = je - 1; j >= js; j--) {
                    res.add(matrix[ie][j]);
                }

                for (i = ie - 1; i > is; i--) {
                    res.add(matrix[i][js]);
                }
            }

            is++;
            ie--;
            js++;
            je--;

        }


        return res;
    }

}
