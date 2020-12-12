package _字节推荐._动态或贪心;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/01 10:43
 * @description 最长递增子序列
 * 动态规划解决此问题
 */
public class _最长递增子序列 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (dp[res - 1] < nums[i]) {
                dp[res++] = nums[i];
            } else bSearch(dp, 0, res, nums[i]);
        }
        return res;
    }

    //二分查找要找到比target刚好大于等于的第一个数，因此更新右边界的时候,r=mid而不是r=mid-1
    public void bSearch(int[] dp, int i, int j, int tar) {
        if (i == j) {
            dp[i] = tar;
        }
        int mid = (i + j) / 2;
        if (dp[mid] > tar) bSearch(dp, i, mid, tar);
        else if (dp[mid] < tar) bSearch(dp, mid + 1, j, tar);
    }
}
