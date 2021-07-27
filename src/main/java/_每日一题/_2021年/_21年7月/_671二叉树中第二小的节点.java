package _每日一题._2021年._21年7月;

import _数据结构.TreeNode;

import java.util.Stack;

/**
 * @ClassName: _671二叉树中第二小的节点
 * @Author: lerry_li
 * @CreateDate: 2021/07/27
 * @Description
 */
public class _671二叉树中第二小的节点 {
    /**
     * 解法1：dfs
     * 思路：
     *      找到比根节点的值大的里面最小的
     */
    public int findSecondMinimumValue(TreeNode root) {
        //特判
        if (root == null) return -1;
        res = Long.MAX_VALUE;
        rootVal = root.val;
        dfs(root);
        return res == Long.MAX_VALUE ? -1 : (int) res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.val > rootVal) {
            res = Math.min(res, root.val);
        }
        dfs(root.left);
        dfs(root.right);
    }

    int rootVal;
    long res;
}
