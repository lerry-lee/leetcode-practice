package _每日一题._2021年._21年3月;

/**
 * @ClassName: _198打家劫舍
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description
 */
public class _198打家劫舍 {
    /**
     * 解法1：带备忘录的递归
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = -1;
        }
        return dfs(nums, 0, memo);
    }

    public int dfs(int[] nums, int t, int[] memo) {
        if (t >= nums.length) {
            return 0;
        }
        if (memo[t] != -1) {
            return memo[t];
        }

        int selectCur = dfs(nums, t + 2, memo) + nums[t];
        int noCur = dfs(nums, t + 1, memo);

        memo[t] = Math.max(selectCur, noCur);

        return memo[t];
    }

    /**
     * 解法2：动态规划 时间O(N) 空间O(N)
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
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

    public static void main(String[] args) {
        _198打家劫舍 instance = new _198打家劫舍();
        System.out.println(instance.rob2(new int[]{1, 2, 3, 1}));
        System.out.println(instance.rob2(new int[]{2, 7, 9, 3, 1}));
        System.out.println(instance.rob2(new int[]{2, 7, 100, 500, 1}));
    }
}
