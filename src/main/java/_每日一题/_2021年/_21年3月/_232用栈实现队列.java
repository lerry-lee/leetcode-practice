package _每日一题._2021年._21年3月;

import java.util.Stack;

/**
 * @ClassName: _232用栈实现队列
 * @Author: lerry_li
 * @CreateTime: 2021/03/05
 * @Description
 */
public class _232用栈实现队列 {

    /**
     * 解法思路：
     *      一个数据栈，一个辅助栈，每次新增数据放到数据栈的栈底
     *      队列先进先出，栈后进先出，因此只要确保新添加的元素在栈底即可，可借助辅助栈完成
     */

    class MyQueue {

        Stack<Integer> dataStack;
        Stack<Integer> helperStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            dataStack = new Stack<>();
            helperStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!dataStack.isEmpty()) {
                helperStack.push(dataStack.pop());
            }
            dataStack.push(x);
            while (!helperStack.isEmpty()) {
                dataStack.push(helperStack.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return dataStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            return dataStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return dataStack.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
