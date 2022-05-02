package _每日一题._2022年._5月1日;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/01
 */
public class _剑指Offer51_数组中的逆序对 {
    /**
     * 解法1：利用归并排序 时间O(NlogN) 空间O(N)
     * 思路：
     *      归并排序每一阶段得到左右两个有序数组left[]和right[]，然后进行合并
     *      合并时，如果left数组第i个元素小于right数组第j个元素，那么直接正常进行合并；
     *      否则，可以进行逆序对的计算：
     *          假设left[i]>right[j]，那么left[i+1,...,mid]这mid-i+1个元素都满足>right[j]，因此统计时直接加上
     */
    class Solution {
        public int reversePairs(int[] nums) {
            //特判
            if (nums == null || nums.length < 2) {
                return 0;
            }
            res = 0;
            func(nums, 0, nums.length-1);
            return res;
        }

        int res;

        private void func(int[] nums, int l, int r) {
            if (l == r) return;
            int mid = l + (r - l) / 2;
            func(nums, l, mid);
            func(nums, mid + 1, r);
            //得到两个有序数组
            int[] tempArr = new int[r - l + 1];
            int idx = 0;
            int i = l, j = mid+1;
            while (i <= mid && j <= r) {
                if (nums[i] <= nums[j]) {
                    tempArr[idx] = nums[i];
                    i++;
                } else {
                    tempArr[idx] = nums[j];
                    res += mid - i + 1;
                    j++;
                }
                idx++;
            }
            while (i <= mid) tempArr[idx++] = nums[i++];
            while (j <= r) tempArr[idx++] = nums[j++];
            //拷贝回原数组
            idx = 0;
            i = l;
            while (idx < r - l + 1) {
                nums[i++] = tempArr[idx++];
            }
        }
    }
}
