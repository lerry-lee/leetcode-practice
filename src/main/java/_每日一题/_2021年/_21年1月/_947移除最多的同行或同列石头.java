package _每日一题._2021年._21年1月;

import _数据结构.UnionFind;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _947移除最多的同行或同列石头
 * @Author: lerry_li
 * @CreateDate: 2021/01/25
 * @Description
 */
public class _947移除最多的同行或同列石头 {
    /**
     * 解法1：并查集
     * 要点：
     * 1. 一定可以把一个连通图里的所有顶点根据这个规则删到只剩下一个顶点；
     * 2. 最多可以移除的石头的个数 = 所有石头的个数 - 连通分量的个数。
     * 难点：
     * 1. 并查集里如何区分横纵坐标？
     * 2. 在并查集里我们需要维护连通分量的个数，新创建顶点的时候连通分量加 11；合并不在同一个连通分量中的两个并查集的时候，连通分量减 11。
     */
    public int removeStones(int[][] stones) {
        if (stones == null || stones.length == 0 || stones[0].length == 0) {
            return 0;
        }

        UnionFind unionFind = new UnionFind();

        for (int[] stone : stones) {
            //横坐标不能和纵坐标相同
            unionFind.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - unionFind.getCount();

    }

    private class UnionFind {

        private Map<Integer, Integer> parent;
        private int count;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                // 并查集集中新加入一个结点，结点的父亲结点是它自己，所以连通分量的总数 +1
                count++;
            }

            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent.put(rootX, rootY);
            // 两个连通分量合并成为一个，连通分量的总数 -1
            count--;
        }
    }


    public static void main(String[] args) {
        _947移除最多的同行或同列石头 instance = new _947移除最多的同行或同列石头();
        int[][] stones1 = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        int[][] stones2 = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
        System.out.println(instance.removeStones(stones1));
        System.out.println(instance.removeStones(stones2));
    }
}
