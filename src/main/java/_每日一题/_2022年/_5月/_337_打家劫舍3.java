package _每日一题._2022年._5月;

import _数据结构.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/12
 * @Description
 */
public class _337_打家劫舍3 {
    /**
     * 解法1：带备忘录的递归
     */
    class Solution {
        Map<TreeNode, Map<Boolean, Integer>> memo;

        public int rob(TreeNode root) {
            memo = new HashMap<>();
            return dfs(root, true);
        }

        private int dfs(TreeNode root, boolean canStole) {
            if (root == null) return 0;
            if (memo.containsKey(root) && memo.get(root).containsKey(canStole)) {
                return memo.get(root).get(canStole);
            }
            int res = dfs(root.left, true) + dfs(root.right, true);
            if (canStole) {
                res = Math.max(res, root.val + dfs(root.left, false) + dfs(root.right, false));
            }
            HashMap<Boolean, Integer> hashMap = new HashMap<>();
            hashMap.put(canStole, res);
            memo.put(root, hashMap);
            return res;
        }
    }

    /**
     * 解法2：树形dp
     */
    class Solution2 {
        public int rob(TreeNode root) {
            int[] rootStatus = dfs(root);
            return Math.max(rootStatus[0], rootStatus[1]);
        }

        //int[0]表示不偷，int[1]表示偷
        public int[] dfs(TreeNode node) {
            if (node == null) {
                return new int[]{0, 0};
            }
            int[] l = dfs(node.left);
            int[] r = dfs(node.right);
            int selected = node.val + l[0] + r[0];
            int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
            return new int[]{notSelected, selected};
        }
    }
}
