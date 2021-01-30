package _每日一题._2021年._21年1月;

import _数据结构.UnionFind;

import java.util.*;

/**
 * @ClassName: _778水位上升的泳池中游泳
 * @Author: lerry_li
 * @CreateTime: 2021/01/30
 * @Description
 */
public class _778水位上升的泳池中游泳 {
    /**
     * 解法1：并查集 时间O(N^2logN) 空间O(N^2)
     * 思路：参考1631最小体力消耗路径
     *
     *
     */
    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        UnionFind unionFind = new UnionFind(n * n);
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = i * n + j;
                //下边
                if (i < n - 1) {
                    int y = (i + 1) * n + j;
                    edges.add(new int[]{x, y, Math.max(grid[i][j], grid[i + 1][j])});
                }
                //右边
                if (j < n - 1) {
                    int y = i * n + j + 1;
                    edges.add(new int[]{x, y, Math.max(grid[i][j], grid[i][j + 1])});
                }
            }
        }
        edges.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int endPoint = n * n - 1;

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            unionFind.union(x, y);
            if (unionFind.isConnect(0, endPoint)) {
                return edge[2];
            }
        }

        return 0;
    }

    /**
     * 解法2：Dijkstra算法
     */
    public int swimInWater2(int[][] grid) {
        int n = grid.length;
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> grid[o[0]][o[1]]));
        //将起点加入
        minHeap.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[n][n];
        // dist[i][j] 表示：到顶点 [i, j] 须要等待的最少的时间
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, n * n);
        }
        dist[0][0] = grid[0][0];

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!minHeap.isEmpty()) {
            // 找最短的边
            int[] front = minHeap.poll();
            int currentX = front[0];
            int currentY = front[1];
            if (visited[currentX][currentY]) {
                continue;
            }

            // 确定最短路径顶点
            visited[currentX][currentY] = true;
            if (currentX == n - 1 && currentY == n - 1) {
                return dist[n - 1][n - 1];
            }

            // 更新
            //上
            if (currentX > 0) {
                int newX = currentX - 1;
                int newY = currentY;
                if (!visited[newX][newY]) {
                    int tempDist = Math.max(dist[currentX][currentY], grid[newX][newY]);
                    if (tempDist < dist[newX][newY]) {
                        dist[newX][newY] = Math.max(dist[currentX][currentY], grid[newX][newY]);
                        minHeap.offer(new int[]{newX, newY});
                    }
                }
            }
            //下
            if (currentX < n - 1) {
                int newX = currentX + 1;
                int newY = currentY;
                if (!visited[newX][newY]) {
                    int tempDist = Math.max(dist[currentX][currentY], grid[newX][newY]);
                    if (tempDist < dist[newX][newY]) {
                        dist[newX][newY] = Math.max(dist[currentX][currentY], grid[newX][newY]);
                        minHeap.offer(new int[]{newX, newY});
                    }
                }
            }
            //左
            if (currentY > 0) {
                int newX = currentX;
                int newY = currentY - 1;
                if (!visited[newX][newY]) {
                    int tempDist = Math.max(dist[currentX][currentY], grid[newX][newY]);
                    if (tempDist < dist[newX][newY]) {
                        dist[newX][newY] = Math.max(dist[currentX][currentY], grid[newX][newY]);
                        minHeap.offer(new int[]{newX, newY});
                    }
                }
            }
            //右
            if (currentY < n - 1) {
                int newX = currentX;
                int newY = currentY + 1;
                if (!visited[newX][newY]) {
                    int tempDist = Math.max(dist[currentX][currentY], grid[newX][newY]);
                    if (tempDist < dist[newX][newY]) {
                        dist[newX][newY] = Math.max(dist[currentX][currentY], grid[newX][newY]);
                        minHeap.offer(new int[]{newX, newY});
                    }
                }
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        _778水位上升的泳池中游泳 instance = new _778水位上升的泳池中游泳();
        int[][] grid = {{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}};
        int[][] grid1 = {{0, 2}, {1, 3}};
        System.out.println(instance.swimInWater(grid1));

        System.out.println(instance.swimInWater(grid));
    }
}
