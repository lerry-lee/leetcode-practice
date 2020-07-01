package _字节跳动推荐._数组与排序;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/06/30 21:04
 * @description 下一个排列
 */
public class _下一个排列 {
    /**
     * 时间复杂度：O(n)O(n)，在最坏的情况下，只需要对整个数组进行两次扫描。
     * 空间复杂度：O(1)O(1)，没有使用额外的空间，原地替换足以做到。
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
