package _每日一题._2021年._21年9月;

import java.util.Stack;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/10
 */
public class _1047删除字符串中的所有相邻重复项 {

    public static void main(String[] args) {
        _1047删除字符串中的所有相邻重复项 instance = new _1047删除字符串中的所有相邻重复项();
        System.out.println(instance.removeDuplicates("abbaca"));
    }

    /**
     * 解法1：用栈 时间O(N) 空间O(N)
     */
    public String removeDuplicates(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 解法2：模拟栈 时间O(N) 空间O(1)
     */
    public String removeDuplicates2(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
