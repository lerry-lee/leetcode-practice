package _每日一题._2021年._21年9月;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/10
 */
public class _240搜索二维矩阵2 {
    /**
     * 解法1：二分查找 时间O(M+N) 空间O(1)
     * 两种思路：
     *      1)从右上角出发，每次判断当前元素和target的关系，若比target大，则左移一位；若比target小，则下移一位；若相等则返回true
     *      （因为矩阵横竖都是有序的，所以每个元素左边一行的元素都比它要小，下边一列的元素都比它要大）
     *      2）从左下角出发，右边一行的元素都比它要大，上边一列的元素都比它要小
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x <m && y >= 0) {
            if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                return true;
            }
        }
        return false;
    }
}
