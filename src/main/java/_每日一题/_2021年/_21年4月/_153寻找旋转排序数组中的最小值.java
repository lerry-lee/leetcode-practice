package _每日一题._2021年._21年4月;

/**
 * @ClassName: _153寻找旋转排序数组中的最小值
 * @Author: lerry_li
 * @CreateDate: 2021/04/08
 * @Description
 */
public class _153寻找旋转排序数组中的最小值 {
    /**
     * 解法1：二分搜索（递归）最坏时间O(N) 空间O(1)
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        return binarySearch(nums, left, right);
    }

    public int binarySearch(int[] nums, int left, int right) {
        if (left < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            return Math.min(binarySearch(nums, left, mid), binarySearch(nums, mid + 1, right));
        }
        return nums[left];
    }

    /**
     * 解法2：二分搜索 时间O(logN) 空间O(1)
     * 思路：若区间内元素不是升序的，则最小值出现在无序的部分
     * 注意：判断mid和right，而不是判断left和mid(因为当只剩2个元素时，left和mid相同)
     */
    public int findMin2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            //若区间为升序，则返回最左侧元素
            if (nums[left] < nums[right]) {
                break;
            }
            //否则进行二分搜索
            int mid = left + (right - left) / 2;
            //若右则无序，则缩小区间到右侧部分
            if (nums[right] < nums[mid]) {
                left = mid + 1;
            }
            //否则左侧无序，则缩小区间到左侧部分
            else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        _153寻找旋转排序数组中的最小值 instance = new _153寻找旋转排序数组中的最小值();
        System.out.println(instance.findMin2(new int[]{3, 4, 5, 1, 2}));//1
        System.out.println(instance.findMin2(new int[]{4, 5, 6, 7, 0, 1, 2}));//0
        System.out.println(instance.findMin2(new int[]{11, 13, 15, 17}));//11
        System.out.println(instance.findMin2(new int[]{5, 1, 2, 3, 4}));//1
    }
}
