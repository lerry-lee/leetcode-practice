package _每日一题._2022年._5月2日;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/02
 * @Description
 */
public class _321_拼接最大数 {
    /**
     * 解法1：单调栈
     * 思路：
     *      已知解法：给定一个数组，求解移除k个数字后的最大数
     *      该题目是给定2个数组，移除k个数字，求最大数，可以转化为：
     *          数组1移除k1个数字的最大数 和 数组2移除k2个数字的最大数 融合的结果，其中k1+k2=k
     *          因此，只需要枚举所有的k1和k2即可
     */
    class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int m = nums1.length, n = nums2.length;
            int[] maxSubsequence = new int[k];
            int start = Math.max(0, k - n), end = Math.min(k, m);
            for (int i = start; i <= end; i++) {
                int[] subsequence1 = maxSubsequence(nums1, i);
                int[] subsequence2 = maxSubsequence(nums2, k - i);
                int[] curMaxSubsequence = merge(subsequence1, subsequence2);
                if (compare(curMaxSubsequence, 0, maxSubsequence, 0) > 0) {
                    System.arraycopy(curMaxSubsequence, 0, maxSubsequence, 0, k);
                }
            }
            return maxSubsequence;
        }

        public int[] maxSubsequence(int[] nums, int k) {
            int length = nums.length;
            int[] stack = new int[k];
            int top = -1;
            int remain = length - k;
            for (int i = 0; i < length; i++) {
                int num = nums[i];
                while (top >= 0 && stack[top] < num && remain > 0) {
                    top--;
                    remain--;
                }
                if (top < k - 1) {
                    stack[++top] = num;
                } else {
                    remain--;
                }
            }
            return stack;
        }

        public int[] merge(int[] subsequence1, int[] subsequence2) {
            int x = subsequence1.length, y = subsequence2.length;
            if (x == 0) {
                return subsequence2;
            }
            if (y == 0) {
                return subsequence1;
            }
            int mergeLength = x + y;
            int[] merged = new int[mergeLength];
            int index1 = 0, index2 = 0;
            for (int i = 0; i < mergeLength; i++) {
                if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                    merged[i] = subsequence1[index1++];
                } else {
                    merged[i] = subsequence2[index2++];
                }
            }
            return merged;
        }

        public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
            int x = subsequence1.length, y = subsequence2.length;
            while (index1 < x && index2 < y) {
                int difference = subsequence1[index1] - subsequence2[index2];
                if (difference != 0) {
                    return difference;
                }
                index1++;
                index2++;
            }
            return (x - index1) - (y - index2);
        }
    }

}
