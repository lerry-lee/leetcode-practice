package _每日一题._2021年._21年1月;

import _数据结构.UnionFind;

/**
 * @ClassName: _1319连通网络的操作次数
 * @Author: lerry_li
 * @CreateTime: 2021/01/29
 * @Description
 */
public class _1319连通网络的操作次数 {
    /**
     * 解法1：并查集 时间O(mα(n)) 空间O(n) m为connections大小
     * 思路：
     * 1.初始化并查集的n个顶点
     * 2.根据连接关系，依次联通两个顶点（若已联通，则记录[冗余连接数]+1）
     * 3.判断[联通子集的个数]，
     * （1）若为1，说明网络已全部联通，返回0；
     * （2）若[冗余连接数]>=[联通子集个数]-1，则可以通过多余的冗余连接线将网络全部联通，所需个数为[联通子集个数]-1；
     * （3）否则，联不通，返回-1
     */
    public int makeConnected(int n, int[][] connections) {
        if (n < 2) {
            return 0;
        }
        if (connections == null || connections.length == 0) {
            return -1;
        }
        UnionFind unionFind = new UnionFind(n);
        int redundancy = 0;
        for (int[] connection : connections) {
            if (unionFind.isConnect(connection[0], connection[1])) {
                redundancy++;
            } else {
                unionFind.union(connection[0], connection[1]);
            }
        }
        int nets = unionFind.getCount();
        if (nets == 1) {
            return 0;
        }
        if (redundancy >= nets - 1) {
            return nets - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        _1319连通网络的操作次数 instance = new _1319连通网络的操作次数();
        int[][] connections = {{0, 1}, {0, 2}, {1, 2}};
        int[][] connections1 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        int[][] connections2 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}};
        int[][] connections3 = {{0, 1}, {0, 2}, {3, 4}, {2, 3}};
        System.out.println(instance.makeConnected(4, connections));
        System.out.println(instance.makeConnected(6, connections1));

        System.out.println(instance.makeConnected(6, connections2));
        System.out.println(instance.makeConnected(5, connections3));

    }
}
