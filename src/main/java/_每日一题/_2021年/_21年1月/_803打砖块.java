package _每日一题._2021年._21年1月;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _803打砖块
 * @Author: lerry_li
 * @CreateDate: 2021/01/25
 * @Description
 */
public class _803打砖块 {

    private int rows;
    private int cols;

    public static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 || hits == null || hits.length == 0 || hits[0].length == 0) {
            return new int[]{};
        }

        this.rows = grid.length;
        this.cols = grid[0].length;

        //第1步：把grid中的砖块全部打掉，首先拷贝一个数组来做
        int[][] grid_copy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid_copy[i][j] = grid[i][j];
            }
        }

        //把grid中的砖块全部打掉
        for (int[] hit : hits) {
            grid_copy[hit[0]][hit[1]] = 0;
        }

        //第2步：建图，把砖块和砖块的连接关系输入并查集，size表示二维网格的大小，ceiling表示天花板
        int size = rows * cols;
        int ceiling = size;
        UnionFind unionFind = new UnionFind(size + 1);

        //将x轴下标为0的这一行的砖块与天花板ceiling相连
        for (int col = 0; col < cols; col++) {
            if (grid_copy[0][col] == 1) {
                unionFind.union(getIndex(0, col), ceiling);
            }
        }

        //其余单元格，如果砖块的同行或同列也是砖块，则在并查集中进行联通
        for (int row = 1; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //首先得是砖块
                if (grid_copy[row][col] == 1) {
                    //如果上方也是砖块
                    if (grid_copy[row - 1][col] == 1) {
                        unionFind.union(getIndex(row - 1, col), getIndex(row, col));
                    }
                    //如果左边也是砖块
                    if (col > 0 && grid_copy[row][col - 1] == 1) {
                        unionFind.union(getIndex(row, col - 1), getIndex(row, col));
                    }
                }
            }
        }

        //第3步：按照hits逆序，在grid_copy中补回砖块，把每一次因为补回砖块而与屋顶相连的砖块的增量记录到 res 数组中
        int hitsLen = hits.length;
        int[] res = new int[hitsLen];
        for (int i = hitsLen - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];

            //注意：这里不能用grid_copy，因为对应位置已经被打掉了
            if (grid[x][y] == 0) {
                continue;
            }

            //补回之前与屋顶相连的砖块数
            int origin = unionFind.getConnectSize(ceiling);


            //注意：如果补回的这个砖块在row=0的首行，要与天花板相连
            if (x == 0) {
                unionFind.union(getIndex(0, y), ceiling);
            }

            //在上下左右四个方法看一下，如果有砖块，需要进行联通
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (inArea(newX, newY) && grid_copy[newX][newY] == 1) {
                    unionFind.union(getIndex(x, y), getIndex(newX, newY));
                }
            }

            //补回之后与屋顶相连的砖块数
            int current = unionFind.getConnectSize(ceiling);
            //减去的1是逆向补回的砖块（正向打掉的砖块）），与 0 比较大小，是因为存在一种情况，添加当前砖块，不会使得与屋顶连接的砖块数更多
            res[i] = Math.max(0, current - origin - 1);

            //真正补上这个砖块
            grid_copy[x][y] = 1;

        }

        return res;


    }


    /**
     * 输入坐标在二维网格中是否越界
     *
     * @param x
     * @param y
     * @return
     */
    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }


    /**
     * 二维坐标转换为一维坐标
     *
     * @param x
     * @param y
     * @return
     */
    private int getIndex(int x, int y) {
        return x * cols + y;
    }


    class UnionFind {
        private int[] parent;

        private int[] size;

        private int count;


        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
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
            if (size[rootX] > size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
            count--;
        }

        public int getCount() {
            return this.count;
        }

        public int getConnectSize(int n) {
            int root = find(n);
            return size[root];
        }

    }
}
