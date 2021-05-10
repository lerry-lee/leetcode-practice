package _每日一题._2021年._21年5月;

import java.util.HashSet;

/**
 * @ClassName: _740删除并获得点数
 * @Author: lerry_li
 * @CreateDate: 2021/05/10
 * @Description
 * 解法1：动态规划
 */
public class _740删除并获得点数 {

    public static void main(String[] args) {
        _740删除并获得点数 instance = new _740删除并获得点数();
        System.out.println(instance.deleteAndEarn(new int[]{3, 4, 2}));//6
        System.out.println(instance.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));//9
        System.out.println(instance.deleteAndEarn(new int[]{3, 7, 10, 5, 2, 4, 8, 9, 9, 4, 9, 2, 6, 4, 6, 5, 4, 7, 6, 10}));//66
    }

    /**
     * 解法1：动态规划 时间O(N+maxVal) 空间O(maxVal)
     */
    public int deleteAndEarn(int[] nums) {
        //特判
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //数组最大值
        int maxVal = 0;
        for (int num : nums) maxVal = Math.max(maxVal, num);
        //计数数组，统计以nums[i]为下标的元素个数
        int[] count = new int[maxVal + 1];
        for (int num : nums) {
            count[num] += 1;
        }
        //动态规划数组
        int[] dp = new int[maxVal + 1];
        //初始化
        dp[0] = 0;
        dp[1] = count[1];
        //状态转移
        for (int i = 2; i <= maxVal; i++) {
            //当前i要么不取，即获得收益=i-1的收益
            //要么取，即获得收益=i-2的收益+i的点数总分
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + count[i] * i);
        }
        //返回
        return dp[maxVal];
    }

}
