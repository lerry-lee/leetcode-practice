package _字节推荐._动态或贪心;

import java.util.Arrays;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/01 10:43
 * @description 最长递增子序列
 * 动态规划解决此问题
 */
public class _最长递增子序列 {

    public static void main(String[] args) {
        _最长递增子序列 instance=new _最长递增子序列();
        System.out.println(Arrays.toString(instance.lengthOfLIS2(new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7})));
    }

    /**
     * 解法1：贪心+二分查找 时间O(NLogN) 空间O(N)
     */
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
        //此时dp[mid]>tar，区间缩至[l,mid]
        if (dp[mid] > tar) bSearch(dp, i, mid, tar);
            //此时dp[mid]<tar，区间缩至[mid+1,r]
        else if (dp[mid] < tar) bSearch(dp, mid + 1, j, tar);
    }

    /**
     * 题目变体：假设题目要求返回最长子序列
     */
    public int[] lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int[] dp_len = new int[n];
        dp_len[0] = 1;
        int length = 1;
        for (int i = 1; i < n; i++) {
            if (dp[length - 1] < nums[i]) {
                dp[length++] = nums[i];
                dp_len[i] = length;//?
            } else {
                dp_len[i] = 1 + bSearch2(dp, 0, length-1, nums[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(dp_len));
        int[] res = new int[length];
        for (int i = n - 1; i >= 0; i--) {
            if (dp_len[i] == length) {
                res[--length] = nums[i];
            }
        }
        return res;
    }

    private int bSearch2(int[] dp, int l, int r, int tar) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (dp[mid] >= tar) r = mid;
            else l = mid + 1;
        }
        dp[l] = tar;
        return l;
    }
}
