package _每日一题._2021年._21年7月;

import java.util.Stack;

/**
 * @ClassName: _155最小栈
 * @Author: lerry_li
 * @CreateDate: 2021/07/31
 * @Description
 */
public class _155最小栈 {
    /**
     * 解法1：双栈 数据栈和最小值栈
     */
    class MinStack {

        private Stack<Integer> valStack;
        private Stack<Integer> minValStack;

        /** initialize your data structure here. */
        public MinStack() {
            valStack = new Stack<>();
            minValStack = new Stack<>();
        }

        public void push(int val) {
            valStack.push(val);
            if (minValStack.isEmpty()) {
                minValStack.push(val);
            } else {
                minValStack.push(Math.min(minValStack.peek(), val));
            }
        }

        public void pop() {
            valStack.pop();
            minValStack.pop();
        }

        public int top() {
            return valStack.peek();
        }

        public int getMin() {
            return minValStack.peek();
        }
    }
}
