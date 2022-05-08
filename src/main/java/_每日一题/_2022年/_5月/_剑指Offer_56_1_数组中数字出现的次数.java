package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/08
 * @Description
 */
public class _剑指Offer_56_1_数组中数字出现的次数 {
    /**
     * 解法1：分组亦或，按二进制为1的某位
     */
    class Solution {
        public int[] singleNumbers(int[] nums) {
            //特判
            if (nums == null || nums.length < 2) return new int[]{};
            //亦或
            int x = 0;
            for (int num : nums) x ^= num;
            int i = 0;
            for (; i < 32; i++) {
                if ((x & 1) == 1) break;
                x >>= 1;
            }
            int a = 0, b = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 1) a ^= num;
                else b ^= num;
            }
            return new int[]{a, b};
        }
    }
}
