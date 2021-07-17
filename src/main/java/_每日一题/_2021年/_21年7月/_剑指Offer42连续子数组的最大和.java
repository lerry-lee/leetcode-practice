package _每日一题._2021年._21年7月;

/**
 * @ClassName: _剑指Offer42连续子数组的最大和
 * @Author: lerry_li
 * @CreateDate: 2021/07/17
 * @Description
 */
public class _剑指Offer42连续子数组的最大和 {
    /**
     * 解法1：贪心 时间O(n) 空间O(1)
     */
    public int maxSubArray(int[] nums) {
        //特判
        if (nums == null || nums.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        int temp = 0;
        for (int num : nums) {
            temp += num;
            res = Math.max(res, temp);
            temp = Math.max(temp, 0);
        }
        return res;
    }

    /**
     * 解法2：二分 时间O(NlogN) 空间O(1)
     */
    public int cal(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = l + (r - l) / 2;
        int leftMaxSum = cal(nums, l, mid);
        int rightMaxSum = cal(nums, mid + 1, r);
        int leftSum = nums[mid];
        int rightSum = nums[mid + 1];
        int temp = 0;
        for (int i = mid; i >= 0; i--) {
            temp += nums[i];
            leftSum = Math.max(leftSum, temp);
        }
        temp = 0;
        for (int i = mid + 1; i <= r; i++) {
            temp += nums[i];
            rightSum = Math.max(rightSum, temp);
        }
        return Math.max(Math.max(leftMaxSum, rightMaxSum), leftSum + rightSum);
    }
}
