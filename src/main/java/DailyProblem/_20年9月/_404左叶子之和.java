package DailyProblem._20年9月;

import DataStructure.TreeNode;

/**
 * @ClassName : _404左叶子之和
 * @CreateTime : 2020/09/19 09
 * @Author : lerry_li
 * @Descrpition : 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class _404左叶子之和 {
    /**
     * 解法1：简单递归
     * 空节点返回0，叶节点返回值
     * 遇到左子结点->递归计算，遇到非空且非叶的右子节点->递归计算
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || isLeaf(root)) return 0;
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        if (isLeaf(root)) {
            return root.val;
        }
        int sum = 0;
        sum += dfs(root.left);
        if (root.right != null && !isLeaf(root.right)) sum += dfs(root.right);
        return sum;
    }

    public boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null) return true;
        return false;
    }
}
