package _每日一题._2021年._21年5月;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _1442形成两个异或相等数组的三元组数目
 * @Author: lerry_li
 * @CreateDate: 2021/05/18
 * @Description
 * 解法1：前缀和+三重循环枚举
 * 解法1：前缀和+二重循环枚举(两种解法)
 * 解法1：前缀和+一重循环枚举
 */
public class _1442形成两个异或相等数组的三元组数目 {

    public static void main(String[] args) {
        _1442形成两个异或相等数组的三元组数目 instance = new _1442形成两个异或相等数组的三元组数目();
        System.out.println(instance.countTriplets(new int[]{2, 3, 1, 6, 7}));//4
        System.out.println(instance.countTriplets(new int[]{1, 1, 1, 1, 1}));//10
        System.out.println(instance.countTriplets(new int[]{2, 3}));//0
        System.out.println(instance.countTriplets(new int[]{1, 3, 5, 7, 9}));//3
        System.out.println(instance.countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));//8

    }

    /**
     * 解法1：前缀和+三重循环枚举 时间O(N^3) 空间O(N)
     */
    public int countTriplets(int[] arr) {
        //特判
        if (arr == null || arr.length < 2) return 0;
        int len = arr.length;
        //前缀和
        int[] xor = new int[len];
        xor[0] = arr[0];
        for (int i = 1; i < len; i++) {
            xor[i] = xor[i - 1] ^ arr[i];
        }
        //枚举
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j; k < len; k++) {
                    int a = xor[j - 1] ^ xor[i] ^ arr[i];
                    int b = xor[k] ^ xor[j] ^ arr[j];
                    if (a == b) {
                        res++;
//                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
        return res;
    }

    /**
     * 解法1等式判断优化
     */
    public int countTriplets1(int[] arr) {
        //特判
        if (arr == null || arr.length < 2) return 0;
        int len = arr.length;
        //前缀和
        int[] xor = new int[len + 1];
        xor[0] = 0;
        for (int i = 0; i < len; i++) {
            xor[i + 1] = xor[i] ^ arr[i];
        }
        //枚举
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j; k < len; k++) {
                    //判断a==b，下面两式联立，可得xor[k+1]==xor[i]
                    //🕐1）a = xor[j] ^ xor[i]
                    //2）b = xor[k+1] ^ xor[j]
                    if (xor[k + 1] == xor[i]) res++;
                }
            }
        }
        return res;
    }

    /**
     * 解法2：二重循环枚举 时间O(N^2) 空间O(N)
     * 思路：
     * 当等式 xor[k+1]==xor[i]成立时，[i+1,k]的范围内的任意j都是符合要求的，对应的三元组个数为 k−i。
     * 因此我们只需枚举下标 i 和 k。
     */
    public int countTriplets2(int[] arr) {
        int n = arr.length;
        int[] xor = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            xor[i + 1] = xor[i] ^ arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int k = i + 1; k < n; ++k) {
                if (xor[i] == xor[k + 1]) {
                    ans += k - i;
                }
            }
        }
        return ans;
    }

    /**
     * 解法3：一重循环枚举 时间O(N) 空间O(N)
     * 思路：参考图解
     */
    public int countTriplets3(int[] arr) {
        int n = arr.length;
        //前缀和数组
        int[] xor = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            xor[i + 1] = xor[i] ^ arr[i];
        }
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        Map<Integer, Integer> total = new HashMap<Integer, Integer>();
        int ans = 0;
        //枚举k
        for (int k = 0; k < n; ++k) {
            //xor[k+1]出现的次数（判断xor[i]==xor[k+1]的情况，i<k）
            //若之前出现过，那么相当于xor[i]==xor[k+1]，取出之前出现的次数即可
            //若之前未出现过，那么xor[k+1]相当于第一次出现
            if (cnt.containsKey(xor[k + 1])) {
                ans += cnt.get(xor[k + 1]) * k - total.get(xor[k + 1]);
            }
            //加入哈希表
            //注意这里加入的是xor[k]，即arr[k-1]的前缀和，因为遍历的是k，但比较的是i，i是取值[0,k-1]的
            cnt.put(xor[k], cnt.getOrDefault(xor[k], 0) + 1);
            total.put(xor[k], total.getOrDefault(xor[k], 0) + k);
        }
        return ans;
    }

    /**
     * 解法4：二重循环的另一种解法 时间O(N^2) 空间O(1)
     * 思路：
     * a ^ b = a[i]^...^a[k] = 0, 题目转化为求子串的异或结果等于0
     */
    public int countTriplets4(int[] arr) {
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            int t = arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                t ^= arr[k];
                if (t == 0) {
                    // j 无所谓呐，i~k任意一个数都行
                    res += k - i;
                }
            }
        }
        return res;
    }

}
