package _每日一题._2022年._5月3日;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/03
 * @Description
 */
public class _162_寻找峰值 {
    /**
     * 解法1：二分搜索 时间O(logN) 空间O(1)
     */
    class Solution {
        public int findPeakElement(int[] nums) {
            //特判
            if (nums.length == 1) return 0;
            //二分
            int l = 0, r = nums.length - 1;
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
}
