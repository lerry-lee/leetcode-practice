package _每日一题._2022年._5月3日;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/03
 * @Description
 */
public class _300_最长递增子序列 {

    public static void main(String[] args) {
        _300_最长递增子序列 instance = new _300_最长递增子序列();
        instance.new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }

    /**
     * 解法1：单调序列+二分搜索 时间O(NlogN) 空间O(N)
     */
    class Solution {
        public int lengthOfLIS(int[] nums) {
            //特判
            if (nums == null || nums.length == 0) return 0;
            //单调递增序列
            int[] seq = new int[nums.length];
            int end = -1;
            //记录最长子序列长度
            int res = 0;
            //遍历数组
            for (int num : nums) {
                if (end == -1) {
                    end++;
                    seq[end] = num;
                } else {
                    int newEnd = getIdxFirstBigThanWithBinarySearch(seq, 0, end, num);
                    seq[newEnd] = num;
                    end = Math.max(end, newEnd);
                }
                res = Math.max(res, end + 1);
            }
            return res;
        }

        private int getIdxFirstBigThanWithBinarySearch(int[] nums, int l, int r, int target) {
            if(nums[r]<target) return r+1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid]<target) {
                    l = mid+1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
}
