package _每日一题._2021年._21年5月;

import java.util.Arrays;

/**
 * @ClassName: _1734解码异或后的排列
 * @Author: lerry_li
 * @CreateDate: 2021/05/11
 * @Description
 * 解法1：暴力
 * 解法2：先求first
 */
public class _1734解码异或后的排列 {

    public static void main(String[] args) {
        _1734解码异或后的排列 instance = new _1734解码异或后的排列();
        System.out.println(Arrays.toString(instance.decode(new int[]{3, 1})));//1,2,3
        System.out.println(Arrays.toString(instance.decode(new int[]{6, 5, 4, 6})));//2,4,1,5,3
    }

    /**
     * 解法1：暴力 时间O(N^2) 空间O(N)
     */
    public int[] decode1(int[] encoded) {
        if (encoded == null || encoded.length == 0) return new int[]{};
        int len = encoded.length;
        int[] decoded = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            if (check(i, encoded, decoded)) {
                return decoded;
            }
        }
        return decoded;
    }

    private boolean check(int first, int[] encoded, int[] decoded) {
        decoded[0] = first;
        int len = encoded.length;
        boolean[] freq = new boolean[len + 2];
        freq[0] = true;
        freq[first] = true;
        for (int i = 0; i < len; i++) {
            decoded[i + 1] = decoded[i] ^ encoded[i];
            if (decoded[i + 1] > len + 1 || freq[decoded[i + 1]]) return false;
        }
        return true;
    }

    /**
     * 解法2：先求first 时间O(N) 空间O(1)
     */
    public int[] decode(int[] encoded) {
        //特判
        if (encoded == null || encoded.length == 0) return new int[]{};
        //前n个正整数的排列
        int n = encoded.length + 1;
        //前n个正整数的异或结果
        int total = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                total = 1;
            } else {
                total ^= i;
            }

        }
        //前n个正整数的异或结果 去掉first元素的异或结果
        //相当于encoded[]奇数下标元素的异或结果，可以举例推演
        int total_rm_first = 0;
        for (int i = 1; i < n - 1; i += 2) {
            if(i==1){
                total_rm_first=encoded[i];
            }else{
                total_rm_first ^= encoded[i];
            }
        }
        //求出first元素
        int first=total^total_rm_first;
        //然后顺次求后面的元素即可
        int[] decoded=new int[n];
        decoded[0]=first;
        for (int i = 0; i < n-1; i++) {
            decoded[i + 1] = decoded[i] ^ encoded[i];
        }
        return decoded;
    }
}
