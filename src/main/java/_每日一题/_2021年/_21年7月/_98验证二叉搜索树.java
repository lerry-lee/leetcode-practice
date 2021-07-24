package _每日一题._2021年._21年7月;

import _数据结构.TreeNode;

/**
 * @ClassName: _98验证二叉搜索树
 * @Author: lerry_li
 * @CreateDate: 2021/07/24
 * @Description
 */
public class _98验证二叉搜索树 {
    /**
     * 解法1：递归
     * 解法2：中序遍历
     */
    public boolean isValidBST(TreeNode root) {
        return check(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean check(TreeNode root, int maxValue, int minValue) {
        if (root == null) return true;
        if (root.val >= maxValue || root.val <= minValue) return false;
        return check(root.left, root.val, minValue) && check(root.right, maxValue, root.val);
    }
}
