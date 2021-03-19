package _每日一题._2021年._21年3月;

import java.util.Arrays;

/**
 * @ClassName: _213打家劫舍2
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description
 */
public class _213打家劫舍2 {
    /**
     * 解法1：动态规划 时间O(N) 空间O(N)
     * 其实就是把环拆成两个队列，一个是从0到n-1，另一个是从1到n，然后返回两个结果最大的。
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        //状态定义：dp[i]表示[0~i]最大值
        //初始化：第0家的收益为0(表示没有偷呢)，第1家的收益为nums[1]
        dp[0] = 0;
        dp[1] = nums[0];
        //状态转移：
        for (int i = 2; i <= len; i++) {
            //选当前这一家i，或者不选
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

}
