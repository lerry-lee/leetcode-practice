package _每日一题._2020年._20年12月;


/**
 * @ClassName: _376摆动序列
 * @Author: lerry_li
 * @CreateTime: 2020/12/12
 * @Description
 */
public class _376摆动序列 {
    /**
     * 解法1：暴力回溯（超时）
     * 解法2：动态规划
     * 解法3：贪心
     */

    /**
     * 解法2：动态规划 时间(N) 空间O(N)
     * 状态定义：
     *      dp[i][j]表示 数组前i个元素 状态为j时 的最长摆动序列的长度
     *          1）j=0：最后是下降的，例如：1 5 2
     *          2）j=1 ：最后是上升的，例如：5 1 3
     * 状态转移：
     *      1.当nums[i]比前一个数要大时
     *          1）摆动序列最后是上升的，最大长度为：
     *              前一个摆动序列最后是上升的长度 或者 前一个摆动序列最后是下降的长度+1
     *              即：dp[i][1]=max(dp[i-1][1],dp[i-1][0]+1)
     *          2）摆动序列最后是下降的，最大长度为：
     *              只能和前一个的状态一致，因为该数字不可能构成下降的
     *              即：dp[i][0]=dp[i-1][0]
     *
     *      2.当nums[i]比前一个数要小时
     *          1）摆动序列最后是下降的，最大长度为：
     *              前一个摆动序列最后是下降的长度 或者 前一个摆动序列最后是上升的长度+1
     *              即：dp[i][0]=max(dp[i - 1][0], dp[i - 1][1] + 1)
     *          2）摆动序列最后是上升的，最大长度为：
     *              只能和前一个的状态一致，因为该数字不可能构成上升的
     *              即：dp[i][1]=dp[i-1][1]
     * 初始化：
     *      第一个元素作为摆动序列，长度为1
     *          dp[0][0]=1
     *          dp[0][1]=1
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + 1);
                dp[i][0] = dp[i - 1][0];
            } else if (nums[i] < nums[i - 1]) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + 1);
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][1] = dp[i - 1][1];
                dp[i][0] = dp[i - 1][0];
            }
        }


        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    /**
     * 解法2动态规划 空间优化 时间(N) 空间O(1)
     */
    public int wiggleMaxLength2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int up = 1, down = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = Math.max(up, down + 1);
                //down=down
            } else if (nums[i] < nums[i - 1]) {
                down = Math.max(down, up + 1);
                //up=up
            } else {
                //up=up
                //down=down
            }
        }

        return Math.max(up, down);
    }


    public static void main(String[] args) {
        _376摆动序列 instance = new _376摆动序列();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums1 = {1, 7, 4, 9, 2, 5};
        int[] nums2 = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(instance.wiggleMaxLength2(nums));
        System.out.println(instance.wiggleMaxLength2(nums1));
        System.out.println(instance.wiggleMaxLength2(nums2));
    }


}
