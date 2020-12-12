package _腾讯推荐._排序与搜索;

import _数据结构.TreeNode;

/**
 * Created by lerry_li on 2020/10/22
 */
public class _二叉搜索树中的第k小的元素 {
    /**
     * 解法1：中序遍历
     */
    public int kthSmallest(TreeNode root, int k) {
        cnt = 0;
        dfs(root, k);
        return res;
    }

    int cnt;
    int res;

    public void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            dfs(root.left, k);
        }
        cnt++;
        if (cnt == k) {
            res = root.val;
            return;
        }
        if (root.right != null) {
            dfs(root.right, k);
        }
    }
}
