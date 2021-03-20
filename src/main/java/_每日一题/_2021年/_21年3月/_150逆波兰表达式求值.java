package _每日一题._2021年._21年3月;

import java.util.Stack;

/**
 * @ClassName: _150逆波兰表达式求值
 * @Author: lerry_li
 * @CreateDate: 2021/03/20
 * @Description
 */
public class _150逆波兰表达式求值 {
    /**
     * 解法1：用栈 时间O(N) 空间O(N)
     */
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String em : tokens) {
            switch (em) {
                case "+": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                    break;
                }
                case "-": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                }
                case "*": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a * b);
                    break;
                }
                case "/": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                    break;
                }
                default: {
                    stack.push(Integer.parseInt(em));
                }
            }
        }
        return stack.peek();
    }
}
