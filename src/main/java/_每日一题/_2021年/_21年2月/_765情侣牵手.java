package _每日一题._2021年._21年2月;

import _数据结构.UnionFind;

/**
 * @ClassName: _765情侣牵手
 * @Author: lerry_li
 * @CreateTime: 2021/02/14
 * @Description
 */
public class _765情侣牵手 {
    /**
     * 解法1：并查集 时间O(NlogN) 空间O(N)
     * 思路：
     * 如果一对情侣恰好坐在了一起，并且坐在了成组的座位上，
     * 其中一个下标一定是偶数，另一个一定是奇数，并且「偶数的值 + 1 = 奇数的值」。
     * 例如编号数对 [2, 3]、[9, 8]，这些数对的特点是除以 2（下取整）得到的数相等。
     *
     */
    public int minSwapsCouples(int[] row) {
        if(row==null||row.length==0){
            return 0;
        }
        int len = row.length;
        int N = len / 2;
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < len; i += 2) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return N - unionFind.getCount();
    }
}
