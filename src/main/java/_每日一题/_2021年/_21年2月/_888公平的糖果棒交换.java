package _每日一题._2021年._21年2月;

import _工具类.CommonMethod;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _888公平的糖果棒交换
 * @Author: lerry_li
 * @CreateTime: 2021/02/01
 * @Description
 */
public class _888公平的糖果棒交换 {
    /**
     * 解法1：哈希表 时间O(N+M) 空间O(M)
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        if (A == null || B == null) {
            return new int[]{};
        }
        int sumA = 0, sumB = 0;
        Set<Integer> hashSetB = new HashSet<>();
        for (int value : A) {
            sumA += value;
        }
        for (int k : B) {
            sumB += k;
            hashSetB.add(k);
        }
        if (sumA == sumB || (sumA - sumB) % 2 != 0) {
            return new int[]{};
        }
        int dif = sumB - sumA;
        for (int j : A) {
            int numB = j + dif / 2;
            if (hashSetB.contains(numB)) {
                return new int[]{j, numB};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        _888公平的糖果棒交换 instance = new _888公平的糖果棒交换();
        int[] A = {1, 2, 5}, B = {2, 4};
        int[] res = instance.fairCandySwap(A, B);
        CommonMethod.display(res);
    }
}
