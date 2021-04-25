package _每日一题._2021年._21年4月;

import _数据结构.TreeNode;

/**
 * @ClassName: _897递增顺序搜索树
 * @Author: lerry_li
 * @CreateTime: 2021/04/25
 * @Description
 */
public class _897递增顺序搜索树 {
    /**
     * 解法1：中序遍历(递归) 时间O(N) 空间O(N)
     */
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return newRoot;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
//        TreeNode left = root.left, right = root.right;
        dfs(root.left);
        if (newRoot == null) {
            newRoot = root;
        } else {
            root.left = null;
//            root.right = null;
            prev.right = root;
        }
        prev = root;
        dfs(root.right);
    }

    TreeNode newRoot;
    TreeNode prev;
}
