package _剑指Offer;

import java.util.PriorityQueue;

/**
 * @ClassName: _41数据流中的中位数
 * @Author: lerry_li
 * @CreateDate: 2021/04/26
 * @Description
 * 解法1：优先队列（大顶堆+小顶堆）
 */
public class _41数据流中的中位数 {
    /**
     * 解法1：优先队列（大顶堆+小顶堆） 每次add时间O(logN) 每次find时间O(1) 空间O(N)
     */
    class MedianFinder {
        PriorityQueue<Integer> rightQueue;//数组右半部分，最小值在前
        PriorityQueue<Integer> leftQueue;//数组左半部分，最大值在前

        /** initialize your data structure here. */
        public MedianFinder() {
            leftQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            rightQueue = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (leftQueue.isEmpty() && rightQueue.isEmpty()) {
                leftQueue.offer(num);
                return;
            }
            if (num < leftQueue.peek()) {
                leftQueue.offer(num);
            } else {
                rightQueue.offer(num);
            }
            //调整两个队列
            int sizeL = leftQueue.size(), sizeR = rightQueue.size();
            if (Math.abs(sizeL - sizeR) <= 1) {
                return;
            }
            if (sizeL > sizeR) {
                rightQueue.offer(leftQueue.poll());
            } else {
                leftQueue.offer(rightQueue.poll());
            }
        }

        public double findMedian() {
            int sizeL = leftQueue.size(), sizeR = rightQueue.size();
            if (sizeL == sizeR) {
                return (leftQueue.peek() + rightQueue.peek()) / 2.0;
            } else if (sizeL > sizeR) {
                return leftQueue.peek();
            } else {
                return rightQueue.peek();
            }
        }
    }
}
