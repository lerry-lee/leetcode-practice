package _每日一题._2022年._5月1日;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/01
 */
public class _152_乘积最大子数组 {
    /**
     * 解法1：dp 时间O(N) 空间O(N)
     * 解法2：dp空间优化 时间O(N) 空间O(1)
     */
    class Solution1 {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int len = nums.length;
            //1.定义
            //dp[i][0] 以i结尾的子数组的乘积最小值
            //dp[i][1] 以i结尾的子数组的乘积最大值
            int[][] dp = new int[len][2];
            //2.初始化：
            dp[0][0] = dp[0][1] = nums[0];
            //3.转移
            for (int i = 1; i < len; i++) {
                if (nums[i] > 0) {
                    dp[i][0] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
                    dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
                } else {
                    dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
                    dp[i][1] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
                }
            }
            //求解
            int res = dp[0][1];
            for (int i = 0; i < len; i++) {
                res = Math.max(res, dp[i][1]);
            }
            return res;
        }
    }

    class Solution2 {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int len = nums.length;
            //1.定义
            //2.初始化：
            int minProd = nums[0], maxProd = nums[0];
            int res = nums[0];
            //3.转移
            for (int i = 1; i < len; i++) {
                if (nums[i] > 0) {
                    minProd = Math.min(nums[i], minProd * nums[i]);
                    maxProd = Math.max(nums[i], maxProd * nums[i]);
                } else {
                    int temp = minProd;
                    minProd = Math.min(nums[i], maxProd * nums[i]);
                    maxProd = Math.max(nums[i], temp * nums[i]);
                }
                res = Math.max(maxProd, res);
            }
            //求解
            return res;
        }
    }
}
