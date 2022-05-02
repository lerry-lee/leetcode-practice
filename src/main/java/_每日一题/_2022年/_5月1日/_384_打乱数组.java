package _每日一题._2022年._5月1日;

import java.util.Random;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/01
 */
public class _384_打乱数组 {

    /**
     * 解法1：洗牌算法，遍历数组，每次随机选一个元素和当前遍历元素交换
     */
    class Solution {
        int[] nums;
        int[] original;

        public Solution(int[] nums) {
            this.nums = nums;
            this.original = new int[nums.length];
            System.arraycopy(nums, 0, original, 0, nums.length);
        }

        public int[] reset() {
            System.arraycopy(original, 0, nums, 0, nums.length);
            return nums;
        }

        public int[] shuffle() {
            Random random = new Random();
            for (int i = 0; i < nums.length; ++i) {
                int j = i + random.nextInt(nums.length - i);
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            return nums;
        }
    }
}
