package _每日一题._20年10月;

/**
 * Created by lerry_li on 2020/10/11
 */
public class _416分割等和子集 {
    /**
     * 解法1：递归（超时）
     * 解法2：动态规划，二维dp，时间O(mn)，空间O(mn)，m为元素和
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        //计算数组元素总和，若为奇数直接返回false
        int totalSum = 0, maxNum = 0;
        for (int num : nums) {
            totalSum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (totalSum % 2 != 0) return false;
        //元素总和的1/2
        totalSum = totalSum / 2;
        //若其中最大的元素大于元素总和的1/2，直接返回false
        if (maxNum > totalSum) return false;
        int len = nums.length;
        //行表示数组元素，列表示元素之和
        //dp[i][j]表示数组第0到第i个元素中可以选择若干个，它们的和为j
        boolean[][] dp = new boolean[len][totalSum + 1];
        //初始化第0个元素，只有当和等于它的值时，才为true
        if (nums[0] <= totalSum) {
            dp[0][nums[0]] = true;
        }
        //填表
        for (int i = 1; i < len; i++) {
            for (int tempSum = 0; tempSum <= totalSum; tempSum++) {
                //若当前元素就等于 和tempSum，只选它，直接为true
                if (nums[i] == tempSum) dp[i][tempSum] = true;
                    //若当前元素小于 和tempSum，要么选它要么不选
                else if (nums[i] < tempSum) {
                    dp[i][tempSum] = dp[i - 1][tempSum] || dp[i - 1][tempSum - nums[i]];
                }
                // 由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作
                if (dp[i][totalSum]) {
                    return true;
                }
            }
        }
        return dp[len - 1][totalSum];
    }

    /**
     * 解法3：动态规划，一维dp，时间O(mn)，空间O(m)，m为元素和
     * TODO
     */
    public boolean dp(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int tempTarget = target; tempTarget >= num; --tempTarget) {
                dp[tempTarget] = dp[tempTarget] | dp[tempTarget - num];
            }
        }
        return dp[target];

    }
}
