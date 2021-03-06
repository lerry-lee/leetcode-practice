package _每日一题._2020年._20年9月;


import _数据结构.TreeNode;

/**
 * @ClassName : _226翻转二叉树
 * @CreateTime : 2020/09/16 14
 * @Author : lerry_li
 * @Descrpition : 翻转二叉树
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 */
public class _226翻转二叉树 {
    /**
     * 解法1：简单递归
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        reverseChild(root);
        return root;
    }

    public void reverseChild(TreeNode root) {
        if (root.left != null) reverseChild(root.left);
        if (root.right != null) reverseChild(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
