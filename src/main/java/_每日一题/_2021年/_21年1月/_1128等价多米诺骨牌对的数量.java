package _每日一题._2021年._21年1月;

import _数据结构.UnionFind;

import java.util.*;

/**
 * @ClassName: _1128等价多米诺骨牌对的数量
 * @Author: lerry_li
 * @CreateDate: 2021/01/26
 * @Description
 */
public class _1128等价多米诺骨牌对的数量 {
    /**
     * 解法1：哈希表 时间O(N) 空间(N)
     * 思路：
     * 由于牌上的数字为0～9，因此将x/y乘上10可以将(x,y)变成一个唯一的数字。
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        if (dominoes == null || dominoes.length == 0 || dominoes[0].length == 0) {
            return 0;
        }
        int n = dominoes.length;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int[] curr : dominoes) {
            int x = curr[0];
            int y = curr[1];
            int mapKey = x > y ? (x * 10 + y) : (x + y * 10);
            hashMap.put(mapKey, hashMap.getOrDefault(mapKey, 0) + 1);
        }
        int res = 0;
        for (int key : hashMap.keySet()) {
            int pairs = hashMap.get(key);
            if (pairs > 1) {
                res += (pairs * (pairs - 1)) / 2;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        _1128等价多米诺骨牌对的数量 instance = new _1128等价多米诺骨牌对的数量();
        int[][] dominoes = {{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}};
        System.out.println(instance.numEquivDominoPairs(dominoes));
    }
}
