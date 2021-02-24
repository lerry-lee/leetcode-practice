package _每日一题._2021年._21年2月;

import _工具类.CommonMethod;

import java.util.Arrays;

/**
 * @ClassName: _832翻转图像
 * @Author: lerry_li
 * @CreateTime: 2021/02/24
 * @Description
 */
public class _832翻转图像 {
    /**
     * 解法1：借助一个行数组做逆序 时间O(MN) 空间O(N)
     */
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return A;
        }
        int[] helper;
        int n = A[0].length;
        for (int[] row : A) {
            helper = Arrays.copyOf(row, n);
            for (int i = 0; i < n; i++) {
                row[i] = helper[n - i - 1] ^ 1;
            }
        }
        return A;
    }

    /**
     * 解法2：双指针做逆序 时间O(MN) 空间O(1)
     */
    public int[][] flipAndInvertImage2(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return A;
        }
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = A[i][left];
                A[i][left] = A[i][right] ^ 1;
                A[i][right] = temp ^ 1;
                left++;
                right--;
            }
            if(left==right){
                A[i][left] ^= 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        _832翻转图像 instance = new _832翻转图像();
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] A1 = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        int[][] res = instance.flipAndInvertImage2(A1);
        CommonMethod.display(res);
    }
}
