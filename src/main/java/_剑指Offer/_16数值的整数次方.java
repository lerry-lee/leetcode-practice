package _剑指Offer;

/**
 * @ClassName: _16数值的整数次方
 * @Author: lerry_li
 * @CreateDate: 2021/04/09
 * @Description TODO
 */
public class _16数值的整数次方 {
    /**
     * 解法1：乘法快速幂 时间O(logN) 空间O(1)
     */
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

    public static void main(String[] args) {
        _16数值的整数次方 instance = new _16数值的整数次方();
        System.out.println(instance.myPow(2.00000, 10));
        System.out.println(instance.myPow(2.10000, 3));
        System.out.println(instance.myPow(2.00000, -2));
    }
}
