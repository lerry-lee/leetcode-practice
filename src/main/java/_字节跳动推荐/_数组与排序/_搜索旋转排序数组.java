package _字节跳动推荐._数组与排序;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * tips：O(log n) 暗示要用二分法
 * 示例1：
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例2：
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class _搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target && nums[l] <= target) {
                r = mid;
            } else if (nums[mid + 1] <= target && nums[r] >= target) {
                l = mid + 1;
            } else if (nums[l] > nums[mid]) {
                if (nums[mid + 1] >= target && nums[r] <= target) l = mid + 1;
                else r = mid;
            } else if (nums[mid + 1] > nums[r]) {
                if (nums[l] <= target && nums[mid] >= target) r = mid;
                else l = mid + 1;
            } else break;
        }
        if (nums[l] == target) return l;
        return -1;
    }

    //思路清晰，二分查找，每次先判断是左半部分有序/右半部分有序，然后判断target是否在有序部分中，在则进入有序部分，不在则进入另半部分
    public int search2(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;
        display(nums,0,nums.length-1);
        int L = 0, R = nums.length - 1;
        while (L < R) {
            int mid = (L + R) / 2;
            System.out.print("mid:"+nums[mid]+"\t");
            display(nums,L,R);
            if (target == nums[mid]) return mid;
            if (nums[L] <= nums[mid]) {
                if (target >= nums[L] && target < nums[mid]) {
                    R = mid - 1;
                } else L = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[R]) {
                    L = mid + 1;
                } else R = mid - 1;
            }
        }
//        display(nums,L,R);
        return nums[L] == target ? L : -1;
    }

    public void display(int[] nums,int s,int e) {
        for (int i=s;i<=e;i++) System.out.print(nums[i] + " ");
        System.out.println();
    }
}
