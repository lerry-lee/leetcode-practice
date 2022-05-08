package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/08
 * @Description
 */
public class _剑指Offer39_数组中出现次数超过一半的数字 {
    /**
     * 解法1：摩尔投票法
     */
    class Solution {
        public int majorityElement(int[] nums) {
            int candidate = 0;
            int cnt = 0;
            for (int num : nums) {
                if (candidate == num) cnt++;
                else if (cnt == 0) {
                    candidate = num;
                    cnt = 1;
                } else {
                    cnt--;
                }
            }
            return candidate;
        }
    }
}
