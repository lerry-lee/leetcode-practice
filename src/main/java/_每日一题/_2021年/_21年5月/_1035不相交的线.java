package _每日一题._2021年._21年5月;

import java.util.HashMap;

/**
 * @ClassName: _1035不相交的线
 * @Author: lerry_li
 * @CreateDate: 2021/05/21
 * @Description
 * 解法1：动态规划（最长公共子序列）
 * 解法2：递归+备忘录
 */
public class _1035不相交的线 {

    public static void main(String[] args) {
        _1035不相交的线 instance = new _1035不相交的线();
        System.out.println(instance.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));//2
        System.out.println(instance.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));//3
        System.out.println(instance.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));//2
    }

    /**
     * 解法1：动态规划（最长公共子序列） 时间(MN) 空间O(MN)
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return 0;
        int n1 = nums1.length, n2 = nums2.length;
        //dp[i][j]表示nums1[0-i]和nums2[0-j]的最长公共子序列的长度
        int[][] dp = new int[n1 + 1][n2 + 1];
        //初始化0行0列均为0
        //...
        //状态转移
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    /**
     * 解法2：递归+备忘录
     */
    public int maxUncrossedLines2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return 0;
        int m = nums1.length, n = nums2.length;
        //递归
        return dp(nums1, nums2, m - 1, n - 1);
    }

    HashMap<Integer, HashMap<Integer, Integer>> memo = new HashMap<>();

    private int dp(int[] nums1, int[] nums2, int n1, int n2) {
        //basecase
        if (n1 < 0 || n2 < 0) return 0;
        //查备忘录
        if (memo.containsKey(n1) && memo.get(n1).containsKey(n2)) return memo.get(n1).get(n2);
        int res;
        if (nums1[n1] == nums2[n2]) {
            res = dp(nums1, nums2, n1 - 1, n2 - 1) + 1;
        } else res = Math.max(dp(nums1, nums2, n1 - 1, n2), dp(nums1, nums2, n1, n2 - 1));
        //加入备忘录
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(n2, res);
        memo.put(n1, hashMap);
        return res;
    }
}
