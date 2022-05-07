package _每日一题._2022年._befor5月;

import java.util.Stack;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/01
 */
public class _224_基本计算器 {

    public static void main(String[] args) {
        _224_基本计算器 instance = new _224_基本计算器();
        instance.calculate("(1+(4+5+2)-3)+(6+8)");
        //"(1+(4+5+2)-3)+(6+8)"
    }

    /**
     * 解法1：数值栈+操作符栈 时间O(N) 空间O(N)
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> valStack = new Stack<>();
        Stack<Character> opsStack = new Stack<>();
        valStack.push(0);//防止"-2+1"这种
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == ' ') continue;
            //如果是数字，考虑入栈，或先计算再入栈
            if (Character.isDigit(c)) {
                //计算连续的数字
                int val = c - '0';
                int j = i + 1;
                for (; j < arr.length; j++) {
                    if (!Character.isDigit(arr[j])) break;
                    val = val * 10 + (arr[j] - '0');
                }
                i = j - 1;
                //操作符栈如果是+或者-，那么先计算，再入栈
                if (!opsStack.isEmpty() && (opsStack.peek() == '+' || opsStack.peek() == '-')) {
                    char ops = opsStack.pop();
                    if (ops == '+') {
                        val = (valStack.pop() + val);
                    } else {
                        val = (valStack.pop() - val);
                    }
                }
                valStack.push(val);
            }
            //如果是+或-或(，直接入栈
            else if (c == '+' || c == '-' || c == '(') {
                opsStack.push(c);
                //如果是-，看当作运算符还是负号，若当作负号，前面补一个0
                if(i>0&&arr[i-1]=='(') valStack.push(0);
            }
            //如果是)，弹出(，并计算前面积累的结果
            else {
                opsStack.pop();
                if (!opsStack.isEmpty() && (opsStack.peek() == '+' || opsStack.peek() == '-')) {
                    char ops = opsStack.pop();
                    if (ops == '+') {
                        valStack.push(valStack.pop() + valStack.pop());
                    } else {
                        valStack.push(-valStack.pop() + valStack.pop());
                    }
                }
            }
        }
        //最终计算栈内剩余元素，这种写法有问题，要从底向上计算
        while (!opsStack.isEmpty()) {
            int a = valStack.pop();
            int b = valStack.pop();
            char ops = opsStack.pop();
            if (ops == '+') valStack.push(b + a);
            else valStack.push(b - a);
        }
        //返回valStack元素
        return valStack.pop();
    }

}
