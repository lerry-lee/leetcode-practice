package _每日一题._2021年._21年1月;

/**
 * @ClassName: _547省份数量
 * @Author: lerry_li
 * @CreateDate: 2021/01/07
 * @Description
 */
public class _547省份数量 {
    /**
     * 解法1：并查集
     * 解法2：dfs
     */
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) {
            return 0;
        }
        int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getCount();
    }


    public int findCircleNum2(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) {
            return 0;
        }
        int n = isConnected.length;
        int res = 0;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && !visited[i][j]) {
                    res++;
                    dfs(isConnected, visited, n, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] isConnected, boolean[][] visited, int n, int i, int j) {
        if (i < 0 || i == n || j < 0 || j == n || visited[i][j]) {
            return;
        }
        if (isConnected[i][j] == 1) {
            visited[i][j] = true;
            for (int k = 0; k < n; k++) {
                if (k != j && isConnected[i][k] == 1) {
                    dfs(isConnected, visited, n, i, k);
                }
            }
            for (int k = 0; k < n; k++) {
                if (k != i && isConnected[k][j] == 1) {
                    dfs(isConnected, visited, n, k, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        _547省份数量 instance = new _547省份数量();
        int[][] isConnected = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(instance.findCircleNum2(isConnected));
    }

    private class UnionFind {
        // 子集个数
        private Integer count;
        // 节点的父节点
        private int[] parent;
        // 节点所在集合的大小
        private int[] size;

        // 初始化n个节点
        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        // 寻找root节点
        public int findRoot(int x) {
            while (x != parent[x]) {
                x = parent[x];
            }
            return x;
        }

        // 联通
        public void union(int x, int y) {
            int rootX = findRoot(x);
            int rootY = findRoot(y);
            if (rootX == rootY) {
                return;
            }
            // 执行路径压缩,小集合的根节点连到大集合的根节点上
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }

            this.count--;
        }

        //  联通的子集的个数
        public int getCount() {
            return this.count;
        }
    }
}
