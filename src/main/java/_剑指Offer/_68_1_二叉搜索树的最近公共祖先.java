package _剑指Offer;

import _数据结构.TreeNode;

/**
 * @ClassName: _68_1_二叉搜索树的最近公共祖先
 * @Signature: Created by lerry_li on 2020/11/13
 * @Description:
 */
public class _68_1_二叉搜索树的最近公共祖先 {
    /**
     * 解法1：哈希表
     * 解法2：递归
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if (p == q) {
            return p;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
