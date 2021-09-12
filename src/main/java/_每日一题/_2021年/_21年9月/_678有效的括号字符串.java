package _每日一题._2021年._21年9月;

import java.util.Stack;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/12
 */
public class _678有效的括号字符串 {

    public static void main(String[] args) {
        _678有效的括号字符串 instance = new _678有效的括号字符串();
        System.out.println(instance.checkValidString("()"));
        System.out.println(instance.checkValidString("(*)"));
        System.out.println(instance.checkValidString("(*))"));
        System.out.println(instance.checkValidString("(*)))"));
        System.out.println(instance.checkValidString("((*))"));
        System.out.println(instance.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
    }

    /**
     * 解法1：双栈（左括号栈+星号栈） 时间O(N) 空间O(N)
     */
    public boolean checkValidString(String s) {
        //特判
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int n = s.length();
        //双栈放的是下标，用于判断前后关系
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //星号入栈
            if (c == '*') {
                star.push(i);
            }
            //左括号入栈
            else if (c == '(') {
                left.push(i);
            }
            //右括号：去栈里匹配左括号，由于*可以代替左括号、空字符、右括号，因此优先匹配左括号栈
            else {
                //优先匹配左括号栈
                if (!left.isEmpty()) {
                    left.pop();
                }
                //左括号栈为空，再匹配星号栈
                else if (!star.isEmpty()) {
                    star.pop();
                }
                //否则，右括号没有与之匹配的，返回false
                else {
                    return false;
                }
            }
        }
        //最后，看看左括号是否能够被匹配完
        while (!left.isEmpty()) {
            //每一个左括号，必须有一个右括号与之匹配，由星号栈的*代替
            if (star.isEmpty()) return false;
            //左括号必须在前面，因此下标必须要小
            if (left.peek() < star.peek()) {
                left.pop();
                star.pop();
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 解法2：未匹配的左括号数量 时间O(N) 空间O(1)
     * 思路：
     *  从左到右遍历字符串，遍历过程中，未匹配的左括号数量可能会出现如下变化：
     *      - 如果遇到左括号，则未匹配的左括号数量加 1；
     *      - 如果遇到右括号，则需要有一个左括号和右括号匹配，因此未匹配的左括号数量减 1；
     *      - 如果遇到星号，由于星号可以看成左括号、右括号或空字符串，因此未匹配的左括号数量可能加 1、减 1 或不变。
     *  基于上述结论，可以在遍历过程中维护未匹配的左括号数量可能的最小值和最大值，根据遍历到的字符更新最小值和最大值：
     *      - 如果遇到左括号，则将最小值和最大值分别加 1；
     *      - 如果遇到右括号，则将最小值和最大值分别减 1；
     *      - 如果遇到星号，则将最小值减 1，将最大值加 1。
     *
     */
    public boolean checkValidString2(String s) {
        //特判
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int minCount = 0, maxCount = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                minCount++;
                maxCount++;
            } else if (c == ')') {
                minCount = Math.max(0, minCount - 1);
                maxCount--;
                if (maxCount < 0) {
                    return false;
                }
            } else {
                minCount = Math.max(0, minCount - 1);
                maxCount++;
            }
        }
        return minCount <= 0;
    }
}
