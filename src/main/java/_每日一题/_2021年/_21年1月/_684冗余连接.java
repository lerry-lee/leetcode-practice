package _每日一题._2021年._21年1月;

import _工具类.CommonMethod;
import _数据结构.UnionFind;

/**
 * @ClassName: _684冗余连接
 * @Author: lerry_li
 * @CreateDate: 2021/01/24
 * @Description
 */
public class _684冗余连接 {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            return new int[]{};
        }
        int n = edges.length;
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            int rootX = unionFind.find(edge[0]-1);
            int rootY = unionFind.find(edge[1]-1);
            if (rootX == rootY) {
                return edge;
            }
            unionFind.union(rootX, rootY);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
//        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[][] edges={{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] res = new _684冗余连接().findRedundantConnection(edges);
        CommonMethod.display(res);
    }
}
