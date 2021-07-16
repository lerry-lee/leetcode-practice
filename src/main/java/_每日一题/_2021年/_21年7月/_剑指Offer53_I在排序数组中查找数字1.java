package _每日一题._2021年._21年7月;

/**
 * @ClassName: _剑指Offer53_I在排序数组中查找数字1
 * @Author: lerry_li
 * @CreateDate: 2021/07/16
 * @Description
 */
public class _剑指Offer53_I在排序数组中查找数字1 {

    public static void main(String[] args) {
        _剑指Offer53_I在排序数组中查找数字1 instance = new _剑指Offer53_I在排序数组中查找数字1();
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int[] nums2 = {1};
        int[] nums3 = {2, 2};
        System.out.println(instance.search2(nums1, 8));//2
        System.out.println(instance.search2(nums1, 6));//0
        System.out.println(instance.search2(nums2, 1));//1
        System.out.println(instance.search2(nums3, 2));//2
    }

    /**
     * 解法1：二分+中心扩散 时间O(NlogN~N) 空间O(1)
     */
    public int search(int[] nums, int target) {
        //特判
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        int l = 0, r = nums.length - 1;
        int mid = bSearch(nums, l, r, target);
        if (mid == -1) return 0;
        count = 1;
        for (int i = mid + 1; i < nums.length; i++) {
            if (nums[i] == target) count++;
            else break;
        }
        for (int i = mid - 1; i >= 0; i--) {
            if (nums[i] == target) count++;
            else break;
        }
        return count;
    }

    /**
     * 解法2：二分 时间O(NlogN) 空间O(1)
     * 思路：
     *      找到第一个和最后一个，然后返回下标差
     */
    public int search2(int[] nums, int target) {
        //特判
        if (nums == null || nums.length == 0) return 0;
        //1.找第一个等于target的元素
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        //若无，则返回0
        if (nums[l] != target) return 0;
        int left = l;
        l = 0;
        r = nums.length - 1;
        //2.找第一个大于target的元素
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        //判断
        if (nums[l] > target) return l - left;
        else return l - left + 1;
    }

    private int bSearch(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        if (nums[l] == target) return l;
        return -1;
    }
}
