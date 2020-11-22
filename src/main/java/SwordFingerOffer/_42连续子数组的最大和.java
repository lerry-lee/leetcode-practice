package SwordFingerOffer;

/**
 * @ClassName: _42连续子数组的最大和
 * @Signature: Created by lerry_li on 2020/11/20
 * @Description:
 */
public class _42连续子数组的最大和 {
    /**
     * 解法1：一次遍历 时间O(N) 空间O(1)
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int temp = 0;
        for (int num : nums) {
            temp += num;
            res = Math.max(res, temp);
            if (temp < 0) {
                temp = 0;
            }
        }
        return res;
    }

    /**
     * 解法2：分治法
     * 思路：
     * 将数组分成两部分，最大值要么在左边，要么在右边，要么横跨两边
     */
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return cal(nums, 0, nums.length - 1);
    }

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

    public static void main(String[] args) {
        _42连续子数组的最大和 instance = new _42连续子数组的最大和();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(instance.maxSubArray2(nums));
    }
}
