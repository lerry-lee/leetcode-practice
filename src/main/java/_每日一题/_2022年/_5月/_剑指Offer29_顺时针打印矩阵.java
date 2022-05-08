package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/08
 * @Description
 */
public class _剑指Offer29_顺时针打印矩阵 {

    public static void main(String[] args) {
        _剑指Offer29_顺时针打印矩阵 instance = new _剑指Offer29_顺时针打印矩阵();
        int[][] matirx = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matirx1 = new int[][]{{7}, {8}, {9}};
        int[][] matirx2 = new int[][]{{1},{2},{3},{4},{5},{6},{7},{8},{9},{10}};
        instance.new Solution().spiralOrder(matirx2);
    }

    /**
     * 解法1：按圈遍历 时间O(MN) 空间O(1)
     * tips:
     *      注意边界！
     */
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            //特判
            if (matrix == null || matrix.length == 0) return new int[]{};
            //边界
            int rowStart = 0, rowEnd = matrix.length - 1;
            int colStart = 0, colEnd = matrix[0].length - 1;
            int[] res = new int[matrix.length * matrix[0].length];
            int idx = 0;
            //按圈遍历，每次圈的宽度缩小
            while (rowStart <= rowEnd&&colStart<=colEnd) {
                //→
                for (int j = colStart; j <= colEnd; j++) {
                    res[idx++] = matrix[rowStart][j];
                }
                //↓
                for (int i = rowStart + 1; i <= rowEnd; i++) {
                    res[idx++] = matrix[i][colEnd];
                }
                //防止只剩一行时，循环计算
                if(rowStart<rowEnd){
                    //←
                    for (int j = colEnd - 1; j >= colStart; j--) {
                        res[idx++] = matrix[rowEnd][j];
                    }
                }
                //防止只剩一列时，循环计算
                if(colStart<colEnd){
                    //↑
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
    }
}
