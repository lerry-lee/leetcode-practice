package _每日一题._2020年._20年8月;

import _数据结构.TreeNode;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/26 11:21
 * @description 二叉树中的最长交错路径
 */
public class _1372二叉树的最大交错路径 {
    /**
     * 解题思路：动态规划
     * 状态定义：
     *      res[0]表示当前节点下一步向左走带来的最大收益；
     *      res[1]表示当前节点下一步向右走带来的最大收益。
     * 状态转移：
     *      res[0]=1+left[1] 当前节点下一步向左走带来的最大收益等于左子节点向右走的最大收益+1
     *      res[1]=1+right[0] 当前节点下一步向右走带来的最大收益等于右子节点向左走的最大收益+1
     * 初始化/base case：
     *      节点为空时，res[0]=res[1]=-1，（单个节点的路径长度为0，空节点的路径长度为-1）
     * 最终返回：
     *      维护一个全局变量maxPath，每次遍历某一节点时，更新它
     */
    int max_len = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max_len;
    }

    public int[] dfs(TreeNode root) {
        int[] dp = new int[2];
        if (root == null) {
            dp[0] = -1;
            dp[1] = -1;
            return dp;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        dp[0] = right[1] + 1;
        dp[1] = left[0] + 1;
        max_len = Math.max(max_len, Math.max(dp[0], dp[1]));
        return dp;
    }

}
