package _字节跳动推荐._数组与排序;

import java.util.Arrays;

/**
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 示例 2:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 */
public class _朋友圈 {
    /**
     * 并查集算法：时间复杂度O(n)，外部遍历O(n^2),总共O(n^3)，路径压缩优化可以达到O(n^2)
     *
     */
    public int findCircleNum(int[][] M) {
        UF uf = new UF(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.getCount();
    }

    class UF {
        int[] parent;
        int count;
        int[] size;

        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            count = n;
        }

        public int findRoot(int x) {
            while (parent[x] != x) x = parent[x];
            return x;
        }

        public void union(int i, int j) {
            if (findRoot(i) == findRoot(j)) return;
            int root_i = findRoot(i);
            int root_j = findRoot(j);
            if (size[root_i] < size[root_j]) {
                parent[root_i] = root_j;
                size[root_j] += size[root_i];
            } else {
                parent[root_j] = root_i;
                size[root_i] += size[root_j];
            }

            count--;
        }

        public int getCount() {
            return count;
        }
    }



    //DFS/BFS O(n^2)
    public int findCircleNum_dfs(int[][] M){
        boolean[] can_visit=new boolean[M.length];
        Arrays.fill(can_visit,true);
        int count=0;
        for(int i=0;i<M.length;i++){
            if(can_visit[i]){
                dfs(M,i,can_visit);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] M,int i,boolean[] can_visit){
        for(int j=0;j<M.length;j++){
            if(can_visit[j]&&M[i][j]==1){
                can_visit[j]=false;
                dfs(M,j,can_visit);
            }
        }
    }

}

