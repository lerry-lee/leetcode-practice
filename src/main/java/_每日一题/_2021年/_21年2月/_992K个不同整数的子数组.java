package _每日一题._2021年._21年2月;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _992K个不同整数的子数组
 * @Author: lerry_li
 * @CreateTime: 2021/02/09
 * @Description
 */
public class _992K个不同整数的子数组 {
    /**
     * 解法1：双指针+哈希集合（超时） 时间O(N^2) 空间O(N)
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        if (A == null || A.length == 0 || K < 1) {
            return 0;
        }
        int len = A.length;
        //[left,right]左闭右闭区间
        int left = 0, right = 0;
        Set<Integer> hashSet = new HashSet<>();
        int count = 0;
        while (right < len) {
            if (hashSet.size() < K) {
                hashSet.add(A[right]);
                if (hashSet.size() == K) {
                    count++;
                }
                right++;
            } else {
                if (hashSet.contains(A[right])) {
                    count++;
                    right++;
                } else {
                    hashSet.clear();
                    left++;
                    right = left;
                }
            }

            if (right == len && left <= len - K) {
                hashSet.clear();
                left++;
                right = left;
            }
        }
        return count;
    }

    /**
     * 解法2：「最多存在K个不同整数的子区间的个数」-「最多存在K−1个不同整数的子区间的个数」 时间O(N) 空间O(N)
     */
    public int subarraysWithKDistinct2(int[] A, int K) {
        return mostK(A, K) - mostK(A, K - 1);
    }

    public int mostK(int[] A, int K) {
        int len = A.length;
        int[] freq = new int[len+1];
        //双指针，滑动窗口
        int left = 0, right = 0;
        //滑动窗口中的不同元素的个数
        int count = 0;
        int res = 0;

        while (right < len) {
            //原来没有该元素，计数器才+1
            if (freq[A[right]] == 0) {
                count++;
            }
            //右窗口移动，计数数组+1
            freq[A[right]]++;
            right++;
            //若滑动窗口中的元素个数超过K个，则左窗口需要左移，但可能需要左移多次，因此使用while
            while (count > K) {
                //左窗口移动，计数数组-1
                freq[A[left]]--;
                //若计数数组某元素为0了，则窗口中不含有该元素了，计数器-1
                if (freq[A[left]] == 0) {
                    count--;
                }
                left++;
            }
            //从左窗口到右窗口一共多少个子数组
            res += right - left;
        }
        return res;
    }

    public static void main(String[] args) {
        _992K个不同整数的子数组 instance = new _992K个不同整数的子数组();
        int[] A = {1, 2, 1, 2, 3};
        System.out.println(instance.subarraysWithKDistinct2(A, 2));
        int[] A1 = {1, 2, 1, 3, 4};
        System.out.println(instance.subarraysWithKDistinct2(A1, 3));
        int[] A2 = {2, 1, 2, 1, 2};
        System.out.println(instance.subarraysWithKDistinct2(A2, 2));
    }
}
