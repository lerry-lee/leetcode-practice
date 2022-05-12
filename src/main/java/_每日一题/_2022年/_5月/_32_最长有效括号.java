package _每日一题._2022年._5月;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/12
 * @Description
 */
public class _32_最长有效括号 {
    /**
     * 解法1：用栈存最后一个没有被匹配到的下标 时间O(N) 空间O(N)
     */
    class Solution {
        public int longestValidParentheses(String s) {
            //特判
            if (s == null || s.length() == 0) return 0;
            //"()(()"
            Deque<Integer> stack = new ArrayDeque<>();
            //放一个前置下标-1进去
            stack.addLast(-1);
            int maxLen = 0;
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                //如果是(，肯定是不能匹配的，下标入栈
                if (arr[i] == '(') {
                    stack.addLast(i);
                }
                //如果是)，考虑匹配
                else {
                    //弹出栈顶元素，如果是（，那么可以理解为匹配
                    //如果是），弹出也不影响，因为栈马上就为空了。
                    stack.pollLast();
                    if (stack.isEmpty()) {
                        stack.addLast(i);
                    }
                    //如果弹出后，栈不为空，说明）和(匹配了，那么更新这段匹配的长度
                    //此时栈顶元素是上一个不匹配的下标
                    else {
                        maxLen = Math.max(maxLen, i - stack.peekLast());
                    }
                }
            }
            return maxLen;
        }
    }

    /**
     * 解法2：时间O(N) 空间O(1)
     */
    class Solution2 {
        public int longestValidParentheses(String s) {
            //特判
            if (s == null || s.length() == 0) return 0;
            int left = 0, right = 0;
            int res = 0;
            char[] arr=s.toCharArray();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    res = Math.max(res, left + right);
                } else if (right > left) {
                    left = 0;
                    right = 0;
                }
            }
            left = 0;
            right = 0;
            //防止（（（）这种情况，左括号比右括号多
            for(int i=arr.length-1;i>=0;i--){
                if (arr[i] == ')') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    res = Math.max(res, left + right);
                } else if (right > left) {
                    left = 0;
                    right = 0;
                }
            }
            return res;
        }
    }
}
