package _每日一题._2021年._21年4月;

import _数据结构.TreeNode;

/**
 * @ClassName: _938二叉搜索树的范围和
 * @Author: lerry_li
 * @CreateDate: 2021/04/28
 * @Description
 * 解法1：朴素dfs
 * 解法2：dfs+二叉搜索树性质
 */
public class _938二叉搜索树的范围和 {
    /**
     * 解法1：朴素dfs 时间O(N) 空间O(N)
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        res = 0;
        dfs(root, low, high);
        return res;
    }

    /**
     * 解法2：dfs+二叉搜索树性质 时间O(N) 空间O(N)
     */
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        res=0;
        dfs2(root, low, high);
        return res;
    }

    private void dfs2(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        if (root.val < low) {
            dfs2(root.right, low, high);
        } else if (root.val > high) {
            dfs2(root.left, low, high);
        } else{
            res+=root.val;
            dfs2(root.left,low,high);
            dfs2(root.right,low,high);
        }

    }

    private void dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val >= low && root.val <= high) {
            res += root.val;
        }
        dfs(root.left, low, high);
        dfs(root.right, low, high);
    }

    int res;
}
