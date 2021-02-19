package _每日一题._2021年._21年2月;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: _1004最大连续1的个数3
 * @Author: lerry_li
 * @CreateTime: 2021/02/19
 * @Description
 */
public class _1004最大连续1的个数3 {
    /**
     * 解法1：滑动窗口 时间O(N) 空间O(1)
     * 思路：
     *      维护一个滑动窗口，确保里面的元素0的个数不超过K
     */
    public int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        //K超过数组长度则无意义
        K = Math.min(K, len);
        //滑动窗口内元素0的个数
        int count0 = 0;
        //滑动窗口左右边界，[left,right)，左闭右开区间
        int left = 0, right = 0;
        //满足条件的滑动窗口的最大值
        int maxWin = 0;

        while (right < len) {
            //若0的个数小于K，则right右移一位
            if (count0 < K) {
                //窗口右边界新增加的元素判断
                if (A[right] == 0) {
                    count0++;
                }
                right++;
            }
            //若0的个数等于K，则判断新增加的一位是0还是1
            else if (count0 == K) {
                //若为0，则滑动窗口left右移一位
                if (A[right] == 0) {
                    if (A[left] == 0) {
                        count0--;
                    }
                    left++;
                    right++;
                    count0++;
                }
                //若为1，则right右移一位
                else {
                    right++;
                }
            }
            //若0个个数大于K，则left右移
            else {
                if (A[left] == 0) {
                    count0--;
                }
                left++;
            }
            maxWin = Math.max(maxWin, right - left);
        }
        return maxWin;
    }

    /**
     * 解法2：双端队列维护滑动窗口 时间O(N) 空间O(N)
     */
    public int longestOnes2(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        //K超过数组长度则无意义
        K = Math.min(K, len);
        //滑动窗口内元素0的个数
        int count0 = 0;
        Deque<Integer> deque = new LinkedList<>();
        //res
        int res = 0;
        for (int i = 0; i < len; i++) {
            deque.offerLast(A[i]);
            if (count0 < K) {
                if (A[i] == 0) {
                    count0++;
                }
            } else if (count0 == K) {
                if (A[i] == 0) {
                    count0++;
                    while (!deque.isEmpty() && count0 > K) {
                        if (deque.pollFirst() == 0) {
                            count0--;
                        }
                    }
                }
            }
            res = Math.max(res, deque.size());
        }
        return res;
    }

    public static void main(String[] args) {
        _1004最大连续1的个数3 instance = new _1004最大连续1的个数3();
        int[] A1 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int[] A2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int[] A3={0,0,1,1,1,0,0};
        System.out.println(instance.longestOnes2(A1, 2));
        System.out.println(instance.longestOnes2(A2, 3));
        System.out.println(instance.longestOnes2(A3, 0));
    }
}
