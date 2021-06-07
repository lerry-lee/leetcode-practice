package _每日一题._2021年._21年6月;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _494目标和
 * @Author: lerry_li
 * @CreateDate: 2021/06/07
 * @Description
 * 解法1：回溯+剪枝
 * 解法2：记忆化递归
 * 解法3：dp(转化为0-1背包问题)
 */
public class _494目标和 {

    public static void main(String[] args) {
        _494目标和 instance = new _494目标和();
//        System.out.println(instance.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
//        System.out.println(instance.findTargetSumWays(new int[]{1}, 1));
    }

    /**
     * 解法1：回溯+剪枝 时间O(2^N) 空间O(2^N)
     */
    public int findTargetSumWays1(int[] nums, int target) {
        //特判
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        prefixSum = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            prefixSum[i][0] = prefixSum[i - 1][0] + nums[i - 1];
            prefixSum[i][1] = prefixSum[i - 1][1] - nums[i - 1];
        }
        int res = dfs(nums, 0, target, 0);
        return res;
    }

    HashMap<Integer, HashMap<Integer, Integer>> memo;

    /**
     * 解法2：记忆化递归
     * 思路：
     *      递归函数中t和sum为可变参数，可以作为记忆容器的维度，用来存储计算过的值
     */
    public int findTargetSumWays2(int[] nums, int target) {
        //特判
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        memo = new HashMap<>();
        int res = dfs(nums, 0, target, 0);
        return res;
    }


    /**
     * 解法3：dp
     */
    public int findTargetSumWays3a(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }

    /**
     原问题等同于： 找到nums一个正子集P和一个负子集N，使得总和等于target。即sum(P) - sum(N) == target，
     即sum(P) + sum(N) + sum(P) - sum(N) == target + sum(P) + sum(N)
     即2 * sum(P) == target + sum(nums)， 其中target + sum(nums)必须>=0且为偶数，否则等式不可能成立。
     则问题转换为：存在多少个子集P，使sum(P) == (target + sum(nums))/2。

     dp[i][j]表示前i个元素有多少个目标和为j的子集。dp[0][0] = 1
     1. dp[i][j] = dp[i-1][j]
     2. 如果nums[0...i-2]存在目标和为j-nums[i-1]的子集，则dp[i][j] += dp[i-1][j-nums[i-1]]
     */
    public int findTargetSumWays3b(int[] nums, int target) {
        //特判
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        for (int num : nums) sum += num;
        if (target + sum < 0 || ((target + sum) & 1) == 1) return 0;  // 必须>=0且为偶数
        int T = (target + sum) >> 1;
        //dp定义
        //dp[j]表示目标和为j的子集个数
        int[] dp = new int[T + 1];
        //初始化
        dp[0] = 1;
        //状态转移
        for (int i = 1; i <= nums.length; ++i) {
            int[] curr = new int[T + 1];
            for (int j = 0; j <= T; ++j) {
                curr[j] = dp[j];
                //若j>nums[i-1]，则加上dp[j-nums[i-1]]
                if (j - nums[i - 1] >= 0) curr[j] += dp[j - nums[i - 1]];
            }
            dp = curr;
        }
        return dp[T];
    }


    private int dfs(int[] nums, int t, int target, int sum) {
        if (t == nums.length) {
            if (sum == target) return 1;
            return 0;
        }
        //检查备忘录
        if (memo.containsKey(t) && memo.get(t).containsKey(sum)) return memo.get(t).get(sum);
        int pos = dfs(nums, t + 1, target, sum + nums[t]);
        int neg = dfs(nums, t + 1, target, sum - nums[t]);
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.put(sum, pos + neg);
        memo.put(t, temp);
        return pos + neg;
    }

    int[][] prefixSum;
}
