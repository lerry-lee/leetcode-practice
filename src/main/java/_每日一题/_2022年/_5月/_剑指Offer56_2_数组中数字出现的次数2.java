package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/08
 * @Description
 */
public class _剑指Offer56_2_数组中数字出现的次数2 {
    /**
     * 解法1：数组中只有一个数字出现1词，其他数字出现m次【通解】
     * 思路：
     *      用一个二进制位数字【】统计所有数字各二进制位的1的个数，
     *      然后遍历这些二进制位，对m进行取模，得到的即使只出现1的数字的该二进位的值，组合起来即可。
     */
    class Solution {
        public int singleNumber(int[] nums) {
            int[] counts = new int[32];
            for(int num : nums) {
                for(int j = 0; j < 32; j++) {
                    counts[j] += num & 1;
                    num >>>= 1;
                }
            }
            int res = 0, m = 3;
            for(int i = 0; i < 32; i++) {
                res <<= 1;
                res |= counts[31 - i] % m;
            }
            return res;
        }
    }
}
