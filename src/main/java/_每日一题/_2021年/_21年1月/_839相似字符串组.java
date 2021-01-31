package _每日一题._2021年._21年1月;

import _数据结构.UnionFind;


/**
 * @ClassName: _839相似字符串组
 * @Author: lerry_li
 * @CreateDate: 2021/01/31
 * @Description
 */
public class _839相似字符串组 {
    /**
     * 解法1：并查集 时间O(N^2logN+M) N为字符串个数，M为字符串长度 空间O(N)
     * 思路：
     * 把每一个字符串看作点，字符串之间是否相似看作边，本题即为求给定的图中有多少连通分量。于是可以使用并查集维护节点间的连通性。
     *
     * 枚举给定序列中的任意一对字符串，检查其是否具有相似性，如果相似，将这对字符串相连。
     *
     * tips：首先判断当前这对字符串是否已经连通，如果没有连通，再检查它们是否具有相似性，可以优化一定的时间复杂度的常数。
     *
     */
    public int numSimilarGroups(String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int n = strs.length;
        int len = strs[0].length();
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (unionFind.isConnect(i, j)) {
                    continue;
                }
                String str1 = strs[i], str2 = strs[j];
                int cnt = 0;
                for (int k = 0; k < len; k++) {
                    if (str1.charAt(k) != str2.charAt(k)) {
                        cnt++;
                    }
                }
                if (cnt == 0 || cnt == 2) {
                    unionFind.union(i, j);
                }
            }
        }

        return unionFind.getCount();
    }

    public static void main(String[] args) {
        _839相似字符串组 instance = new _839相似字符串组();
        String[] strs = {"tars", "rats", "arts", "star"};
        String[] strs1 = {"omv", "ovm"};
        String[] strs2 = {"bca", "acb", "abc", "abc"};
        String[] strs3 = {"ajdidocuyh", "djdyaohuic", "ddjyhuicoa", "djdhaoyuic", "ddjoiuycha", "ddhoiuycja", "ajdydocuih", "ddjiouycha", "ajdydohuic", "ddjyouicha"};
        System.out.println(instance.numSimilarGroups(strs));
        System.out.println(instance.numSimilarGroups(strs1));
        System.out.println(instance.numSimilarGroups(strs2));
        System.out.println(instance.numSimilarGroups(strs3));
    }
}
