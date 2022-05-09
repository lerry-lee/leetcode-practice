package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/09
 */
public class _547_省份数量 {
    /**
     * 解法1：并查集 时间O(N^2logN) 空间O(N)
     */
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            //特判
            if (isConnected == null || isConnected.length == 0) return 0;
            //并查集
            int n = isConnected.length;
            UnionFind UF = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if(isConnected[i][j]==1)UF.union(i, j);
                }
            }
            return UF.getCount();
        }
    }

    class UnionFind {
        private int n;
        private int[] parent;
        private int[] size;
        private int count;

        public UnionFind(int n) {
            this.n = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            this.count = n;
        }

        public void union(int x, int y) {
            int rootX = findRoot(x), rootY = findRoot(y);
            if (rootX == rootY) return;
            if (size[rootX] > size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
            count--;
        }

        public int findRoot(int x) {
            while (x != parent[x]) {
                x = parent[x];
            }
            return x;
        }

        public int getCount() {
            return count;
        }
    }
}
