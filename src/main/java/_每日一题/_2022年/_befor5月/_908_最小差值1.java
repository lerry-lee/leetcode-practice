package _每日一题._2022年._befor5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/30
 */
public class _908_最小差值1 {

    /**
     * 解法1：直接找数组最大值和最小值，然后-2*k，时间O(N) 空间O(1)
     */
    class Solution1 {
        public int smallestRangeI(int[] nums, int k) {
            if(nums==null||nums.length<=1) return 0;
            int minNum=Integer.MAX_VALUE,maxNum=Integer.MIN_VALUE;
            for(int num:nums) {
                minNum=Math.min(minNum,num);
                maxNum=Math.max(maxNum,num);
            }
            return Math.max(0,maxNum-minNum-2*k);
        }
    }
}
