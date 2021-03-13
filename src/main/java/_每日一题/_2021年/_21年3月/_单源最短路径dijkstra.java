package _每日一题._2021年._21年3月;

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
     * @param vStart  起点
     * @param n       节点个数
     * @param v       节点（从0开始编号，即1～n-1）
     * @param aMatrix 邻接矩阵，aMatrix[i][j]表示节点i到节点j的距离，用INF表示不可达
     * @param dist    最短路径数组，如果已经访问过的节点，那么就是最短路径，否则是初始化的值（邻接矩阵存的距离）
     * @param prev    最短路径上的该节点的前驱节点
     */
    public static void dijkstra(int vStart, int n, char[] v, int[][] aMatrix, int[] dist, int[] prev) {
        //flag数组记录访问过的节点
        boolean[] flag = new boolean[n];
        //初始化，每个节点设置为未访问，每个节点到起始点的距离设置为邻接矩阵的对应的值，INF表示不可达
        for (int i = 0; i < n; i++) {
            flag[i] = false;
            dist[i] = aMatrix[vStart][i];
        }
        //出发点设置为已访问
        flag[vStart] = true;
//        prev[vStart]=vStart;
        //出发点到出发点的距离初始化为0
        dist[vStart] = 0;
        //i表示循环次数，每循环一次，一个节点就被更新了最短路径（即，一个节点加入已访问的集合中），因此循环n-1即可
        for (int i = 1; i < n; i++) {
            //k记录从源点出发，每次搜索时，找到的最短路径的节点
            int k = 0;
            int min = Integer.MAX_VALUE;
            //遍历所有的节点，找到从源点出发到这些节点的最短路径，标记这个节点k
            for (int j = 0; j < n; j++) {
                //条件：1.未访问过 2.源点到该点的距离小于当前最小距离
                if (!flag[j] && dist[j] < min) {
                    min = dist[j];
                    //用k标记该节点
                    k = j;
                }
            }
            //将节点k设置为已经访问
            flag[k] = true;
            //遍历从k出发，所有可达的节点，更新它们的路径（由于节点k的最短路径已经求出，那么从源点到这些节点的路径则可能需要更新）
            for (int j = 0; j < n; j++) {
                //min是源点到节点k的最短路径
                //节点k到其可达节点的距离设置为temp，如果是INF，即不可达的，则temp=INF，否则temp=min+节点k到该节点的距离
                //tmp是源点到k，再到节点j的最短距离，但这个距离可能不是最短的（因为从源点到j可能不会经过k），所以需要和dist记录的距离比较
                int tmp = (aMatrix[k][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : (min + aMatrix[k][j]));
                //如果该节点未被访问，同时temp<源点到该节点的最短路径
                //否则更新dist，源点到该节点的最短路径
                if (!flag[j] && (tmp < dist[j])) {
                    dist[j] = tmp;
                    //记录前驱节点
                    prev[j] = k;
                }
            }

        }

        for (int i = 0; i < n; i++) {
            System.out.println("vStart=1,end=" + v[i] + " shortest distance:" + dist[i]);
//            System.out.print(prev[i]+"->");
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
        dijkstra(vStart, 5, v, aMatrix, new int[5], new int[5]);
    }
}
