package _剑指Offer;

import java.util.Arrays;

/**
 * @ClassName: _21调整数组顺序使奇数位于偶数前面
 * @Author: lerry_li
 * @CreateDate: 2021/04/10
 * @Description
 */
public class _21调整数组顺序使奇数位于偶数前面 {
    /**
     * 解法1：双指针（快排的partition思想） 时间O(N) 空间O(1)
     */
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        _21调整数组顺序使奇数位于偶数前面 instance=new _21调整数组顺序使奇数位于偶数前面();
        System.out.println(Arrays.toString(instance.exchange(new int[]{1,2,3,4})));
    }
}
