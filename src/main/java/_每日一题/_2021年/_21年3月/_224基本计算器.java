package _每日一题._2021年._21年3月;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName: _224基本计算器
 * @Author: lerry_li
 * @CreateDate: 2021/03/10
 * @Description
 */
public class _224基本计算器 {
    /**
     * 解法1：数值栈+操作符栈 时间O(N) 空间O(N)
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //定义一个valueStack，初始化放入0（避免上来就是"-2+1"这种算式）
        Stack<Integer> valueStack = new Stack<>();
        valueStack.push(0);
        //定义一个operationStack，保存(,+,-
        Stack<Character> operationStack = new Stack<>();
        //遍历算式字符串
        for (int i = 0; i < s.length(); i++) {
            //取出单个字符，如果为空格则跳过
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            //如果为操作符或(，则push
            if (c == '(' || c == '+' || c == '-') {
                operationStack.push(c);
            }
            //否则，要么为')'，要么为数值
            else {
                //若为')'，则把operationStack的栈顶元素pop掉（必为'('）
                if (c == ')') {
                    operationStack.pop();
                    //然后operationStack的栈顶元素是否是'+'或者'-'，
                    //1.如果是则计算valueStack的栈顶元素与次栈顶元素的运算结果
                    //2.如果不是，则不动
                    int sum = valueStack.pop();
                    if (!operationStack.isEmpty()) {
                        char operation = operationStack.pop();
                        if (operation == '+') {
                            sum += valueStack.pop();
                        } else if (operation == '-') {
                            sum = valueStack.pop() - sum;
                        }

                    }
                    valueStack.push(sum);
                }
                //若为数值，则取出连续的数字组成一个数值
                else {
                    int j = i + 1;
                    for (; j < s.length(); j++) {
                        char cj = s.charAt(j);
                        if (cj == '(' || cj == ')' || cj == '+' || cj == '-'||cj==' ') {
                            break;
                        }
                    }
                    //拿到该数值
                    int sum = Integer.parseInt(s.substring(i, j));
                    //i也要更新
                    i = j-1;
                    //接下来，如果操作符栈不为空，则计算当前数值和valueStack的栈顶元素的计算结果，并将其push到valueStack
                    if (!operationStack.isEmpty()) {
                        char operation = operationStack.peek();
                        if (operation == '+') {
                            sum += valueStack.pop();
                            operationStack.pop();
                        } else if (operation == '-') {
                            sum = valueStack.pop() - sum;
                            operationStack.pop();
                        }
                    }
                    valueStack.push(sum);
                }
            }
        }
        //最终valueStack的栈顶元素即为算式的计算结果
        return valueStack.peek();
    }

    /**
     * 解法2：括号展开+栈 时间O(N) 空间O(N)
     */
    public int calculate2(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;

        int res = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += sign * num;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        _224基本计算器 instance = new _224基本计算器();
        System.out.println(instance.calculate("1+1"));
        System.out.println(instance.calculate(" 2-1 + 2 "));
        System.out.println(instance.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(instance.calculate("2147483647"));
        System.out.println(instance.calculate("-2+1"));
    }
}
