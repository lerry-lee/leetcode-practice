package _腾讯推荐._数组与字符串;

/**
 * Created by lerry_li on 2020/09/26
 */

/**
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class _合并两个有序数组 {
    /**
     * 解法1：双指针从前往后 时间复杂度大概O(m^2)级别
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int total = m;
        while (i < total && j < n) {
            if (nums1[i] <= nums2[j]) {
                i++;
            } else {
                insertToNums(nums1, i, total - 1, nums2[j]);
                total++;
                i++;
                j++;
            }

        }
        while (j < n) {
            nums1[i] = nums2[j];
            i++;
            j++;
        }
//        if(j<n){
//            for(int t=i;t<m+n;t++) nums1[t]=nums2[j++];
//        }
    }

    public void insertToNums(int[] nums, int idx, int end, int num) {
        for (int i = end; i >= idx; i--) {
            nums[i + 1] = nums[i];
        }
        nums[idx] = num;
    }

    /**
     * 解法2：双指针从后往前，时间复杂度O(m+n)
     */
    public void merge_improved(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int t = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[t] = nums2[j];
                j--;
            } else {
                nums1[t] = nums1[i];
                i--;
            }
            t--;
        }
        while (j >= 0) {
            nums1[t] = nums2[j];
            t--;
            j--;
        }
    }
}
