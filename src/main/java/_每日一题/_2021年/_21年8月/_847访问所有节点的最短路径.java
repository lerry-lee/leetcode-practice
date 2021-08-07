package _每日一题._2021年._21年8月;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _847访问所有节点的最短路径
 * @Author: lerry_li
 * @CreateDate: 2021/08/07
 * @Description
 */
public class _847访问所有节点的最短路径 {
    /**
     * 解法1：bfs+状态压缩
     * 思路与算法
     *      由于题目需要我们求出「访问所有节点的最短路径的长度」，
     *      并且图中每一条边的长度均为 1，因此我们可以考虑使用广度优先搜索的方法求出最短路径。
     *      在常规的广度优先搜索中，我们会在队列中存储节点的编号。
     *      对于本题而言，最短路径的前提是「访问了所有节点」，
     *      因此除了记录节点的编号以外，我们还需要记录每一个节点的经过情况。
     *      因此，我们使用三元组 (u,mask,dist) 表示队列中的每一个元素，其中：
     *          1)u 表示当前位于的节点编号；
     *          2)mask 是一个长度为 n 的二进制数，表示每一个节点是否经过。
     *            如果 {mask 的第 i 位是 1，则表示节点 i 已经过，否则表示节点 i 未经过；
     *          3)dist 表示到当前节点为止经过的路径长度。
     *      这样一来，我们使用该三元组进行广度优先搜索，即可解决本题。
     *      初始时，我们将所有的 (i,2^i,0) 放入队列，表示可以从任一节点开始。
     *      在搜索的过程中，如果当前三元组中的 mask 包含 n 个 1（即 mask=2^n−1），那么我们就可以返回 dist 作为答案。
     *
     * 细节
     *      为了保证广度优先搜索时间复杂度的正确性，
     *      即同一个节点 u 以及节点的经过情况 mask 只被搜索到一次，
     *      我们可以使用数组或者哈希表记录(u,mask) 是否已经被搜索过，防止无效的重复搜索。
     */
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        // 1.初始化队列及标记数组，存入起点
        Queue<int[]> queue = new LinkedList<int[]>(); // 三个属性分别为 idx, mask, dist
        boolean[][] vis = new boolean[n][1 << n]; // 节点编号及当前状态
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i, 0}); // 存入起点，起始距离0，标记
            vis[i][1 << i] = true;
        }

        // 开始搜索
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll(); // 弹出队头元素
            int idx = tuple[0], mask = tuple[1], dist = tuple[2];

            // 找到答案，返回结果
            if (mask == (1 << n) - 1) return dist;

            // 扩展
            for (int x : graph[idx]) {
                int next_mask = mask | (1 << x);
                if (!vis[x][next_mask]) {
                    queue.offer(new int[]{x, next_mask, dist + 1});
                    vis[x][next_mask] = true;
                }
            }
        }
        return 0;
    }
}
