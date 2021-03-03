package _每日一题._2021年._21年3月;

/**
 * @ClassName: _338比特位计数
 * @Author: lerry_li
 * @CreateDate: 2021/03/03
 * @Description
 */
public class _338比特位计数 {
    /**
     * 解法1：直接计算+按位运算 时间O(NK) K为二进制位数，空间O(1)
     */
    public int[] countBits(int num) {
        if (num < 0) {
            return new int[]{};
        }
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = countOne(i);
        }
        return res;
    }

    public int countOne(int num) {
        int res = 0;
        while (num > 0) {
            //该运算表示将二进制数num的最后一个1变成0
            num &= (num - 1);
            res++;
        }
        return res;
    }

    /**
     * 解法2：动态规划+最低有效位 时间O(N) 空间O(1)
     * 思路：
     *      x的1比特数可以由x>>1(x右移一位)的1比特数转移得到
     * 状态转移：
     *      1）若x的最低有效位是1，则x的1比特数为x>>1的1比特数+1
     *      2）若x的最低有效位是0，则x的1比特数为x>>1的1比特数
     * 初始化：
     *      0的1比特数为0
     */
    public int[] countBits2(int num) {
        if (num < 0) {
            return new int[]{};
        }
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            //i>>1表示i右移一位，最低位丢失
            //i&1表示i除以2的余数，若为1则说明丢失的最低位为1，否则为0
            res[i] = res[i>>1]+(i&1);
        }
        return res;
    }

    /**
     * 解法3：动态规划+最低设置位 时间O(N) 空间O(1)
     * 思路：
     *      x的1比特数可以由x&(x-1)(x的最低位的1变成0)的1比特数转移得到
     * 状态转移：
     *      x的1比特数=x&(x-1)的1比特数+1
     * 初始化：
     *      0的1比特数为0
     */
    public int[] countBits3(int num) {
        if (num < 0) {
            return new int[]{};
        }
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            //x&(x-1)表示i的最低位的1变成0
            res[i] = res[i&(i-1)]+1;
        }
        return res;
    }

}
