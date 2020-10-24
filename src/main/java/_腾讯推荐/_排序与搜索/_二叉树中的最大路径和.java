package _腾讯推荐._排序与搜索;

import _数据结构.TreeNode;

/**
 * Created by lerry_li on 2020/10/24
 */

/**
 * 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 */
public class _二叉树中的最大路径和 {
    /**
     * 解法1：递归
     */
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;

    }

    int res;

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        res = Math.max(res, left + right + root.val);

        // 返回节点的最大贡献值
        //这里为什么只能选择左子树/右子树呢？
        //因为题目要求是路径，如果左右都选了：左中右，那么再往上走就没办法走了，相当于只能往左子树下面/右子树下面走了
        return root.val + Math.max(left, right);
    }
}
