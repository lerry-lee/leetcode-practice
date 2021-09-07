package _每日一题._2021年._21年3月;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _单源最短路径dijkstra
 * @Author: lerry_li
 * @CreateDate: 2021/03/13
 * @Description
 */
public class _单源最短路径dijkstra {
    /**
     * 单源最短路径算法，求的是，从一个起始点到所有点的最短路径（如果只求一个点到另一个点的最短路径，则需要变化一下）
     *
     * @param startNode  起点
     * @param n       节点个数
     * @param v       节点（从0开始编号，即1～n-1）
     * @param aMatrix 邻接矩阵，aMatrix[i][j]表示节点i到节点j的距离，用INF表示不可达
     */
    public static void dijkstra(int startNode, int n, char[] v, int[][] aMatrix) {
        //dist[i]表示节点i到起点的最短路径
        int[] dist = new int[n];//最短路径数组，如果已经访问过的节点，那么就是最短路径，否则是初始化的值（邻接矩阵存的距离)
        //prev[i]表示节点i的前驱节点
        int[] prev = new int[n];//最短路径上的该节点的前驱节点
        //记录访问过的节点
        Set<Integer> visited = new HashSet<>();
        //【1】初始化
        //初始化出发点设置为已访问
        visited.add(startNode);
        //初始化所有节点到源点的距离为INF
        Arrays.fill(dist, Integer.MAX_VALUE);
        //源点到源点的距离初始化为0
        dist[startNode] = 0;
        //【2】图的遍历
        //i表示循环次数，每循环一次，一个节点就被更新了最短路径（即，一个节点加入已访问的集合中），因此循环n-1即可
        for (int i = 1; i < n; i++) {
            //k记录从源点出发，每次搜索时，可达节点中的最短路径的节点
            int kNode = 0;
            int shortestPath_startToK = Integer.MAX_VALUE;
            //遍历所有的节点，找到从源点出发到这些节点的最短路径，标记这个节点k
            for (int jNode = 0; jNode < n; jNode++) {
                //条件：1.未访问过 2.源点到该点的距离小于当前最小距离
                if (!visited.contains(jNode) && dist[jNode] < shortestPath_startToK) {
                    shortestPath_startToK = dist[jNode];
                    //用k标记该节点
                    kNode = jNode;
                }
            }
            //将节点k设置为已经访问
            visited.add(kNode);
            //遍历从k出发，所有可达的节点，更新它们的路径（由于节点k的最短路径已经求出，那么从源点到这些节点的路径则可能需要更新）
            for (int jNode = 0; jNode < n; jNode++) {
                //shortestPath_startToK是源点到节点k的最短路径
                //节点k到其可达节点的距离设置为temp，如果是INF，即不可达的，则temp=INF，否则temp=shortestPath_startToK+节点k到该节点的距离
                //tmp是源点到k，再到节点j的最短距离，但这个距离可能不是最短的（因为从源点到j可能不会经过k），所以需要和dist记录的距离比较
                int path_fromKToJ = (aMatrix[kNode][jNode] == Integer.MAX_VALUE ? Integer.MAX_VALUE : (shortestPath_startToK + aMatrix[kNode][jNode]));
                //如果该节点未被访问，同时temp<源点到该节点的最短路径
                //否则更新dist，源点到该节点的最短路径
                if (!visited.contains(jNode) && (path_fromKToJ < dist[jNode])) {
                    dist[jNode] = path_fromKToJ;
                    //记录节点j的前驱节点是k
                    prev[jNode] = kNode;
                }
            }

        }

        for (int i = 0; i < n; i++) {
            System.out.println("vStart=1,end=" + v[i] + " shortest distance:" + dist[i]);
        }
        System.out.println("前驱节点：");
        for (int i = 0; i < n; i++) {
            System.out.print(prev[i] + " ");
        }
    }

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int vStart = 0;
        char[] v = {'1', '2', '3', '4', '5'};
        int[][] aMatrix = {
                {0, 10, INF, 30, 100},
                {INF, 0, 50, INF, INF},
                {INF, INF, 0, INF, 10},
                {INF, INF, 20, 0, 60},
                {INF, INF, INF, INF, 0}};
        dijkstra(vStart, 5, v, aMatrix);
    }
}
