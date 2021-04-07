package _每日一题._2021年._21年4月;

/**
 * @ClassName: _81搜索旋转排序数组2
 * @Author: lerry_li
 * @CreateDate: 2021/04/07
 * @Description
 */
public class _81搜索旋转排序数组2 {
    /**
     * 解法1：二分搜索(递归) 时间O(logN) 空间O(1)
     * 思路：
     * 每次二分，判断左/右是否有序；
     * target在有序部分则继续二分搜索，否则在无序部分重复上述操作
     * 若左右都是有序的，则两边同时重复上述操作
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public boolean binarySearch(int[] nums, int target, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            //判断哪部分有序
            //若左部分有序，则查看target在左吗
            if (nums[left] <= nums[mid] && nums[mid] > nums[right]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    return binarySearch(nums, target, left, mid);
                } else {
                    return binarySearch(nums, target, mid + 1, right);
                }
            }
            //若右部分有序，则查看target在右吗
            else if (nums[mid] <= nums[right] && nums[left] > nums[mid]) {
                if (target >= nums[mid] && target <= nums[right]) {
                    return binarySearch(nums, target, mid, right);
                } else {
                    return binarySearch(nums, target, left, mid - 1);
                }
            }
            //否则，两边都检查
            else {
                return binarySearch(nums, target, left, mid) || binarySearch(nums, target, mid + 1, right);
            }
        }
        return nums[left] == target;
    }

    /**
     * 解法2：二分 时间O(logN) 空间O(1)
     */
    public boolean search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return true;
            //若left和right想等，则left右移
            if (nums[left] == nums[right]) {
                left++;
                continue;
            }
            if (nums[left] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target;
    }

    public static void main(String[] args) {
        _81搜索旋转排序数组2 instance = new _81搜索旋转排序数组2();
        System.out.println(instance.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(instance.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(instance.search(new int[]{1, 0, 1, 1, 1}, 0));
    }
}
