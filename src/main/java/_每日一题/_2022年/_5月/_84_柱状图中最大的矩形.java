package _每日一题._2022年._5月;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/05
 * @Description
 */
public class _84_柱状图中最大的矩形 {
    /**
     * 解法1：暴力
     * 解法2：单调栈
     */
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int len = heights.length;
            if (len == 0) {
                return 0;
            }
            if (len == 1) {
                return heights[0];
            }

            int res = 0;
            // 单调栈：单调递增
            Deque<Integer> stack = new ArrayDeque<>(len);
            for (int i = 0; i < len; i++) {
                // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
                while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                    int curHeight = heights[stack.pollLast()];
                    while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                        stack.pollLast();
                    }

                    int curWidth;
                    if (stack.isEmpty()) {
                        curWidth = i;
                    } else {
                        curWidth = i - stack.peekLast() - 1;
                    }

                    // System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
                    res = Math.max(res, curHeight * curWidth);
                }
                stack.addLast(i);
            }

            while (!stack.isEmpty()) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }
                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = len;
                } else {
                    curWidth = len - stack.peekLast() - 1;
                }
                res = Math.max(res, curHeight * curWidth);
            }
            return res;
        }
    }
}
