package _腾讯推荐._数学与数字;

/**
 * Created by lerry_li on 2020/10/16
 */

/**
 * 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class _2的幂 {
    /**
     * 解法1：递归
     */
    public boolean isPowerOfTwo(int n) {
        //特判
        if (n == 0) return false;
        //递归终止条件
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        //递归计算n/2
        return isPowerOfTwo(n / 2);
    }

}
