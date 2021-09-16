package _每日一题._2021年._21年9月;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/15
 */
public class _162_寻找峰值 {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        return bSearch(nums, 0, nums.length - 1);
    }

    /**
     * 解法1：二分 时间O(logN) 空间O(N)
     * 思路：
     *      由于nums[]左右边界都是负无穷大，因此只要沿着上坡走，一定能找到峰值
     */
    private int bSearch(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
