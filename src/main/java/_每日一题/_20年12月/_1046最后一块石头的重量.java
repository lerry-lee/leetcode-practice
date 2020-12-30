package _每日一题._20年12月;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: _1046最后一块石头的重量
 * @Author: lerry_li
 * @CreateTime: 2020/12/30
 * @Description
 */
public class _1046最后一块石头的重量 {
    /**
     * 解法1：大顶堆（优先队列实现） 时间O(NlogN) 空间O(N)
     */
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int stone : stones) {
            bigHeap.add(stone);
        }
        while (!bigHeap.isEmpty()) {
            int y = bigHeap.poll();
            if (bigHeap.isEmpty()) {
                return y;
            }
            int x = bigHeap.poll();
            if (x != y) {
                bigHeap.add(y - x);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        _1046最后一块石头的重量 instance = new _1046最后一块石头的重量();
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(instance.lastStoneWeight(stones));
    }
}
