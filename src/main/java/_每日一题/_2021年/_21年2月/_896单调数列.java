package _每日一题._2021年._21年2月;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @ClassName: _896单调数列
 * @Author: lerry_li
 * @CreateDate: 2021/02/28
 * @Description
 */
public class _896单调数列 {
    /**
     * 解法1：一次遍历 时间O(N) 空间O(1)
     * 思路：
     *      使用一个标志位标记数组第一次抖动是递增还是递减，然后后面再次发生抖动时判断是否与标志位一致
     */
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        int len = A.length;
        int flag = 0;
        for (int i = 1; i < len; i++) {
            int dif = A[i] - A[i - 1];
            if (dif != 0) {
                if (flag == 0) {
                    flag = dif;
                }
                if ((dif > 0 && flag < 0) || (dif < 0 && flag > 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 解法2：使用两个标志位 一次遍历 时间O(N) 空间O(1）
     */
    public boolean isMonotonic2(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        //a标志递增，b标志递减
        int a = 0, b = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                a = 1;
            } else if (A[i] < A[i - 1]) {
                b = 1;
            }
            //若a和b同时被设置，则不满单调数组
            if (a + b == 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _896单调数列 instance = new _896单调数列();
        int[] A1 = {1, 2, 2, 3};
        int[] A2 = {6, 5, 4, 4};
        int[] A3 = {1, 3, 2};
        System.out.println(instance.isMonotonic2(A1));
        System.out.println(instance.isMonotonic2(A2));
        System.out.println(instance.isMonotonic2(A3));
    }
}
