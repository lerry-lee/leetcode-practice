package _每日一题._2021年._21年6月;

/**
 * @ClassName: _剑指Offer15二进制中1的个数
 * @Author: lerry_li
 * @CreateDate: 2021/06/26
 * @Description
 * 解法1：位运算
 */
public class _剑指Offer15二进制中1的个数 {
    /**
     * 解法1：位运算 时间O(logN) 空间O(1)
     * n&(n-1)可以把n最后一个1变成0
     */
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}
