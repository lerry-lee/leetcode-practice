package _每日一题._2022年._5月3日;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/03
 * @Description
 */
public class _287_寻找重复数 {
    /**
     * 解法3：快慢指针（类比环形链表找入口节点）https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode-solution/
     */
    /**
     * 解法1：计数置换
     * 思路：
     *      每个下标i的数字为i，遇到重复的停止，否则，最后下标0处为重复数字
     */
    class Solution {
        public int findDuplicate(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i) {
                    if (nums[nums[i]] == nums[i]) return nums[i];
                    swap(nums, nums[i], i);
                }
            }
            return nums[0];
        }

        private void swap(int[] nums, int i, int j) {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
    /**
     * 解法2：二分查找
     * 思路：
     *      数组范围在[1,n]，每次取中间那个数mid，然后统计数组[]中小于mid的数有几个，假设为cnt;
     *      如果cnt>mid了，说明重复数字在左半部分(数字不重复的话，左半部分最多有1~mid个元素)，否则在右半部分，进而继续缩小空间搜索
     */
    public class Solution2 {

        public int findDuplicate(int[] nums) {
            int len = nums.length;//len=n+1
            int left = 1;
            int right = len - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;

                int cnt = 0;
                for (int num : nums) {
                    if (num <= mid) {
                        cnt += 1;
                    }
                }

                // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个，此时重复元素一定出现在 [1..4] 区间里
                if (cnt > mid) {
                    // 重复元素位于区间 [left..mid]
                    right = mid;
                } else {
                    // if 分析正确了以后，else 搜索的区间就是 if 的反面区间 [mid + 1..right]
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
