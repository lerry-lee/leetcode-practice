package _每日一题._2022年._5月;

import _数据结构.TreeNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/12
 * @Description
 */
public class _98_验证二叉搜索树 {
    /**
     * 解法1：设置最大值/最小值，递归搜索 时间O(N) 空间O(N)递归栈开销
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean dfs(TreeNode root, long minValue, long maxValue) {
            if (root == null) return true;
            if (root.val < maxValue && root.val > minValue) {
                return dfs(root.left, minValue, root.val) && dfs(root.right, root.val, maxValue);
            }
            return false;
        }
    }


    /**
     * 解法2：中序遍历（判断是否为升序排列）
     */
    class Solution2 {
        boolean res;
        TreeNode prev;

        public boolean isValidBST(TreeNode root) {
            res = true;
            prev = null;
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null || !res) return;
            dfs(root.left);
            if (prev != null) {
                if (prev.val >= root.val) {
                    res = false;
                    return;
                }
            }
            prev = root;
            dfs(root.right);
        }
    }
}
