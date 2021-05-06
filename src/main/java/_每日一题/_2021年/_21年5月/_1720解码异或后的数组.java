package _每日一题._2021年._21年5月;

import java.util.Arrays;

/**
 * @ClassName: _1720解码异或后的数组
 * @Author: lerry_li
 * @CreateDate: 2021/05/06
 * @Description
 * 解法1：异或运算
 */
public class _1720解码异或后的数组 {

    public static void main(String[] args) {
        _1720解码异或后的数组 instance = new _1720解码异或后的数组();
        System.out.println(Arrays.toString(instance.decode(new int[]{1, 2, 3}, 1)));//1,0,2,1
        System.out.println(Arrays.toString(instance.decode(new int[]{6,2,7,3}, 4)));//4,2,0,7,4
    }

    /**
     * 解法1：异或运算 时间O(N) 空间O(N)
     * 思路：
     *      【a^b = c ， a^b^b = a， 即 c^b=a 同理 c^a =b】
     */
    public int[] decode(int[] encoded, int first) {
        int len = encoded.length;
        int[] decoded = new int[len + 1];
        decoded[0] = first;
        for (int i = 0; i < len; i++) {
            decoded[i + 1] = func(encoded[i], decoded[i]);
        }
        return decoded;
    }

    private int func(int ans, int a) {
        return ans ^ a;
    }
}
