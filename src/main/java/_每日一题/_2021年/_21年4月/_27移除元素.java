package _每日一题._2021年._21年4月;

/**
 * @ClassName: _27移除元素
 * @Author: lerry_li
 * @CreateDate: 2021/04/19
 * @Description
 * 解法1：双指针
 */
public class _27移除元素 {

    public static void main(String[] args) {
        _27移除元素 instance=new _27移除元素();
        System.out.println(instance.removeElement(new int[]{3,2,2,3},3));//2
        System.out.println(instance.removeElement(new int[]{0,1,2,2,3,0,4,2},2));//5
    }

    /**
     * 解法1：双指针 时间O(N) 空间O(1)
     * 思路：
     *      left表示已处理的长度(下标)，right表示已遍历的长度(下标)
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
