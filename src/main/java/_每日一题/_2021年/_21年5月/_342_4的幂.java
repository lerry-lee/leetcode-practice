package _每日一题._2021年._21年5月;

/**
 * @ClassName: _4的幂
 * @Author: lerry_li
 * @CreateDate: 2021/05/31
 * @Description
 * 解法1：位运算
 */
public class _342_4的幂 {

    public static void main(String[] args) {
        _342_4的幂 instance=new _342_4的幂();
        System.out.println(instance.isPowerOfFour(1));
        System.out.println(instance.isPowerOfFour(2));
        System.out.println(instance.isPowerOfFour(3));
        System.out.println(instance.isPowerOfFour(4));
        System.out.println(instance.isPowerOfFour(5));
        System.out.println(instance.isPowerOfFour(16));
    }

    /**
     * 解法1：位运算 时间O(1) 空间O(1)
     */
    public boolean isPowerOfFour(int n) {
        //非正整数直接返回falsel
        if (n <= 0) return false;
        //取n二进制表示最低位的1
        int lowOne = (n & (-n));
        //二者不等，则返回falsel
        //二者想等，说明n是2的幂，需要继续判断
        if (lowOne != n) return false;
        //统计n中0的个数
        int count0 = 0;
        while (lowOne > 0) {
            lowOne >>= 1;
            count0++;
        }
        //0的个数必须为2的倍数(二进制中2个0表示4倍，100)
        return (count0-1) % 2 == 0;
    }
}
