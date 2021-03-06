package _每日一题._2021年._21年3月;

import java.util.Stack;

/**
 * @ClassName: _227基本计算器2
 * @Author: lerry_li
 * @CreateDate: 2021/03/11
 * @Description 1+4/2, 3-2*1
 */
public class _227基本计算器2 {
    /**
     * 解法1：数据栈+操作符栈 时间O(N) 空间O(N)
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> vStack = new Stack<>();
        Stack<Character> oStack = new Stack<>();
//        vStack.push(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //空格跳过
            if (c == ' ') {
                continue;
            }
            //操作符push到vStack
            if (!Character.isDigit(c)) {
                oStack.push(c);
            }
            //数字则判断是否计算
            else {
                //如果可能，取连续一段数字
                int j = i + 1;
                for (; j < s.length(); j++) {
                    if (!Character.isDigit(s.charAt(j))) {
                        break;
                    }
                }
                int cur = Integer.parseInt(s.substring(i, j));
                i = j - 1;
                if (!oStack.isEmpty()) {
                    //判断是否需要和vStack栈顶元素作运算
                    char operation = oStack.peek();
                    //当操作符是'*'或者'/'，则需要作运算
                    if (operation == '*') {
                        cur = vStack.pop() * cur;
                        oStack.pop();
                    } else if (operation == '/') {
                        cur = vStack.pop() / cur;
                        oStack.pop();
                    }
                }
                vStack.push(cur);
            }
        }
        int res = vStack.get(0);
        //最终需要再计算，操作符栈中的'+'或'-'还没有计算
        for (int i = 1, j = 0; i < vStack.size(); i++, j++) {
            char operation = oStack.get(j);
            if (operation == '+') {
                res += vStack.get(i);
            } else if (operation == '-') {
                res -= vStack.get(i);
            }
        }
        return res;
    }


    /**
     * 解法2：单栈 符号位记录正负，转换为加法，遇到乘除先计算  时间O(N) 空间O(N)
     */
    public int calculate2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int sign = 1;
        char preOperation = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                int j = i;
                int num = 0;
                for (; j < s.length(); j++) {
                    char cj = s.charAt(j);
                    if (!Character.isDigit(cj)) {
                        break;
                    }
                    num = num * 10 + (cj - '0');
                }
                num = num * sign;
//                int num = sign * Integer.parseInt(s.substring(i, j));
                sign = 1;
                i = j - 1;
                if (preOperation == '*') {
                    stack.push(stack.pop() * num);
                } else if (preOperation == '/') {
                    stack.push(stack.pop() / num);
                } else {
                    stack.push(num);
                }
            } else {
                if (c == '-') {
                    sign = -1;
                } else if (c == '+') {
                    sign = 1;
                }
                preOperation = c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }


    public static void main(String[] args) {
        _227基本计算器2 instance = new _227基本计算器2();
        System.out.println(instance.calculate2("3+2*2"));//7
        System.out.println(instance.calculate2(" 3/2 "));//1
        System.out.println(instance.calculate2(" 3+5 / 2 "));//5
        System.out.println(instance.calculate2("1-1+1"));//1
        System.out.println(instance.calculate2("2+3-4"));//1
        System.out.println(instance.calculate2("42"));//42
        System.out.println(instance.calculate2("12-3*4"));//0
    }
}
