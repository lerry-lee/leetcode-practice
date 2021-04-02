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
     * 解法1：时间复杂度O(N^2)
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
            helper.push(value);
            while (!helper.isEmpty()) {
                values.push(helper.pop());
            }
        }

        public int deleteHead() {
            if(values.isEmpty()){
                return -1;
            }
            return values.pop();
        }
    }
}
