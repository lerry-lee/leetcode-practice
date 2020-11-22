package DailyExercises._20年11月;

import DataStructure.CommonMethod;

/**
 * @ClassName: _922按奇偶排序数组2
 * @Signature: Created by lerry_li on 2020/11/12
 * @Description:
 */
public class _922按奇偶排序数组2 {
    /**
     * 解法1：双指针 时间O(N) 空间O(1)
     * 定义：一个偶数下标指针p_even，一个奇数下标指针p_odd
     * 初始化：
     * p_even=0
     * p_odd=1
     * 过程：
     * 1）指针每次+2：
     * 这样p_even始终指向偶数下标的元素；
     * p_odd始终指向奇数下标的元素；
     * 2）p_even找奇数元素，p_odd找偶数元素，然后交换
     * 3）遍历到数组末尾停止
     */
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int p_even = 0, p_odd = 1;
        while (p_even < A.length && p_odd < A.length) {
            while (p_even < A.length && A[p_even] % 2 == 0) {
                p_even = p_even + 2;
            }
            while (p_odd < A.length && A[p_odd] % 2 != 0) {
                p_odd = p_odd + 2;
            }
            if (p_even < A.length && p_odd < A.length) {
                int temp = A[p_even];
                A[p_even] = A[p_odd];
                A[p_odd] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        _922按奇偶排序数组2 instance = new _922按奇偶排序数组2();
        int[] A = {1, 2, 3, 4};
        CommonMethod.display(A);
        CommonMethod.display(instance.sortArrayByParityII(A));
    }
}
