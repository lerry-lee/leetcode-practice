package _每日一题._2021年._21年7月;

import java.util.Stack;

/**
 * @ClassName: _32最长有效括号
 * @Author: lerry_li
 * @CreateDate: 2021/07/21
 * @Description
 * 栈
 */
public class _32最长有效括号 {
    /**
     * 栈 时间O(N) 空间O(N)
     * 用栈模拟一遍，将所有无法匹配的括号的位置全部置1
     * 例如: "()(()"的mark为[0, 0, 1, 0, 0]
     * 再例如: ")()((())"的mark为[1, 0, 0, 1, 0, 0, 0, 0]
     * 经过这样的处理后, 此题就变成了寻找最长的连续的0的长度
     */
    public int longestValidParentheses(String s) {
        //特判
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(i);
            else {
                if (!stack.isEmpty()) {
                    int idx = stack.pop();
                    arr[i] = 0;
                    arr[idx] = 0;
                } else {
                    arr[i] = -1;
                }
            }
        }
        while(!stack.isEmpty()){
            arr[stack.pop()]=1;
        }
        int maxLen = 0, tempLen = 0;
        for (int j : arr) {
            if (j == 0) {
                tempLen++;
                maxLen = Math.max(maxLen, tempLen);
            }
            else tempLen = 0;
        }
        return maxLen;
    }

    /**
     * 解法2：贪心 时间O(N) 空间O(1)
     * 思路：
     *  遍历字符串，遇到'(' left++，遇到')' right++，
     *  当left==right时，left+right为一个有效的括号长度
     *  当right>left时，右括号多了，此时left和right都清零
     *
     * tips：这样可能会漏掉"(()"这种左括号比右括号多的情况，因此需要倒着遍历一遍
     */
    public int longestValidParentheses2(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
