package _每日一题._2021年._21年3月;

import _数据结构.TreeNode;

/**
 * @ClassName: _124二叉树中的最大路径和
 * @Author: lerry_li
 * @CreateDate: 2021/03/26
 * @Description
 */
public class _124二叉树中的最大路径和 {
    /**
     * 解法1：递归
     */
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //递归计算左子结点和右子节点的最大贡献值
        int left = Math.max(0, dfs(root.left));//9
        int right = Math.max(0, dfs(root.right));//20+15=35
        //更新最大路径，这一行代码保证了可以只选子节点而不走父节点（因为递归计算子节点的过程中，left+right+root.val是子节点的val和子节点的子节点）
        res = Math.max(res, left + right + root.val);//(res,9+35-10)
        //返回当前节点走左子结点/右子节点的最大路径和，只能从左/右选择一个走，不然上层就不能走到该路径了
        return Math.max(left, right) + root.val;//(9-10,35-10)
    }
}
