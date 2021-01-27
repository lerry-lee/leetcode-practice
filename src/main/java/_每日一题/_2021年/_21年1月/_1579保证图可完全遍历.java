package _每日一题._2021年._21年1月;

import _数据结构.UnionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _1579保证图可完全遍历
 * @Author: lerry_li
 * @CreateDate: 2021/01/27
 * @Description
 */
public class _1579保证图可完全遍历 {
    /**
     * 解法1：并查集 时间O(NlogN) 空间O(N)
     * 思路：
     * 使用两个并查集
     * 1.首先将公共的边(类型为3)连接的节点加入并查集(联通)。注意：需要判断是否冗余，是则需要删除；
     * 2.对于每个并查集，遍历对应类型的边，将其连接的节点联通。注意：需要判断是否冗余，是则需要删除；
     * 3.若最终两个并查集都是全联通的(即：联通子集的个数为1)，则返回可以删除的冗余的边的数目，否则返回-1
     */
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        if (n < 1 || edges == null || edges.length == 0 || edges[0].length == 0) {
            return 0;
        }
        UnionFind unionFind1 = new UnionFind(n);
        UnionFind unionFind2 = new UnionFind(n);
        List<int[]> edges1 = new ArrayList<>();
        List<int[]> edges2 = new ArrayList<>();


        int canRemove = 0;

        //将类型3的边连接的节点联通
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                //已经联通的节点，跳过
                if (unionFind1.isConnect(edge[1] - 1, edge[2] - 1)) {
                    canRemove++;
                } else {
                    unionFind1.union(edge[1] - 1, edge[2] - 1);
                    unionFind2.union(edge[1] - 1, edge[2] - 1);
                }
            } else if (edge[0] == 1) {
                edges1.add(edge);
            } else {
                edges2.add(edge);
            }
        }


        //检查类型1的边连接的节点，若已经联通，则跳过，否则联通
        for (int[] edge1 : edges1) {
            boolean isConnect = unionFind1.isConnect(edge1[1] - 1, edge1[2] - 1);
            //已经联通的节点，跳过
            if (!isConnect) {
                unionFind1.union(edge1[1] - 1, edge1[2] - 1);
            } else {
                canRemove++;
            }
        }

        //检查类型2的边连接的节点，若已经联通，则跳过，否则联通
        for (int[] edge2 : edges2) {
            boolean isConnect = unionFind2.isConnect(edge2[1] - 1, edge2[2] - 1);
            //已经联通的节点，跳过
            if (!isConnect) {
                unionFind2.union(edge2[1] - 1, edge2[2] - 1);
            } else {
                canRemove++;
            }
        }

        if (unionFind1.getCount() != 1 || unionFind2.getCount() != 1) {
            return -1;
        }

        return canRemove;
    }

    public static void main(String[] args) {
        _1579保证图可完全遍历 instance = new _1579保证图可完全遍历();
        int[][] edges = {{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}};
        int n = 4;

        int[][] edges1 = {{3, 1, 2}, {3, 2, 3}, {1, 1, 4}, {2, 1, 4}};
        int[][] edges2 = {{3, 2, 3}, {1, 1, 2}, {2, 3, 4}};

        int[][] edges3 = {{1, 1, 2}, {2, 1, 3}, {3, 2, 4}, {3, 2, 5}, {1, 2, 6}, {3, 6, 7}, {3, 7, 8}, {3, 6, 9}, {3, 4, 10}, {2, 3, 11}, {1, 5, 12}, {3, 3, 13}, {2, 1, 10}, {2, 6, 11}, {3, 5, 13}, {1, 9, 12}, {1, 6, 8}, {3, 6, 13}, {2, 1, 4}, {1, 1, 13}, {2, 9, 10}, {2, 1, 6}, {2, 10, 13}, {2, 2, 9}, {3, 4, 12}, {2, 4, 7}, {1, 1, 10}, {1, 3, 7}, {1, 7, 11}, {3, 3, 12}, {2, 4, 8}, {3, 8, 9}, {1, 9, 13}, {2, 4, 10}, {1, 6, 9}, {3, 10, 13}, {1, 7, 10}, {1, 1, 11}, {2, 4, 9}, {3, 5, 11}, {3, 2, 6}, {2, 1, 5}, {2, 5, 11}, {2, 1, 7}, {2, 3, 8}, {2, 8, 9}, {3, 4, 13}, {3, 3, 8}, {3, 3, 11}, {2, 9, 11}, {3, 1, 8}, {2, 1, 8}, {3, 8, 13}, {2, 10, 11}, {3, 1, 5}, {1, 10, 11}, {1, 7, 12}, {2, 3, 5}, {3, 1, 13}, {2, 4, 11}, {2, 3, 9}, {2, 6, 9}, {2, 1, 13}, {3, 1, 12}, {2, 7, 8}, {2, 5, 6}, {3, 1, 9}, {1, 5, 10}, {3, 2, 13}, {2, 3, 6}, {2, 2, 10}, {3, 4, 11}, {1, 4, 13}, {3, 5, 10}, {1, 4, 10}, {1, 1, 8}, {3, 3, 4}, {2, 4, 6}, {2, 7, 11}, {2, 7, 10}, {2, 3, 12}, {3, 7, 11}, {3, 9, 10}, {2, 11, 13}, {1, 1, 12}, {2, 10, 12}, {1, 7, 13}, {1, 4, 11}, {2, 4, 5}, {1, 3, 10}, {2, 12, 13}, {3, 3, 10}, {1, 6, 12}, {3, 6, 10}, {1, 3, 4}, {2, 7, 9}, {1, 3, 11}, {2, 2, 8}, {1, 2, 8}, {1, 11, 13}, {1, 2, 13}, {2, 2, 6}, {1, 4, 6}, {1, 6, 11}, {3, 1, 2}, {1, 1, 3}, {2, 11, 12}, {3, 2, 11}, {1, 9, 10}, {2, 6, 12}, {3, 1, 7}, {1, 4, 9}, {1, 10, 12}, {2, 6, 13}, {2, 2, 12}, {2, 1, 11}, {2, 5, 9}, {1, 3, 8}, {1, 7, 8}, {1, 2, 12}, {1, 5, 11}, {2, 7, 12}, {3, 1, 11}, {3, 9, 12}, {3, 2, 9}, {3, 10, 11}};
        System.out.println(instance.maxNumEdgesToRemove(n, edges));
        System.out.println(instance.maxNumEdgesToRemove(n, edges1));
        System.out.println(instance.maxNumEdgesToRemove(n, edges2));
        System.out.println(instance.maxNumEdgesToRemove(13, edges3));
    }
}
