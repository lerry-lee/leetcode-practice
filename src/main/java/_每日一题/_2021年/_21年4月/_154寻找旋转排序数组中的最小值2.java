package _每日一题._2021年._21年4月;

/**
 * @ClassName: _154寻找旋转排序数组中的最小值2
 * @Author: lerry_li
 * @CreateDate: 2021/04/09
 * @Description
 */
public class _154寻找旋转排序数组中的最小值2 {
    /**
     * 解法1：二分搜索（递归） 最坏时间O(N) 空间O(1)
     */
    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            return Math.min(binarySearch(nums, left, mid), binarySearch(nums, mid + 1, right));
        }
        return nums[left];
    }

    /**
     * 解法2：二分搜索 时间O(logN) 空间O(1)
     */
    public int findMin2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == nums[right]) {
                left++;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        _154寻找旋转排序数组中的最小值2 instance = new _154寻找旋转排序数组中的最小值2();
        System.out.println(instance.findMin(new int[]{1, 3, 5}));//1
        System.out.println(instance.findMin(new int[]{2, 2, 2, 0, 1}));//0
        System.out.println(instance.findMin2(new int[]{1, 3, 5}));//1
        System.out.println(instance.findMin2(new int[]{2, 2, 2, 0, 1}));//0
        System.out.println(instance.findMin2(new int[]{2, 1, 1, 1, 1}));//1
    }
}
