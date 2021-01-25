package _每日一题._2021年._21年1月;

import _数据结构.UnionFind;

/**
 * @ClassName: _959由斜杠划分区域
 * @Author: lerry_li
 * @CreateDate: 2021/01/25
 * @Description
 */
public class _959由斜杠划分区域 {
    /**
     * 解法1：并查集 时间(N^2*logN) 空间(N^2)
     * 思路：
     * 将一个单元格看作4个三角形节点，初始化并查集的节点个数为整个网络中三角形节点的个数
     */
    public int regionsBySlashes(String[] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        //并查集的节点的个数，一个单元格分成4个三角形
        int size = 4 * n * n;
        //初始化并查集
        UnionFind unionFind = new UnionFind(size);
        //遍历单元格
        for (int i = 0; i < n; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                //当前单元格的三角形节点的编号，第一个三角形节点
                int node = 4 * (i * n + j);
                //当前单元格的图案
                char c = row[j];

                //1. 单元格内合并
                //若为'/'，则节点0和3合并，节点1和2合并
                if (c == '/') {
                    unionFind.union(node, node + 3);
                    unionFind.union(node + 1, node + 2);
                }
                //若为'\'，则节点0和1合并，节点2和3合并
                else if (c == '\\') {
                    unionFind.union(node, node + 1);
                    unionFind.union(node + 2, node + 3);
                }
                //若为空格，则节点0、1、2、3合并
                else {
                    unionFind.union(node, node + 1);
                    unionFind.union(node + 1, node + 2);
                    unionFind.union(node + 2, node + 3);
                }

                //2. 单元格间合并
                //向右合并，当前单元格的节点1和右侧单元格的节点3合并
                if (j + 1 < n) {
                    unionFind.union(node + 1, 4 * (i * n + j + 1) + 3);
                }
                //向下合并，当前单元格的节点2和下侧单元格的节点0合并
                if (i + 1 < n) {
                    unionFind.union(node + 2, 4 * ((i + 1) * n + j));
                }
            }
        }

        return unionFind.getCount();
    }
}
