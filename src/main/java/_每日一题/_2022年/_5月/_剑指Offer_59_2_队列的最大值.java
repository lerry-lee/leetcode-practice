package _每日一题._2022年._5月;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/12
 * @Description
 */
public class _剑指Offer_59_2_队列的最大值 {
    /**
     * 解法1：普通队列+单调队列(双端队列) 时间平均O(1) 空间O(N)
     * 思路：
     * 普通队列维护正常的尾插和头取，单调队列保持单调递减，这样每次队首都是最大值。
     * 每次push新元素时，单调队列尾部更小的全部弹出，因为它们对于取最大值这个方法来说，全部失效了，后来的更大元素一定使得前面更小的失效。
     * 每次pop元素时，判断是不是在单调队列队首，如果是，也要一起弹出。
     */
    class MaxQueue {

        Queue<Integer> queue;
        Deque<Integer> increasingQueue;

        public MaxQueue() {
            queue = new LinkedList<>();
            increasingQueue = new LinkedList<>();
        }

        public int max_value() {
            if (increasingQueue.isEmpty()) {
                return -1;
            }
            return increasingQueue.peekFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            while (!increasingQueue.isEmpty() && value > increasingQueue.peekLast()) {
                increasingQueue.removeLast();
            }
            increasingQueue.addLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) return -1;
            int val = queue.poll();
            if (increasingQueue.peekFirst() == val) {
                increasingQueue.removeFirst();
            }
            return val;
        }
    }
}
