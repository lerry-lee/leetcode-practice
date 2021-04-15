package _每日一题._2021年._21年4月;

/**
 * @ClassName: _213打家劫舍2
 * @Author: lerry_li
 * @CreateDate: 2021/04/15
 * @Description
 * 解法：动态规划+空间优化
 */
public class _213打家劫舍2 {

    public static void main(String[] args) {
        _213打家劫舍2 instance = new _213打家劫舍2();
        System.out.println(instance.rob(new int[]{2, 3, 2}));//3
        System.out.println(instance.rob(new int[]{1, 2, 3, 1}));//4
        System.out.println(instance.rob(new int[]{0}));//0
        System.out.println(instance.rob(new int[]{3, 2, 4, 10}));//13
    }

    /**
     * 解法1：动态规划 时间O(N) 空间O(N)
     * 状态定义：
     * “dp[i][j]表示第i个房屋状态为j时的最大收益，j=0表示不偷，j=1表示偷”
     * 状态转移：
     * 1）dp[i][1]=dp[i-1][0]+nums[i]
     * 2）dp[i][0]=max(dp[i-1][0],dp[i-1][1])
     * 初始化：
     * ”dp[0][0]=0,dp[0][1]=nums[0]“
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
//        return Math.max(func(nums, 2, len - 2) + nums[0], func(nums, 1, len - 1));
        return Math.max(func2(nums, 0, len - 1), func2(nums, 1, len));
    }

    private int func(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return nums[start];
        }
        int[][] dp = new int[nums.length][2];
        dp[start][0] = 0;
        dp[start][1] = nums[start];
        for (int i = start + 1; i <= end; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[end][0], dp[end][1]);
    }

    //func优化
    private int func2(int[] nums, int start, int end) {
        //dp[i]表示偷到第i家的最大金额
        int[] dp = new int[nums.length + 1];
        dp[start] = 0;
        dp[start + 1] = nums[start];//第1家最大金额为偷取
        for (int i = start + 1; i < end; i++) {
            //状态转移
            //选择偷/不偷当前第i家
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[end];
    }

    //func2空间优化
    private int func3(int[] nums, int start, int end) {
        //dp[i]表示偷到第i家的最大金额
        int prev = 0;
        int cur = nums[start];
        for (int i = start + 1; i < end; i++) {
            //状态转移
            //选择偷/不偷当前第i家
            int temp=cur;
            cur = Math.max(cur, prev + nums[i]);
            prev = temp;
        }
        return cur;
    }
}
