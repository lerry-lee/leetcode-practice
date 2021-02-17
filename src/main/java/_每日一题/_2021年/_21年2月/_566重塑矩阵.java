package _每日一题._2021年._21年2月;

import _工具类.CommonMethod;

/**
 * @ClassName: _566重塑矩阵
 * @Author: lerry_li
 * @CreateTime: 2021/02/17
 * @Description
 */
public class _566重塑矩阵 {
    /**
     * 解法1：直接解 时间O(MN) 空间(1)
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r <= 0 || c <= 0 || nums == null || nums.length == 0) {
            return nums;
        }
        int row = nums.length, col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }
        int rowI = 0, colJ = 0;
        int[][] res=new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (colJ == col) {
                    rowI++;
                    colJ = 0;
                }
                res[i][j] = nums[rowI][colJ++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _566重塑矩阵 instance=new _566重塑矩阵();
        int[][] nums={{1,2},{3,4}};
        int[][] res=instance.matrixReshape(nums,2,5);
        CommonMethod.display(res);
    }
}
