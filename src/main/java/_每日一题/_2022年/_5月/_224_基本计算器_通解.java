package _每日一题._2022年._5月;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/15
 * @Description
 */
public class _224_基本计算器_通解 {

    public static void main(String[] args) {
        //"((1 - (1+1)))"
        _224_基本计算器_通解 instance = new _224_基本计算器_通解();
        instance.new Solution().calculate("((1 - (1+1)))");
    }

    /**
     * 解法：基本计算机包含+、-、*、/和（）的通用解法
     * solution: Basic computers include general solutions for +, -, *, / and ( )
     */
    class Solution {
        public int calculate(String s) {
            // check if input is empty
            if (s == null || s.length() == 0) return 0;
            // declare a value stack and an operator stack
            Deque<Integer> valStack = new ArrayDeque<>();
            Deque<Character> opStack = new ArrayDeque<>();
            // iterate over s
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                // skip the space
                if (arr[i] == ' ') continue;
                // 1.process consecutive number
                if (Character.isDigit(arr[i])) {
                    // calculate number
                    int number = 0;
                    // find the range of consecutive number
                    int j = i;
                    for (; j < arr.length; j++) {
                        // when arr[j] is not number,break
                        if (!Character.isDigit(arr[j])) {
                            break;
                        }
                        number = number * 10 + (arr[j] - '0');
                    }
                    // update i
                    i = j - 1;
                    // Now a number has been obtained, before putting it on the stack,
                    // determine whether it needs to be operated first, that is, whether the top of the operator stack is * or /
                    if (!opStack.isEmpty()) {
                        if (opStack.peekLast() == '*') {
                            number = valStack.removeLast() * number;
                            opStack.removeLast();
                        } else if (opStack.peekLast() == '/') {
                            number = valStack.removeLast() / number;
                            opStack.removeLast();
                        }
                    }
                    // Before pushing the number onto the stack,
                    // judge whether the previous operator is '(' or empty, if so, need to add a '+'
                    if (opStack.isEmpty() || opStack.peekLast() == '(') {
                        opStack.addLast('+');
                    }
                    // push number into stack
                    valStack.addLast(number);
                }
                // 2. process ')'
                else if (arr[i] == ')') {
                    // When ')' is encountered, compute the element inside '()'
                    int res = 0;
                    while (opStack.peekLast() != '(') {
                        char op = opStack.removeLast();
                        if (op == '+') {
                            res += valStack.removeLast();
                        } else {
                            res += -valStack.removeLast();
                        }
                    }
                    // pop '('
                    opStack.removeLast();
                    // push res into valStack
                    valStack.addLast(res);
                }
                // 3.process (,+,-,*,/
                else {
                    // When it is (, judge whether the previous operator is an operator, otherwise add a '+'
                    if (arr[i] == '(') {
                        if (opStack.isEmpty() || opStack.peekLast() == '(') {
                            opStack.addLast('+');
                        }
                    }
                    opStack.addLast(arr[i]);
                }
            }
            // finally, calculate the res
            int res = 0;
            while (!opStack.isEmpty()) {
                char op = opStack.removeLast();
                if (op == '+') {
                    res += valStack.removeLast();
                } else {
                    res += -valStack.removeLast();
                }
            }
            return res;
        }
    }
}
