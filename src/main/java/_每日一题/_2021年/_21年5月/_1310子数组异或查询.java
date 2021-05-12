package _每日一题._2021年._21年5月;

import java.util.Arrays;

/**
 * @ClassName: _1310子数组异或查询
 * @Author: lerry_li
 * @CreateDate: 2021/05/12
 * @Description
 * 解法1：前缀和
 */
public class _1310子数组异或查询 {
    public static void main(String[] args) {
        _1310子数组异或查询 instance = new _1310子数组异或查询();
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println(Arrays.toString(instance.xorQueries(arr, queries)));
    }

    /**
     * 解法1：前缀和 时间(N) 空间O(N)
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;
        int[] xor = new int[len];
        xor[0] = arr[0];
        for (int i = 1; i < len; i++) {
            xor[i] = xor[i - 1] ^ arr[i];
        }
        int qLen = queries.length;
        int[] res = new int[qLen];
        for (int i = 0; i < qLen; i++) {
            int a = queries[i][0] - 1, b = queries[i][1];
            if (a == -1) {
                res[i] = xor[b];
            } else {
                res[i] = xor[b] ^ xor[a];
            }
        }
        return res;
    }
}
