package _每日一题._2021年._21年4月;

/**
 * @ClassName: _263丑数
 * @Author: lerry_li
 * @CreateTime: 2021/04/10
 * @Description
 */
public class _263丑数 {
    /**
     * 解法1：数学 时间O(logN) 空间O(1)
     * 思路：
     *      根据丑数的定义，0和负整数一定不是丑数。
     *      当n>0时，若n是丑数，则n可以写成n=2^a x 3^b x 5^c的形式，其中a,b,c都是非负整数。
     *      特别地，当a,b,c都是0时,n=1
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        //对n反复除以2,3,5，直到n不再包含质因数2,3,5。若剩下的数等于1，则说明n不包含其他质因数
        //否则，说明n包含其他质因数
        while (n % 5 == 0) {
            n /= 5;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
