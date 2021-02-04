package _每日一题._2021年._21年2月;


/**
 * @ClassName: _643子数组最大平均数1
 * @Author: lerry_li
 * @CreateTime: 2021/02/04
 * @Description
 */
public class _643子数组最大平均数1 {
    /**
     * 解法1：滑动窗口（一次遍历） 时间O(N) 空间O(1)
     */
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return 0;
        }
        k = Math.min(k, nums.length);
        int left = 0, right = k;
        int tempSum = 0;
        for (int i = 0; i < k; i++) {
            tempSum += nums[i];
        }
        int maxSum = tempSum;
        while (right < nums.length) {
            tempSum += nums[right] - nums[left];
            maxSum = Math.max(maxSum, tempSum);
            right++;
            left++;
        }
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        _643子数组最大平均数1 instance = new _643子数组最大平均数1();
        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(instance.findMaxAverage(nums, 4));
    }
}
