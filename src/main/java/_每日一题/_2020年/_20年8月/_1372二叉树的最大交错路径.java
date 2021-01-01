package _每日一题._2020年._20年8月;

import _数据结构.TreeNode;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/26 11:21
 * @description 二叉树中的最长交错路径
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 * <p>
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 * <p>
 * 请你返回给定树中最长 交错路径 的长度。
 */
public class _1372二叉树的最大交错路径 {
    /**
     * 解题思路
     * res[0]表示当前节点下一步向左走带来的最大收益，res[1]表示当前节点下一步向右走带来的最大收益
     * res[0]=1+left[1] 当前节点下一步向左走带来的最大收益等于左子节点向右走的最大收益+1
     * res[1]=1+right[0] 当前节点下一步向右走带来的最大收益等于右子节点向左走的最大收益+1
     * <p>
     * 维护一个全局变量maxPath，每次遍历某一节点时，更新它
     */
    int max_len = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max_len;
    }

    public int[] dfs(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = right[1] + 1;
        res[1] = left[0] + 1;
        max_len = Math.max(max_len, Math.max(res[0], res[1]));
        return res;
    }
}
