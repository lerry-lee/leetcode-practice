package _剑指Offer;

/**
 * @ClassName: _16数值的整数次方
 * @Author: lerry_li
 * @CreateDate: 2021/04/09
 * @Description
 */
public class _16数值的整数次方 {
    /**
     * 解法1：乘法快速幂 时间O(logN) 空间O(1)
     * 思路：
     *      数学（见图解）
     * tips：Java 代码中 int32 变量 n∈[−2147483648,2147483647] ，
     *      因此当 n = -2147483648 时执行 n = -n 会因越界而赋值出错。
     *      解决方法是先将 n 存入 long 变量 ，后面用 long 变量 操作即可。
     *
     */
    public double myPow(double x, int n) {
        //特判
        if (x == 0) return 0;
        double res = 1.0;
        boolean sign = n > 0;
        long N = n;
        N = Math.max(N, -N);
        while (N > 0) {
            //判断n最低位是否为1
            //为1，则累乘x
            if ((N & 1) == 1) {
                res *= x;
            }
            //为0，则res=res*1，相当于无操作
            //x每次平方
            x *= x;
            //n每次右移一位，因为最低位已经被处理
            N >>= 1;
        }
        if (sign) {
            return res;
        }
        return 1 / res;
    }


    public static void main(String[] args) {
        _16数值的整数次方 instance = new _16数值的整数次方();
        System.out.println(instance.myPow(2.00000, 10));
        System.out.println(instance.myPow(2.10000, 3));
        System.out.println(instance.myPow(2.00000, -2));
    }
}
