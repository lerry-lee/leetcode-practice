package _每日一题._2021年._21年9月;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/10
 */
public class _283移动零 {
    /**
     * 解法1：双指针 时间O(N) 空间O(1)
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int end = 0;
        for (; end < nums.length; end++) {
            if (nums[end] == 0) break;
        }
        for (int i = end + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[end++] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
