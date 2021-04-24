package _每日一题._2021年._21年4月;

import java.util.HashMap;

/**
 * @ClassName: _377组合总和4
 * @Author: lerry_li
 * @CreateTime: 2021/04/24
 * @Description
 * 解法1：记忆化递归
 * 解法2：动态规划
 */
public class _377组合总和4 {

    public static void main(String[] args) {
        _377组合总和4 instance = new _377组合总和4();
        System.out.println(instance.combinationSum4(new int[]{1, 2, 3}, 4));//7
        System.out.println(instance.combinationSum4(new int[]{9}, 3));//0
    }


    /**
     * 解法1：记忆化递归
     */
    public int combinationSum42(int[] nums, int target) {
        memo = new HashMap<>();
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return dfs(nums, target);
    }

    /**
     * 解法2：动态规划
     * 状态定义：
     *      dp[i]表示nums数组，和为target=i的组合个数
     * 状态转移：
     *      遍历i从1到target，对于每个i：
     *      遍历nums[]数组，当num<=i时，检查dp[i-num]
     *      dp]i]+=dp[i-num]
     * 初始化：
     *      dp[0]=1，空集合
     */
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        //空集合，只有一种情况
        dp[0] = 1;
        //状态转移，枚举金额
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    HashMap<Integer, Integer> memo;

    private int dfs(int[] nums, int target) {
        //递归终止条件
        if (target == 0) {
            return 1;
        }
        //检查是否计算过
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        int res = 0;
        //遍历nums，枚举硬币
        for (int num : nums) {
            if (num <= target) {
                res += dfs(nums, target - num);
            }
        }
        //加入备忘录
        memo.put(target, res);
        return res;
    }
}
