package _剑指Offer;

import _数据结构.TreeNode;

/**
 * @ClassName: _55_1_二叉树的深度
 * @Author: lerry_li
 * @CreateDate: 2021/05/07
 * @Description
 */
public class _55_1_二叉树的深度 {
    /**
     * 解法1：递归
     */
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
