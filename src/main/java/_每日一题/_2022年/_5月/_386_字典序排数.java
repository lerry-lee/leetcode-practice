package _每日一题._2022年._5月;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/12
 * @Description
 */
public class _386_字典序排数 {
    /**
     * 解法1：递归（10叉树） 时间O(N) 空间O(1)忽略栈开销
     */
    class Solution {
        List<Integer> res;

        public List<Integer> lexicalOrder(int n) {
            res = new ArrayList<>();
            if (n < 1) return res;
            for (int i = 1; i <= 9; i++) {
                dfs(n, i);
            }
            return res;
        }

        private void dfs(int n, int cur) {
            if (cur > n) return;
            res.add(cur);
            for (int i = 0; i <= 9; i++) {
                dfs(n, cur * 10 + i);
            }
        }
    }
}
