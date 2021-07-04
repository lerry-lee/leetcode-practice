package _每日一题._2021年._21年7月;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName: _LCP07传递信息
 * @Author: lerry_li
 * @CreateDate: 2021/07/04
 * @Description
 * 解法1：dfs
 * 解法2：dp
 */
public class _LCP07传递信息 {

    public static void main(String[] args) {
        _LCP07传递信息 instance = new _LCP07传递信息();
        int[][] relation = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        int[][] relation1 = {{0, 2}, {2, 1}};
        System.out.println(instance.numWays(3,relation1,2));
    }

    /**
     * 解法1：dfs
     */
    public int numWays(int n, int[][] relation, int k) {
        //特判
        if (n <= 0 || relation == null || relation.length == 0 || relation[0].length == 0 || k <= 0) return 0;
        adj = new HashMap<>();
        for (int[] relationI : relation) {
            HashSet<Integer> hashSet = adj.getOrDefault(relationI[0], new HashSet<>());
            hashSet.add(relationI[1]);
            adj.put(relationI[0], hashSet);
        }
        N = n;
        res = 0;
        dfs(0, k);
        return res;
    }

    private void dfs(int num, int k) {
        if (k == 0) {
            if (num == N - 1) res++;
            return;
        }
        if(!adj.containsKey(num)) return;
        //枚举所有可以达到的节点
        for (int nextNum : adj.get(num)) {
            dfs(nextNum, k - 1);
        }
    }

    int res;
    int N;
    Map<Integer, HashSet<Integer>> adj;

    /**
     * 解法2：dp
     */
    public int numWays2(int n, int[][] relation, int k) {
        //定义：
        //dp[i][j]表示经过i轮传递编号到j玩家的方案数
        int[][] f = new int[k + 1][n];
        //初始化
        f[0][0] = 1;
        //状态转移：
        //枚举k轮
        for (int i = 1; i <= k; i++) {
            //枚举所有可达关系
            for (int[] relationI : relation) {
                //a为出发编号，b为达到编号
                int a = relationI[0], b = relationI[1];
                //经过i轮，达到编号b的方案数为：
                //所以出发编号的总和
                f[i][b] += f[i - 1][a];
            }
        }
        //最终返回经过k轮到达编码n-1玩家的方案数
        return f[k][n - 1];
    }

}
