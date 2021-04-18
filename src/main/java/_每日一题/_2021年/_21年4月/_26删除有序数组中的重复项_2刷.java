package _每日一题._2021年._21年4月;

/**
 * @ClassName: _26删除有序数组中的重复项_2刷
 * @Author: lerry_li
 * @CreateTime: 2021/04/18
 * @Description
 * 解法1：双指针 时间O(N) 空间O(1)
 */
public class _26删除有序数组中的重复项_2刷 {
    /**
     * 解法1：双指针 时间O(N) 空间O(1)
     * left表示处理到的下标，right表示遍历到的下标
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int left = 0, right = 1;
        while (right < len) {
            if (nums[right] > nums[left]) {
                nums[left + 1] = nums[right];
                left++;
            }
            right++;
        }
        return left+1;
    }

    public static void main(String[] args) {
        _26删除有序数组中的重复项_2刷 instance=new _26删除有序数组中的重复项_2刷();
        System.out.println(instance.removeDuplicates(new int[]{1,1,2}));
        System.out.println(instance.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
