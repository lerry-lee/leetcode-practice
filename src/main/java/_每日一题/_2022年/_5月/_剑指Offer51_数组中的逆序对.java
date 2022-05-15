package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/15
 * @Description
 */
public class _剑指Offer51_数组中的逆序对 {

    public static void main(String[] args) {
        _剑指Offer51_数组中的逆序对 instance = new _剑指Offer51_数组中的逆序对();
        instance.new Solution().reversePairs(new int[]{1, 2, 1, 2, 1});//3
    }

    /**
     * 解法1：利用归并排序 时间O(NlogN) 空间O(N)
     */
    class Solution {
        int res;

        public int reversePairs(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            res = 0;
            mergeSort(nums, 0, nums.length - 1);
            return res;
        }

        private void mergeSort(int[] nums, int l, int r) {
            if (l == r) return;
            int mid = l + (r - l) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            int i = l, j = mid + 1;
            while (i <= mid && j <= r) {
                if (nums[i] > nums[j]) {
                    res += mid - i + 1;
                    j++;
                } else {
                    i++;
                }
            }
            int[] temp = new int[r - l + 1];
            i = l;
            j = mid + 1;
            int k = 0;
            for (; k < temp.length; k++) {
                if (i > mid || j > r) break;
                if (nums[i] < nums[j]) {
                    temp[k] = nums[i];
                    i++;
                } else {
                    temp[k] = nums[j];
                    j++;
                }
            }
            while (i <= mid) {
                temp[k++] = nums[i];
                i++;
            }
            while (j <= r) {
                temp[k++] = nums[j];
                j++;
            }
            for (int x = l; x <= r; x++) {
                nums[x] = temp[x - l];
            }
        }
    }
}
