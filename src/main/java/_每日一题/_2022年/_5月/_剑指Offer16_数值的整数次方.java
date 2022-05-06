package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/05
 * @Description
 */
public class _剑指Offer16_数值的整数次方 {
    /**
     * 解法1：乘法快速幂（二分思想）
     * 思路：
     *      3*3*3*3*3*3*3*3
     *     =9*9*9*9
     *     =81*81
     *     =res
     */
    class Solution {
        public double myPow(double x, int n) {
            if(x == 0) return 0;
            long b = n;
            double res = 1.0;
            if(b < 0) {
                x = 1 / x;
                b = -b;
            }
            while(b > 0) {
                if((b & 1) == 1) res *= x;
                x *= x;
                b >>= 1;
            }
            return res;
        }
    }
}
