package _每日一题._2021年._21年9月;

import java.util.Arrays;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/07
 */
public class _743网络延迟时间 {

    public static void main(String[] args) {
        _743网络延迟时间 instance = new _743网络延迟时间();
        int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(instance.networkDelayTime(times, 4, 2));
    }

    /**
     * 解法1：dijkstra
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE;
        //初始化邻接表，adj[i][j]表示从节点i到节点j的路径，INF表示不可达
        int[][] adj = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(adj[i], INF);
        }
        for (int[] t : times) {
            int from = t[0] - 1, to = t[1] - 1;
            adj[from][to] = t[2];
        }
        //dist[i]表示从源点到节点i的最短路径，初始化为INF
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        //源点到源点的最短路径为0
        dist[k - 1] = 0;
        //记录节点是否已经访问
        boolean[] visited = new boolean[n];
        //设置起点已经访问，这个其实不影响，因为下面x初始化就是源点
        visited[k - 1] = true;
        //图的遍历
        for (int i = 0; i < n; i++) {
            //x记录每次遍历找到的下一波可达的节点中最短路径的那个节点
            int x = k - 1;
            //记录这一波的最短路径
            int shortestPath = INF;
            for (int y = 0; y < n; ++y) {
                //如果节点y未被访问过，并且节点y到源点的最短路径<shortestPath
                if (!visited[y] && dist[y] < shortestPath) {
                    x = y;
                    shortestPath = dist[y];
                }
            }
            //设置这一波的最短路径的节点x为已访问
            visited[x] = true;
            //更新节点x的所有可达节点的最短路径
            for (int y = 0; y < n; ++y) {
                if(visited[y]) continue;
                dist[y] = adj[x][y] == INF ? INF : Math.min(dist[y], dist[x] + adj[x][y]);
            }
        }
        //最终返回最长的路径
        int ans = Arrays.stream(dist).max().getAsInt();
        //如果还有INF，说明有的节点是从源点不可达的，返回-1
        return ans == INF ? -1 : ans;
    }
}
