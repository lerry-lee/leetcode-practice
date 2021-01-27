package _数据结构;

/**
 * @ClassName: UnionFind
 * @Author: lerry_li
 * @CreateDate: 2021/01/24
 * @Description
 */
public class UnionFind {
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
            //路径压缩
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
        //按秩合并
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

    public int getSize(int index) {
        return size[index];
    }

    public boolean isConnect(int x, int y) {
        return find(x) == find(y);
    }
}
