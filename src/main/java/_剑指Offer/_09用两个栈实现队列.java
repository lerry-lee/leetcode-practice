package _剑指Offer;

import java.util.Stack;

/**
 * @ClassName: _09用两个栈实现队列
 * @Author: lerry_li
 * @CreateDate: 2021/04/02
 * @Description
 */
public class _09用两个栈实现队列 {
    /**
     * 解法1：数据栈+辅助栈 插入操作_时间O(N) 删除操作_时间O(1) 空间O(N)
     */
    class CQueue {

        private Stack<Integer> values;
        private Stack<Integer> helper;

        public CQueue() {
            values = new Stack<>();
            helper = new Stack<>();
        }

        public void appendTail(int value) {
            while (!values.isEmpty()) {
                helper.push(values.pop());
            }
            values.push(value);
            while (!helper.isEmpty()) {
                values.push(helper.pop());
            }
        }

        public int deleteHead() {
            if (values.isEmpty()) {
                return -1;
            }
            return values.pop();
        }
    }

    /**
     * 解法2：插入栈(push)+删除栈(pop) 插入操作_时间O(1) 删除操作_时间O(N) 空间O(N)
     */
    class CQueue2 {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public CQueue2() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            if(stack1.isEmpty()){
                return -1;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
