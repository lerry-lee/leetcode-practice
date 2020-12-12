package _剑指Offer;

/**
 * @ClassName: _15二进制中1的个数
 * @Signature: Created by lerry_li on 2020/11/10
 * @Description: 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2
 */
public class _15二进制中1的个数 {
    /**
     * 解法1 逐位计算 时间O(logN) 空间O(1)
     * 根据 与运算 定义，设二进制数字 nn ，则有：
     * 若 n & 1 = 0 ，则 nn 二进制 最右一位 为 0 ；
     * 若 n & 1 = 1 ，则 nn 二进制 最右一位 为 1 。
     * 根据以上特点，考虑以下 循环判断 ：
     * 判断 n 最右一位是否为 1 ，根据结果计数。
     * 将 n 右移一位（本题要求把数字 n 看作无符号数，因此使用 无符号右移>>> 操作）。
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >>> 1;
        }
        return res;
    }

    /**
     * 解法2：巧用n&(n-1) 时间O(M) 空间O(1) M为1的个数
     * (n−1) 解析： 二进制数字 n 最右边的 1 变成 0 ，此 1 右边的 0 都变成 1 。
     * n&(n−1) 解析： 二进制数字 n 最右边的 1 变成 0 ，其余不变。
     * 例如：
     * ↓
     * n      = 10101000
     * n-1    = 10100111
     * n&(n−1)= 10100000
     */
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }


    public static void main(String[] args) {
        _15二进制中1的个数 instance = new _15二进制中1的个数();
        System.out.println(instance.hammingWeight(3));
    }
}
