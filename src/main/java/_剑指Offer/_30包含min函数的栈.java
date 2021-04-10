package _剑指Offer;

import java.util.Stack;
import java.util.TreeMap;

/**
 * @ClassName: _30包含min函数的栈
 * @Author: lerry_li
 * @CreateTime: 2021/04/10
 * @Description
 */
public class _30包含min函数的栈 {
    /**
     * 解法1：TreeMap+Stack 时间O(logN) 空间O(1)
     */
    class MinStack {

        private Stack<Integer> stack;
        private TreeMap<Integer, Integer> treeMap;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            treeMap = new TreeMap<>();
        }

        public void push(int x) {
            stack.push(x);
            treeMap.put(x, treeMap.getOrDefault(x, 0) + 1);
        }

        public void pop() {
            int x = stack.pop();
            int count = treeMap.get(x);
            if (count == 1) {
                treeMap.remove(x);
            } else {
                treeMap.put(x, count - 1);
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return treeMap.firstKey();
        }
    }

    /**
     * 解法2：数据栈+辅助栈(维护递减顺序) 时间O(1) 空间O(1)
     * 思路：
     *      1.数据栈维护正常的插入顺序
     *      2.辅助栈维护非递增顺序，这样每次栈顶元素就是当前栈的最小值，每次数据栈push的时候判断一下辅助栈的栈顶元素是不是一致，是则也要push
     */
    class MinStack2 {

        private Stack<Integer> valueStack;
        private Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack2() {
            valueStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            valueStack.push(x);
            if (minStack.isEmpty() || (minStack.peek() >= x)) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (valueStack.pop().equals(minStack.peek())) {
                minStack.pop();
            }
        }

        public int top() {
            return valueStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}
