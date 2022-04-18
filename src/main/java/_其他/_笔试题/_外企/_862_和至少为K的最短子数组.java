package _其他._笔试题._外企;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/18
 * @Description
 */
public class _862_和至少为K的最短子数组 {

    /**
     * 解法1：前缀和+单调队列
     */
    public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        // 前缀和数组，pSum[i]表示A[0:i-1]的前缀和
        long[] pSum = new long[N + 1];
        for (int i = 0; i < N; ++i)
            pSum[i + 1] = pSum[i] + (long) A[i];

        // 目标：找到满足pSum[j]-pSum[i]>=k的j和i中j-i最小的那个，
        // 即：j和i离得最近，且j和i之间的数字之和>=k

        // 设置一个不可达的值，这样如果找不到符合条件的可以返回-1
        int ans = N + 1;
        // 单调递增队列，记录pSum[]
        Deque<Integer> deque = new LinkedList();
        //遍历j，当j为某个值时，找到符合条件的i，然后看是否更新ans为j-i的值
        for (int j = 0; j < pSum.length; ++j) {
            // 当j一定时，找到最大的i，使得pSum[j]-pSum[i]>=k，当然这个i是小于j的

            //保持deque单调递增，如果当前pSum[j]比队尾值更小，那么不断弹出队尾值
            while (!deque.isEmpty() && pSum[j] <= pSum[deque.getLast()]) {
                deque.removeLast();
            }
            //此时deque满足单调递增，开始找i
            //从队首开始找，找到一个符合条件的就弹出
            while (!deque.isEmpty() && pSum[j] - pSum[deque.getFirst()] >= K) {
                ans = Math.min(ans, j - deque.removeFirst());
            }
            //把当前j加入队尾
            deque.addLast(j);
        }
        //结果判断，返回
        return ans < N + 1 ? ans : -1;
    }

}
