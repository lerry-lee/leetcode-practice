package _每日一题._2020年._20年11月;

import java.util.Stack;

/**
 * @ClassName: _1221分割平衡字符串
 * @Signature: Created by lerry_li on 2020/11/19
 * @Description:
 */
public class _1221分割平衡字符串 {
    /**
     * 解法1：用栈 时间O(N) 空间O(N)
     * 算法：初始化结果为res=0，遍历字符串s，设当前字符为c
     * 1.若栈为空，push(c)
     * 2.若栈不为空，
     * 1）若c和栈顶元素相同,push(c)
     * 2）若c和栈顶元素不同,pop()
     * 3.每遍历一个字符，检查栈是否为空，为空则res++
     * 返回res
     */
    public int balancedStringSplit(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                if (c == stack.peek()) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
            if (stack.isEmpty()) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _1221分割平衡字符串 instance = new _1221分割平衡字符串();
        System.out.println(instance.balancedStringSplit("LLLLRRRR"));
    }
}
