package _每日一题._20年11月;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _454四数相加2
 * @Author: lerry_li
 * @CreateDate: 2020/11/27
 * @Description
 */
public class _454四数相加2 {
    /**
     * 解法1：哈希表1个数组 时间O(N^3) 空间O(1)
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null | D == null || A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0) {
            return 0;
        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int d : D) {
            hashMap.put(d, hashMap.getOrDefault(d, 0) + 1);
        }
        int res = 0;
        for (int a : A) {
            for (int b : B) {
                for (int c : C) {
                    long sum = a + b + c;
                    if (hashMap.containsKey((int) -sum)) {
                        int count = hashMap.get((int) -sum);
                        res += count;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 解法2：分组+哈希表 时间O(N^2) 空间O(N^2)
     * 思路：
     *      先把C和D的所有和用哈希表存储
     *      然后遍历A和B的所有和，判断哈希表中是否有能组成0的元素
     */
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null | D == null || A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0) {
            return 0;
        }
        //用哈希表存储C和D的所有和
        Map<Long, Integer> hashMap = new HashMap<>();
        for (int c : C) {
            for (int d : D) {
                long sum = c + d;
                hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int a : A) {
            for (int b : B) {
                long sum = a + b;
                if (hashMap.containsKey(-sum)) {
                    int count = hashMap.get(-sum);
                    res += count;
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {

        _454四数相加2 instance = new _454四数相加2();
        int[] A = {-1, -1};
        int[] B = {-1, 1};
        int[] C = {-1, 1};
        int[] D = {1, -1};
        int ans = instance.fourSumCount2(A, B, C, D);
        System.out.println(ans);
    }
}
