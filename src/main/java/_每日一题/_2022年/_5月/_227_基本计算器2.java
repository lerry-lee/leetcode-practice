package _每日一题._2022年._5月;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/07
 * @Description
 */
public class _227_基本计算器2 {

    public static void main(String[] args) {
        _227_基本计算器2 instance = new _227_基本计算器2();
        instance.new Solution().calculate("2-4-(8+2-6+(8+4-(1)+8-10))");
    }

    /**
     * 解法1：双栈
     */
    class Solution {
        public int calculate(String s) {
            // 特判
            if (s == null || s.length() == 0) return 0;
            Deque<Integer> vals = new ArrayDeque<>();
            Deque<Character> ops = new ArrayDeque<>();
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                // 如果是空格，跳过
                if (arr[i] == ' ') continue;
                // 如果是数字
                if (Character.isDigit(arr[i])) {
                    // 寻找连续的数字
                    int j = i + 1;
                    int num = arr[i] - '0';
                    for (; j < arr.length; j++) {
                        if (!Character.isDigit(arr[j])) break;
                        num = num * 10 + (arr[j] - '0');
                    }
                    i = j - 1;
                    // num为连续的数字，判断ops栈顶元素，如果是乘除，需要先算，否则不需要
                    if (!ops.isEmpty() && (ops.peekLast() == '*' || ops.peekLast() == '/')) {
                        // 取出vals栈顶元素，进行乘除运算
                        if (ops.pollLast() == '*') num = vals.pollLast() * num;
                        else num = vals.pollLast() / num;
                    }
                    // num入栈
                    vals.addLast(num);
                }
                // 否则，为运算符，直接入栈
                else {
                    ops.addLast(arr[i]);
                }
            }
            // 最后计算栈中结果
            if (ops.isEmpty()) return vals.pollLast();

            if (ops.size() > vals.size()-1 && ops.peekFirst() == '-') {
                vals.addFirst(0);// 防止-3+1这种
            }
            while (!ops.isEmpty()) {
                // 获取运算符
                char op = ops.pollFirst();
                // 获取数值
                int a = vals.pollFirst(), b = vals.pollFirst();
                // 根据不同运算符进行计算，只可能是+或-
                if (op == '+') {
                    a = a + b;
                } else {
                    a = a - b;
                }
                // 结果入栈
                vals.addFirst(a);
            }
            return vals.pollLast();
        }
    }

    /**
     * 解法2：单栈
     */
    class Solution2 {
        public int calculate(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            char preSign = '+';
            int num = 0;
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                if (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                }
                if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                    switch (preSign) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop() * num);
                            break;
                        default:
                            stack.push(stack.pop() / num);
                    }
                    preSign = s.charAt(i);
                    num = 0;
                }
            }
            int ans = 0;
            while (!stack.isEmpty()) {
                ans += stack.pop();
            }
            return ans;
        }
    }

}
