package _每日一题._2022年._5月;

import java.util.Random;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/15
 * @Description
 */
public class _384_打乱数组 {
    /**
     * 解法1：洗牌算法 时间O(N) 空间O(N)
     */
    class Solution {

        private int[] originNums;
        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
            originNums = new int[nums.length];
            System.arraycopy(nums, 0, originNums, 0, originNums.length);
        }

        public int[] reset() {
            System.arraycopy(originNums, 0, nums, 0, originNums.length);
            return this.nums;
        }

        public int[] shuffle() {
            for (int i = 0; i < nums.length; i++) {
                Random random = new Random();
                int j = random.nextInt(nums.length - i) + i;
                swap(nums, i, j);
            }
            return this.nums;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    /**
     * 解法2：暴力 时间O(N) 空间O(N)
     */
    class Solution2 {

        private int[] originNums;
        private int[] nums;

        public Solution2(int[] nums) {
            this.nums = nums;
            originNums = new int[nums.length];
            System.arraycopy(nums, 0, originNums, 0, originNums.length);
        }

        public int[] reset() {
            System.arraycopy(originNums, 0, nums, 0, originNums.length);
            return this.nums;
        }

        public int[] shuffle() {
            int[] temp = new int[originNums.length];
            System.arraycopy(originNums, 0, temp, 0, originNums.length);
            int end = temp.length - 1;
            Random random = new Random();
            for (int i = 0; i < nums.length; i++) {
                int j = random.nextInt(end+1);
                nums[i] = temp[j];
                swap(temp, j, end);
                end--;
            }
            return this.nums;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
