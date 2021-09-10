package _每日一题._2021年._21年3月;

import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _1047删除字符串中的所有相邻重复项
 * @Author: lerry_li
 * @CreateDate: 2021/03/09
 * @Description
 */
public class _1047删除字符串中的所有相邻重复项 {
    /**
     * 解法1：用栈 时间O(N) 空间O(N)
     */
    public String removeDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }

    /**
     * 解法2：用栈 时间O(N) 空间O(1)
     */
    public String removeDuplicates2(String S) {
        StringBuilder stack = new StringBuilder();
        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }

}
