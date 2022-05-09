package _每日一题._2022年._5月;

import java.util.PriorityQueue;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/09
 * @Description
 */
public class _1642_可以到达的最远建筑 {
    /**
     * 解法1：贪心+优先队列 时间(NlogL) 空间O(L) L表示ladders
     * 思路：
     * 由于梯子不在乎高度是多少，因此尽可能贪心的选择高度差最大的地方使用梯子。
     * 梯子的个数为ladders，只需要找到ladders个高度差最大的地方，给它们用上梯子，剩下的都用砖块。
     */
    class Solution {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            int len = heights.length;
            //1.优先队列
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            //2.遍历高度
            for (int i = 1; i < len; i++) {
                //计算高度差
                int dif = heights[i] - heights[i - 1];
                //若高度差>0，说明需要爬楼
                if (dif > 0) {
                    //将当前高度差加入队列
                    minHeap.add(dif);
                    //若队列大小超过了梯子的个数，此时需要把里面最小的高度差dif移除，因为剩下的都是比它大的，而且个数等于梯子的个数
                    //这样可以确保最大的若干个dif都是用梯子来解决（若干个等于梯子的个数）
                    if (minHeap.size() > ladders) {
                        //小的dif用砖块解决
                        bricks -= minHeap.poll();
                    }
                    if (bricks < 0) return i - 1;
                }
            }
            return len - 1;
        }
    }

    /**
     * 解法2：带备忘录的递归 超时+超内存
     */
    class Solution2 {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            memo = new int[heights.length][bricks + 1][ladders + 1];
            for (int i = 0; i < heights.length; i++) {
                for (int j = 0; j <= bricks; j++) {
                    for (int k = 0; k <= ladders; k++) {
                        memo[i][j][k] = -1;
                    }
                }
            }
            return dfs(heights, 0, bricks, ladders) - 1;

        }

        int[][][] memo;

        private int dfs(int[] heights, int t, int bricks, int ladders) {
            if (t == heights.length) return 0;
            if (memo[t][bricks][ladders] != -1) return memo[t][bricks][ladders];
            //判断是否需要加砖块/梯子
            //1.如果不需要
            if (t == 0 || heights[t] <= heights[t - 1]) {
                //直接往后跳
                memo[t][bricks][ladders] = dfs(heights, t + 1, bricks, ladders) + 1;
            }
            //2.否则，考虑用砖块/梯子，选最优
            else {
                //2.1考虑用砖块
                //检查建筑物的高度差是否 砖块够填上
                int dif = heights[t] - heights[t - 1];
                if (bricks >= dif) {
                    //用砖块垫上去
                    memo[t][bricks][ladders] = dfs(heights, t + 1, bricks - dif, ladders) + 1;
                }
                //考虑用梯子
                if (ladders > 0) {
                    memo[t][bricks][ladders] = Math.max(memo[t][bricks][ladders], dfs(heights, t + 1, bricks, ladders - 1) + 1);
                }
                //两者都不够，返回
                if (bricks < dif && ladders == 0) {
                    memo[t][bricks][ladders] = 0;
                }
            }
            return memo[t][bricks][ladders];
        }
    }
}
