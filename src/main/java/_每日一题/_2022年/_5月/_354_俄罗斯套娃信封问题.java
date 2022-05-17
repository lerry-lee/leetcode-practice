package _每日一题._2022年._5月;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/17
 */
public class _354_俄罗斯套娃信封问题 {
    /**
     * 解法1：自定义排序+最长递增子序列 时间O(NlogN) 空间O(N)
     * Solution 1: Custom sorting + longest increasing subsequence
     */
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            // 特判check null
            if (envelopes == null || envelopes.length == 0) return 0;
            // 按宽度升序排序sort by width in ascending order
            // 如果宽度相同，按高度降序排序 if the width is the same, by height descending
            Arrays.sort(envelopes, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o2[1], o1[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            });
            // 现在得到一个宽度有序的二维数组now get a 2D array with width sorted
            // 接下来针对长度这一维，求最长的递增子序列
            // Next, for the height dimension, find the longest increasing subsequence
            List<Integer> increasingSeq = new ArrayList<>();
            for (int[] envelope : envelopes) {
                // 当前高度 cur height
                int curHeight = envelope[1];
                // 在单调递增序列中，找到第一个比它大于等于的下标，如果没有，返回-1
                // In a monotonically increasing sequence, find the first subscript greater than it, if not, return -1
                int index = binarySearchIndex(increasingSeq, curHeight);
                // 如果下标为-1，说明当前元素大于序列中的最大元素，直接后面插入
                // If the subscript is -1, it means that the current element is greater than the largest element in the sequence, and it is inserted directly after
                if (index == -1) increasingSeq.add(curHeight);
                    // 否则，替换掉第一个比它大的 Otherwise, replace the first larger than
                else increasingSeq.set(index, curHeight);
            }
            return increasingSeq.size();
        }

        private int binarySearchIndex(List<Integer> increasingSeq, int target) {
            if (increasingSeq.size() == 0) return -1;
            int l = 0, r = increasingSeq.size() - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (target > increasingSeq.get(mid)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (increasingSeq.get(l) >= target) return l;
            return -1;
        }
    }

    /**
     * 解法2：数组代替list
     */
    class Solution2 {
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes == null || envelopes.length == 0) {
                return 0;
            }
            //1.对第0列递增排序
            Arrays.sort(envelopes, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o2[1], o1[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            });
            int len = envelopes.length;
            //2.然后对第1列求最长递增子序列
            int[] increasingArray = new int[len];
            increasingArray[0] = envelopes[0][1];
            int res = 1;
            for (int i = 1; i < len; i++) {
                int target = envelopes[i][1];
                if (target > increasingArray[res - 1]) {
                    increasingArray[res] = target;
                    res++;
                } else {
                    //二分查找，找到刚好比它大的
                    int idx=binarySearch(increasingArray,0,res-1,target);
                    increasingArray[idx]=target;
                }
            }
            return res;
        }

        public int binarySearch(int[] array, int start, int end, int target) {
            int i = start, j = end;
            while (i < j) {
                int mid = i + (j - i) / 2;
                if (array[mid] < target) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            return i;
        }
    }
}
