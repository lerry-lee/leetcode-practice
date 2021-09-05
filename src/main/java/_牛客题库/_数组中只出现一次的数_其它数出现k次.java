package _牛客题库;

/**
 * @ClassName: _数组中只出现一次的数_其它数出现k次
 * @Author: lerry_li
 * @CreateTime: 2021/09/04
 * @Description
 */
public class _数组中只出现一次的数_其它数出现k次 {
    /**
     * 按位求和模k 时间O(32N) 空间O(32)
     */
    public int foundOnceNumber(int[] arr, int k) {
        //二进制位求和
        int[] binSum = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                binSum[i] += (num >> (31 - i)) & 1;
            }
        }
        int res = 0;
        //按位模k判断要找的数字的该位是1还是0
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if (binSum[i] % k > 0) {
                res += 1;
            }
        }
        return res;
    }
}
