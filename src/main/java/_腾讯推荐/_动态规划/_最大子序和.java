package _腾讯推荐._动态规划;

/**
 * @ClassName: _最大子序和
 * @Signature: Created by lerry_li on 2020/10/31
 * @Description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class _最大子序和 {
    /**
     * 解法1：一次遍历 时间O(N) 空间O(1)
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE, temp = 0;
        for (int num : nums) {
            temp += num;
            maxSum = Math.max(maxSum, temp);
            if (temp < 0) {
                temp = 0;
            }
        }
        return maxSum;
    }

    /**
     * 解法2：分治
     * 最大值子序列要么在左区间，要么在右区间，要么跨左右区间
     */
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return method2(nums, 0, nums.length - 1);
    }

    public int method2(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = l + (r - l) / 2;
        //递归计算左区间的最大值
        int left = method2(nums, l, mid);
        //递归计算右区间的最大值
        int right = method2(nums, mid + 1, r);
        //计算跨左右区间的最大值
        //至少包含左区间的最右边一个元素
        int leftSum = 0, leftMaxSum = nums[mid];
        for (int i = mid; i >= l; i--) {
            leftSum += nums[i];
            leftMaxSum = Math.max(leftMaxSum, leftSum);
        }
        //至少包含右区间的最左边一个元素
        int rightSum = 0, rightMaxSum = nums[mid + 1];
        for (int i = mid + 1; i <= r; i++) {
            rightSum += nums[i];
            rightMaxSum = Math.max(rightMaxSum, rightSum);
        }
        return max3(left, right, leftMaxSum + rightMaxSum);
    }

    public int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new _最大子序和().maxSubArray2(nums));
    }
}
