package _每日一题._2020年._20年10月;

/**
 * Created by lerry_li on 2020/10/16
 */

/**
 * 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 */
public class _977有序数组的平方 {
    /**
     * 解法1：双指针从两边向中间遍历，从后往前填充数组 时间O(n) 空间O(n)
     */
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) return A;
        int n = A.length;
        int[] B = new int[n];
        //初始化指针l，指针r
        int l = 0, r = n - 1;
        //B数组从后向前赋值
        int i = n - 1;
        //两边向中间遍历，相遇时为最后一个元素
        while (l <= r) {
            int temp;
            //选绝对值大的，然后那边的指针移动
            if (Math.abs(A[r]) > Math.abs(A[l])) {
                System.out.print("A[" + r + "]" + A[r] + "比" + "A[" + l + "]" + A[l] + "大");
                temp = A[r] * A[r];
                r--;
            } else {
                System.out.print("A[" + r + "]" + A[r] + "比" + "A[" + l + "]" + A[l] + "小");
                temp = A[l] * A[l];
                l++;
            }
            System.out.println("\tB数组的第" + i + "个元素赋值" + temp);
            B[i--] = temp;
        }
        return B;
    }
}
