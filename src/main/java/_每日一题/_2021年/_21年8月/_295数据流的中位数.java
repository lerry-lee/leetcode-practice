package _每日一题._2021年._21年8月;

import java.util.PriorityQueue;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/08/27
 */
public class _295数据流的中位数 {

    /**
     * 解法1：大顶堆+小顶堆 时间【添加元素的时间复杂度O(logN)，查找中位数为O(1)】 空间O(N)
     */
    class MedianFinder {
        //小顶堆
        PriorityQueue<Integer> rightQueue;//数组右半部分，最小值在前
        //大顶堆
        PriorityQueue<Integer> leftQueue;//数组左半部分，最大值在前

        /** initialize your data structure here. */
        public MedianFinder() {
            leftQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            rightQueue = new PriorityQueue<>();
        }

        //添加一个元素num
        public void addNum(int num) {
            //如果大顶堆(数组左半部分)和小顶堆(数组右半部分)都为空
            if (leftQueue.isEmpty() && rightQueue.isEmpty()) {
                //将元素添加到大顶堆(数组左半部分)
                leftQueue.offer(num);
                return;
            }
            //否则
            //若元素小于大顶堆的堆顶，即元素小于数组左半部分的最大值(最右侧)
            if (num < leftQueue.peek()) {
                //大顶堆(数组左半部分)添加该元素
                leftQueue.offer(num);
            }
            //否则，元素大于等于大顶堆的堆顶
            else {
                //小顶堆(数组右半部分)添加该元素
                rightQueue.offer(num);
            }
            //调整两个队列，保证size之差<=1
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

        //查找中位数
        public double findMedian() {
            int sizeL = leftQueue.size(), sizeR = rightQueue.size();
            //若左半部分和右半部分的size相等，则取两个二叉堆的堆顶元素，然后计算平均值
            if (sizeL == sizeR) {
                return (leftQueue.peek() + rightQueue.peek()) / 2.0;
            }
            //否则，取size大的那部分的堆顶元素
            else if (sizeL > sizeR) {
                return leftQueue.peek();
            } else {
                return rightQueue.peek();
            }
        }
    }
}
