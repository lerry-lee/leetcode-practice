package _腾讯推荐._排序与搜索;

/**
 * Created by lerry_li on 2020/10/20
 */

/**
 * 搜索旋转排序数组
 * 给你一个升序排列的整数数组 nums ，和一个整数 target 。
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 * <p>
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 */
public class _搜索旋转排序数组 {
    /**
     * 解法1：二分查找
     * 思路清晰，二分查找，
     * 每次先判断是左半部分有序/右半部分有序，
     * 然后判断target是否在有序部分中，
     * 在则进入有序部分，不在则进入另半部分
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) return mid;
            if (nums[l] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        if (target == nums[l]) return l;
        return -1;
    }
}
