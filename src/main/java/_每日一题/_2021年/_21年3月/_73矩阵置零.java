package _每日一题._2021年._21年3月;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ClassName: _73矩阵置零
 * @Author: lerry_li
 * @CreateTime: 2021/03/21
 * @Description 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 */
public class _73矩阵置零 {
    /**
     * 解法1：使用标记数组/哈希集合 时间O(MN) 空间O(M+N)
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        //一个标记为0的行，一个标记为0的列，也可以用bool数组
        HashSet<Integer> rows = new HashSet<>(), cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (rows.contains(i)) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (cols.contains(j)) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 解法2：使用原数组第0行和第0列标记，并使用2个bool变量记录第0行和第0列是否有0 时间O(MN) 空间O(1)
     */
    public void setZeroes2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean row0has0 = false, col0has0 = false;
        //遍历第0列的所有行，若出现0则标记第0列含有0
        for (int[] rows : matrix) {
            if (rows[0] == 0) {
                col0has0 = true;
                break;
            }
        }
        //遍历第行列的所有列，若出现0则标记第0行含有0
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0has0 = true;
                break;
            }
        }
        //遍历二维数组，若遇到0，则标记对应的行和列（用第0行来标记各列，用第0列来标记各行）
        //细节：从第1行第1列开始，第0行第0列用来标记了，不能再用了
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    //第0列标记各行
                    matrix[i][0] = 0;
                    //第0行标记各列
                    matrix[0][j] = 0;
                }
            }
        }
        //遍历所有行，若该行已标记0，则填充该行所有元素全为0(除第0列以外)
        //细节：从第1行第1列开始，第0行第0列用来标记了，不能再用了
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //遍历所有列
        //细节：从第1行第1列开始，第0行第0列用来标记了，不能再用了
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //最后填首行首列
        if (row0has0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0has0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        _73矩阵置零 instance = new _73矩阵置零();
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        instance.setZeroes2(matrix);
    }
}
