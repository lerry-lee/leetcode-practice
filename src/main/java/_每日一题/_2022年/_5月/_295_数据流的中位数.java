package _每日一题._2022年._5月;

import java.util.PriorityQueue;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/12
 * @Description
 */
public class _295_数据流的中位数 {
    /**
     * 解法1：2个优先队列，分别存数组左半部分和右半部分
     */
    class MedianFinder {

        PriorityQueue<Integer> leftQueue;//大顶堆，左半部分数组
        PriorityQueue<Integer> rightQueue;//小顶堆，右半部分数组

        public MedianFinder() {
            leftQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
            rightQueue = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (leftQueue.isEmpty() && rightQueue.isEmpty()) {
                leftQueue.add(num);
                return;
            }
            //如果num在左部分的范围内，放进leftQueue
            if (num < leftQueue.peek()) {
                leftQueue.add(num);
            }
            //否则，放到rightQueue
            else {
                rightQueue.add(num);
            }
            //左右queue的大小不能差距超过1
            int size1 = leftQueue.size(), size2 = rightQueue.size();
            if (Math.abs(size1 - size2) <= 1) {
                return;
            }
            if (size1 > size2) {
                rightQueue.add(leftQueue.poll());
            } else {
                leftQueue.add(rightQueue.poll());
            }
        }

        public double findMedian() {
            int size1 = leftQueue.size(), size2 = rightQueue.size();
            if ((size1 + size2) % 2 == 0) {
                return (leftQueue.peek() + rightQueue.peek()) / 2.0;
            } else {
                return size1 > size2 ? leftQueue.peek() : rightQueue.peek();
            }
        }
    }
}
