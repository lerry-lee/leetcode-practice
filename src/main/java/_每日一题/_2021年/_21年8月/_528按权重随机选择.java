package _每日一题._2021年._21年8月;

import java.util.Arrays;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/08/31
 */
public class _528按权重随机选择 {
    /**
     * 解法1：前缀和+二分
     */
    class Solution {
        //前缀和数组
        int[] prefixSum;
        //权重数组元素综合
        int totalW;

        public Solution(int[] w) {
            prefixSum = new int[w.length];
            prefixSum[0] = w[0];
            for (int i = 1; i < w.length; ++i) {
                prefixSum[i] = prefixSum[i - 1] + w[i];
            }
            totalW = Arrays.stream(w).sum();
        }

        public int pickIndex() {
            //取随机值
            int x = (int) (Math.random() * totalW) + 1;
            //二分查找该随机值对应的下标
            return binarySearch(x);
        }

        /**
         * 二分查找比x刚好大的元素的下标
         */
        private int binarySearch(int x) {
            int low = 0, high = prefixSum.length - 1;
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (prefixSum[mid] < x) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
}
