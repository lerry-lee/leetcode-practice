package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/12
 * @Description
 */
public class _41_缺失的第一个正数 {
    /**
     * 解法1：计数置换 时间O(N) 空间O(1)
     * 思路：
     *      假设数组长度为n，遍历数组，对于当前元素i
     *      若i在[1,n]内，将其置换到下标i-1处；
     *      否则，不置换。
     *      最后在遍历一次数组，如果下标i处的数字不等于i+1，那该数字就是缺失的第一个正整数。
     */
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
            }
            for (int i = 0; i < n; i++) {
                if(nums[i]!=i+1){
                    return i+1;
                }
            }
            return n+1;
        }
    }
}
