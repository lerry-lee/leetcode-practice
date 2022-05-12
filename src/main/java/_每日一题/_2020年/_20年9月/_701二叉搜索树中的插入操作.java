package _每日一题._2020年._20年9月;

import _数据结构.TreeNode;

/**
 * Created by lerry_li on 2020/09/30
 */
public class _701二叉搜索树中的插入操作 {
    /**
     * 解法1：递归
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) root.right = insertIntoBST(root.right, val);
        else root.left = insertIntoBST(root.left, val);
        return root;
    }

    /**
     * 解法2：迭代
     */
    public TreeNode insertIntoBST_(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode node = root;
        while (node != null) {
            if (node.val < val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                }
                node = node.right;
            } else {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                }
                node = node.left;
            }
        }
        return root;
    }
}
