package _牛客题库;

import java.util.Stack;

/**
 * @ClassName: _表达式求值
 * @Author: lerry_li
 * @CreateTime: 2021/09/04
 * @Description
 */
public class _表达式求值 {

    public static void main(String[] args) {
        _表达式求值 instance = new _表达式求值();
        System.out.println(instance.solve("1+2"));//3
        System.out.println(instance.solve("3+2*3*4-1"));//26
        System.out.println(instance.solve("3-2*3*4-1"));//-22
        System.out.println(instance.solve("(2*(3-4))*5"));//-10
        System.out.println(instance.solve("(3+4)*(5+(2-3))"));//28
        System.out.println(instance.solve("((10+2)*10-(100-(10+20*10-(2*3)))*10*1*2)-2"));//2198
    }

    /**
     * 解法1：双栈 时间O(N) 空间O(N)
     */
    public int solve(String s) {
        // 特判
        if (s == null || s.length() == 0) return 0;
        //数值栈
        Stack<Integer> valStack = new Stack<>();
        //运算符栈
        Stack<Character> opsStack = new Stack<>();
        //遍历
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            //如果是数字，找全
            if (Character.isDigit(c)) {
                int j = i + 1;
                for (; j < s.length(); j++) {
                    //若s[j]为非数字，则s[i:j)为数字
                    if (!Character.isDigit(s.charAt(j))) {
                        //退出找数字的遍历
                        break;
                    }
                }
                //当前数字
                int num = Integer.parseInt(s.substring(i, j));
                //1)看ops栈是否是*，乘需要先算
                if (!opsStack.isEmpty() && opsStack.peek() == '*') {
                    //当前数字*栈顶数字
                    num *= valStack.pop();
                    opsStack.pop();//弹出*
                }
                //2)入val栈
                valStack.push(num);
                //更新i
                i = j;
            }
            //否则为运算符或括号，入ops栈
            else {
                //若为右括号，计算第一个匹配的左括号的表达式
                if (c == ')') {
                    //计算（）的值
                    while (opsStack.peek() != '(') {
                        char ops = opsStack.pop();
                        if (ops == '+') {
                            valStack.push(valStack.pop() + valStack.pop());
                        } else if (ops == '-') {
                            valStack.push(-valStack.pop() + valStack.pop());
                        } else {
                            valStack.push(valStack.pop() * valStack.pop());
                        }
                    }
                    //弹出匹配的(
                    opsStack.pop();
                    //看前面是不是*，是要先算
                    if (!opsStack.isEmpty() && opsStack.peek() == '*') {
                        //当前数字*栈顶数字
                        valStack.push(valStack.pop() * valStack.pop());
                        opsStack.pop();//弹出*
                    }
                }
                //否则，为*+-或(，直接入栈
                else opsStack.push(c);
                i++;
            }
        }
        //最终遍历val栈和ops栈，计算
        int res = valStack.get(0);
        for (int i = 1; i < valStack.size(); i++) {
            char ops = opsStack.get(i-1);
            if (ops == '+') {
                res += valStack.get(i);
            } else {
                res -= valStack.get(i);
            }
        }
        return res;
    }
}
