package _剑指Offer;

/**
 * @ClassName: _53_2_缺失的数字
 * @Signature: Created by lerry_li on 2020/11/14
 * @Description: 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class _53_2_缺失的数字 {
    /**
     * 解法1：直接遍历
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }
}
