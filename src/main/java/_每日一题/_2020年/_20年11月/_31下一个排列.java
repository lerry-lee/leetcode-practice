package _每日一题._2020年._20年11月;


import java.util.Arrays;

/**
 * @ClassName: _31下一个排列
 * @Signature: Created by lerry_li on 2020/11/10
 * @Description:
 */
public class _31下一个排列 {
    /**
     * 解法1：时间O(N) 空间O(1)
     * 从后往前遍历，
     * 找不满足升序的第一个元素i，
     * 然后从[i,n]中找大于等于i的最小的元素j，
     * 然后交换i和j，并把i后面的元素升序排列.
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i < 0) {
            Arrays.sort(nums);
            return;
        }
        int j = i + 1;
        for (; j < nums.length; j++) {
            if (nums[j] <= nums[i]) {
                break;
            }
        }
        swap(nums, i, j - 1);
        Arrays.sort(nums, i + 1, nums.length);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        _31下一个排列 instance = new _31下一个排列();
        int[] nums = {5, 6, 4, 3, 2, 1};

        instance.nextPermutation(nums);

    }
}
