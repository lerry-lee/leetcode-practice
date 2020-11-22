package DailyExercises._20年10月;

import DataStructure.TreeNode;


/**
 * Created by lerry_li on 2020/10/12
 */

/**
 * 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */
public class _530二叉搜索树的最小绝对差 {
    /**
     * 解法1：利用二叉搜索树的性质，最小差值=min(当前节点和其左子树的最右叶节点的差值，当前节点和其右子树的最左叶节点的差值）
     * 时间O(nlogn) 空间O(n)?  logn表示树的深度
     */
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return minDiff;
    }

    int minDiff = Integer.MAX_VALUE;

    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            TreeNode node = root.left;
            while (node.right != null) node = node.right;
            minDiff = Math.min(minDiff, Math.abs(root.val - node.val));
        }
        if (root.right != null) {
            TreeNode node = root.right;
            while (node.left != null) node = node.left;
            minDiff = Math.min(minDiff, Math.abs(root.val - node.val));
        }
        dfs(root.left);
        dfs(root.right);
    }

    /**
     * 解法2：中序遍历得到的升序数组，最小差值一定是相邻两个元素的差值
     * 在中序遍历过程中找到最小值
     * 时间O(n) 空间O(n)
     */
    int pre = Integer.MAX_VALUE;
    int cnt = 0;
    int res = Integer.MAX_VALUE;

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        cnt = root.val;
        if (pre != Integer.MAX_VALUE) {
            res = Math.min(res, Math.abs(cnt - pre));
        }
        pre = cnt;
        inOrder(root.right);
    }


}
