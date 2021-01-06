package _每日一题._2021年._21年1月;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: _399除法求值
 * @Author: lerry_li
 * @CreateDate: 2021/01/06
 * @Description
 */
public class _399除法求值 {
    /**
     * 解法1：并查集
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // 第1步：预处理
        // 将变量的值与id进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            // 取出变量1、变量2
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);
            // 若变量1没有被映射为id，则进行映射
            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            // 若变量2没有被映射为id，则进行映射
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            // 将变量1和变量2进行联通，根据表达式：var1/var2=values[i]
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // 第2步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            // 取出变量1、变量2
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            // 拿到对应的id，方便去并查集里查询
            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);
            // 若id不存在，说明是不确定的表达式，结果设置为-1.0
            if (id1 == null || id2 == null) {
                res[i] = -1.0;
            } else {
                // 否则，查询变量1、变量2的联通关系，返回他们的边权值(即var1=?var2)
                res[i] = unionFind.isConnected(id1, id2);
            }
        }

        return res;

    }

    private class UnionFind {
        private int[] parent;

        /**
         * 结点指向父节点的权值
         */
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = findRoot(x);
            int rootY = findRoot(y);
            // 若根节点相同，表示已经联通
            if (rootX == rootY) {
                return;
            }
            // 否则，将x的根节点指向y的根节点
            parent[rootX] = rootY;
            // 推导过程见题图解
            weight[rootX] = weight[y] * value / weight[x];
        }

        /**
         * 路径压缩
         */
        public int findRoot(int x) {
            if (x != parent[x]) {
                // x的父节点
                int origin = parent[x];
                // x的父节点变成x的根节点
                parent[x] = findRoot(parent[x]);
                // 权值乘上父节点的权值
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = findRoot(x);
            int rootY = findRoot(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(1.0d);
    }
}
