package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/09
 * @Description
 */
public class _137_只出现一次的数字2 {
    /**
     * 解法1：只出现1次的数字，其他数字均出现m次的通用解法 时间O(N) 空间O(1)
     */
    class Solution {
        public int singleNumber(int[] nums) {
            //统计所有二进制位1的个数
            int[] digitCounts = new int[32];
            for (int num : nums) {
                for (int i = 31; i >= 0; i--) {
                    if ((num & 1) == 1) digitCounts[31 - i]++;
                    num >>>= 1;

                }
            }
            int m = 3;
            int res = 0;
            //遍历所有二进位，对m取模运算
            for (int i = 31; i >= 0; i--) {
                res <<= 1;
                res |= digitCounts[i] % m;
            }
            return res;
        }
    }
}
