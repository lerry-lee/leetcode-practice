package _每日一题._2021年._21年3月;

/**
 * @ClassName: _191位1的个数
 * @Author: lerry_li
 * @CreateTime: 2021/03/22
 * @Description
 */
public class _191位1的个数 {
    /**
     * 解法1：位运算（n每次右移一位，看末位是1就res+1） 时间O(K) 空间O(1)
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    /**
     * 解法2：位运算(n & (n - 1) 的技巧可以消除二进制中最后一个 1) 时间O(K) 空间O(1)
     */
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res += 1;
            n &= n - 1;
        }
        return res;
    }

}
