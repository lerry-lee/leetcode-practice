package _每日一题._2021年._21年3月;

/**
 * @ClassName: _74搜索二维矩阵
 * @Author: lerry_li
 * @CreateDate: 2021/03/30
 * @Description
 */
public class _74搜索二维矩阵 {
    /**
     * 解法1：二分搜索 时间O(logM+logN) 空间O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        if (matrix[0][0] > target || matrix[m - 1][n - 1] < target) {
            return false;
        }
        int mL = 0, mR = m - 1;
        while (mL < mR) {
            int mid = mL + (mR - mL) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                mR = mid - 1;
            } else if (matrix[mid][0] < target) {
                mL = mid + 1;
            }
        }
        if (matrix[mL][0] > target) {
            mL = mL - 1;
        }
        int nL = 0, nR = n - 1;
        while (nL < nR) {
            int mid = nL + (nR - nL) / 2;
            if (matrix[mL][mid] == target) {
                return true;
            } else if (matrix[mL][mid] < target) {
                nL = mid + 1;
            } else {
                nR = mid - 1;
            }
        }
        return matrix[mL][nL] == target;
    }

    public static void main(String[] args) {
        _74搜索二维矩阵 instance = new _74搜索二维矩阵();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(instance.searchMatrix(matrix, 3));//t
        System.out.println(instance.searchMatrix(matrix, 13));//f
        System.out.println(instance.searchMatrix(matrix, 0));//f
        System.out.println(instance.searchMatrix(matrix, 90));//f
    }
}
