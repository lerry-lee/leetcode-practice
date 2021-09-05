package _剑指Offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/05
 */
public class _59_2_队列的最大值 {
    /**
     * 解法：队列(存数据)+双端队列(存最大值)
     */
    class MaxQueue {

        Queue<Integer> queue;//队列(存数据)
        Deque<Integer> maxValQueue;//双端队列(存最大值)

        public MaxQueue() {
            queue = new LinkedList<>();
            maxValQueue = new LinkedList<>();
        }

        public int max_value() {
            return maxValQueue.isEmpty() ? -1 : maxValQueue.peekFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            //若双端队列的队尾元素<=value，弹出这些元素
            while (!maxValQueue.isEmpty() && maxValQueue.peekLast() <= value) {
                maxValQueue.pollLast();
            }
            //value加到双端队列队尾
            maxValQueue.offerLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) return -1;
            int num = queue.poll();
            if (maxValQueue.peekFirst() == num) maxValQueue.pollFirst();
            return num;
        }
    }
}
