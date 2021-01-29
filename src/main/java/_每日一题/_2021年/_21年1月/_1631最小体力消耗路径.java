package _每日一题._2021年._21年1月;

import java.util.*;

/**
 * @ClassName: _1631最小体力消耗路径
 * @Author: lerry_li
 * @CreateTime: 2021/01/29
 * @Description
 */
public class _1631最小体力消耗路径 {
    /**
     * 解法1：回溯（超时）
     */
    public int minimumEffortPath(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] visited = new boolean[rows][cols];

        minCost = Integer.MAX_VALUE;

        dfs(heights, visited, rows, cols, 0, 0, 0);

        return minCost;

    }

    int minCost;

    public void dfs(int[][] heights, boolean[][] visited, int rows, int cols, int row, int col, int cost) {
        if (minCost == 0 || cost > minCost) {
            return;
        }
        if (row == rows - 1 && col == cols - 1) {
            minCost = Math.min(minCost, cost);
            return;
        }
        //向左
        if (row > 0 && !visited[row - 1][col]) {
            visited[row - 1][col] = true;
            dfs(heights, visited, rows, cols, row - 1, col, Math.max(cost, Math.abs(heights[row][col] - heights[row - 1][col])));
            visited[row - 1][col] = false;
        }
        //向右
        if (row < rows - 1 && !visited[row + 1][col]) {
            visited[row + 1][col] = true;
            dfs(heights, visited, rows, cols, row + 1, col, Math.max(cost,
                    Math.abs(heights[row][col] - heights[row + 1][col])));
            visited[row + 1][col] = false;
        }
        //向上
        if (col > 0 && !visited[row][col - 1]) {
            visited[row][col - 1] = true;
            dfs(heights, visited, rows, cols, row, col - 1, Math.max(cost,
                    Math.abs(heights[row][col] - heights[row][col - 1])));
            visited[row][col - 1] = false;
        }
        //向下
        if (col < cols - 1 && !visited[row][col + 1]) {
            visited[row][col + 1] = true;
            dfs(heights, visited, rows, cols, row, col + 1, Math.max(cost,
                    Math.abs(heights[row][col] - heights[row][col + 1])));
            visited[row][col + 1] = false;
        }
    }

    /**
     * 解法2：最短路径(超时)
     */
    public int minimumEffortPath2(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] visited = new boolean[rows][cols];

        List<int[]> minSet = new ArrayList<>();

        //先加入出发点（0,0）及其路径
        minSet.add(new int[]{0, 0, 0});
        visited[0][0] = true;
        //不到终点不停
        while (true) {
            int currCost = Integer.MAX_VALUE;
            int currX = -1, currY = -1;
            //遍历最小集合
            for (int[] xy : minSet) {
                //取出坐标
                int x = xy[0];
                int y = xy[1];
                int v = xy[2];
                int tempCost = Integer.MAX_VALUE;
                int tempX = x, tempY = y;
                //遍历四周可访问的节点，计算最短路径
                if (x > 0 && !visited[x - 1][y]) {
                    int tempV = Math.max(v, Math.abs(heights[x][y] - heights[x - 1][y]));
                    if (tempCost > tempV) {
                        tempCost = tempV;
                        tempX = x - 1;
                        tempY = y;
                    }
                }
                if (x < rows - 1 && !visited[x + 1][y]) {
                    int tempV = Math.max(v, Math.abs(heights[x][y] - heights[x + 1][y]));
                    if (tempCost > tempV) {
                        tempCost = tempV;
                        tempX = x + 1;
                        tempY = y;
                    }
                }
                if (y > 0 && !visited[x][y - 1]) {
                    int tempV = Math.max(v, Math.abs(heights[x][y] - heights[x][y - 1]));
                    if (tempCost > tempV) {
                        tempCost = tempV;
                        tempX = x;
                        tempY = y - 1;
                    }
                }
                if (y < cols - 1 && !visited[x][y + 1]) {
                    int tempV = Math.max(v, Math.abs(heights[x][y] - heights[x][y + 1]));
                    if (tempCost > tempV) {
                        tempCost = tempV;
                        tempX = x;
                        tempY = y + 1;
                    }
                }
                if (currCost > tempCost) {
                    currCost = tempCost;
                    currX = tempX;
                    currY = tempY;
                }
            }
            if (currX == -1 && currY == -1) {
                return 0;
            }
            if (currX == rows - 1 && currY == cols - 1) {
                return currCost;
            }
            minSet.add(new int[]{currX, currY, currCost});
            visited[currX][currY] = true;
        }

    }

    /**
     * 解法3：并查集
     *
     * 思路：
     * 把所有的单元格看成顶点，相邻单元格的距离看作一条有权值的边，然后构造图中所有的边，升序排列后依次加入并查集，直到出发点和中点联通
     *
     * 复杂度：
     *
     * （1）时间复杂度：O(mnlog(mn))，
     * 其中 m 和 n 分别是地图的行数和列数。图中的边数为 O(mn)，
     * 因此排序的时间复杂度为O(mnlog(mn))。
     * 并查集的时间复杂度为 O(mn⋅α(mn))，其中α为阿克曼函数的反函数。
     * 由于后者在渐进意义下小于前者，因此总时间复杂度为O(mnlog(mn))。
     *
     * （2）空间复杂度：O(mn)，即为存储所有边以及并查集需要的空间。
     */
    public int minimumEffortPath3(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        //将单元格看成一个顶点，相邻顶点之间的距离看作一条边
        //构造图中所有的边
        List<int[]> edges = new ArrayList<int[]>();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                int index = i * cols + j;
//                //当前节点和上边节点的边
//                if (i > 0) {
//                    int up = (i - 1) * n + j;
//                    edges.add(new int[]{up, index, Math.abs(heights[i][j] - heights[i - 1][j])});
//                }
//                //当前节点和左边节点的边
//                if (j > 0) {
//                    int left = i * n + j - 1;
//                    edges.add(new int[]{left, index, Math.abs(heights[i][j] - heights[i][j - 1])});
//                }
                //当前节点和下边节点的边
                if (i < rows - 1) {
                    int up = (i + 1) * cols + j;
                    edges.add(new int[]{up, index, Math.abs(heights[i][j] - heights[i + 1][j])});
                }
                //当前节点和右边节点的边
                if (j < cols - 1) {
                    int left = i * cols + j + 1;
                    edges.add(new int[]{left, index, Math.abs(heights[i][j] - heights[i][j + 1])});
                }
            }
        }
        edges.sort(new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });

        UnionFind uf = new UnionFind(rows * cols);
        int ans = 0;
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], v = edge[2];
            uf.union(x, y);
            if (uf.isConnected(0, rows * cols - 1)) {
                ans = v;
                break;
            }
        }
        return ans;
    }


    // 并查集模板
    class UnionFind {
        int[] parent;
        int[] size;
        //        int n;
        // 当前连通分量数目
        int count;

        public UnionFind(int n) {
//            this.n = n;
            this.count = n;
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            count--;
        }

        public boolean isConnected(int x, int y) {
            x = find(x);
            y = find(y);
            return x == y;
        }

    }


    public static void main(String[] args) {
        _1631最小体力消耗路径 instance = new _1631最小体力消耗路径();
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        int[][] heights1 = {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};
        int[][] heights2 = {{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};
        int[][] heights3 = {{1, 10, 6, 7, 9, 10, 4, 9}};
        System.out.println(instance.minimumEffortPath2(heights));
        System.out.println(instance.minimumEffortPath2(heights1));
        System.out.println(instance.minimumEffortPath2(heights2));
        System.out.println(instance.minimumEffortPath2(heights3));
    }

}
