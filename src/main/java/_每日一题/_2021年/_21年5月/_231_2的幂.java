package _每日一题._2021年._21年5月;

/**
 * @ClassName: _2312的幂
 * @Author: lerry_li
 * @CreateDate: 2021/05/30
 * @Description
 * 解法1：按位判断
 * 解法2：巧用位运算
 */
public class _231_2的幂 {

    public static void main(String[] args) {
        _231_2的幂 instance = new _231_2的幂();
        System.out.println(instance.isPowerOfTwo(1));
        System.out.println(instance.isPowerOfTwo(16));
        System.out.println(instance.isPowerOfTwo(3));
        System.out.println(instance.isPowerOfTwo(4));
        System.out.println(instance.isPowerOfTwo(5));
    }

    /**
     * 解法1：按位判断 时间O(1) 空间O(1)
     */
    public boolean isPowerOfTwo1(int n) {
        if (n < 0) return false;
        boolean flag = false;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                if (flag) return false;
                flag = true;
            }
            n >>= 1;
        }
        return flag;
    }

    /**
     * 解法2：巧用位运算 时间O(1) 空间O(1)
     * 思路：
     *      充分性证明：
     *          1) n & n-1可以把n最低位的1变0，
     *          2) 当(n & n-1) == 0时，则说明n只有一个1，且在最低位
     *          因此n=1000... (后面若干个0)
     *      必要性证明：
     *          1）n 二进制最高位为 1，其余所有位为 0；
     *          2）n−1 二进制最高位为 0，其余所有位为 1；
     *          因此 (n&(n-1))==0
     *
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    /**
     * 解法3：巧用位运算 时间O(1) 空间O(1)
     * 思路：
     *      n&(-n) 可以得到n二进制表示的最低位的1
     *      原理证明：参考图解 data/图解/231_2的幂_为运算技巧.png
     */
    public boolean isPowerOfTwo3(int n) {
        if (n <= 0) return false;
        return (n & (-n)) == n;
    }
}
