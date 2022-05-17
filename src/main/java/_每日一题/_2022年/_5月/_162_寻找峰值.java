package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/17
 */
public class _162_寻找峰值 {
    /**
     * 解法1：二分
     * 思路：
     *      如果nums[mid]>nums[mid+1]，那么mid可能是峰值，mid+1比不可能是，因此缩小区间为[l,mid]
     *      否则nums[mid]<nums[mid+1]，那么mid必不可能是，因此区间缩小为[mid+1,r]
     */
    class Solution {
        public int findPeakElement(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }
}
