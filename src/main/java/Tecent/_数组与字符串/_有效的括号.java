package Tecent._数组与字符串;

import java.util.Stack;

/**
 * @ClassName : _有效的括号
 * @CreateTime : 2020/09/18 15
 * @Author : lerry_li
 * @Descrpition : 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class _有效的括号 {
    /**
     * 解法1：用栈存储左括号，遇到右括号，栈顶元素出栈，如匹配则继续，不匹配则返回false。最终栈为空则返回true，否则返回false
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') stack.push(c);
            else {
                if (!stack.isEmpty()) {
                    char c1 = stack.pop();
                    if ((c == '}' && c1 == '{') || (c == ']' && c1 == '[') || (c == ')' && c1 == '(')) continue;
                    else return false;
                } else return false;
            }
        }
        return stack.isEmpty();
    }
}
