package _其他._笔试题._阿里;

/**
 * @ClassName: T1
 * @Author: lerry_li
 * @CreateTime: 2021/04/08
 * @Description
 */
public class T1 {
    public static void main(String[] args) {
        System.out.println(getMaxSubsetSum(new int[]{-1, -2, 1, 6, -5, 7, 2}));//1+6-5+7+2=11
    }

    /**
     * 解法1：贪心 时间O(N) 空间O(1)
     */
    private static int getMaxSubsetSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int tempSum = 0;
        for (int num : nums) {
            tempSum += num;
            maxSum = Math.max(maxSum, tempSum);
            if (tempSum < 0) {
                tempSum = 0;
            }
        }
        return maxSum;
    }

    /**
     * 解法2：动态规划 时间O(N) 空间O(N)
     */
    private static int getMaxSubsetSum2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + nums[i];
        }
        int maxSum = dp[0];
        for (int i = 0; i < len; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
