package _每日一题._2021年._21年7月;

import java.util.Arrays;

/**
 * @ClassName: _31下一个排列
 * @Author: lerry_li
 * @CreateDate: 2021/07/14
 * @Description
 */
public class _31下一个排列 {
    /**
     * 推导题 时间O(N) 空间O(1)
     */
    public void nextPermutation(int[] nums) {
        //特判
        if (nums == null || nums.length == 0) return;
        //从后往前遍历
        //找到第一个降序的数字，然后和后面比该数字大的里面最小的数字交换，并把后面的数字排序
        int n = nums.length;
        int i = n - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) break;
        }
        if (i < 0) {
            Arrays.sort(nums);
        } else {
            //找后面比i大的里面最小的数字
            int j = i + 1;
            for (; j < n; j++) {
                if (nums[j] <= nums[i]) break;
            }
            int temp = nums[i];
            nums[i] = nums[j - 1];
            nums[j - 1] = temp;
            Arrays.sort(nums, i + 1, n);
        }
    }
}
