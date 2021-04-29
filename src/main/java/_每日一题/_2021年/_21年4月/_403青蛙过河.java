package _每日一题._2021年._21年4月;

import java.util.HashMap;

/**
 * @ClassName: _403青蛙过河
 * @Author: lerry_li
 * @CreateDate: 2021/04/29
 * @Description
 * 解法1：dfs+备忘录
 */
public class _403青蛙过河 {

    public static void main(String[] args) {
        _403青蛙过河 instance = new _403青蛙过河();
        System.out.println(instance.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        System.out.println(instance.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }

    /**
     * 解法1：dfs+备忘录 时间O(N^2-N^3) 空间O(N) 最差(N^3,找下一格子的时候遍历,改成二分可优化到N^2logN)
     */
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) return false;
        if (stones.length == 1) return true;
        if (stones[1] - stones[0] != 1) return false;
        //备忘录初始化
        memo = new int[stones.length][stones.length];
        //递归回溯计算
        return dfs(stones, 0, 1);
    }

    //备忘录，记录从lastIdx跳跃到idx的结果
    int[][] memo;

    private boolean dfs(int[] stones, int lastIdx, int idx) {
        //到最后一格，返回true
        if (idx == stones.length - 1) {
            return true;
        }
        //检查备忘录
        if (memo[lastIdx][idx] != 0) {
            return false;
        }
        //上次跳跃的步数
        int k = stones[idx] - stones[lastIdx];
        //枚举解法
        int i = idx + 1;
        for (; i < stones.length; i++) {
            int cur = stones[i] - stones[idx];
            if (cur < k - 1) {
                continue;
            } else if (cur > k + 1) {
                break;
            } else {
                boolean flag = dfs(stones, idx, i);
                if (flag) {
                    return true;
                } else {
                    //记录子问题结果
                    //加入备忘录
                    memo[idx][i] = -1;
                }
            }
        }
        return false;
    }
}
