package _每日一题._2021年._21年1月;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: _989数组形式的整数加法
 * @Author: lerry_li
 * @CreateTime: 2021/01/29
 * @Description
 */
public class _989数组形式的整数加法 {
    /**
     * 解法1：按位相加，时间O(max(N,logK)) 空间O(max(N,logK))
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        int n = A.length;
        List<Integer> res = new ArrayList<>();  //  往后加，最后反转
        int i = n - 1, sum = 0, carry = 0;
        while (i >= 0 || K != 0) {  // 循环条件：两个数有一个没完
            int x = i >= 0 ? A[i] : 0;
            int y = K != 0 ? K % 10 : 0;

            sum = x + y + carry;
            carry = sum / 10;
            K = K / 10;

            i--;
            res.add(sum % 10);
        }
        if (carry != 0) res.add(carry);
        Collections.reverse(res);
        return res;

    }

    public static void main(String[] args) {
        _989数组形式的整数加法 instance = new _989数组形式的整数加法();
        int[] A = {1, 2, 0, 0};
        int K = 34;
        int[] A1 = {2, 7, 4};
        int K1 = 181;
        int[] A2 = {2, 1, 5};
        int K2 = 806;
        int[] A3 = {9, 9, 9};
        int K3 = 1;
        int[] A4 = {3, 7};
        int K4 = 789;
        System.out.println(instance.addToArrayForm(A, K));
        System.out.println(instance.addToArrayForm(A1, K1));
        System.out.println(instance.addToArrayForm(A2, K2));
        System.out.println(instance.addToArrayForm(A3, K3));
        System.out.println(instance.addToArrayForm(A4, K4));

    }
}
