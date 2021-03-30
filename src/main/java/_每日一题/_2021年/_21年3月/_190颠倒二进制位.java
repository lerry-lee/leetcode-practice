package _每日一题._2021年._21年3月;

/**
 * @ClassName: _190颠倒二进制位
 * @Author: lerry_li
 * @CreateTime: 2021/03/29
 * @Description
 */
public class _190颠倒二进制位 {
    /**
     * 解法1：逐位颠倒
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    /**
     * 解法2：分治
     */
    public int reverseBits2(int n) {
        n = (n >>> 16) | (n << 16); //低16位与高16位交换
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8); //每16位中低8位和高8位交换; 1111是f
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4); //每8位中低4位和高4位交换;
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2); //每4位中低2位和高2位交换; 1100是c,0011是3
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1); //每2位中低1位和高1位交换; 1010是a,0101是5
        return n;
    }

    public static void main(String[] args) {
        _190颠倒二进制位 instance = new _190颠倒二进制位();
        System.out.println(instance.reverseBits(43261596));
    }
}
