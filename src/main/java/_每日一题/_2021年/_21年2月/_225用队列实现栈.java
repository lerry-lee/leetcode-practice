package _每日一题._2021年._21年2月;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _225用队列实现栈
 * @Author: lerry_li
 * @CreateTime: 2021/02/19
 * @Description
 */
public class _225用队列实现栈 {
    /**
     * 解法：两个队列，queue1存储数据，queue2作辅助队列
     *      queue2每次前都是空的，queue1存储了栈内的数据
     * push：元素入队queue2，然后将queue1的元素依次入队queue2，此时queue2和queue1交换
     */
    class MyStack {

        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        /** Initialize your data structure here. */
        public MyStack() {
            this.queue1 = new LinkedList<>();
            this.queue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue2.offer(x);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue1.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue1.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}
